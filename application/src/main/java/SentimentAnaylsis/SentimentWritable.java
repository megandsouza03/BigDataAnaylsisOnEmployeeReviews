package SentimentAnaylsis;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class SentimentWritable implements Writable {

    int sentiment_0;
    int sentiment_1;
    int sentiment_2;
    int sentiment_3;
    int sentiment_4;

    public SentimentWritable() {

    }

    public void write(DataOutput dataOutput) throws IOException {

    dataOutput.writeInt(sentiment_0);
        dataOutput.writeInt(sentiment_1);
        dataOutput.writeInt(sentiment_2);
        dataOutput.writeInt(sentiment_3);
        dataOutput.writeInt(sentiment_4);
    }

    public void readFields(DataInput dataInput) throws IOException {

        sentiment_0 = dataInput.readInt();
        sentiment_1 = dataInput.readInt();
        sentiment_2 = dataInput.readInt();
        sentiment_3 = dataInput.readInt();
        sentiment_4 = dataInput.readInt();

    }

    @Override
    public String toString() {
        return "SentimentWritable{" +
                "sentiment_0=" + sentiment_0 +
                ", sentiment_1=" + sentiment_1 +
                ", sentiment_2=" + sentiment_2 +
                ", sentiment_3=" + sentiment_3 +
                ", sentiment_4=" + sentiment_4 +
                '}';
    }

    public int getSentiment_0() {
        return sentiment_0;
    }

    public void setSentiment_0(int sentiment_0) {
        this.sentiment_0 = sentiment_0;
    }

    public int getSentiment_1() {
        return sentiment_1;
    }

    public void setSentiment_1(int sentiment_1) {
        this.sentiment_1 = sentiment_1;
    }

    public int getSentiment_2() {
        return sentiment_2;
    }

    public void setSentiment_2(int sentiment_2) {
        this.sentiment_2 = sentiment_2;
    }

    public int getSentiment_3() {
        return sentiment_3;
    }

    public void setSentiment_3(int sentiment_3) {
        this.sentiment_3 = sentiment_3;
    }

    public int getSentiment_4() {
        return sentiment_4;
    }

    public void setSentiment_4(int sentiment_4) {
        this.sentiment_4 = sentiment_4;
    }
}
