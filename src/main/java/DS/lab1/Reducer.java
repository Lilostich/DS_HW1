package DS.lab1;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

import java.io.IOException;

    /**
     * Reducer class. calculate all log type messages.
     * @version 1.0
     */
public class Reducer extends org.apache.hadoop.mapreduce.Reducer<Text, IntWritable, Text, IntWritable> {

    /**
     * Main Reducer function.
     *
     * @param key     log type
     * @param values  sum of current log type
     * @param context job context
     */
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int sum = 0;
        while (values.iterator().hasNext()) {
            sum += values.iterator().next().get();
        }
        context.write(key, new IntWritable(sum));
    }
}
