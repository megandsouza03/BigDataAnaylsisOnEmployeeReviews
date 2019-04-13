package StarAnaylsis;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class mapper extends Mapper<LongWritable, Text, Text,StarsWritable> {
    StarsWritable starsWritable = new StarsWritable();
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] data = value.toString().split(",");
        if(!data[1].equals("company")) {
            if(data[10].equals("none")){
                starsWritable.setWork_balance(0);
            }
            else{starsWritable.setWork_balance(Float.parseFloat(data[10]));}
            if(data[11].equals("none")){
                starsWritable.setCulture_values(0);
            }
            else{starsWritable.setCulture_values(Float.parseFloat(data[11]));}
            if(data[12].equals("none")){
                starsWritable.setCareer_opp(0);
            }
            else{starsWritable.setCareer_opp(Float.parseFloat(data[12]));}
            if(data[13].equals("none")){
                starsWritable.setComp_ben(0);
            }
            else{starsWritable.setComp_ben(Float.parseFloat(data[13]));}
            if(data[14].equals("none")){
                starsWritable.setSen_man(0);
            }
            else{starsWritable.setSen_man(Float.parseFloat(data[14]));}

           // System.out.println(starsWritable);
            context.write(new Text((data[1])),starsWritable );
        }
    }
}
