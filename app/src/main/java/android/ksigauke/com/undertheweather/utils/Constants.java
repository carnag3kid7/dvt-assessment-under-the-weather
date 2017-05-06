package android.ksigauke.com.undertheweather.utils;

import android.ksigauke.com.undertheweather.R;

import java.util.HashMap;
import java.util.Map;

public class Constants {
    public static final String WEATHER_UNITS = "metric";

    public static final Map<String, Integer> FORECAST_DRAWABLES = new HashMap<>();

    static {
        FORECAST_DRAWABLES.put("Rain", R.drawable.ic_rain);
        FORECAST_DRAWABLES.put("Cloudy", R.drawable.ic_cloudy);
        FORECAST_DRAWABLES.put("Sunny", R.drawable.ic_sun);
        FORECAST_DRAWABLES.put("Snow", R.drawable.ic_snow);
    }
}