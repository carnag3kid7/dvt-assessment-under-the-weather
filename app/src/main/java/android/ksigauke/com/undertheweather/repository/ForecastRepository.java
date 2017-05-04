package android.ksigauke.com.undertheweather.repository;

import android.ksigauke.com.undertheweather.domain.Forecast;

/**
 * Created by KSigauke on 2017/05/04.
 */

public interface ForecastRepository {
    interface GetForecastCallback{
        void onForecastLoaded(Forecast forecast); }

    void getForecast(GetForecastCallback callback);
}
