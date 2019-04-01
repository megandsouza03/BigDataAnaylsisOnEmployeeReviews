package joinAnalysis.AntiJoinReviewsListings;

import basicAnaylsis.CountByCompany.reducer;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class driver {
    public static void main(String[] args) throws Exception {

        Job job = Job.getInstance();
        job.setJarByClass(basicAnaylsis.CountByCompany.driver.class);


        job.setReducerClass(reducer.class);
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        job.setMapOutputKeyClass(LongWritable.class);
        job.setMapOutputValueClass(Text.class);

        MultipleInputs.addInputPath(job,new Path(args[0]),TextInputFormat.class,listingMapper.class);
        MultipleInputs.addInputPath(job,new Path(args[1]),TextInputFormat.class,reviewMapper.class);
     //   FileInputFormat.addInputPath(job,new Path(args[0]));
        FileOutputFormat.setOutputPath(job,new Path(args[2]));

        FileSystem fs = FileSystem.get(job.getConfiguration());
        Path outDir = new Path(args[1]);

        job.waitForCompletion(true);

    }
}
