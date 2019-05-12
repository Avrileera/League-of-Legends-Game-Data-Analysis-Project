package bean;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class WardBean implements Writable {

    public double winWardTime = 0;
    public double loseWardTime = 0;
    public double winCampGold = 0;
    public double loseCampGold = 0;

    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeDouble(winWardTime);
        dataOutput.writeDouble(loseWardTime);
        dataOutput.writeDouble(winCampGold);
        dataOutput.writeDouble(loseCampGold);
    }

    public void readFields(DataInput dataInput) throws IOException {
        this.winWardTime = dataInput.readDouble();
        this.loseWardTime = dataInput.readDouble();
        this.winCampGold = dataInput.readDouble();
        this.loseCampGold = dataInput.readDouble();
    }
}
