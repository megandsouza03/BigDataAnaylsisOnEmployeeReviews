package secSort;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Partitioner;

public class CustomPartitioner extends Partitioner<CustomWritable, IntWritable> {

    @Override
    public int getPartition(CustomWritable key, IntWritable value, int numPartitions) {

        return key.getCompany().hashCode()%numPartitions;

    }

}
