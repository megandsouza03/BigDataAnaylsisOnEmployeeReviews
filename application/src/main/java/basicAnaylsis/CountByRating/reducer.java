package basicAnaylsis.CountByRating;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class reducer extends Reducer<Text, RatingWritable, Text,RatingWritable> {
    RatingWritable rw = new RatingWritable();
    @Override
    protected void reduce(Text key, Iterable<RatingWritable> values, Context context) throws IOException, InterruptedException {
        int sum1 = 0 , sum2= 0, sum3=0, sum4 = 0 ,sum5=0;
        for (RatingWritable val : values){
            if(val.getRating_1() == 1){
                sum1 ++;
            }else if (val.getRating_2() == 2){
                sum2 ++;
            }
            else if(val.getRating_3() == 3){
                sum3 ++;
            }else if (val.getRating_4() == 4){
                sum4 ++;
            }
            else if(val.getRating_5() == 5){
                sum5 ++;
            }
        }
        rw.setRating_5(sum5);
        rw.setRating_4(sum4);
        rw.setRating_3(sum3);
        rw.setRating_2(sum2);
        rw.setRating_1(sum1 );

        context.write(key,rw);
    }
}
