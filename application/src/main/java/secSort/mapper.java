package secSort;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class mapper extends Mapper<LongWritable, Text, CustomWritable, IntWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] data = value.toString().split(",");

        CustomWritable customWritable = new CustomWritable();
        customWritable.setCompany(data[1]);
        customWritable.setPlace(data[2]);
        context.write(customWritable,new IntWritable(1));

    }
}
