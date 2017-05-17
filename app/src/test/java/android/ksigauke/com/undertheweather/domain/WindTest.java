package android.ksigauke.com.undertheweather.domain;

import android.ksigauke.com.undertheweather.TestUtilities;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WindTest {

    private Wind wind = new Wind(TestUtilities.WIND_SPEED);

    @Test
    public void testGetWind() {
        assertEquals(wind.getSpeed(), TestUtilities.WIND_SPEED, 0.0);
    }
}
