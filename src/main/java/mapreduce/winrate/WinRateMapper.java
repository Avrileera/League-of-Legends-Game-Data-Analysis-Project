package mapreduce.winrate;

import java.io.IOException;

import bean.Game;
import bean.WinRateBean;
import bean.JsonUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WinRateMapper extends Mapper<LongWritable, Text, LongWritable, WinRateBean>{

    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        Game game = JsonUtils.jsonToPojo(value.toString(), Game.class);
        String team1="", team2="";
        int num0=0, num1=0, num2=0;
        if(game.getChampion_ids().size()==10) {
            num0=0;num1=5;num2=10;
            team1 = game.getChampion_ids().get(0) + "," + game.getChampion_ids().get(1) + "," + game.getChampion_ids().get(2)
                    + "," + game.getChampion_ids().get(3) + "," + game.getChampion_ids().get(4);
            team2 = game.getChampion_ids().get(5) + "," + game.getChampion_ids().get(6) + "," + game.getChampion_ids().get(7)
                    + "," + game.getChampion_ids().get(8) + "," + game.getChampion_ids().get(9);
        } else if(game.getChampion_ids().size()==6){
            num0=0;num1=3;num2=6;
            team1 = game.getChampion_ids().get(0) + "," + game.getChampion_ids().get(1) + "," + game.getChampion_ids().get(2);
            team2 = game.getChampion_ids().get(3) + "," + game.getChampion_ids().get(4) + "," + game.getChampion_ids().get(5);
        } else if(game.getChampion_ids().size()==2){
            num0=0;num1=1;num2=2;
            team1 = game.getChampion_ids().get(0)+"";
            team2 = game.getChampion_ids().get(1)+"";

        }
        for(int i=num0; i<num1; i++) {
            WinRateBean wb = new WinRateBean();
            wb.championID = game.getChampion_ids().get(i);
            if(game.getWinner() == 100) wb.win = true;
            else wb.win = false;

            wb.op = team2;
            context.write(new LongWritable(wb.championID), wb);
        }
        for(int i=num1; i<num2; i++) {
            WinRateBean wb = new WinRateBean();
            wb.championID = game.getChampion_ids().get(i);
            if(game.getWinner() == 200) wb.win = true;
            else wb.win = false;

            wb.op = team1;
            context.write(new LongWritable(wb.championID), wb);
        }
    }
}
