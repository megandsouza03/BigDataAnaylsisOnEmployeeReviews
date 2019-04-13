package StarAnaylsis;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class reducer extends Reducer<Text,StarsWritable,Text,StarsWritable> {

    @Override
    protected void reduce(Text key, Iterable<StarsWritable> values, Context context) throws IOException, InterruptedException {
        int count = 0 ;
        float sum_wb = 0 , sum_cul = 0, sum_car =0, sum_comp = 0, sum_sen =0;
        for(StarsWritable sw : values){
            sum_wb += sw.getWork_balance();
            sum_cul += sw.getCulture_values();
            sum_car += sw.getCareer_opp();
            sum_comp += sw.getComp_ben();
            sum_sen += sw.getSen_man();
            count ++;
        }

        StarsWritable starsWritable = new StarsWritable(sum_wb/count,
                sum_cul/count,sum_car/count,
                sum_comp/count,sum_sen/count );
        System.out.println(starsWritable);
        context.write(key,starsWritable);

    }
}
