package android.ksigauke.com.undertheweather.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wind {

    @SerializedName("speed")
    @Expose
    private double speed;

    public Wind(double speed){
        this.speed = speed;
    }

    @SuppressWarnings("unused")
    private Wind(){}

    public double getSpeed() {
        return speed;
    }

}
