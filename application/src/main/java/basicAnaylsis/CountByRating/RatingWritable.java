package basicAnaylsis.CountByRating;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class RatingWritable implements Writable {

    int rating_1;
    int rating_2;
    int rating_3;
    int rating_4;
    int rating_5;

    public int getRating_1() {
        return rating_1;
    }

    public void setRating_1(int rating_1) {
        this.rating_1 = rating_1;
    }

    public int getRating_2() {
        return rating_2;
    }

    public void setRating_2(int rating_2) {
        this.rating_2 = rating_2;
    }

    public int getRating_3() {
        return rating_3;
    }

    public void setRating_3(int rating_3) {
        this.rating_3 = rating_3;
    }

    public int getRating_4() {
        return rating_4;
    }

    public void setRating_4(int rating_4) {
        this.rating_4 = rating_4;
    }

    public int getRating_5() {
        return rating_5;
    }

    public void setRating_5(int rating_5) {
        this.rating_5 = rating_5;
    }

    @Override
    public String toString() {
        return "RatingWritable{" +
                "rating_1=" + rating_1 +
                ", rating_2=" + rating_2 +
                ", rating_3=" + rating_3 +
                ", rating_4=" + rating_4 +
                ", rating_5=" + rating_5 +
                '}';
    }

    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(rating_1);
        dataOutput.writeInt(rating_2);
        dataOutput.writeInt(rating_3);
        dataOutput.writeInt(rating_4);
        dataOutput.writeInt(rating_5);
    }

    public void readFields(DataInput dataInput) throws IOException {
        rating_1 = dataInput.readInt();
        rating_2 = dataInput.readInt();
        rating_3 = dataInput.readInt();
        rating_4 = dataInput.readInt();
        rating_5 = dataInput.readInt();
    }
}
