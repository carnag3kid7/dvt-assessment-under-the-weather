package android.ksigauke.com.undertheweather.domain;

public class Clouds {
    private int all;

    @SuppressWarnings("unused")
    private Clouds() {
    }

    public Clouds(int all) {
        this.all = all;
    }

    public int getAll() {
        return all;
    }
}
