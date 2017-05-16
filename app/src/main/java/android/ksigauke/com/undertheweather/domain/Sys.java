package android.ksigauke.com.undertheweather.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sys {

    @SerializedName("country")
    @Expose
    private String country;

    @SuppressWarnings("unused")
    private Sys() {
        //no-args constructor for serialization
    }

    public Sys(String country) {

        this.country = country;
    }

    public String getCountry() {
        return country;
    }
}
