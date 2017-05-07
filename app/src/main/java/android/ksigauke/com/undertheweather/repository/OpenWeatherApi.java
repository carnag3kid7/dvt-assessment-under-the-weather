package android.ksigauke.com.undertheweather.repository;

import android.ksigauke.com.undertheweather.BuildConfig;
import android.ksigauke.com.undertheweather.domain.Forecast;
import android.ksigauke.com.undertheweather.utils.Constants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by KSigauke on 2017/05/07.
 */

public interface OpenWeatherApi {
    @GET("data/" + Constants.OPEN_WEATHER_MAP_VERSION + "/weather?appId=" + BuildConfig.OPEN_WEATHER_API_KEY+"&units="+Constants.WEATHER_UNITS)
    Call<Forecast> getCurrentWeather(@Query("lat") double latitude, @Query("lon") double longitude);
}
