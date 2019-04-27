package secSort;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class SecodarySortComparator extends WritableComparator {

    protected SecodarySortComparator() {
        super(CustomWritable.class, true);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {

        CustomWritable ckw1 = (CustomWritable) a;
        CustomWritable ckw2 = (CustomWritable) b;

        int result = ckw1.getCompany().compareTo(ckw2.getCompany());

        if (result == 0) {
            return -ckw1.getPlace().compareTo(ckw2.getPlace());
        }

        return result;
    }



}
