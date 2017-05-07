package android.ksigauke.com.undertheweather.dailyforecast;

import android.ksigauke.com.undertheweather.Injection;
import android.ksigauke.com.undertheweather.R;
import android.ksigauke.com.undertheweather.domain.Forecast;
import android.ksigauke.com.undertheweather.domain.Weather;
import android.ksigauke.com.undertheweather.utils.Constants;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CurrentWeatherFragment extends Fragment implements ForecastContract.View {

    private CurrentWeatherPresenter currentWeatherPresenter;
    private ImageView ivCurrentWeather;
    private TextView tvMaxTemperature;
    private TextView tvMinTemperature;
    private TextView tvCurrentLocation;
    private TextView tvWindSpeed;
    private TextView tvCloudPercentage;
    private TextView tvWeatherDescription;
    private ImageView ivLocationImage;
    private ImageView ivWindSpeedImage;
    private ImageView ivCloudPercentageImage;

    public CurrentWeatherFragment() {

        currentWeatherPresenter = new CurrentWeatherPresenter(Injection.forecastRepository(), this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View currentWeatherView = inflater.inflate(R.layout.fragment_current_weather, container, false);
        initView(currentWeatherView);
        return currentWeatherView;
    }

    private void initView(View view) {
        ivCurrentWeather = (ImageView) view.findViewById(R.id.iv_current_weather_image);
        tvMaxTemperature = (TextView) view.findViewById(R.id.tv_max_temperature);
        tvMinTemperature = (TextView) view.findViewById(R.id.tv_min_temperature);
        tvCurrentLocation = (TextView) view.findViewById(R.id.tv_current_location);
        tvWindSpeed = (TextView) view.findViewById(R.id.tv_wind_speed);
        tvWeatherDescription = (TextView) view.findViewById(R.id.tv_weather_description);
        tvCloudPercentage = (TextView) view.findViewById(R.id.tv_cloud_percentage);
        ivLocationImage = (ImageView) view.findViewById(R.id.iv_location_image);
        ivWindSpeedImage = (ImageView) view.findViewById(R.id.iv_wind_speed);
        ivCloudPercentageImage = (ImageView) view.findViewById(R.id.iv_cloud_percentage);

    }

    @Override
    public void showForecastDetails(Forecast forecast) {
        Weather weather = forecast.getWeather().get(0);
        int imageDrawable = Constants.getCurrentWeatherImage(weather.getMain());

        ivLocationImage.setImageResource(R.drawable.ic_place_24dp);
        ivWindSpeedImage.setImageResource(R.drawable.ic_wind_speed_black_24dp);
        ivCloudPercentageImage.setImageResource(R.drawable.ic_cloud_percentage_24dp);

        ivCurrentWeather.setImageResource(imageDrawable);
        tvMaxTemperature.setText(getString(R.string.max_temperature_text, forecast.getMain().getTempMax()));
        tvMinTemperature.setText(getString(R.string.min_temperature_text, forecast.getMain().getTempMin()));


        //TODO: use the geocoder library to get address
        tvCurrentLocation.setText(forecast.getSys().getCountry() + ", " + forecast.getName());
        tvWindSpeed.setText(getString(R.string.wind_speed_text, forecast.getWind().getSpeed()));

        tvCloudPercentage.setText(String.valueOf(forecast.getClouds().getAll() + "%"));
        tvWeatherDescription.setText(weather.getDescription());
    }

    @Override
    public void showLoadingForecastProgressBar() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void onResume() {
        super.onResume();
        //TODO: change the below method so that it takes user's current lat long
        currentWeatherPresenter.openForecast(new Pair<>(-37.3384444,-57.0390686));
    }

}
