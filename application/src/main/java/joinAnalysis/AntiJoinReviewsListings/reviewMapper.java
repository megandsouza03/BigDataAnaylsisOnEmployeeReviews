package joinAnalysis.AntiJoinReviewsListings;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class reviewMapper extends Mapper<LongWritable, Text,LongWritable,Text>{

    Text outValue = new Text();
    LongWritable outKey = new LongWritable();
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] data = value.toString().split(",");
        if(!data[0].equals("listing_id")) {
            outKey.set(Long.parseLong(data[0]));
            if(data.length == 6){
            outValue.set("R" + data[1]+data[5]);}
            System.out.println(data[1]);
            context.write(outKey, outValue);
        }

    }
}
