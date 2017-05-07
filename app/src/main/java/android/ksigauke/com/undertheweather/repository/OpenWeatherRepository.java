package android.ksigauke.com.undertheweather.repository;

import android.ksigauke.com.undertheweather.domain.Forecast;
import android.ksigauke.com.undertheweather.utils.Constants;
import android.support.v4.util.Pair;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OpenWeatherRepository implements ForecastRepository {

    private static OpenWeatherRepository INSTANCE;
    private OpenWeatherRepository(){

    }

    public static OpenWeatherRepository getInstance(){
        if(INSTANCE == null)
            INSTANCE = new OpenWeatherRepository();

        return  INSTANCE;
    }

    @Override
    public void getForecast(Pair<Double, Double> latLong, final GetForecastCallback callback) {
        Retrofit request = new Retrofit.Builder().baseUrl(Constants.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        OpenWeatherApi api = request.create(OpenWeatherApi.class);
        Call<Forecast> forecastCall = api.getCurrentWeather(latLong.first, latLong.second);

        forecastCall.enqueue(new Callback<Forecast>() {
            @Override
            public void onResponse(Call<Forecast> call, Response<Forecast> response) {
                callback.onForecastLoaded(response.body());
            }

            @Override
            public void onFailure(Call<Forecast> call, Throwable t) {

            }
        });
    }
}
