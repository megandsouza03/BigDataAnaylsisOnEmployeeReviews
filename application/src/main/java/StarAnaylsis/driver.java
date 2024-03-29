package StarAnaylsis;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class driver {
    public static void main(String[] args) throws Exception {

        Job job = Job.getInstance();
        job.setJarByClass(driver.class);

        job.setMapperClass(mapper.class);
        job.setReducerClass(reducer.class);
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(StarsWritable.class);

        FileInputFormat.addInputPath(job,new Path(args[0]));
        FileOutputFormat.setOutputPath(job,new Path(args[1]));

        FileSystem fs = FileSystem.get(job.getConfiguration());
        Path outDir = new Path(args[1]);

        if(fs.exists(outDir)) {
            fs.delete(outDir, true);
        }

        job.waitForCompletion(true);

    }
}
