package android.ksigauke.com.undertheweather.domain;

/**
 * Created by KSigauke on 2017/05/04.
 */

public class Wind {
    private double speed;
    private int degrees;

    public Wind(double speed, int degrees){
        this.speed = speed;
        this.degrees = degrees;
    }

    private Wind(){}

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getDegrees() {
        return degrees;
    }

    public void setDegrees(int degrees) {
        this.degrees = degrees;
    }
}
