package be.vives.student.jonas.thumperdrive;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jonas on 23-11-2015.
 */
public class NeoPixelString {
    @SerializedName("string_id")
    @Expose
    private String stringId;

    @SerializedName("number_of_pixels")
    @Expose
    private String numberOfPixels;

    String getStringId(){
        return stringId;
    }

    String getNumberOfPixels(){
        return numberOfPixels;
    }
}
