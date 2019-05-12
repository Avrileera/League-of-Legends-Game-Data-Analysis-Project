package bean;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class PositionBean implements Writable {

    public double time = 0;
    public double x = 0;
    public double y = 0;

    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeDouble(time);
        dataOutput.writeDouble(x);
        dataOutput.writeDouble(y);
    }

    public void readFields(DataInput dataInput) throws IOException {
        this.time = dataInput.readDouble();
        this.x = dataInput.readDouble();
        this.y = dataInput.readDouble();
    }
}
