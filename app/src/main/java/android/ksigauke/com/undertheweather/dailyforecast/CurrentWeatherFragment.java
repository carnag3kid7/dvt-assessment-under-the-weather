package android.ksigauke.com.undertheweather.dailyforecast;

import android.Manifest;
import android.content.pm.PackageManager;
import android.ksigauke.com.undertheweather.Injection;
import android.ksigauke.com.undertheweather.R;
import android.ksigauke.com.undertheweather.domain.Coordinates;
import android.ksigauke.com.undertheweather.domain.Forecast;
import android.ksigauke.com.undertheweather.domain.Weather;
import android.ksigauke.com.undertheweather.utils.Constants;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import java.io.IOException;
import java.util.Locale;

public class CurrentWeatherFragment extends Fragment implements ForecastContract.View, GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {

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

    private static final int PERMISSION_REQUEST_READ_LOCATION = 1337;
    private GoogleApiClient googleApiClient;

    public CurrentWeatherFragment() {

        currentWeatherPresenter = new CurrentWeatherPresenter(Injection.forecastRepository(), this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (googleApiClient == null) {
            googleApiClient = new GoogleApiClient.Builder(getActivity())
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }
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
        Glide.with(this).load(R.drawable.ic_place_24dp)
                .placeholder(R.drawable.ic_place_24dp)
                .error(R.drawable.ic_place_24dp)
                .into(ivLocationImage);
        Glide.with(this).load(R.drawable.ic_wind_speed_black_24dp)
                .placeholder(R.drawable.ic_wind_speed_black_24dp)
                .error(R.drawable.ic_wind_speed_black_24dp)
                .into(ivWindSpeedImage);

        Glide.with(this).load(R.drawable.ic_cloud_percentage_24dp)
                .placeholder(R.drawable.ic_cloud_percentage_24dp)
                .error(R.drawable.ic_cloud_percentage_24dp)
                .into(ivCloudPercentageImage);

        ivCurrentWeather.setImageResource(imageDrawable);
        tvMaxTemperature.setText(getString(R.string.max_temperature_text, forecast.getMain().getTempMax()));
        tvMinTemperature.setText(getString(R.string.min_temperature_text, forecast.getMain().getTempMin()));


        Coordinates coordinates = forecast.getCoordinates();
        tvCurrentLocation.setText(getLocationAddress(coordinates.getLatitude(), coordinates.getLongitude()));
        tvWindSpeed.setText(getString(R.string.wind_speed_text, forecast.getWind().getSpeed()));

        tvCloudPercentage.setText(String.valueOf(forecast.getClouds().getAll() + "%"));
        tvWeatherDescription.setText(weather.getDescription());
    }

    @Override
    public void onResume() {
        super.onResume();
        if (googleApiClient == null) {
            googleApiClient = new GoogleApiClient.Builder(getActivity())
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, PERMISSION_REQUEST_READ_LOCATION);

        } else {
            Location lastLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
            currentWeatherPresenter.openForecast(new Pair<>(lastLocation.getLatitude(), lastLocation.getLongitude()));
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onStart() {
        googleApiClient.connect();
        super.onStart();
    }

    @Override
    public void onStop() {
        googleApiClient.disconnect();
        super.onStop();
    }

    private String getLocationAddress(Double lat, Double lon) {
        Geocoder g = new Geocoder(getContext(), Locale.getDefault());
        String addressLine = "";
        try {
            Address a = g.getFromLocation(lat, lon, 1)
                    .get(0);
            addressLine = a.getSubLocality() + ", " + a.getCountryName();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return addressLine;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_READ_LOCATION: {
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED)
                {

                    Location lastLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
                    currentWeatherPresenter.openForecast(new Pair<>(lastLocation.getLatitude(), lastLocation.getLongitude()));
                }
            }
        }
    }
}

