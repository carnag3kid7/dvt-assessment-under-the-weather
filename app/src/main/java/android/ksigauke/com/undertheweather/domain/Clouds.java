package android.ksigauke.com.undertheweather.domain;

/**
 * Created by KSigauke on 2017/05/04.
 */

public class Clouds {
    private int all;

    private Clouds(){}
    public Clouds(int all){
        this.all = all;
    }
    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }
}
