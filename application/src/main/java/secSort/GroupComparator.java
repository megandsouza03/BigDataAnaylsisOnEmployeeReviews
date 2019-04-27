package secSort;

import org.apache.hadoop.io.WritableComparator;

public class GroupComparator extends WritableComparator {

    protected GroupComparator() {
        super(CustomWritable.class, true);
    }

    @Override
    public int compare(Object a, Object b) {

        CustomWritable ckw1 = (CustomWritable)a;
        CustomWritable ckw2 = (CustomWritable)b;

        return ckw1.getCompany().compareTo(ckw2.getCompany());
    }

}
