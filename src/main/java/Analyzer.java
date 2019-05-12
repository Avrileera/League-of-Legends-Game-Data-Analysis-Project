import bean.*;
import mapreduce.kda.KDAMapper;
import mapreduce.kda.KDAReducer;
import mapreduce.mapcontrol.ControlMapper;
import mapreduce.mapcontrol.ControlReducer;
import mapreduce.position.PositionMapper;
import mapreduce.position.PositionReducer;
import mapreduce.winrate.WinRateMapper;
import mapreduce.winrate.WinRateReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;


import javax.imageio.ImageIO;
import javax.swing.text.Position;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Analyzer {

    //INPUT FILE PATH
    //private final static String INPUT_FILE_PATH = "/user/blackburn/riftwalk.gg/riftwalk.jsons";
    private final static String INPUT_FILE_PATH = "data/input/sample.json";
    private static String outputFilePath = "";
    private static String[] COLOR = {"#FFC1C1" ,"#FF8C00", "#EE00EE", "#CD9B1D", "#9F79EE", "#5F9EA0", "#000000", "#FF0000", "#98FB98", "#4B0082"};
    private static Job job;

    private static void printMenu() throws InterruptedException, IOException, ClassNotFoundException{
        System.out.println("-----------------------------------------");
        System.out.println("|           LOL Data Analyzer           |");
        System.out.println("|     1. Win Rate                       |");
        System.out.println("|     2. Kill/Death/Assist              |");
        System.out.println("|     3. Map Control                    |");
        System.out.println("|     4. Player's Position              |");
        System.out.println("-----------------------------------------");
        System.out.print("Please select a function:");
        Scanner s = new Scanner(System.in);

        int i;
        try {
            i = s.nextInt();
        } catch(InputMismatchException e) {
            i = -1;
        }

        switch (i) {
            case 1:
                doAnalyzeWinRate();
                break;
            case 2:
                doAnalyzeKDA();
                break;
            case 3:
                doAnalyzeMapControl();
                break;
            case 4:
                doAnalyzePosition();
                break;
            default:
                System.out.println("error input");
                System.out.println();
                System.out.println();
                printMenu();
                break;
        }
    }


    private static void doAnalyzeWinRate() throws InterruptedException, IOException, ClassNotFoundException {

        job.setMapperClass(WinRateMapper.class);
        job.setReducerClass(WinRateReducer.class);

        job.setMapOutputKeyClass(LongWritable.class);
        job.setMapOutputValueClass(WinRateBean.class);

        job.setOutputKeyClass(LongWritable.class);
        job.setOutputValueClass(Text.class);

        boolean res = job.waitForCompletion(true);

        if(res) {
            Runtime.getRuntime().exec("mkdir -p temp/"+time).waitFor();
            Runtime.getRuntime().exec("hadoop fs -get hdfs://jedimaster:9000/user/blackburn/riftwalk.gg/data"+time+"/part-r-00000 ./temp/"+time).waitFor();
            //String path =  "temp/"+time+"/part-r-" + String.format("%05d", i);
            HashMap<String, WinRateAnalyzeBean> hashMap = new HashMap();

            for(int i=0; i<10000; i++) {
                String path =  "temp/"+time+"/part-r-" + String.format("%05d", i);
                if(!new File(path).exists()) {
                    break;
                }
                File file=new File(path);
                BufferedReader reader=null;
                String temp=null;
                try{
                    reader=new BufferedReader(new FileReader(file));
                    while((temp=reader.readLine())!=null){
                        if(temp.split("\t").length!=2) continue;
                        String[] items = temp.split("\t")[1].split(";");
                        if(items.length == 5 || items.length == 4) {

                            String name = items[0];
                            if(!hashMap.containsKey(name)) {
                                WinRateAnalyzeBean wab = new WinRateAnalyzeBean();
                                wab.winGame = Integer.parseInt(items[1]);
                                wab.totalGame = Integer.parseInt(items[2]);
                                String[] winplayer = items[3].split(",");
                                if(winplayer.length>1) {
                                    for (int wi = 0; wi < winplayer.length; wi++) {
                                        if(winplayer[wi].equals("0")) continue;
                                        if (!wab.winPlayer.containsKey(winplayer[wi]))
                                            wab.winPlayer.put(winplayer[wi], 0);
                                        wab.winPlayer.put(winplayer[wi], wab.winPlayer.get(winplayer[wi]) + 1);
                                    }
                                }

                                if(items.length==5) {
                                    String[] loseplayer = items[4].split(",");
                                    for(int wi=0; wi<loseplayer.length; wi++) {
                                        if(loseplayer[wi].equals("0")) continue;
                                        if(!wab.losePlayer.containsKey(loseplayer[wi])) wab.losePlayer.put(loseplayer[wi], 0);
                                        wab.losePlayer.put(loseplayer[wi], wab.losePlayer.get(loseplayer[wi])+1);
                                    }
                                }
                                hashMap.put(name, wab);
                            }
                        }
                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                finally{
                    if(reader!=null){
                        try{
                            reader.close();
                        }
                        catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            }
            for(String s: hashMap.keySet()) {
                WinRateAnalyzeBean wab = hashMap.get(s);
                System.out.println("Champion: "+s+" [Win rate: "+String.format("%.2f", 100.0f*wab.winGame/wab.totalGame)+"%] "+ wab.getTop5());
            }
        } else {
            System.out.println("hadoop exit with error");
        }

    }

    private static void doAnalyzeKDA() throws InterruptedException, IOException, ClassNotFoundException{
    	
        job.setMapperClass(KDAMapper.class);
        job.setReducerClass(KDAReducer.class);

        job.setMapOutputKeyClass(LongWritable.class);
        job.setMapOutputValueClass(KDABean.class);

        job.setOutputKeyClass(LongWritable.class);
        job.setOutputValueClass(Text.class);

        boolean res = job.waitForCompletion(true);
        if(res) {
            Runtime.getRuntime().exec("mkdir -p temp/"+time).waitFor();
            Runtime.getRuntime().exec("hadoop fs -get hdfs://jedimaster:9000/user/blackburn/riftwalk.gg/data"+time+"/part-r-00000 ./temp/"+time).waitFor();
            //String path =  "temp/"+time+"/part-r-" + String.format("%05d", i);
            HashMap<String, KDABean> kdabean = new HashMap();
            for(int i=0; i<10000; i++) {
                String path =  "temp/"+time+"/part-r-" + String.format("%05d", i);

                if (!new File(path).exists()) {
                    break;
                }
                File file = new File(path);
                BufferedReader reader = null;
                String temp = null;
                try {
                    reader = new BufferedReader(new FileReader(file));
                    while ((temp = reader.readLine()) != null) {
                        if (temp.split("\t").length != 2) continue;
                        String[] items = temp.split("\t")[1].split(";");
                        if(items.length!=4) {
                            continue;
                        } else {
                            if(items[0].equals("0")) continue;
                            if(!kdabean.containsKey(items[0])) {
                                kdabean.put(items[0], new KDABean());
                            }
                            KDABean sb = kdabean.get(items[0]);
                            sb.killCount += Integer.parseInt(items[1]);
                            sb.deathCount += Integer.parseInt(items[2]);
                            sb.assistCount += Integer.parseInt(items[3]);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            for(String s: kdabean.keySet()) {
                KDABean wab = kdabean.get(s);
                System.out.println("Champion: "+s+" [KDA: "+String.format("%.2f", (wab.killCount+wab.assistCount)*1.0/wab.deathCount)+"]");
            }
        } else {
            System.out.println("hadoop exit with error");
        }
    }

    private static void doAnalyzeMapControl() throws InterruptedException, IOException, ClassNotFoundException{
    	
        job.setMapperClass(ControlMapper.class);
        job.setReducerClass(ControlReducer.class);

        job.setMapOutputKeyClass(LongWritable.class);
        job.setMapOutputValueClass(WardBean.class);

        job.setOutputKeyClass(LongWritable.class);
        job.setOutputValueClass(Text.class);

        boolean res = job.waitForCompletion(true);
        if(res) {
            double winWardTime = 0;
            double loseWardTime = 0;
            int totalGame = 0;
            File file2 = new File("gold.txt");
            Writer out = new FileWriter(file2);
            File file3 = new File("ward.txt");
            Writer out2 = new FileWriter(file3);
            Runtime.getRuntime().exec("mkdir -p temp/"+time).waitFor();
            Runtime.getRuntime().exec("hadoop fs -get hdfs://jedimaster:9000/user/blackburn/riftwalk.gg/data"+time+"/part-r-00000 ./temp/"+time).waitFor();

            for(int i=0; i<10000; i++) {
                //String path =  outputFilePath+"/part-r-" + String.format("%05d", i);
                String path =  "temp/"+time+"/part-r-" + String.format("%05d", i);
                if (!new File(path).exists()) {
                    break;
                }
                File file = new File(path);
                BufferedReader reader = null;
                String temp = null;
                try {
                    reader = new BufferedReader(new FileReader(file));
                    while ((temp = reader.readLine()) != null) {
                        if (temp.split("\t").length != 2) continue;
                        String[] items = temp.split("\t")[1].split(";");
                        if(items.length!=5) {
                            continue;
                        } else {
                            if( Double.parseDouble(items[1])>200000) continue;
                            if( Double.parseDouble(items[2])>200000) continue;
                            if( Double.parseDouble(items[1])<0) continue;
                            if( Double.parseDouble(items[2])<0) continue;
                            winWardTime += Double.parseDouble(items[1]);
                            loseWardTime += Double.parseDouble(items[2]);

                            StringBuilder sb = new StringBuilder();
                            sb.append("[gameID: ")
                                    .append(items[0])
                                    .append("]  [Win team camp gold gain: ")
                                    .append((int)Double.parseDouble(items[3]))
                                    .append("]  [Lose team camp gold gain: ")
                                    .append((int)Double.parseDouble(items[4]))
                                    .append("]\r\n");
                            out.write(sb.toString());

                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("[gameID: ")
                                    .append(items[0])
                                    .append("]  [Win team camp ward time: ")
                                    .append((int)Double.parseDouble(items[1]))
                                    .append("]  [Lose team camp ward time: ")
                                    .append((int)Double.parseDouble(items[2]))
                                    .append("]\r\n");
                            out2.write(sb2.toString());
                            totalGame ++;

                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            System.out.println("In "+totalGame+" games, winner's ward time is: " + String.format("%.2f", winWardTime/totalGame)+
                    ", loser's ward time is: " + String.format("%.2f", loseWardTime/totalGame));

            out2.close();
            out.close();

        } else {
            System.out.println("hadoop exit with error");
        }
    }

    private static void doAnalyzePosition() throws InterruptedException, IOException, ClassNotFoundException{

        System.out.print("Please enter a game ID:");
        Scanner s = new Scanner(System.in);

        int i2;
        try {
            i2 = s.nextInt();
        } catch(InputMismatchException e) {
            i2 = -1;
        }

        if(i2<0) {
            System.out.println("Error game ID.");
            return;
        }

        job.getConfiguration().set("game_id", i2+"");

        job.setMapperClass(PositionMapper.class);
        job.setReducerClass(PositionReducer.class);

        job.setMapOutputKeyClass(LongWritable.class);
        job.setMapOutputValueClass(Text.class);

        job.setOutputKeyClass(LongWritable.class);
        job.setOutputValueClass(Text.class);

        // submit jobs
        boolean res = job.waitForCompletion(true);
        if(res) {

            //handle result
            Runtime.getRuntime().exec("mkdir -p temp/"+time).waitFor();
            Runtime.getRuntime().exec("hadoop fs -get hdfs://jedimaster:9000/user/blackburn/riftwalk.gg/data"+time+"/part-r-00000 ./temp/"+time).waitFor();

            for(int i=0; i<10000; i++) {
                //String path =  outputFilePath+"/part-r-" + String.format("%05d", i)
                String path =  "temp/"+time+"/part-r-" + String.format("%05d", i);
                ArrayList<String> strs = new ArrayList<String>();
                if (!new File(path).exists()) {
                    break;
                }
                File file = new File(path);
                BufferedReader reader = null;
                String temp = null;
                try {
                    reader = new BufferedReader(new FileReader(file));
                    while ((temp = reader.readLine()) != null) {
                        if (temp.split("\t").length != 2) continue;
                        strs.add(temp.split("\t")[1]);

                    }
                    if(strs.size()>12*15) {
                        for(int k=0; k<100; k++) {
                            BufferedImage image = new BufferedImage(4000, 4000,
                                    BufferedImage.TYPE_INT_ARGB);
                            Graphics graphics = image.getGraphics();
                            Graphics2D g2d = (Graphics2D)graphics;
                            g2d.setStroke(new BasicStroke(10));

                            ArrayList<BufferedImage> bufferedImages = new ArrayList<BufferedImage>();
                            for(int sk=0; sk<10; sk++) {
                                BufferedImage image2 = new BufferedImage(4000, 4000,
                                        BufferedImage.TYPE_INT_ARGB);
                                bufferedImages.add(image2);
                            }

                            int maxplayers = 0;
                            String[] lastPosition = new String[10];
                            for(int id=k*120; id<((k+1)*120>strs.size()?strs.size():(k+1)*120); id++) {
                                String string = strs.get(id);
                                String[] positions = string.split(";");
                                if(positions.length>maxplayers) maxplayers = positions.length;
                                for(String ss: positions) {
                                    String[] gs = ss.split(",");
                                    if(lastPosition[Integer.parseInt(gs[0])]!=null) {
                                        graphics.setColor(Color.decode(COLOR[Integer.parseInt(gs[0])]));
                                        String[] ns = lastPosition[Integer.parseInt(gs[0])].split(",");
                                        graphics.drawLine(Integer.parseInt(ns[0])/4, Integer.parseInt(ns[1])/4,
                                                Integer.parseInt(gs[1])/4, Integer.parseInt(gs[2])/4);

                                        Graphics gps2 = bufferedImages.get(Integer.parseInt(gs[0])).getGraphics();
                                        Graphics2D g2d2 = (Graphics2D)gps2;
                                        g2d2.setStroke(new BasicStroke(10));
                                        gps2.setColor(Color.decode(COLOR[Integer.parseInt(gs[0])]));
                                        gps2.drawLine(Integer.parseInt(ns[0])/4, Integer.parseInt(ns[1])/4,
                                                Integer.parseInt(gs[1])/4, Integer.parseInt(gs[2])/4);
                                    }
                                    lastPosition[Integer.parseInt(gs[0])] = gs[1]+","+gs[2];
                                }
                            }

                            for(int p=0; p<maxplayers; p++) {
                                File outputfile = new File("position-"+k+"-"+p+".png");
                                ImageIO.write(bufferedImages.get(p), "png", outputfile);
                            }
                            File outputfile = new File("position-"+k+"-"+"all.png");
                            ImageIO.write(image, "png", outputfile);
                            if((k+1)*120>strs.size())
                                break;
                        }
                    } else {
                        BufferedImage image = new BufferedImage(4000, 4000,
                                BufferedImage.TYPE_INT_ARGB);
                        Graphics graphics = image.getGraphics();

                        Graphics2D g2d = (Graphics2D)graphics;
                        g2d.setStroke(new BasicStroke(10));

                        ArrayList<BufferedImage> bufferedImages = new ArrayList<BufferedImage>();
                        for(int sk=0; sk<10; sk++) {
                            BufferedImage image2 = new BufferedImage(4000, 4000,
                                    BufferedImage.TYPE_INT_ARGB);
                            bufferedImages.add(image2);
                        }

                        int maxplayers = 0;

                        String[] lastPosition = new String[10];
                        for(int id=0;id<strs.size(); id++) {
                            String string = strs.get(id);
                            String[] positions = string.split(";");
                            if(positions.length>maxplayers) maxplayers = positions.length;
                            for(String ss2: positions) {

                                String[] gs = ss2.split(",");
                                if(lastPosition[Integer.parseInt(gs[0])]!=null) {
                                    graphics.setColor(Color.decode(COLOR[Integer.parseInt(gs[0])]));
                                    String[] ns = lastPosition[Integer.parseInt(gs[0])].split(",");
                                    graphics.drawLine(Integer.parseInt(ns[0])/4, Integer.parseInt(ns[1])/4,
                                            Integer.parseInt(gs[1])/4, Integer.parseInt(gs[2])/4);

                                    Graphics gps2 = bufferedImages.get(Integer.parseInt(gs[0])).getGraphics();
                                    Graphics2D g2d2 = (Graphics2D)gps2;
                                    g2d2.setStroke(new BasicStroke(10));
                                    gps2.setColor(Color.decode(COLOR[Integer.parseInt(gs[0])]));
                                    gps2.drawLine(Integer.parseInt(ns[0])/4, Integer.parseInt(ns[1])/4,
                                            Integer.parseInt(gs[1])/4, Integer.parseInt(gs[2])/4);
                                }
                                lastPosition[Integer.parseInt(gs[0])] = gs[1]+","+gs[2];
                            }
                        }
                        for(int p=0; p<maxplayers; p++) {
                            File outputfile = new File("position"+"-"+p+".png");
                            ImageIO.write(bufferedImages.get(p), "png", outputfile);
                        }
                        File outputfile = new File("position.png");
                        ImageIO.write(image, "png", outputfile);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        } else {
            System.out.println("hadoop exit with error");
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException, IOException {

        // setup some base config to job
        if(args.length != 1){
            System.out.println("usage: hadoop jar XXX.jar /input path");
        } else {
            setUpBaseJob(args[0]);

            // select function
            printMenu();
        }
    }
    static long time;

    private static void setUpBaseJob(String input) throws IOException {

        time = System.currentTimeMillis();
        outputFilePath = "/user/blackburn/riftwalk.gg/data"+System.currentTimeMillis();

        Configuration conf = new Configuration();
        job = Job.getInstance(conf);
        job.setJarByClass(Analyzer.class);
        job.setInputFormatClass(TextInputFormat.class);
        FileInputFormat.setInputPaths(job, input);
        job.setOutputFormatClass(TextOutputFormat.class);
        TextOutputFormat.setOutputPath(job, new Path(outputFilePath));
    }
}
