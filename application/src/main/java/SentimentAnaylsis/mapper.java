package SentimentAnaylsis;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class mapper extends Mapper<LongWritable, Text, Text,SentimentWritable> {
    SentimentWritable sentimentWritable  = new SentimentWritable();
    SentimentService sentimentService;
    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
         sentimentService = new SentimentService();
    }

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {


        String[] data = value.toString().split(",");
        if(!data[1].equals("company")) {
            sentimentWritable.setSentiment_0(sentimentService.findSentiment(data[5]));
            sentimentWritable.setSentiment_1(sentimentService.findSentiment(data[5]));
            sentimentWritable.setSentiment_2(sentimentService.findSentiment(data[5]));
            sentimentWritable.setSentiment_3(sentimentService.findSentiment(data[5]));
            sentimentWritable.setSentiment_4(sentimentService.findSentiment(data[5]));

            context.write(new Text((data[1])), sentimentWritable);
        }
    }
}
