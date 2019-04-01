package joinAnalysis.AntiJoinReviewsListings;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class listingMapper extends Mapper<LongWritable, Text,LongWritable,Text> {
    Text outValue = new Text();
    LongWritable outKey = new LongWritable();
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] data = value.toString().split(",");
        if(!data[0].equals("listing_id")) {
            outKey.set(Long.parseLong(data[0]));
            outValue.set("L" + data[2] + data[3] + data[5] + data[17] + data[33]);

            context.write(outKey, outValue);
        }

    }
}
