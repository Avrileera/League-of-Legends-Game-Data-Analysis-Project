package mapreduce.mapcontrol;

import bean.KDABean;
import bean.WardBean;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class ControlReducer extends Reducer<LongWritable, WardBean, LongWritable, Text> {

    protected void reduce(LongWritable key, Iterable<WardBean> values, Context context) throws IOException, InterruptedException {

        for(WardBean kb: values) {
            context.write(key, new Text(key.get()+";"+kb.winWardTime+";"+kb.loseWardTime+";"+kb.winCampGold+";"+kb.loseCampGold));
        }

    }

}