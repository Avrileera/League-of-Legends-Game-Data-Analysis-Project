package bean;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class KDABean implements Writable {

    public int killCount = 0;
    public int assistCount = 0;
    public int deathCount = 0;

    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(killCount);
        dataOutput.writeInt(assistCount);
        dataOutput.writeInt(deathCount);
    }

    public void readFields(DataInput dataInput) throws IOException {
        this.killCount = dataInput.readInt();
        this.assistCount = dataInput.readInt();
        this.deathCount = dataInput.readInt();
    }
}
