package basicAnaylsis.CountByRating;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class mapper extends Mapper<LongWritable, Text, Text, RatingWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] data = value.toString().split(",");
        if(!data[1].equals("company")) {
            RatingWritable rw = new RatingWritable() ;

            rw.setRating_1(Integer.parseInt(data[9]));
            rw.setRating_2(Integer.parseInt(data[9]));
            rw.setRating_3(Integer.parseInt(data[9]));
            rw.setRating_4(Integer.parseInt(data[9]));
            rw.setRating_5(Integer.parseInt(data[9]));
            context.write(new Text((data[1])),rw );
        }
    }

}
