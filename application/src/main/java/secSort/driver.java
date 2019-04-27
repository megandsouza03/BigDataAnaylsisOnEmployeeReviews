package secSort;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class driver  {

    public static void main( String[] args ) throws IOException, ClassNotFoundException, InterruptedException
    {
        Job job = Job.getInstance();

        job.setJarByClass(driver.class);

        job.setGroupingComparatorClass(GroupComparator.class);
        job.setSortComparatorClass(SecodarySortComparator.class);
        job.setPartitionerClass(CustomPartitioner.class);

        FileInputFormat.addInputPath(job, new Path(args[0]));
        Path outDir = new Path(args[1]);
        FileOutputFormat.setOutputPath(job, outDir);

        job.setMapperClass(mapper.class);
        job.setReducerClass(reducer.class);

        job.setNumReduceTasks(1);
        job.setInputFormatClass(TextInputFormat.class);

        job.setOutputKeyClass(CustomWritable.class);
        job.setOutputValueClass(IntWritable.class);

        FileSystem fs = FileSystem.get(job.getConfiguration());
        if(fs.exists(outDir)) {
            fs.delete(outDir, true);
        }

        job.waitForCompletion(true);
    }
}
