package mapreduce.position;

import bean.KDABean;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class PositionReducer extends Reducer<LongWritable, Text, LongWritable, Text> {

    protected void reduce(LongWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

        context.write(key,
            values.iterator().next());
        
    }
}