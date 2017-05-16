package android.ksigauke.com.undertheweather.repository;

import android.ksigauke.com.undertheweather.domain.Clouds;
import android.ksigauke.com.undertheweather.domain.Coordinates;
import android.ksigauke.com.undertheweather.domain.Forecast;
import android.ksigauke.com.undertheweather.domain.Main;
import android.ksigauke.com.undertheweather.domain.Sys;
import android.ksigauke.com.undertheweather.domain.Weather;
import android.ksigauke.com.undertheweather.domain.Wind;
import android.support.v4.util.Pair;

import java.util.ArrayList;

public class InMemoryRepository implements ForecastRepository {

    private static final Forecast SUNNY_DAY;

    static {
        SUNNY_DAY = new Forecast.Builder()
                .name("test city")
                .coordinates(new Coordinates(-26.1825267, 27.9976842))
                .weather(new ArrayList<Weather>() {
                    {
                        add(new Weather("Clouds", "broken clouds"));
                    }
                })
                .main(new Main(21.43, 30.12))
                .wind(new Wind(2.2))
                .clouds(new Clouds(12))
                .sys(new Sys("ZA"))
                .build();
    }

    @Override
    public void getForecast(Pair<Double, Double> latLong, GetForecastCallback callback) {

        callback.onForecastLoaded(SUNNY_DAY);
    }
}
