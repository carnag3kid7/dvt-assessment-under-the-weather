package android.ksigauke.com.undertheweather.repository;

import android.ksigauke.com.undertheweather.domain.Forecast;
import android.support.v4.util.Pair;

/**
 * Created by KSigauke on 2017/05/04.
 */

public interface ForecastRepository {
    interface GetForecastCallback{
        void onForecastLoaded(Forecast forecast); }

    void getForecast(Pair<Double, Double> latLong, GetForecastCallback callback);
}
