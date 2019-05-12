package mapreduce.position;

import bean.Game;
import bean.JsonUtils;
import bean.KDABean;
import bean.PositionBean;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.HashMap;

public class PositionMapper extends Mapper<LongWritable, Text, LongWritable, Text>{

    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        Game game = JsonUtils.jsonToPojo(value.toString(), Game.class);
        int i = Integer.parseInt(context.getConfiguration().get("game_id", "0"));

        if(i==game.getGame_id()) {
            for (Game.DataBean.PositionFramesBean fb : game.getData().getPositionFrames()) {
                StringBuilder sb = new StringBuilder();
                for(Game.DataBean.PositionFramesBean.PlayerPositionsBean ppb: fb.getPlayerPositions()) {
                    sb.append(ppb.getUnitID())
                            .append(",")
                            .append(ppb.getPosition().getX())
                            .append(",")
                            .append(ppb.getPosition().getY())
                            .append(";");
                }
                String string = sb.toString();
                context.write(new LongWritable(fb.getTime()), new Text(string.substring(0, string.length()-1)));
            }
        }
        //context.write(new LongWritable(wb.championID), wb);
    }
}
