package android.ksigauke.com.undertheweather.domain;

import android.ksigauke.com.undertheweather.TestUtilities;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    private Main main = new Main(TestUtilities.TEMP_MIN, TestUtilities.TEMP_MAX);

    @Test
    public void testGetTempMin(){
        assertEquals(main.getTempMin(), TestUtilities.TEMP_MIN, 0.0);
    }

    @Test
    public void testGetTempMax(){
        assertEquals(main.getTempMax(), TestUtilities.TEMP_MAX, 0.0);
    }

}
