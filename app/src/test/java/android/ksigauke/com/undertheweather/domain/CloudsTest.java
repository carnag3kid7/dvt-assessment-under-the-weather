package android.ksigauke.com.undertheweather.domain;

import android.ksigauke.com.undertheweather.TestUtilities;

import org.junit.Test;

import static org.junit.Assert.*;

public class CloudsTest {

    private Clouds testClouds = new Clouds(TestUtilities.CLOUD_CHANCE);

    @Test
    public void testGetAll(){
        assertEquals(testClouds.getAll(), TestUtilities.CLOUD_CHANCE);
    }

}
