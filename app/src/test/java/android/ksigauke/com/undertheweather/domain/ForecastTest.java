package android.ksigauke.com.undertheweather.domain;

import android.ksigauke.com.undertheweather.TestUtilities;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ForecastTest {

    private Forecast forecast = new Forecast.Builder()
            .name(TestUtilities.CITY_NAME)
            .coordinates(new Coordinates(TestUtilities.LATITUDE, TestUtilities.LONGITUDE))
            .weather(new ArrayList<Weather>() {
                {
                    add(new Weather(TestUtilities.MAIN, TestUtilities.DESCRIPTION));
                }
            })
            .main(new Main(21.43, 30.12))
            .wind(new Wind(2.2))
            .clouds(new Clouds(12))
            .sys(new Sys(TestUtilities.COUNTRY_NAME))
            .build();

    @Test
    public void testGetName(){
        assertTrue(forecast.getName().equals(TestUtilities.CITY_NAME));
    }

    @Test
    public void testGetCoordinates(){
        Coordinates coordinates = forecast.getCoordinates();
        assertNotNull(coordinates);
    }

    @Test
    public void testGetWeather(){
        List<Weather> weather = forecast.getWeather();
        assertNotNull(weather);
        assertTrue(weather.size() > 0);
    }

    @Test
    public void testGetMain(){
        Main main = forecast.getMain();
        assertNotNull(main);
    }

    @Test
    public void testGetWind(){
        Wind wind = forecast.getWind();
        assertNotNull(wind);
    }

    @Test
    public void testGetClouds(){
        Clouds clouds = forecast.getClouds();
        assertNotNull(clouds);
    }

    @Test
    public void testGetSys(){
        Sys sys = forecast.getSys();
        assertNotNull(sys);
    }
}
