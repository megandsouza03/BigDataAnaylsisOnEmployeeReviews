package StarAnaylsis;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class StarsWritable implements Writable {
    float work_balance;
    float culture_values;
    float career_opp;
    float comp_ben;
    float sen_man;

    public StarsWritable(float work_balance, float culture_values, float career_opp, float comp_ben, float sen_man) {
        this.work_balance = work_balance;
        this.culture_values = culture_values;
        this.career_opp = career_opp;
        this.comp_ben = comp_ben;
        this.sen_man = sen_man;
    }

    public void setWork_balance(float work_balance) {
        this.work_balance = work_balance;
    }

    public void setCulture_values(float culture_values) {
        this.culture_values = culture_values;
    }

    public void setCareer_opp(float career_opp) {
        this.career_opp = career_opp;
    }

    public void setComp_ben(float comp_ben) {
        this.comp_ben = comp_ben;
    }

    public void setSen_man(float sen_man) {
        this.sen_man = sen_man;
    }

    public float getWork_balance() {
        return work_balance;
    }

    public float getCulture_values() {
        return culture_values;
    }

    public float getCareer_opp() {
        return career_opp;
    }

    public float getComp_ben() {
        return comp_ben;
    }

    public float getSen_man() {
        return sen_man;
    }

    public StarsWritable() {
    }

    @Override
    public String toString() {
        return "StarsWritable{" +
                "work-balance-stars=" + work_balance +
                ", culture-values-stars=" + culture_values +
                ", career-opportunities-stars=" + career_opp +
                ", comp-benefit-stars=" + comp_ben +
                ", senior-mangemnet-stars=" + sen_man +
                '}';
    }

    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeFloat(work_balance);
        dataOutput.writeFloat(culture_values);
        dataOutput.writeFloat(career_opp);
        dataOutput.writeFloat(comp_ben);
        dataOutput.writeFloat(sen_man);
    }

    public void readFields(DataInput dataInput) throws IOException {
        work_balance = dataInput.readFloat();
        culture_values = dataInput.readFloat();
        career_opp = dataInput.readFloat();
        comp_ben = dataInput.readFloat();
        sen_man = dataInput.readFloat();
    }
}
