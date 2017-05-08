package android.ksigauke.com.undertheweather.dailyforecast;

import android.ksigauke.com.undertheweather.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

public class CurrentWeatherActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_weather);

        CurrentWeatherFragment currentWeatherFragment = new CurrentWeatherFragment();
        initFragment(currentWeatherFragment);
    }
    private void initFragment(Fragment currentWeatherFragment) {

        getSupportFragmentManager().beginTransaction().add(R.id.contentFrame, currentWeatherFragment)
                .commit();
    }

}
