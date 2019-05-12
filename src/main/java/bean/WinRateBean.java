package bean;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class WinRateBean implements Writable {
    public int championID;
    public boolean win;
    public String op;

    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(championID);
        dataOutput.writeBoolean(win);
        dataOutput.writeUTF(op);
    }

    public void readFields(DataInput dataInput) throws IOException {
        this.championID = dataInput.readInt();
        this.win = dataInput.readBoolean();
        this.op = dataInput.readUTF();
    }
}
