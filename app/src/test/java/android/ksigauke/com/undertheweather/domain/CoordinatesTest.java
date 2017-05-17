package android.ksigauke.com.undertheweather.domain;

import android.ksigauke.com.undertheweather.TestUtilities;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoordinatesTest {

    private Coordinates coordinates = new Coordinates(TestUtilities.LATITUDE, TestUtilities.LONGITUDE);

    @Test
    public void testGetLongitude(){
        assertEquals(coordinates.getLongitude() ,TestUtilities.LONGITUDE, 0.0);
    }

    @Test
    public void testGetLatitude(){
        assertEquals(coordinates.getLatitude(), TestUtilities.LATITUDE, 0.0);
    }
}
