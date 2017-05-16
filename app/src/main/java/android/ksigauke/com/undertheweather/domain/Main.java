package android.ksigauke.com.undertheweather.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Main {
    @SerializedName("temp_min")
    @Expose
    private double tempMin;
    @SerializedName("temp_max")
    @Expose
    private double tempMax;

    @SuppressWarnings("unused")
    private Main() {
        // no args constructor for serialization
    }

    public Main(double tempMin, double tempMax) {
        this.tempMin = tempMin;
        this.tempMax = tempMax;
    }

    public double getTempMin() {
        return tempMin;
    }

    public double getTempMax() {
        return tempMax;
    }

}
