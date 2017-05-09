package android.ksigauke.com.undertheweather.domain;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Forecast {

    private String base;
    private int visibility;
    private int dateRecorded;
    private int id;

    @SerializedName("name")
    @Expose
    private String name;
    private int cod;

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

    private Forecast() {

    }

    public Forecast(Forecast.Builder builder) {
        base = builder.base;
        visibility = builder.visibility;
        dateRecorded = builder.dateRecorded;
        id = builder.id;
        name = builder.name;
        cod = builder.cod;
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

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public int getDateRecorded() {
        return dateRecorded;
    }

    public void setDateRecorded(int dateRecorded) {
        this.dateRecorded = dateRecorded;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public static class Builder {
        private String base;
        private int visibility;
        private int dateRecorded;
        private int id;
        private String name;
        private int cod;
        private Coordinates coordinates;
        private List<Weather> weather;
        private Main main;
        private Wind wind;
        private Clouds clouds;
        private Sys sys;

        public Builder base(String base) {
            this.base = base;
            return this;
        }

        public Builder visibility(int visibility) {
            this.visibility = visibility;
            return this;
        }

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder dateRecorded(int dateRecorded) {
            this.dateRecorded = dateRecorded;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder cod(int cod) {
            this.cod = cod;
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
