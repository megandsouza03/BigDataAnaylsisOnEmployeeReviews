package secSort;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class CustomWritable implements WritableComparable<CustomWritable> {
    String company;
    String  place;

    public CustomWritable(String company, String place) {
        this.company = company;
        this.place = place;
    }

    public CustomWritable() {

    }

    public String getCompany() {
        return company;
    }

    public String getPlace() {
        return place;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "CustomWritable{" +
                "company='" + company + '\'' +
                ", place='" + place + '\'' +
                '}';
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int compareTo(CustomWritable o) {
        int result = this.company.compareTo(o.company);
        if (result == 0) {
            return this.place.compareTo(o.place);
        }
        return result;
    }

    public void write(DataOutput dataOutput) throws IOException {
            dataOutput.writeUTF(company);
            dataOutput.writeUTF(place);
    }

    public void readFields(DataInput dataInput) throws IOException {
            company = dataInput.readUTF();
            place = dataInput.readUTF();
    }
}
