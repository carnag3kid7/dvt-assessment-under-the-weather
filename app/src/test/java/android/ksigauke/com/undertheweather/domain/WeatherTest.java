package android.ksigauke.com.undertheweather.domain;

import android.ksigauke.com.undertheweather.TestUtilities;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class WeatherTest {

    private Weather weather = new Weather(TestUtilities.MAIN, TestUtilities.DESCRIPTION);

    @Test
    public void testGetMain() {
        assertTrue(weather.getMain().equals(TestUtilities.MAIN));
    }

    @Test
    public void testGetDescription(){
        assertTrue(weather.getDescription().equals(TestUtilities.DESCRIPTION));
    }
}
