package mapreduce.kda;

import bean.Game;
import bean.JsonUtils;
import bean.KDABean;
import bean.WinRateBean;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.HashMap;

public class KDAMapper extends Mapper<LongWritable, Text, LongWritable, KDABean>{

    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        Game game = JsonUtils.jsonToPojo(value.toString(), Game.class);
        HashMap<Integer, KDABean> hash = new HashMap<Integer, KDABean>();
        for(Game.DataBean.KillFramesBean kb: game.getData().getKillFrames()) {

            if(kb.getKillerUnitID()>=0&&kb.getKillerUnitID()<=9) {
                int killerCID = game.getPlayers().get(kb.getKillerUnitID()).getChampionID();
                if(!hash.containsKey(killerCID))  hash.put(killerCID, new KDABean());
                hash.get(killerCID).killCount ++;
            }

            if(kb.getVictimUnitID()>=0&&kb.getVictimUnitID()<=9) {
                int deathCID = game.getPlayers().get(kb.getVictimUnitID()).getChampionID();
                if (!hash.containsKey(deathCID)) hash.put(deathCID, new KDABean());
                hash.get(deathCID).deathCount++;
            }
            for(Integer i: kb.getAssistersUnitIDs()) {
                if(i<0||i>9) continue;
                int asCID = game.getPlayers().get(i).getChampionID();
                if(!hash.containsKey(asCID))  hash.put(asCID, new KDABean());
                hash.get(asCID).assistCount ++;
            }
        }

        for(Integer i: hash.keySet()) {
            KDABean kb = hash.get(i);
            context.write(new LongWritable(i), kb);
        }
        //context.write(new LongWritable(wb.championID), wb);
    }
}
