package joinAnalysis.AntiJoinReviewsListings;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;

public class reducer extends Reducer<LongWritable, Text, Text,Text> {
    Text emtpyText = new Text(" ");
    Text tmp = new Text();
    ArrayList<Text> listings = new ArrayList<Text>();
    ArrayList<Text> reviews = new ArrayList<Text>();

    @Override
    protected void reduce(LongWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
            listings.clear();
            reviews.clear();

            while (values.iterator().hasNext()){
                    tmp = values.iterator().next();
                    if(tmp.charAt(0)=='L'){
                        listings.add(new Text(tmp.toString().substring(1)));
                    }else if(tmp.charAt(0)=='R'){
                        reviews.add(new Text(tmp.toString().substring(1)));
                    }
            }

            if(listings.isEmpty()^reviews.isEmpty()){
                for(Text listing : listings){
                    context.write(listing,emtpyText);
                }
                for(Text review : reviews){
                    context.write(emtpyText,review);
                }
            }
    }
}
