package android.ksigauke.com.undertheweather.utils;

import android.ksigauke.com.undertheweather.R;

import java.util.Locale;

/**
 * The below constants are derived from the weather conditions documentation at
 * https://openweathermap.org/weather-conditions
 */
public class Constants {
    public static final String WEATHER_UNITS = "metric";

    private static final String THUNDERSTORMS = "thunderstorm";
    private static final String DRIZZLE = "drizzle";
    private static final String RAIN = "rain";
    private static final String SNOW = "snow";
    private static final String ATMOSPHERE = "atmosphere";
    private static final String CLEAR = "clear";
    private static final String CLOUDS = "clouds";
    private static final String EXTREME = "extreme";
    private static final String ADDITIONAL = "additional";
    private static final String HAZE = "haze";
    public static final String OPEN_WEATHER_MAP_VERSION = "2.5";
    public static final String API_BASE_URL = "http://api.openweathermap.org/";
    public static int getCurrentWeatherImage(String condition) {
        switch (condition.toLowerCase(Locale.getDefault())) {
            case THUNDERSTORMS:
            case DRIZZLE:
            case RAIN:
                return R.drawable.ic_rain;

            case SNOW:
                return R.drawable.ic_snow;

            case ATMOSPHERE:
            case CLOUDS:
                return R.drawable.ic_partly_cloudy;
            case HAZE:
                return R.drawable.ic_cloudy;

            case CLEAR:
                return R.drawable.ic_sun;

            case EXTREME:
            case ADDITIONAL:
                return R.drawable.ic_current_weather_placeholder;

            default:
                return R.drawable.ic_current_weather_placeholder;

        }
    }



}