package android.ksigauke.com.undertheweather.domain;

import android.ksigauke.com.undertheweather.TestUtilities;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SysTest {

    private Sys sys = new Sys(TestUtilities.COUNTRY_NAME);

    @Test
    public void testGetCountry(){
        assertTrue(sys.getCountry().equals(TestUtilities.COUNTRY_NAME));
    }
}
