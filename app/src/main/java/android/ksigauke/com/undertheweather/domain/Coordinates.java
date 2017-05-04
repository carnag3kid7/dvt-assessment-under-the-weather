package android.ksigauke.com.undertheweather.domain;

/**
 * Created by KSigauke on 2017/05/04.
 */

public class Coordinates {
    private double latitude;
    private double longitude;

    public Coordinates(double latitude, double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
