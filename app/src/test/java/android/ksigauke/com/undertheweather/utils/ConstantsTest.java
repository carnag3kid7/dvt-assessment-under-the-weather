package android.ksigauke.com.undertheweather.utils;

import android.ksigauke.com.undertheweather.R;
import android.ksigauke.com.undertheweather.TestUtilities;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConstantsTest {

    @Test
    public void testGetCurrentWeatherImage_Returns_RainDrawable_When_WeatherConditionIsRain(){
        assertEquals(R.drawable.ic_rain, Constants.getCurrentWeatherImage(TestUtilities.RAIN));
    }

    @Test
    public void testGetCurrentWeatherImage_Returns_RainDrawable_When_WeatherConditionIsDrizzle(){
        assertEquals(R.drawable.ic_rain, Constants.getCurrentWeatherImage(TestUtilities.DRIZZLE));
    }

    @Test
    public void testGetCurrentWeatherImage_Returns_RainDrawable_When_WeatherConditionIsThunderstorms(){
        assertEquals(R.drawable.ic_rain, Constants.getCurrentWeatherImage(TestUtilities.THUNDERSTORMS));
    }

    @Test
    public void testGetCurrentWeatherImage_Returns_SnowDrawable_When_WeatherConditionIsSnow(){
        assertEquals(R.drawable.ic_snow, Constants.getCurrentWeatherImage(TestUtilities.SNOW));
    }

    @Test
    public void testGetCurrentWeatherImage_Returns_PartlyCloudyDrawable_When_WeatherConditionIsAtmosphere(){
        assertEquals(R.drawable.ic_partly_cloudy, Constants.getCurrentWeatherImage(TestUtilities.ATMOSPHERE));
    }

    @Test
    public void testGetCurrentWeatherImage_Returns_PartlyCloudyDrawable_When_WeatherConditionIsClouds(){
       assertEquals(R.drawable.ic_partly_cloudy, Constants.getCurrentWeatherImage(TestUtilities.CLOUDS));
    }

    @Test
    public void testGetCurrentWeatherImage_Returns_ClearDrawable_When_WeatherConditionIsClear(){
        assertEquals(R.drawable.ic_sun, Constants.getCurrentWeatherImage(TestUtilities.CLEAR));
    }

    @Test
    public void testGetCurrentWeatherImage_Returns_CurrentWeatherPlaceholderDrawable_When_WeatherConditionIsExtreme(){
        assertEquals(R.drawable.ic_current_weather_placeholder, Constants.getCurrentWeatherImage(TestUtilities.EXTREME));
    }

    @Test
    public void testGetCurrentWeatherImage_Returns_PartlyCloudyDrawable_When_WeatherConditionIsAdditional(){
        assertEquals(R.drawable.ic_current_weather_placeholder, Constants.getCurrentWeatherImage(TestUtilities.ADDITIONAL));
    }

    @Test
    public void testGetCurrentWeatherImage_Returns_CloudyDrawable_When_WeatherConditionIsHaze(){
        assertEquals(R.drawable.ic_cloudy, Constants.getCurrentWeatherImage(TestUtilities.HAZE));
    }


}
