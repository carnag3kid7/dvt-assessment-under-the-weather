package android.ksigauke.com.undertheweather.dailyforecast;

import android.ksigauke.com.undertheweather.domain.Forecast;
import android.support.annotation.NonNull;
import android.support.v4.util.Pair;

/**
 * Created by KSigauke on 2017/05/04.
 */

public interface ForecastContract {

    interface View{
        void showForecastDetails(Forecast forecast);
        void showLoadingForecastProgressBar();
    }
    interface Presenter{
        void openForecast(@NonNull Pair<Double, Double> latLong);
    }
}
