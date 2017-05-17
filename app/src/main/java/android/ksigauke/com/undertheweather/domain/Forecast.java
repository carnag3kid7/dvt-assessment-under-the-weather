package android.ksigauke.com.undertheweather.domain;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Forecast {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("coord")
    @Expose
    private Coordinates coordinates;

    @SerializedName("weather")
    @Expose
    private List<Weather> weather;

    @SerializedName("main")
    @Expose
    private Main main;
    private Wind wind;
    private Clouds clouds;

    @SerializedName("sys")
    @Expose
    private Sys sys;

    @SuppressWarnings("unused")
    private Forecast() {
        // no args constructor for serialization
    }

    private Forecast(Forecast.Builder builder) {
        name = builder.name;
        coordinates = builder.coordinates;
        weather = builder.weather;
        main = builder.main;
        wind = builder.wind;
        clouds = builder.clouds;
        sys = builder.sys;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public Main getMain() {
        return main;
    }

    public Wind getWind() {
        return wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public Sys getSys() {
        return sys;
    }

    public String getName() {
        return name;
    }

    public static class Builder {
        private String name;
        private Coordinates coordinates;
        private List<Weather> weather;
        private Main main;
        private Wind wind;
        private Clouds clouds;
        private Sys sys;

        public Builder name(String name) {
            this.name = name;
            return this;
        }


        public Builder coordinates(Coordinates coordinates) {
            this.coordinates = coordinates;
            return this;
        }

        public Builder weather(List<Weather> weather) {
            this.weather = weather;
            return this;
        }

        public Builder main(Main main) {
            this.main = main;
            return this;
        }

        public Builder wind(Wind wind) {
            this.wind = wind;
            return this;
        }

        public Builder clouds(Clouds clouds) {
            this.clouds = clouds;
            return this;
        }

        public Builder sys(Sys sys) {
            this.sys = sys;
            return this;
        }

        public Forecast build() {
            return new Forecast(Builder.this);
        }
    }

}
