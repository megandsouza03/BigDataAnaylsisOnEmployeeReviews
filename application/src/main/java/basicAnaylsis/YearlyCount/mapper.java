package basicAnaylsis.YearlyCount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class mapper extends Mapper<LongWritable, Text, Text,IntWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] data = value.toString().split(",");
        if(!data[3].equals("dates")) {
         System.out.println(new Text(data[3].split("  ")[1]));
         context.write(new Text(data[3].split("  ")[1]),
                 new IntWritable(1));
        }
    }
}
