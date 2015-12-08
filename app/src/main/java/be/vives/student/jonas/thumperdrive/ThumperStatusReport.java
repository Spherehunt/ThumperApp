package be.vives.student.jonas.thumperdrive;

import com.google.gson.annotations.Expose;

/**
 * Created by Jonas on 7-12-2015.
 */
public class ThumperStatusReport extends StatusReport {
    @Expose
    private float battery_voltage;

    public float getbatteryvoltagelevel(){return battery_voltage;}

}
