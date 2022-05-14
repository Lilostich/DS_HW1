package DS.lab1;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

import java.io.IOException;


public class Mapper extends org.apache.hadoop.mapreduce.Mapper<LongWritable, Text, Text, IntWritable> {

    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        if (line.toLowerCase().contains("debug")) {
            line = "debug";
        } else if (line.toLowerCase().contains("info")) {
            line = "info";
        } else if (line.toLowerCase().contains("notice")) {
            line = "notice";
        } else if (line.toLowerCase().contains("warn")) {
            line = "warning";
        } else if (line.toLowerCase().contains("err")) {
            line = "error";
        } else if (line.toLowerCase().contains("crit")) {
            line = "crit";
        } else if (line.toLowerCase().contains("alert")) {
            line = "alert";
        } else if (line.toLowerCase().contains("emerg") || line.toLowerCase().contains("panic")) {
            line = "emerg";
        } else {
            line = "";
        }
        if (!line.equals("")) {
            word.set(line);
            context.write(word, one);
        }
    }
}
//7-debug, 6-info, 5-notice, 4-warning/warn, 3-error/err, 2-crit, 1-alert, 0-emerg/panic