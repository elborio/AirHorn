package nl.melbasolutions.airhorn;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.Date;
import java.util.List;

@Table(name = "measure")
public class Measure extends Model{

    @Column(name = "value")
    int value;

    @Column
    Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static List<Measure> getAll() {
        return new Select().from(Measure.class).execute();
    }
}
