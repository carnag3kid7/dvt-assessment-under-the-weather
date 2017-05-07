package android.ksigauke.com.undertheweather.dailyforecast;

import android.ksigauke.com.undertheweather.domain.Forecast;
import android.ksigauke.com.undertheweather.repository.ForecastRepository;
import android.support.annotation.NonNull;
import android.support.v4.util.Pair;

/**
 * Created by KSigauke on 2017/05/07.
 */

public class CurrentWeatherPresenter  implements  ForecastContract.Presenter{

    private ForecastRepository forecastRepository;
    private ForecastContract.View forecastView;

    public CurrentWeatherPresenter(ForecastRepository forecastRepository,  ForecastContract.View forecastView){
        this.forecastRepository = forecastRepository;
        this.forecastView = forecastView;
    }

    @Override
    public void openForecast(@NonNull Pair<Double, Double> latLong) {
        forecastRepository.getForecast(latLong, new ForecastRepository.GetForecastCallback() {
            @Override
            public void onForecastLoaded(Forecast forecast) {
                forecastView.showForecastDetails(forecast);
            }
        });
    }
}
