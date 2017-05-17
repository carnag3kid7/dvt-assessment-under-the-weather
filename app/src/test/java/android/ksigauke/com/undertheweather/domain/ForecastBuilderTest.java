package android.ksigauke.com.undertheweather.domain;

import android.ksigauke.com.undertheweather.TestUtilities;

import org.junit.Test;

/**
 * Created by KSigauke on 2017/05/17.
 */

public class ForecastBuilderTest {
    Forecast.Builder builder = new Forecast.Builder();

    @Test
    public void testSetCoordinates(){
        builder.coordinates(new Coordinates(TestUtilities.LATITUDE, TestUtilities.LONGITUDE));
    }
}
