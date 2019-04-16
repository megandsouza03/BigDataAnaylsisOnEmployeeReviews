package SentimentAnaylsis;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class reducer extends Reducer<Text, SentimentWritable, Text, SentimentWritable> {
        SentimentWritable sentimentWritable = new SentimentWritable();

    @Override
    protected void reduce(Text key, Iterable<SentimentWritable> values, Context context) throws IOException, InterruptedException {
        System.out.println("REducer");
       int  sentiment_0 = 0,sentiment_1 = 0 ,sentiment_2 = 0,sentiment_3 = 0,sentiment_4 = 0 ;
        for(SentimentWritable sw : values){
            if(sw.getSentiment_0()==0) {
                sentiment_0 += sw.getSentiment_0();
            }else if( sw.getSentiment_0() ==1){
            sentiment_1 += sw.getSentiment_1();}
            else if(sw.getSentiment_0() ==2){
            sentiment_2 += sw.getSentiment_2();}
            else if(sw.getSentiment_0()==3){
            sentiment_3 += sw.getSentiment_3();}
            else if(sw.getSentiment_0()==4){
            sentiment_4 += sw.getSentiment_4();}
        }

        sentimentWritable.setSentiment_0(sentiment_0);
        sentimentWritable.setSentiment_1(sentiment_1);
        sentimentWritable.setSentiment_2(sentiment_2);
        sentimentWritable.setSentiment_3(sentiment_3);
        sentimentWritable.setSentiment_4(sentiment_4);

        context.write(key,sentimentWritable);

    }
}
