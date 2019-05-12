package mapreduce.mapcontrol;

import bean.Game;
import bean.JsonUtils;
import bean.KDABean;
import bean.WardBean;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.HashMap;

public class ControlMapper extends Mapper<LongWritable, Text, LongWritable, WardBean>{

    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        Game game = JsonUtils.jsonToPojo(value.toString(), Game.class);
        WardBean wardBean = new WardBean();
        int winner = game.getWinner();
        if(game.getChampion_ids().size()!=10) return;

        for(Game.DataBean.WardFramesBean wfb: game.getData().getWardFrames()) {

            int id = wfb.getCasterUnitID();
            double sTime = wfb.getEndTime()-wfb.getStartTime();
            if(id>=0&&id<=9) {
                if(winner==100) {
                    if(id<5) wardBean.winWardTime+=sTime;
                    else wardBean.loseWardTime+=sTime;
                } else {
                    if(id<5) wardBean.loseWardTime+=sTime;
                    else wardBean.winWardTime+=sTime;
                }
            }
        }

        for(Game.DataBean.GoldEarnedEventsBean earn: game.getData().getGoldEarnedEvents()) {
            int id = earn.getUnitID();
            int sourceid = earn.getSourceUnitID();
            if(sourceid<301||sourceid>309) continue;
            double earnC = earn.getGoldEarned();
            if(id>=0&&id<=9) {
                if(winner==100) {
                    if(id<5) wardBean.winCampGold+=earnC;
                    else wardBean.loseCampGold+=earnC;
                } else {
                    if(id<5) wardBean.loseCampGold+=earnC;
                    else wardBean.winCampGold+=earnC;
                }
            }
        }
        context.write(new LongWritable(game.getGame_id()), wardBean);
    }
}
