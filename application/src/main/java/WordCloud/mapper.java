package WordCloud;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;
import java.util.StringTokenizer;
import rita.wordnet.RiWordnet;

public class mapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    private static final IntWritable ONE = new IntWritable(1);
    private Text word = new Text();
    private RiWordnet wordnet;
    @Override
    protected void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
        wordnet = new RiWordnet();
        String[] data = value.toString().split(",");
        StringTokenizer tokenizer = new StringTokenizer(data[]);
        if(data[1].equals("microsoft")) {
        while (tokenizer.hasMoreTokens()) {

                String token = tokenizer.nextToken().replaceAll("[^a-zA-Z]+", "");
            if( wordnet.exists(token) ) {
                word.set(token);
                context.write(word, ONE);
            }
            }
        }
    }
}
