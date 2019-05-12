package mapreduce.winrate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import bean.WinRateBean;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WinRateReducer extends Reducer<LongWritable, WinRateBean, LongWritable, Text> {

    protected void reduce(LongWritable key, Iterable<WinRateBean> values, Context context) throws IOException, InterruptedException {

        int winGame = 0;
        int count = 0;
        String winGames = "";
        String loseGames = "";

        for (WinRateBean game : values) {
            count++;
            if(game.win) {
                winGame++;
                winGames = (winGames+game.op+",");
            } else {
                loseGames = (loseGames+game.op+",");
            }
        }
        if(winGames.length() == 0) winGames=",";
        if(loseGames.length() == 0) loseGames=",";

        context.write(key, new Text(key.get()+";"+winGame+";"+count+";"+winGames.substring(0, winGames.length()-1)+";"+
                loseGames.substring(0, loseGames.length()-1)));

    }

}