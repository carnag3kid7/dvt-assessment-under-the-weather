package android.ksigauke.com.undertheweather;

import android.ksigauke.com.undertheweather.repository.ForecastRepository;
import android.ksigauke.com.undertheweather.repository.OpenWeatherRepository;

/**
 * Created by KSigauke on 2017/05/07.
 */

public class Injection {

    public static ForecastRepository forecastRepository(){
        return OpenWeatherRepository.getInstance();
    }

}
