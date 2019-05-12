package mapreduce.kda;

import bean.KDABean;
import bean.WinRateBean;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class KDAReducer extends Reducer<LongWritable, KDABean, LongWritable, Text> {

    protected void reduce(LongWritable key, Iterable<KDABean> values, Context context) throws IOException, InterruptedException {

        int killcount = 0;
        int deathcount = 0;
        int assistcount = 0;

        for(KDABean kb: values) {
            killcount+=kb.killCount;
            deathcount+=kb.deathCount;
            assistcount+=kb.assistCount;
        }
        context.write(key, new Text(key.get()+";"+killcount+";"+deathcount+";"+assistcount));
    }
}