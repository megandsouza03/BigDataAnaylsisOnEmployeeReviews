package basicAnaylsis.CountByJobTitle;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class mapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] data = value.toString().split(",");

        if(!data[4].equals("job-title")) {

            context.write(new Text((data[4]).split(" - ")[0]), new IntWritable(1));
        }
    }

}
