package theateam.com.tourmanager.Weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import java.util.List;

/**
 * Created by Hasibuzzaman on 8/22/2016.
 */
public class WeatherResponse {

    @SerializedName("response")
    @Expose
    private Response response;
    /*    @SerializedName("location")
        @Expose
        private Location location;*/
    @SerializedName("current_observation")
    @Expose
    private CurrentObservation currentObservation;
    @SerializedName("forecast")
    @Expose
    private Forecast forecast;

    /**
     *
     * @return
     * The response
     */
    public Response getResponse() {
        return response;
    }

    /**
     *
     * @param response
     * The response
     */
    public void setResponse(Response response) {
        this.response = response;
    }

    /**
     *
     * @return
    /* * The location
     *//*
    public Location getLocation() {
        return location;
    }

    *//**
     *
     * @param location
     * The location
     *//*
    public void setLocation(Location location) {
        this.location = location;
    }*/

    /**
     *
     * @return
     * The currentObservation
     */
    public CurrentObservation getCurrentObservation() {
        return currentObservation;
    }

    /**
     *
     * @param currentObservation
     * The current_observation
     */
    public void setCurrentObservation(CurrentObservation currentObservation) {
        this.currentObservation = currentObservation;
    }

    /**
     *
     * @return
     * The forecast
     */
    public Forecast getForecast() {
        return forecast;
    }

    /**
     *
     * @param forecast
     * The forecast
     */
    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }



    // Response class

    public class Response {

        @SerializedName("version")
        @Expose
        private String version;
        @SerializedName("termsofService")
        @Expose
        private String termsofService;
        @SerializedName("features")
        @Expose
        private Features features;

        /**
         *
         * @return
         * The version
         */
        public String getVersion() {
            return version;
        }

        /**
         *
         * @param version
         * The version
         */
        public void setVersion(String version) {
            this.version = version;
        }

        /**
         *
         * @return
         * The termsofService
         */
        public String getTermsofService() {
            return termsofService;
        }

        /**
         *
         * @param termsofService
         * The termsofService
         */
        public void setTermsofService(String termsofService) {
            this.termsofService = termsofService;
        }

        /**
         *
         * @return
         * The features
         */
        public Features getFeatures() {
            return features;
        }

        /**
         *
         * @param features
         * The features
         */
        public void setFeatures(Features features) {
            this.features = features;
        }

        // Start Of Features

        public class Features {

            /*      @SerializedName("geolookup")
                  @Expose
                  private Integer geolookup;*/
            @SerializedName("conditions")
            @Expose
            private Integer conditions;
            @SerializedName("forecast10day")
            @Expose
            private Integer forecast10day;

            /**
             /*  *
             * @return
             * The geolookup
             *//*
            public Integer getGeolookup() {
                return geolookup;
            }

            *//**
             *
             * @param geolookup
             * The geolookup
             *//*
            public void setGeolookup(Integer geolookup) {
                this.geolookup = geolookup;
            }
*/
            /**
             *
             * @return
             * The conditions
             */
            public Integer getConditions() {
                return conditions;
            }

            /**
             *
             * @param conditions
             * The conditions
             */
            public void setConditions(Integer conditions) {
                this.conditions = conditions;
            }

            /**
             *
             * @return
             * The forecast10day
             */
            public Integer getForecast10day() {
                return forecast10day;
            }

            /**
             *
             * @param forecast10day
             * The forecast10day
             */
            public void setForecast10day(Integer forecast10day) {
                this.forecast10day = forecast10day;
            }

        }




    } // End OF Response



    // Start Of Location

/*    public class Location {

        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("country")
        @Expose
        private String country;
        @SerializedName("country_iso3166")
        @Expose
        private String countryIso3166;
        @SerializedName("country_name")
        @Expose
        private String countryName;
        @SerializedName("state")
        @Expose
        private String state;
        @SerializedName("city")
        @Expose
        private String city;
        @SerializedName("tz_short")
        @Expose
        private String tzShort;
        @SerializedName("tz_long")
        @Expose
        private String tzLong;
        @SerializedName("lat")
        @Expose
        private String lat;
        @SerializedName("lon")
        @Expose
        private String lon;
        @SerializedName("zip")
        @Expose
        private String zip;
        @SerializedName("magic")
        @Expose
        private String magic;
        @SerializedName("wmo")
        @Expose
        private String wmo;
        @SerializedName("l")
        @Expose
        private String l;
        @SerializedName("requesturl")
        @Expose
        private String requesturl;
        @SerializedName("wuiurl")
        @Expose
        private String wuiurl;
        @SerializedName("nearby_weather_stations")
        @Expose
        private NearbyWeatherStations nearbyWeatherStations;

        *//**
     *
     * @return
     * The type
     *//*
        public String getType() {
            return type;
        }

        *//**
     *
     * @param type
     * The type
     *//*
        public void setType(String type) {
            this.type = type;
        }

        *//**
     *
     * @return
     * The country
     *//*
        public String getCountry() {
            return country;
        }

        *//**
     *
     * @param country
     * The country
     *//*
        public void setCountry(String country) {
            this.country = country;
        }

        *//**
     *
     * @return
     * The countryIso3166
     *//*
        public String getCountryIso3166() {
            return countryIso3166;
        }

        *//**
     *
     * @param countryIso3166
     * The country_iso3166
     *//*
        public void setCountryIso3166(String countryIso3166) {
            this.countryIso3166 = countryIso3166;
        }

        *//**
     *
     * @return
     * The countryName
     *//*
        public String getCountryName() {
            return countryName;
        }

        *//**
     *
     * @param countryName
     * The country_name
     *//*
        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }

        *//**
     *
     * @return
     * The state
     *//*
        public String getState() {
            return state;
        }

        *//**
     *
     * @param state
     * The state
     *//*
        public void setState(String state) {
            this.state = state;
        }

        *//**
     *
     * @return
     * The city
     *//*
        public String getCity() {
            return city;
        }

        *//**
     *
     * @param city
     * The city
     *//*
        public void setCity(String city) {
            this.city = city;
        }

        *//**
     *
     * @return
     * The tzShort
     *//*
        public String getTzShort() {
            return tzShort;
        }

        *//**
     *
     * @param tzShort
     * The tz_short
     *//*
        public void setTzShort(String tzShort) {
            this.tzShort = tzShort;
        }

        *//**
     *
     * @return
     * The tzLong
     *//*
        public String getTzLong() {
            return tzLong;
        }

        *//**
     *
     * @param tzLong
     * The tz_long
     *//*
        public void setTzLong(String tzLong) {
            this.tzLong = tzLong;
        }

        *//**
     *
     * @return
     * The lat
     *//*
        public String getLat() {
            return lat;
        }

        *//**
     *
     * @param lat
     * The lat
     *//*
        public void setLat(String lat) {
            this.lat = lat;
        }

        *//**
     *
     * @return
     * The lon
     *//*
        public String getLon() {
            return lon;
        }

        *//**
     *
     * @param lon
     * The lon
     *//*
        public void setLon(String lon) {
            this.lon = lon;
        }

        *//**
     *
     * @return
     * The zip
     *//*
        public String getZip() {
            return zip;
        }

        *//**
     *
     * @param zip
     * The zip
     *//*
        public void setZip(String zip) {
            this.zip = zip;
        }

        *//**
     *
     * @return
     * The magic
     *//*
        public String getMagic() {
            return magic;
        }

        *//**
     *
     * @param magic
     * The magic
     *//*
        public void setMagic(String magic) {
            this.magic = magic;
        }

        *//**
     *
     * @return
     * The wmo
     *//*
        public String getWmo() {
            return wmo;
        }

        *//**
     *
     * @param wmo
     * The wmo
     *//*
        public void setWmo(String wmo) {
            this.wmo = wmo;
        }

        *//**
     *
     * @return
     * The l
     *//*
        public String getL() {
            return l;
        }

        *//**
     *
     * @param l
     * The l
     *//*
        public void setL(String l) {
            this.l = l;
        }

        *//**
     *
     * @return
     * The requesturl
     *//*
        public String getRequesturl() {
            return requesturl;
        }

        *//**
     *
     * @param requesturl
     * The requesturl
     *//*
        public void setRequesturl(String requesturl) {
            this.requesturl = requesturl;
        }

        *//**
     *
     * @return
     * The wuiurl
     *//*
        public String getWuiurl() {
            return wuiurl;
        }

        *//**
     *
     * @param wuiurl
     * The wuiurl
     *//*
        public void setWuiurl(String wuiurl) {
            this.wuiurl = wuiurl;
        }

        *//**
     *
     * @return
     * The nearbyWeatherStations
     *//*
        public NearbyWeatherStations getNearbyWeatherStations() {
            return nearbyWeatherStations;
        }

        *//**
     *
     * @param nearbyWeatherStations
     * The nearby_weather_stations
     *//*
        public void setNearbyWeatherStations(NearbyWeatherStations nearbyWeatherStations) {
            this.nearbyWeatherStations = nearbyWeatherStations;
        }


        // Start Of NearbyWeatherStations

        public class NearbyWeatherStations {

            @SerializedName("airport")
            @Expose
            private Airport airport;
            @SerializedName("pws")
            @Expose
            private Pws pws;

            *//**
     *
     * @return
     * The airport
     *//*
            public Airport getAirport() {
                return airport;
            }

            *//**
     *
     * @param airport
     * The airport
     *//*
            public void setAirport(Airport airport) {
                this.airport = airport;
            }

            *//**
     *
     * @return
     * The pws
     *//*
            public Pws getPws() {
                return pws;
            }

            *//**
     *
     * @param pws
     * The pws
     *//*
            public void setPws(Pws pws) {
                this.pws = pws;
            }

            // Start Of Pws

            public class Pws {

                @SerializedName("station")
                @Expose
                private List<Station_> station = new ArrayList<Station_>();

                *//**
     *
     * @return
     * The station
     *//*
                public List<Station_> getStation() {
                    return station;
                }

                *//**
     *
     * @param station
     * The station
     *//*
                public void setStation(List<Station_> station) {
                    this.station = station;
                }

                // Start oF sTATION_

                public class Station_ {

                    @SerializedName("neighborhood")
                    @Expose
                    private String neighborhood;
                    @SerializedName("city")
                    @Expose
                    private String city;
                    @SerializedName("state")
                    @Expose
                    private String state;
                    @SerializedName("country")
                    @Expose
                    private String country;
                    @SerializedName("id")
                    @Expose
                    private String id;
                    @SerializedName("lat")
                    @Expose
                    private Double lat;
                    @SerializedName("lon")
                    @Expose
                    private Double lon;
                    @SerializedName("distance_km")
                    @Expose
                    private Integer distanceKm;
                    @SerializedName("distance_mi")
                    @Expose
                    private Integer distanceMi;

                    *//**
     *
     * @return
     * The neighborhood
     *//*
                    public String getNeighborhood() {
                        return neighborhood;
                    }

                    *//**
     *
     * @param neighborhood
     * The neighborhood
     *//*
                    public void setNeighborhood(String neighborhood) {
                        this.neighborhood = neighborhood;
                    }

                    *//**
     *
     * @return
     * The city
     *//*
                    public String getCity() {
                        return city;
                    }

                    *//**
     *
     * @param city
     * The city
     *//*
                    public void setCity(String city) {
                        this.city = city;
                    }

                    *//**
     *
     * @return
     * The state
     *//*
                    public String getState() {
                        return state;
                    }

                    *//**
     *
     * @param state
     * The state
     *//*
                    public void setState(String state) {
                        this.state = state;
                    }

                    *//**
     *
     * @return
     * The country
     *//*
                    public String getCountry() {
                        return country;
                    }

                    *//**
     *
     * @param country
     * The country
     *//*
                    public void setCountry(String country) {
                        this.country = country;
                    }

                    *//**
     *
     * @return
     * The id
     *//*
                    public String getId() {
                        return id;
                    }

                    *//**
     *
     * @param id
     * The id
     *//*
                    public void setId(String id) {
                        this.id = id;
                    }

                    *//**
     *
     * @return
     * The lat
     *//*
                    public Double getLat() {
                        return lat;
                    }

                    *//**
     *
     * @param lat
     * The lat
     *//*
                    public void setLat(Double lat) {
                        this.lat = lat;
                    }

                    *//**
     *
     * @return
     * The lon
     *//*
                    public Double getLon() {
                        return lon;
                    }

                    *//**
     *
     * @param lon
     * The lon
     *//*
                    public void setLon(Double lon) {
                        this.lon = lon;
                    }

                    *//**
     *
     * @return
     * The distanceKm
     *//*
                    public Integer getDistanceKm() {
                        return distanceKm;
                    }

                    *//**
     *
     * @param distanceKm
     * The distance_km
     *//*
                    public void setDistanceKm(Integer distanceKm) {
                        this.distanceKm = distanceKm;
                    }

                    *//**
     *
     * @return
     * The distanceMi
     *//*
                    public Integer getDistanceMi() {
                        return distanceMi;
                    }

                    *//**
     *
     * @param distanceMi
     * The distance_mi
     *//*
                    public void setDistanceMi(Integer distanceMi) {
                        this.distanceMi = distanceMi;
                    }

                }



            }



        }// End Of NearbySearch Stations


        // Start Of Airport
        public class Airport {

            @SerializedName("station")
            @Expose
            private List<Station> station = new ArrayList<Station>();

            *//**
     *
     * @return
     * The station
     *//*
            public List<Station> getStation() {
                return station;
            }

            *//**
     *
     * @param station
     * The station
     *//*
            public void setStation(List<Station> station) {
                this.station = station;
            }

        }

        // Start Of Station



        public class Station {

            @SerializedName("city")
            @Expose
            private String city;
            @SerializedName("state")
            @Expose
            private String state;
            @SerializedName("country")
            @Expose
            private String country;
            @SerializedName("icao")
            @Expose
            private String icao;
            @SerializedName("lat")
            @Expose
            private String lat;
            @SerializedName("lon")
            @Expose
            private String lon;

            *//**
     *
     * @return
     * The city
     *//*
            public String getCity() {
                return city;
            }

            *//**
     *
     * @param city
     * The city
     *//*
            public void setCity(String city) {
                this.city = city;
            }

            *//**
     *
     * @return
     * The state
     *//*
            public String getState() {
                return state;
            }

            *//**
     *
     * @param state
     * The state
     *//*
            public void setState(String state) {
                this.state = state;
            }

            *//**
     *
     * @return
     * The country
     *//*
            public String getCountry() {
                return country;
            }

            *//**
     *
     * @param country
     * The country
     *//*
            public void setCountry(String country) {
                this.country = country;
            }

            *//**
     *
     * @return
     * The icao
     *//*
            public String getIcao() {
                return icao;
            }

            *//**
     *
     * @param icao
     * The icao
     *//*
            public void setIcao(String icao) {
                this.icao = icao;
            }

            *//**
     *
     * @return
     * The lat
     *//*
            public String getLat() {
                return lat;
            }

            *//**
     *
     * @param lat
     * The lat
     *//*
            public void setLat(String lat) {
                this.lat = lat;
            }

            *//**
     *
     * @return
     * The lon
     *//*
            public String getLon() {
                return lon;
            }

            *//**
     *

     * The lon
     *//*
            public void setLon(String lon) {
                this.lon = lon;
            }

        }



    }  // End Of Location*/

    //Start Of Current Obserbation



    public class CurrentObservation {

        @SerializedName("image")
        @Expose
        private Image image;
        @SerializedName("display_location")
        @Expose
        private DisplayLocation displayLocation;
        @SerializedName("observation_location")
        @Expose
        private ObservationLocation observationLocation;
        @SerializedName("estimated")
        @Expose
        private Estimated estimated;
        @SerializedName("station_id")
        @Expose
        private String stationId;
        @SerializedName("observation_time")
        @Expose
        private String observationTime;
        @SerializedName("observation_time_rfc822")
        @Expose
        private String observationTimeRfc822;
        @SerializedName("observation_epoch")
        @Expose
        private String observationEpoch;
        @SerializedName("local_time_rfc822")
        @Expose
        private String localTimeRfc822;
        @SerializedName("local_epoch")
        @Expose
        private String localEpoch;
        @SerializedName("local_tz_short")
        @Expose
        private String localTzShort;
        @SerializedName("local_tz_long")
        @Expose
        private String localTzLong;
        @SerializedName("local_tz_offset")
        @Expose
        private String localTzOffset;
        @SerializedName("weather")
        @Expose
        private String weather;
        @SerializedName("temperature_string")
        @Expose
        private String temperatureString;
        @SerializedName("temp_f")
        @Expose
        private Double tempF;
        @SerializedName("temp_c")
        @Expose
        private Double tempC;
        @SerializedName("relative_humidity")
        @Expose
        private String relativeHumidity;
        @SerializedName("wind_string")
        @Expose
        private String windString;
        @SerializedName("wind_dir")
        @Expose
        private String windDir;
        @SerializedName("wind_degrees")
        @Expose
        private Integer windDegrees;
        @SerializedName("wind_mph")
        @Expose
        private Double windMph;
        @SerializedName("wind_gust_mph")
        @Expose
        private String windGustMph;
        @SerializedName("wind_kph")
        @Expose
        private Double windKph;
        @SerializedName("wind_gust_kph")
        @Expose
        private String windGustKph;
        @SerializedName("pressure_mb")
        @Expose
        private String pressureMb;
        @SerializedName("pressure_in")
        @Expose
        private String pressureIn;
        @SerializedName("pressure_trend")
        @Expose
        private String pressureTrend;
        @SerializedName("dewpoint_string")
        @Expose
        private String dewpointString;
        @SerializedName("dewpoint_f")
        @Expose
        private Integer dewpointF;
        @SerializedName("dewpoint_c")
        @Expose
        private Integer dewpointC;
        @SerializedName("heat_index_string")
        @Expose
        private String heatIndexString;
        @SerializedName("heat_index_f")
        @Expose
        private String heatIndexF;
        @SerializedName("heat_index_c")
        @Expose
        private String heatIndexC;
        @SerializedName("windchill_string")
        @Expose
        private String windchillString;
        @SerializedName("windchill_f")
        @Expose
        private String windchillF;
        @SerializedName("windchill_c")
        @Expose
        private String windchillC;
        @SerializedName("feelslike_string")
        @Expose
        private String feelslikeString;
        @SerializedName("feelslike_f")
        @Expose
        private String feelslikeF;
        @SerializedName("feelslike_c")
        @Expose
        private String feelslikeC;
        @SerializedName("visibility_mi")
        @Expose
        private String visibilityMi;
        @SerializedName("visibility_km")
        @Expose
        private String visibilityKm;
        @SerializedName("solarradiation")
        @Expose
        private String solarradiation;
        @SerializedName("UV")
        @Expose
        private String uV;
        @SerializedName("precip_1hr_string")
        @Expose
        private String precip1hrString;
        @SerializedName("precip_1hr_in")
        @Expose
        private String precip1hrIn;
        @SerializedName("precip_1hr_metric")
        @Expose
        private String precip1hrMetric;
        @SerializedName("precip_today_string")
        @Expose
        private String precipTodayString;
        @SerializedName("precip_today_in")
        @Expose
        private String precipTodayIn;
        @SerializedName("precip_today_metric")
        @Expose
        private String precipTodayMetric;
        @SerializedName("icon")
        @Expose
        private String icon;
        @SerializedName("icon_url")
        @Expose
        private String iconUrl;
        @SerializedName("forecast_url")
        @Expose
        private String forecastUrl;
        @SerializedName("history_url")
        @Expose
        private String historyUrl;
        @SerializedName("ob_url")
        @Expose
        private String obUrl;
        @SerializedName("nowcast")
        @Expose
        private String nowcast;

        /**
         *
         * @return
         * The image
         */
        public Image getImage() {
            return image;
        }

        /**
         *
         * @param image
         * The image
         */
        public void setImage(Image image) {
            this.image = image;
        }

        /**
         *
         * @return
         * The displayLocation
         */
        public DisplayLocation getDisplayLocation() {
            return displayLocation;
        }

        /**
         *
         * @param displayLocation
         * The display_location
         */
        public void setDisplayLocation(DisplayLocation displayLocation) {
            this.displayLocation = displayLocation;
        }

        /**
         *
         * @return
         * The observationLocation
         */
        public ObservationLocation getObservationLocation() {
            return observationLocation;
        }

        /**
         *
         * @param observationLocation
         * The observation_location
         */
        public void setObservationLocation(ObservationLocation observationLocation) {
            this.observationLocation = observationLocation;
        }

        /**
         *
         * @return
         * The estimated
         */
        public Estimated getEstimated() {
            return estimated;
        }

        /**
         *
         * @param estimated
         * The estimated
         */
        public void setEstimated(Estimated estimated) {
            this.estimated = estimated;
        }

        /**
         *
         * @return
         * The stationId
         */
        public String getStationId() {
            return stationId;
        }

        /**
         *
         * @param stationId
         * The station_id
         */
        public void setStationId(String stationId) {
            this.stationId = stationId;
        }

        /**
         *
         * @return
         * The observationTime
         */
        public String getObservationTime() {
            return observationTime;
        }

        /**
         *
         * @param observationTime
         * The observation_time
         */
        public void setObservationTime(String observationTime) {
            this.observationTime = observationTime;
        }

        /**
         *
         * @return
         * The observationTimeRfc822
         */
        public String getObservationTimeRfc822() {
            return observationTimeRfc822;
        }

        /**
         *
         * @param observationTimeRfc822
         * The observation_time_rfc822
         */
        public void setObservationTimeRfc822(String observationTimeRfc822) {
            this.observationTimeRfc822 = observationTimeRfc822;
        }

        /**
         *
         * @return
         * The observationEpoch
         */
        public String getObservationEpoch() {
            return observationEpoch;
        }

        /**
         *
         * @param observationEpoch
         * The observation_epoch
         */
        public void setObservationEpoch(String observationEpoch) {
            this.observationEpoch = observationEpoch;
        }

        /**
         *
         * @return
         * The localTimeRfc822
         */
        public String getLocalTimeRfc822() {
            return localTimeRfc822;
        }

        /**
         *
         * @param localTimeRfc822
         * The local_time_rfc822
         */
        public void setLocalTimeRfc822(String localTimeRfc822) {
            this.localTimeRfc822 = localTimeRfc822;
        }

        /**
         *
         * @return
         * The localEpoch
         */
        public String getLocalEpoch() {
            return localEpoch;
        }

        /**
         *
         * @param localEpoch
         * The local_epoch
         */
        public void setLocalEpoch(String localEpoch) {
            this.localEpoch = localEpoch;
        }

        /**
         *
         * @return
         * The localTzShort
         */
        public String getLocalTzShort() {
            return localTzShort;
        }

        /**
         *
         * @param localTzShort
         * The local_tz_short
         */
        public void setLocalTzShort(String localTzShort) {
            this.localTzShort = localTzShort;
        }

        /**
         *
         * @return
         * The localTzLong
         */
        public String getLocalTzLong() {
            return localTzLong;
        }

        /**
         *
         * @param localTzLong
         * The local_tz_long
         */
        public void setLocalTzLong(String localTzLong) {
            this.localTzLong = localTzLong;
        }

        /**
         *
         * @return
         * The localTzOffset
         */
        public String getLocalTzOffset() {
            return localTzOffset;
        }

        /**
         *
         * @param localTzOffset
         * The local_tz_offset
         */
        public void setLocalTzOffset(String localTzOffset) {
            this.localTzOffset = localTzOffset;
        }

        /**
         *
         * @return
         * The weather
         */
        public String getWeather() {
            return weather;
        }

        /**
         *
         * @param weather
         * The weather
         */
        public void setWeather(String weather) {
            this.weather = weather;
        }

        /**
         *
         * @return
         * The temperatureString
         */
        public String getTemperatureString() {
            return temperatureString;
        }

        /**
         *
         * @param temperatureString
         * The temperature_string
         */
        public void setTemperatureString(String temperatureString) {
            this.temperatureString = temperatureString;
        }

        /**
         *
         * @return
         * The tempF
         */
        public Double getTempF() {
            return tempF;
        }

        /**
         *
         * @param tempF
         * The temp_f
         */
        public void setTempF(Double tempF) {
            this.tempF = tempF;
        }

        /**
         *
         * @return
         * The tempC
         */
        public Double getTempC() {
            return tempC;
        }

        /**
         *
         * @param tempC
         * The temp_c
         */
        public void setTempC(Double tempC) {
            this.tempC = tempC;
        }

        /**
         *
         * @return
         * The relativeHumidity
         */
        public String getRelativeHumidity() {
            return relativeHumidity;
        }

        /**
         *
         * @param relativeHumidity
         * The relative_humidity
         */
        public void setRelativeHumidity(String relativeHumidity) {
            this.relativeHumidity = relativeHumidity;
        }

        /**
         *
         * @return
         * The windString
         */
        public String getWindString() {
            return windString;
        }

        /**
         *
         * @param windString
         * The wind_string
         */
        public void setWindString(String windString) {
            this.windString = windString;
        }

        /**
         *
         * @return
         * The windDir
         */
        public String getWindDir() {
            return windDir;
        }

        /**
         *
         * @param windDir
         * The wind_dir
         */
        public void setWindDir(String windDir) {
            this.windDir = windDir;
        }

        /**
         *
         * @return
         * The windDegrees
         */
        public Integer getWindDegrees() {
            return windDegrees;
        }

        /**
         *
         * @param windDegrees
         * The wind_degrees
         */
        public void setWindDegrees(Integer windDegrees) {
            this.windDegrees = windDegrees;
        }

        /**
         *
         * @return
         * The windMph
         */
        public Double getWindMph() {
            return windMph;
        }

        /**
         *
         * @param windMph
         * The wind_mph
         */
        public void setWindMph(Double windMph) {
            this.windMph = windMph;
        }

        /**
         *
         * @return
         * The windGustMph
         */
        public String getWindGustMph() {
            return windGustMph;
        }

        /**
         *
         * @param windGustMph
         * The wind_gust_mph
         */
        public void setWindGustMph(String windGustMph) {
            this.windGustMph = windGustMph;
        }

        /**
         *
         * @return
         * The windKph
         */
        public Double getWindKph() {
            return windKph;
        }

        /**
         *
         * @param windKph
         * The wind_kph
         */
        public void setWindKph(Double windKph) {
            this.windKph = windKph;
        }

        /**
         *
         * @return
         * The windGustKph
         */
        public String getWindGustKph() {
            return windGustKph;
        }

        /**
         *
         * @param windGustKph
         * The wind_gust_kph
         */
        public void setWindGustKph(String windGustKph) {
            this.windGustKph = windGustKph;
        }

        /**
         *
         * @return
         * The pressureMb
         */
        public String getPressureMb() {
            return pressureMb;
        }

        /**
         *
         * @param pressureMb
         * The pressure_mb
         */
        public void setPressureMb(String pressureMb) {
            this.pressureMb = pressureMb;
        }

        /**
         *
         * @return
         * The pressureIn
         */
        public String getPressureIn() {
            return pressureIn;
        }

        /**
         *
         * @param pressureIn
         * The pressure_in
         */
        public void setPressureIn(String pressureIn) {
            this.pressureIn = pressureIn;
        }

        /**
         *
         * @return
         * The pressureTrend
         */
        public String getPressureTrend() {
            return pressureTrend;
        }

        /**
         *
         * @param pressureTrend
         * The pressure_trend
         */
        public void setPressureTrend(String pressureTrend) {
            this.pressureTrend = pressureTrend;
        }

        /**
         *
         * @return
         * The dewpointString
         */
        public String getDewpointString() {
            return dewpointString;
        }

        /**
         *
         * @param dewpointString
         * The dewpoint_string
         */
        public void setDewpointString(String dewpointString) {
            this.dewpointString = dewpointString;
        }

        /**
         *
         * @return
         * The dewpointF
         */
        public Integer getDewpointF() {
            return dewpointF;
        }

        /**
         *
         * @param dewpointF
         * The dewpoint_f
         */
        public void setDewpointF(Integer dewpointF) {
            this.dewpointF = dewpointF;
        }

        /**
         *
         * @return
         * The dewpointC
         */
        public Integer getDewpointC() {
            return dewpointC;
        }

        /**
         *
         * @param dewpointC
         * The dewpoint_c
         */
        public void setDewpointC(Integer dewpointC) {
            this.dewpointC = dewpointC;
        }

        /**
         *
         * @return
         * The heatIndexString
         */
        public String getHeatIndexString() {
            return heatIndexString;
        }

        /**
         *
         * @param heatIndexString
         * The heat_index_string
         */
        public void setHeatIndexString(String heatIndexString) {
            this.heatIndexString = heatIndexString;
        }

        /**
         *
         * @return
         * The heatIndexF
         */
        public String getHeatIndexF() {
            return heatIndexF;
        }

        /**
         *
         * @param heatIndexF
         * The heat_index_f
         */
        public void setHeatIndexF(String heatIndexF) {
            this.heatIndexF = heatIndexF;
        }

        /**
         *
         * @return
         * The heatIndexC
         */
        public String getHeatIndexC() {
            return heatIndexC;
        }

        /**
         *
         * @param heatIndexC
         * The heat_index_c
         */
        public void setHeatIndexC(String heatIndexC) {
            this.heatIndexC = heatIndexC;
        }

        /**
         *
         * @return
         * The windchillString
         */
        public String getWindchillString() {
            return windchillString;
        }

        /**
         *
         * @param windchillString
         * The windchill_string
         */
        public void setWindchillString(String windchillString) {
            this.windchillString = windchillString;
        }

        /**
         *
         * @return
         * The windchillF
         */
        public String getWindchillF() {
            return windchillF;
        }

        /**
         *
         * @param windchillF
         * The windchill_f
         */
        public void setWindchillF(String windchillF) {
            this.windchillF = windchillF;
        }

        /**
         *
         * @return
         * The windchillC
         */
        public String getWindchillC() {
            return windchillC;
        }

        /**
         *
         * @param windchillC
         * The windchill_c
         */
        public void setWindchillC(String windchillC) {
            this.windchillC = windchillC;
        }

        /**
         *
         * @return
         * The feelslikeString
         */
        public String getFeelslikeString() {
            return feelslikeString;
        }

        /**
         *
         * @param feelslikeString
         * The feelslike_string
         */
        public void setFeelslikeString(String feelslikeString) {
            this.feelslikeString = feelslikeString;
        }

        /**
         *
         * @return
         * The feelslikeF
         */
        public String getFeelslikeF() {
            return feelslikeF;
        }

        /**
         *
         * @param feelslikeF
         * The feelslike_f
         */
        public void setFeelslikeF(String feelslikeF) {
            this.feelslikeF = feelslikeF;
        }

        /**
         *
         * @return
         * The feelslikeC
         */
        public String getFeelslikeC() {
            return feelslikeC;
        }

        /**
         *
         * @param feelslikeC
         * The feelslike_c
         */
        public void setFeelslikeC(String feelslikeC) {
            this.feelslikeC = feelslikeC;
        }

        /**
         *
         * @return
         * The visibilityMi
         */
        public String getVisibilityMi() {
            return visibilityMi;
        }

        /**
         *
         * @param visibilityMi
         * The visibility_mi
         */
        public void setVisibilityMi(String visibilityMi) {
            this.visibilityMi = visibilityMi;
        }

        /**
         *
         * @return
         * The visibilityKm
         */
        public String getVisibilityKm() {
            return visibilityKm;
        }

        /**
         *
         * @param visibilityKm
         * The visibility_km
         */
        public void setVisibilityKm(String visibilityKm) {
            this.visibilityKm = visibilityKm;
        }

        /**
         *
         * @return
         * The solarradiation
         */
        public String getSolarradiation() {
            return solarradiation;
        }

        /**
         *
         * @param solarradiation
         * The solarradiation
         */
        public void setSolarradiation(String solarradiation) {
            this.solarradiation = solarradiation;
        }

        /**
         *
         * @return
         * The uV
         */
        public String getUV() {
            return uV;
        }

        /**
         *
         * @param uV
         * The UV
         */
        public void setUV(String uV) {
            this.uV = uV;
        }

        /**
         *
         * @return
         * The precip1hrString
         */
        public String getPrecip1hrString() {
            return precip1hrString;
        }

        /**
         *
         * @param precip1hrString
         * The precip_1hr_string
         */
        public void setPrecip1hrString(String precip1hrString) {
            this.precip1hrString = precip1hrString;
        }

        /**
         *
         * @return
         * The precip1hrIn
         */
        public String getPrecip1hrIn() {
            return precip1hrIn;
        }

        /**
         *
         * @param precip1hrIn
         * The precip_1hr_in
         */
        public void setPrecip1hrIn(String precip1hrIn) {
            this.precip1hrIn = precip1hrIn;
        }

        /**
         *
         * @return
         * The precip1hrMetric
         */
        public String getPrecip1hrMetric() {
            return precip1hrMetric;
        }

        /**
         *
         * @param precip1hrMetric
         * The precip_1hr_metric
         */
        public void setPrecip1hrMetric(String precip1hrMetric) {
            this.precip1hrMetric = precip1hrMetric;
        }

        /**
         *
         * @return
         * The precipTodayString
         */
        public String getPrecipTodayString() {
            return precipTodayString;
        }

        /**
         *
         * @param precipTodayString
         * The precip_today_string
         */
        public void setPrecipTodayString(String precipTodayString) {
            this.precipTodayString = precipTodayString;
        }

        /**
         *
         * @return
         * The precipTodayIn
         */
        public String getPrecipTodayIn() {
            return precipTodayIn;
        }

        /**
         *
         * @param precipTodayIn
         * The precip_today_in
         */
        public void setPrecipTodayIn(String precipTodayIn) {
            this.precipTodayIn = precipTodayIn;
        }

        /**
         *
         * @return
         * The precipTodayMetric
         */
        public String getPrecipTodayMetric() {
            return precipTodayMetric;
        }

        /**
         *
         * @param precipTodayMetric
         * The precip_today_metric
         */
        public void setPrecipTodayMetric(String precipTodayMetric) {
            this.precipTodayMetric = precipTodayMetric;
        }

        /**
         *
         * @return
         * The icon
         */
        public String getIcon() {
            return icon;
        }

        /**
         *
         * @param icon
         * The icon
         */
        public void setIcon(String icon) {
            this.icon = icon;
        }

        /**
         *
         * @return
         * The iconUrl
         */
        public String getIconUrl() {
            return iconUrl;
        }

        /**
         *
         * @param iconUrl
         * The icon_url
         */
        public void setIconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
        }

        /**
         *
         * @return
         * The forecastUrl
         */
        public String getForecastUrl() {
            return forecastUrl;
        }

        /**
         *
         * @param forecastUrl
         * The forecast_url
         */
        public void setForecastUrl(String forecastUrl) {
            this.forecastUrl = forecastUrl;
        }

        /**
         *
         * @return
         * The historyUrl
         */
        public String getHistoryUrl() {
            return historyUrl;
        }

        /**
         *
         * @param historyUrl
         * The history_url
         */
        public void setHistoryUrl(String historyUrl) {
            this.historyUrl = historyUrl;
        }

        /**
         *
         * @return
         * The obUrl
         */
        public String getObUrl() {
            return obUrl;
        }

        /**
         *
         * @param obUrl
         * The ob_url
         */
        public void setObUrl(String obUrl) {
            this.obUrl = obUrl;
        }

        /**
         *
         * @return
         * The nowcast
         */
        public String getNowcast() {
            return nowcast;
        }

        /**
         *
         * @param nowcast
         * The nowcast
         */
        public void setNowcast(String nowcast) {
            this.nowcast = nowcast;
        }




        // Start of image

        public class Image {

            @SerializedName("url")
            @Expose
            private String url;
            @SerializedName("title")
            @Expose
            private String title;
            @SerializedName("link")
            @Expose
            private String link;

            /**
             *
             * @return
             * The url
             */
            public String getUrl() {
                return url;
            }

            /**
             *
             * @param url
             * The url
             */
            public void setUrl(String url) {
                this.url = url;
            }

            /**
             *
             * @return
             * The title
             */
            public String getTitle() {
                return title;
            }

            /**
             *
             * @param title
             * The title
             */
            public void setTitle(String title) {
                this.title = title;
            }

            /**
             *
             * @return
             * The link
             */
            public String getLink() {
                return link;
            }

            /**
             *
             * @param link
             * The link
             */
            public void setLink(String link) {
                this.link = link;
            }

        }// End Of Image

        // Start Of DisplayLocation

        public class DisplayLocation {

            @SerializedName("full")
            @Expose
            private String full;
            @SerializedName("city")
            @Expose
            private String city;
            @SerializedName("state")
            @Expose
            private String state;
            @SerializedName("state_name")
            @Expose
            private String stateName;
            @SerializedName("country")
            @Expose
            private String country;
            @SerializedName("country_iso3166")
            @Expose
            private String countryIso3166;
            @SerializedName("zip")
            @Expose
            private String zip;
            @SerializedName("magic")
            @Expose
            private String magic;
            @SerializedName("wmo")
            @Expose
            private String wmo;
            @SerializedName("latitude")
            @Expose
            private String latitude;
            @SerializedName("longitude")
            @Expose
            private String longitude;
            @SerializedName("elevation")
            @Expose
            private String elevation;

            /**
             *
             * @return
             * The full
             */
            public String getFull() {
                return full;
            }

            /**
             *
             * @param full
             * The full
             */
            public void setFull(String full) {
                this.full = full;
            }

            /**
             *
             * @return
             * The city
             */
            public String getCity() {
                return city;
            }

            /**
             *
             * @param city
             * The city
             */
            public void setCity(String city) {
                this.city = city;
            }

            /**
             *
             * @return
             * The state
             */
            public String getState() {
                return state;
            }

            /**
             *
             * @param state
             * The state
             */
            public void setState(String state) {
                this.state = state;
            }

            /**
             *
             * @return
             * The stateName
             */
            public String getStateName() {
                return stateName;
            }

            /**
             *
             * @param stateName
             * The state_name
             */
            public void setStateName(String stateName) {
                this.stateName = stateName;
            }

            /**
             *
             * @return
             * The country
             */
            public String getCountry() {
                return country;
            }

            /**
             *
             * @param country
             * The country
             */
            public void setCountry(String country) {
                this.country = country;
            }

            /**
             *
             * @return
             * The countryIso3166
             */
            public String getCountryIso3166() {
                return countryIso3166;
            }

            /**
             *
             * @param countryIso3166
             * The country_iso3166
             */
            public void setCountryIso3166(String countryIso3166) {
                this.countryIso3166 = countryIso3166;
            }

            /**
             *
             * @return
             * The zip
             */
            public String getZip() {
                return zip;
            }

            /**
             *
             * @param zip
             * The zip
             */
            public void setZip(String zip) {
                this.zip = zip;
            }

            /**
             *
             * @return
             * The magic
             */
            public String getMagic() {
                return magic;
            }

            /**
             *
             * @param magic
             * The magic
             */
            public void setMagic(String magic) {
                this.magic = magic;
            }

            /**
             *
             * @return
             * The wmo
             */
            public String getWmo() {
                return wmo;
            }

            /**
             *
             * @param wmo
             * The wmo
             */
            public void setWmo(String wmo) {
                this.wmo = wmo;
            }

            /**
             *
             * @return
             * The latitude
             */
            public String getLatitude() {
                return latitude;
            }

            /**
             *
             * @param latitude
             * The latitude
             */
            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            /**
             *
             * @return
             * The longitude
             */
            public String getLongitude() {
                return longitude;
            }

            /**
             *
             * @param longitude
             * The longitude
             */
            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            /**
             *
             * @return
             * The elevation
             */
            public String getElevation() {
                return elevation;
            }

            /**
             *
             * @param elevation
             * The elevation
             */
            public void setElevation(String elevation) {
                this.elevation = elevation;
            }

        }  // DisplayLocation

        public class ObservationLocation {

            @SerializedName("full")
            @Expose
            private String full;
            @SerializedName("city")
            @Expose
            private String city;
            @SerializedName("state")
            @Expose
            private String state;
            @SerializedName("country")
            @Expose
            private String country;
            @SerializedName("country_iso3166")
            @Expose
            private String countryIso3166;
            @SerializedName("latitude")
            @Expose
            private String latitude;
            @SerializedName("longitude")
            @Expose
            private String longitude;
            @SerializedName("elevation")
            @Expose
            private String elevation;

            /**
             *
             * @return
             * The full
             */
            public String getFull() {
                return full;
            }

            /**
             *
             * @param full
             * The full
             */
            public void setFull(String full) {
                this.full = full;
            }

            /**
             *
             * @return
             * The city
             */
            public String getCity() {
                return city;
            }

            /**
             *
             * @param city
             * The city
             */
            public void setCity(String city) {
                this.city = city;
            }

            /**
             *
             * @return
             * The state
             */
            public String getState() {
                return state;
            }

            /**
             *
             * @param state
             * The state
             */
            public void setState(String state) {
                this.state = state;
            }

            /**
             *
             * @return
             * The country
             */
            public String getCountry() {
                return country;
            }

            /**
             *
             * @param country
             * The country
             */
            public void setCountry(String country) {
                this.country = country;
            }

            /**
             *
             * @return
             * The countryIso3166
             */
            public String getCountryIso3166() {
                return countryIso3166;
            }

            /**
             *
             * @param countryIso3166
             * The country_iso3166
             */
            public void setCountryIso3166(String countryIso3166) {
                this.countryIso3166 = countryIso3166;
            }

            /**
             *
             * @return
             * The latitude
             */
            public String getLatitude() {
                return latitude;
            }

            /**
             *
             * @param latitude
             * The latitude
             */
            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            /**
             *
             * @return
             * The longitude
             */
            public String getLongitude() {
                return longitude;
            }

            /**
             *
             * @param longitude
             * The longitude
             */
            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            /**
             *
             * @return
             * The elevation
             */
            public String getElevation() {
                return elevation;
            }

            /**
             *
             * @param elevation
             * The elevation
             */
            public void setElevation(String elevation) {
                this.elevation = elevation;
            }

        }


        public class Estimated {


        }




    }  // End Of Current Obserbation

    public class Forecast {

        @SerializedName("txt_forecast")
        @Expose
        private TxtForecast txtForecast;
        @SerializedName("simpleforecast")
        @Expose
        private Simpleforecast simpleforecast;

        /**
         *
         * @return
         * The txtForecast
         */
        public TxtForecast getTxtForecast() {
            return txtForecast;
        }

        /**
         *
         * @param txtForecast
         * The txt_forecast
         */
        public void setTxtForecast(TxtForecast txtForecast) {
            this.txtForecast = txtForecast;
        }

        /**
         *
         * @return
         * The simpleforecast
         */
        public Simpleforecast getSimpleforecast() {
            return simpleforecast;
        }

        /**
         *
         * @param simpleforecast
         * The simpleforecast
         */
        public void setSimpleforecast(Simpleforecast simpleforecast) {
            this.simpleforecast = simpleforecast;
        }


        // Start of TXTFORCAST

        public class TxtForecast {

            @SerializedName("date")
            @Expose
            private String date;
            @SerializedName("forecastday")
            @Expose
            private List<Forecastday> forecastday = new ArrayList<Forecastday>();

            /**
             *
             * @return
             * The date
             */
            public String getDate() {
                return date;
            }

            /**
             *
             * @param date
             * The date
             */
            public void setDate(String date) {
                this.date = date;
            }

            /**
             *
             * @return
             * The forecastday
             */
            public List<Forecastday> getForecastday() {
                return forecastday;
            }

            /**
             *
             * @param forecastday
             * The forecastday
             */
            public void setForecastday(List<Forecastday> forecastday) {
                this.forecastday = forecastday;
            }


            // Start Of ForecastDay

            public class Forecastday {

                @SerializedName("period")
                @Expose
                private Integer period;
                @SerializedName("icon")
                @Expose
                private String icon;
                @SerializedName("icon_url")
                @Expose
                private String iconUrl;
                @SerializedName("title")
                @Expose
                private String title;
                @SerializedName("fcttext")
                @Expose
                private String fcttext;
                @SerializedName("fcttext_metric")
                @Expose
                private String fcttextMetric;
                @SerializedName("pop")
                @Expose
                private String pop;

                /**
                 *
                 * @return
                 * The period
                 */
                public Integer getPeriod() {
                    return period;
                }

                /**
                 *
                 * @param period
                 * The period
                 */
                public void setPeriod(Integer period) {
                    this.period = period;
                }

                /**
                 *
                 * @return
                 * The icon
                 */
                public String getIcon() {
                    return icon;
                }

                /**
                 *
                 * @param icon
                 * The icon
                 */
                public void setIcon(String icon) {
                    this.icon = icon;
                }

                /**
                 *
                 * @return
                 * The iconUrl
                 */
                public String getIconUrl() {
                    return iconUrl;
                }

                /**
                 *
                 * @param iconUrl
                 * The icon_url
                 */
                public void setIconUrl(String iconUrl) {
                    this.iconUrl = iconUrl;
                }

                /**
                 *
                 * @return
                 * The title
                 */
                public String getTitle() {
                    return title;
                }

                /**
                 *
                 * @param title
                 * The title
                 */
                public void setTitle(String title) {
                    this.title = title;
                }

                /**
                 *
                 * @return
                 * The fcttext
                 */
                public String getFcttext() {
                    return fcttext;
                }

                /**
                 *
                 * @param fcttext
                 * The fcttext
                 */
                public void setFcttext(String fcttext) {
                    this.fcttext = fcttext;
                }

                /**
                 *
                 * @return
                 * The fcttextMetric
                 */
                public String getFcttextMetric() {
                    return fcttextMetric;
                }

                /**
                 *
                 * @param fcttextMetric
                 * The fcttext_metric
                 */
                public void setFcttextMetric(String fcttextMetric) {
                    this.fcttextMetric = fcttextMetric;
                }

                /**
                 *
                 * @return
                 * The pop
                 */
                public String getPop() {
                    return pop;
                }

                /**
                 *
                 * @param pop
                 * The pop
                 */
                public void setPop(String pop) {
                    this.pop = pop;
                }

            }



        }// End OF TXTforcast

        // Satrt Of Simpleforcast

        public class Simpleforecast {

            @SerializedName("forecastday")
            @Expose
            private List<Forecastday_> forecastday = new ArrayList<Forecastday_>();

            /**
             *
             * @return
             * The forecastday
             */
            public List<Forecastday_> getForecastday() {
                return forecastday;
            }

            /**
             *
             * @param forecastday
             * The forecastday
             */
            public void setForecastday(List<Forecastday_> forecastday) {
                this.forecastday = forecastday;
            }


            // Start Of ForecastDay_

            public class Forecastday_ {

                @SerializedName("date")
                @Expose
                private Date date;
                @SerializedName("period")
                @Expose
                private Integer period;
                @SerializedName("high")
                @Expose
                private High high;
                @SerializedName("low")
                @Expose
                private Low low;
                @SerializedName("conditions")
                @Expose
                private String conditions;
                @SerializedName("icon")
                @Expose
                private String icon;
                @SerializedName("icon_url")
                @Expose
                private String iconUrl;
                @SerializedName("skyicon")
                @Expose
                private String skyicon;
                @SerializedName("pop")
                @Expose
                private Integer pop;
                @SerializedName("qpf_allday")
                @Expose
                private QpfAllday qpfAllday;
                @SerializedName("qpf_day")
                @Expose
                private QpfDay qpfDay;
                @SerializedName("qpf_night")
                @Expose
                private QpfNight qpfNight;
                @SerializedName("snow_allday")
                @Expose
                private SnowAllday snowAllday;
                @SerializedName("snow_day")
                @Expose
                private SnowDay snowDay;
                @SerializedName("snow_night")
                @Expose
                private SnowNight snowNight;
                @SerializedName("maxwind")
                @Expose
                private Maxwind maxwind;
                @SerializedName("avewind")
                @Expose
                private Avewind avewind;
                @SerializedName("avehumidity")
                @Expose
                private Integer avehumidity;
                @SerializedName("maxhumidity")
                @Expose
                private Integer maxhumidity;
                @SerializedName("minhumidity")
                @Expose
                private Integer minhumidity;

                /**
                 *
                 * @return
                 * The date
                 */
                public Date getDate() {
                    return date;
                }

                /**
                 *
                 * @param date
                 * The date
                 */
                public void setDate(Date date) {
                    this.date = date;
                }

                /**
                 *
                 * @return
                 * The period
                 */
                public Integer getPeriod() {
                    return period;
                }

                /**
                 *
                 * @param period
                 * The period
                 */
                public void setPeriod(Integer period) {
                    this.period = period;
                }

                /**
                 *
                 * @return
                 * The high
                 */
                public High getHigh() {
                    return high;
                }

                /**
                 *
                 * @param high
                 * The high
                 */
                public void setHigh(High high) {
                    this.high = high;
                }

                /**
                 *
                 * @return
                 * The low
                 */
                public Low getLow() {
                    return low;
                }

                /**
                 *
                 * @param low
                 * The low
                 */
                public void setLow(Low low) {
                    this.low = low;
                }

                /**
                 *
                 * @return
                 * The conditions
                 */
                public String getConditions() {
                    return conditions;
                }

                /**
                 *
                 * @param conditions
                 * The conditions
                 */
                public void setConditions(String conditions) {
                    this.conditions = conditions;
                }

                /**
                 *
                 * @return
                 * The icon
                 */
                public String getIcon() {
                    return icon;
                }

                /**
                 *
                 * @param icon
                 * The icon
                 */
                public void setIcon(String icon) {
                    this.icon = icon;
                }

                /**
                 *
                 * @return
                 * The iconUrl
                 */
                public String getIconUrl() {
                    return iconUrl;
                }

                /**
                 *
                 * @param iconUrl
                 * The icon_url
                 */
                public void setIconUrl(String iconUrl) {
                    this.iconUrl = iconUrl;
                }

                /**
                 *
                 * @return
                 * The skyicon
                 */
                public String getSkyicon() {
                    return skyicon;
                }

                /**
                 *
                 * @param skyicon
                 * The skyicon
                 */
                public void setSkyicon(String skyicon) {
                    this.skyicon = skyicon;
                }

                /**
                 *
                 * @return
                 * The pop
                 */
                public Integer getPop() {
                    return pop;
                }

                /**
                 *
                 * @param pop
                 * The pop
                 */
                public void setPop(Integer pop) {
                    this.pop = pop;
                }

                /**
                 *
                 * @return
                 * The qpfAllday
                 */
                public QpfAllday getQpfAllday() {
                    return qpfAllday;
                }

                /**
                 *
                 * @param qpfAllday
                 * The qpf_allday
                 */
                public void setQpfAllday(QpfAllday qpfAllday) {
                    this.qpfAllday = qpfAllday;
                }

                /**
                 *
                 * @return
                 * The qpfDay
                 */
                public QpfDay getQpfDay() {
                    return qpfDay;
                }

                /**
                 *
                 * @param qpfDay
                 * The qpf_day
                 */
                public void setQpfDay(QpfDay qpfDay) {
                    this.qpfDay = qpfDay;
                }

                /**
                 *
                 * @return
                 * The qpfNight
                 */
                public QpfNight getQpfNight() {
                    return qpfNight;
                }

                /**
                 *
                 * @param qpfNight
                 * The qpf_night
                 */
                public void setQpfNight(QpfNight qpfNight) {
                    this.qpfNight = qpfNight;
                }

                /**
                 *
                 * @return
                 * The snowAllday
                 */
                public SnowAllday getSnowAllday() {
                    return snowAllday;
                }

                /**
                 *
                 * @param snowAllday
                 * The snow_allday
                 */
                public void setSnowAllday(SnowAllday snowAllday) {
                    this.snowAllday = snowAllday;
                }

                /**
                 *
                 * @return
                 * The snowDay
                 */
                public SnowDay getSnowDay() {
                    return snowDay;
                }

                /**
                 *
                 * @param snowDay
                 * The snow_day
                 */
                public void setSnowDay(SnowDay snowDay) {
                    this.snowDay = snowDay;
                }

                /**
                 *
                 * @return
                 * The snowNight
                 */
                public SnowNight getSnowNight() {
                    return snowNight;
                }

                /**
                 *
                 * @param snowNight
                 * The snow_night
                 */
                public void setSnowNight(SnowNight snowNight) {
                    this.snowNight = snowNight;
                }

                /**
                 *
                 * @return
                 * The maxwind
                 */
                public Maxwind getMaxwind() {
                    return maxwind;
                }

                /**
                 *
                 * @param maxwind
                 * The maxwind
                 */
                public void setMaxwind(Maxwind maxwind) {
                    this.maxwind = maxwind;
                }

                /**
                 *
                 * @return
                 * The avewind
                 */
                public Avewind getAvewind() {
                    return avewind;
                }

                /**
                 *
                 * @param avewind
                 * The avewind
                 */
                public void setAvewind(Avewind avewind) {
                    this.avewind = avewind;
                }

                /**
                 *
                 * @return
                 * The avehumidity
                 */
                public Integer getAvehumidity() {
                    return avehumidity;
                }

                /**
                 *
                 * @param avehumidity
                 * The avehumidity
                 */
                public void setAvehumidity(Integer avehumidity) {
                    this.avehumidity = avehumidity;
                }

                /**
                 *
                 * @return
                 * The maxhumidity
                 */
                public Integer getMaxhumidity() {
                    return maxhumidity;
                }

                /**
                 *
                 * @param maxhumidity
                 * The maxhumidity
                 */
                public void setMaxhumidity(Integer maxhumidity) {
                    this.maxhumidity = maxhumidity;
                }

                /**
                 *
                 * @return
                 * The minhumidity
                 */
                public Integer getMinhumidity() {
                    return minhumidity;
                }

                /**
                 *
                 * @param minhumidity
                 * The minhumidity
                 */
                public void setMinhumidity(Integer minhumidity) {
                    this.minhumidity = minhumidity;
                }


                public class Date {

                    @SerializedName("epoch")
                    @Expose
                    private String epoch;
                    @SerializedName("pretty")
                    @Expose
                    private String pretty;
                    @SerializedName("day")
                    @Expose
                    private Integer day;
                    @SerializedName("month")
                    @Expose
                    private Integer month;
                    @SerializedName("year")
                    @Expose
                    private Integer year;
                    @SerializedName("yday")
                    @Expose
                    private Integer yday;
                    @SerializedName("hour")
                    @Expose
                    private Integer hour;
                    @SerializedName("min")
                    @Expose
                    private String min;
                    @SerializedName("sec")
                    @Expose
                    private Integer sec;
                    @SerializedName("isdst")
                    @Expose
                    private String isdst;
                    @SerializedName("monthname")
                    @Expose
                    private String monthname;
                    @SerializedName("monthname_short")
                    @Expose
                    private String monthnameShort;
                    @SerializedName("weekday_short")
                    @Expose
                    private String weekdayShort;
                    @SerializedName("weekday")
                    @Expose
                    private String weekday;
                    @SerializedName("ampm")
                    @Expose
                    private String ampm;
                    @SerializedName("tz_short")
                    @Expose
                    private String tzShort;
                    @SerializedName("tz_long")
                    @Expose
                    private String tzLong;

                    /**
                     *
                     * @return
                     * The epoch
                     */
                    public String getEpoch() {
                        return epoch;
                    }

                    /**
                     *
                     * @param epoch
                     * The epoch
                     */
                    public void setEpoch(String epoch) {
                        this.epoch = epoch;
                    }

                    /**
                     *
                     * @return
                     * The pretty
                     */
                    public String getPretty() {
                        return pretty;
                    }

                    /**
                     *
                     * @param pretty
                     * The pretty
                     */
                    public void setPretty(String pretty) {
                        this.pretty = pretty;
                    }

                    /**
                     *
                     * @return
                     * The day
                     */
                    public Integer getDay() {
                        return day;
                    }

                    /**
                     *
                     * @param day
                     * The day
                     */
                    public void setDay(Integer day) {
                        this.day = day;
                    }

                    /**
                     *
                     * @return
                     * The month
                     */
                    public Integer getMonth() {
                        return month;
                    }

                    /**
                     *
                     * @param month
                     * The month
                     */
                    public void setMonth(Integer month) {
                        this.month = month;
                    }

                    /**
                     *
                     * @return
                     * The year
                     */
                    public Integer getYear() {
                        return year;
                    }

                    /**
                     *
                     * @param year
                     * The year
                     */
                    public void setYear(Integer year) {
                        this.year = year;
                    }

                    /**
                     *
                     * @return
                     * The yday
                     */
                    public Integer getYday() {
                        return yday;
                    }

                    /**
                     *
                     * @param yday
                     * The yday
                     */
                    public void setYday(Integer yday) {
                        this.yday = yday;
                    }

                    /**
                     *
                     * @return
                     * The hour
                     */
                    public Integer getHour() {
                        return hour;
                    }

                    /**
                     *
                     * @param hour
                     * The hour
                     */
                    public void setHour(Integer hour) {
                        this.hour = hour;
                    }

                    /**
                     *
                     * @return
                     * The min
                     */
                    public String getMin() {
                        return min;
                    }

                    /**
                     *
                     * @param min
                     * The min
                     */
                    public void setMin(String min) {
                        this.min = min;
                    }

                    /**
                     *
                     * @return
                     * The sec
                     */
                    public Integer getSec() {
                        return sec;
                    }

                    /**
                     *
                     * @param sec
                     * The sec
                     */
                    public void setSec(Integer sec) {
                        this.sec = sec;
                    }

                    /**
                     *
                     * @return
                     * The isdst
                     */
                    public String getIsdst() {
                        return isdst;
                    }

                    /**
                     *
                     * @param isdst
                     * The isdst
                     */
                    public void setIsdst(String isdst) {
                        this.isdst = isdst;
                    }

                    /**
                     *
                     * @return
                     * The monthname
                     */
                    public String getMonthname() {
                        return monthname;
                    }

                    /**
                     *
                     * @param monthname
                     * The monthname
                     */
                    public void setMonthname(String monthname) {
                        this.monthname = monthname;
                    }

                    /**
                     *
                     * @return
                     * The monthnameShort
                     */
                    public String getMonthnameShort() {
                        return monthnameShort;
                    }

                    /**
                     *
                     * @param monthnameShort
                     * The monthname_short
                     */
                    public void setMonthnameShort(String monthnameShort) {
                        this.monthnameShort = monthnameShort;
                    }

                    /**
                     *
                     * @return
                     * The weekdayShort
                     */
                    public String getWeekdayShort() {
                        return weekdayShort;
                    }

                    /**
                     *
                     * @param weekdayShort
                     * The weekday_short
                     */
                    public void setWeekdayShort(String weekdayShort) {
                        this.weekdayShort = weekdayShort;
                    }

                    /**
                     *
                     * @return
                     * The weekday
                     */
                    public String getWeekday() {
                        return weekday;
                    }

                    /**
                     *
                     * @param weekday
                     * The weekday
                     */
                    public void setWeekday(String weekday) {
                        this.weekday = weekday;
                    }

                    /**
                     *
                     * @return
                     * The ampm
                     */
                    public String getAmpm() {
                        return ampm;
                    }

                    /**
                     *
                     * @param ampm
                     * The ampm
                     */
                    public void setAmpm(String ampm) {
                        this.ampm = ampm;
                    }

                    /**
                     *
                     * @return
                     * The tzShort
                     */
                    public String getTzShort() {
                        return tzShort;
                    }

                    /**
                     *
                     * @param tzShort
                     * The tz_short
                     */
                    public void setTzShort(String tzShort) {
                        this.tzShort = tzShort;
                    }

                    /**
                     *
                     * @return
                     * The tzLong
                     */
                    public String getTzLong() {
                        return tzLong;
                    }

                    /**
                     *
                     * @param tzLong
                     * The tz_long
                     */
                    public void setTzLong(String tzLong) {
                        this.tzLong = tzLong;
                    }

                }



                public class High {

                    @SerializedName("fahrenheit")
                    @Expose
                    private String fahrenheit;
                    @SerializedName("celsius")
                    @Expose
                    private String celsius;

                    /**
                     *
                     * @return
                     * The fahrenheit
                     */
                    public String getFahrenheit() {
                        return fahrenheit;
                    }

                    /**
                     *
                     * @param fahrenheit
                     * The fahrenheit
                     */
                    public void setFahrenheit(String fahrenheit) {
                        this.fahrenheit = fahrenheit;
                    }

                    /**
                     *
                     * @return
                     * The celsius
                     */
                    public String getCelsius() {
                        return celsius;
                    }

                    /**
                     *
                     * @param celsius
                     * The celsius
                     */
                    public void setCelsius(String celsius) {
                        this.celsius = celsius;
                    }

                }



                public class QpfAllday {

                    @SerializedName("in")
                    @Expose
                    private Double in;
                    @SerializedName("mm")
                    @Expose
                    private Integer mm;

                    /**
                     *
                     * @return
                     * The in
                     */
                    public Double getIn() {
                        return in;
                    }

                    /**
                     *
                     * @param in
                     * The in
                     */
                    public void setIn(Double in) {
                        this.in = in;
                    }

                    /**
                     *
                     * @return
                     * The mm
                     */
                    public Integer getMm() {
                        return mm;
                    }

                    /**
                     *
                     * @param mm
                     * The mm
                     */
                    public void setMm(Integer mm) {
                        this.mm = mm;
                    }

                }


                public class QpfDay {

                    @SerializedName("in")
                    @Expose
                    private Double in;
                    @SerializedName("mm")
                    @Expose
                    private Integer mm;

                    /**
                     *
                     * @return
                     * The in
                     */
                    public Double getIn() {
                        return in;
                    }

                    /**
                     *
                     * @param in
                     * The in
                     */
                    public void setIn(Double in) {
                        this.in = in;
                    }

                    /**
                     *
                     * @return
                     * The mm
                     */
                    public Integer getMm() {
                        return mm;
                    }

                    /**
                     *
                     * @param mm
                     * The mm
                     */
                    public void setMm(Integer mm) {
                        this.mm = mm;
                    }

                }

                public class Low {

                    @SerializedName("fahrenheit")
                    @Expose
                    private String fahrenheit;
                    @SerializedName("celsius")
                    @Expose
                    private String celsius;

                    /**
                     *
                     * @return
                     * The fahrenheit
                     */
                    public String getFahrenheit() {
                        return fahrenheit;
                    }

                    /**
                     *
                     * @param fahrenheit
                     * The fahrenheit
                     */
                    public void setFahrenheit(String fahrenheit) {
                        this.fahrenheit = fahrenheit;
                    }

                    /**
                     *
                     * @return
                     * The celsius
                     */
                    public String getCelsius() {
                        return celsius;
                    }

                    /**
                     *
                     * @param celsius
                     * The celsius
                     */
                    public void setCelsius(String celsius) {
                        this.celsius = celsius;
                    }

                }


                public class QpfNight {

                    @SerializedName("in")
                    @Expose
                    private Double in;
                    @SerializedName("mm")
                    @Expose
                    private Integer mm;

                    /**
                     *
                     * @return
                     * The in
                     */
                    public Double getIn() {
                        return in;
                    }

                    /**
                     *
                     * @param in
                     * The in
                     */
                    public void setIn(Double in) {
                        this.in = in;
                    }

                    /**
                     *
                     * @return
                     * The mm
                     */
                    public Integer getMm() {
                        return mm;
                    }

                    /**
                     *
                     * @param mm
                     * The mm
                     */
                    public void setMm(Integer mm) {
                        this.mm = mm;
                    }

                }


                public class SnowAllday {

                    @SerializedName("in")
                    @Expose
                    private Double in;
                    @SerializedName("cm")
                    @Expose
                    private Double cm;

                    /**
                     *
                     * @return
                     * The in
                     */
                    public Double getIn() {
                        return in;
                    }

                    /**
                     *
                     * @param in
                     * The in
                     */
                    public void setIn(Double in) {
                        this.in = in;
                    }

                    /**
                     *
                     * @return
                     * The cm
                     */
                    public Double getCm() {
                        return cm;
                    }

                    /**
                     *
                     * @param cm
                     * The cm
                     */
                    public void setCm(Double cm) {
                        this.cm = cm;
                    }

                }


                public class Maxwind {

                    @SerializedName("mph")
                    @Expose
                    private Integer mph;
                    @SerializedName("kph")
                    @Expose
                    private Integer kph;
                    @SerializedName("dir")
                    @Expose
                    private String dir;
                    @SerializedName("degrees")
                    @Expose
                    private Integer degrees;

                    /**
                     *
                     * @return
                     * The mph
                     */
                    public Integer getMph() {
                        return mph;
                    }

                    /**
                     *
                     * @param mph
                     * The mph
                     */
                    public void setMph(Integer mph) {
                        this.mph = mph;
                    }

                    /**
                     *
                     * @return
                     * The kph
                     */
                    public Integer getKph() {
                        return kph;
                    }

                    /**
                     *
                     * @param kph
                     * The kph
                     */
                    public void setKph(Integer kph) {
                        this.kph = kph;
                    }

                    /**
                     *
                     * @return
                     * The dir
                     */
                    public String getDir() {
                        return dir;
                    }

                    /**
                     *
                     * @param dir
                     * The dir
                     */
                    public void setDir(String dir) {
                        this.dir = dir;
                    }

                    /**
                     *
                     * @return
                     * The degrees
                     */
                    public Integer getDegrees() {
                        return degrees;
                    }

                    /**
                     *
                     * @param degrees
                     * The degrees
                     */
                    public void setDegrees(Integer degrees) {
                        this.degrees = degrees;
                    }

                }



                public class SnowDay {

                    @SerializedName("in")
                    @Expose
                    private Double in;
                    @SerializedName("cm")
                    @Expose
                    private Double cm;

                    /**
                     *
                     * @return
                     * The in
                     */
                    public Double getIn() {
                        return in;
                    }

                    /**
                     *
                     * @param in
                     * The in
                     */
                    public void setIn(Double in) {
                        this.in = in;
                    }

                    /**
                     *
                     * @return
                     * The cm
                     */
                    public Double getCm() {
                        return cm;
                    }

                    /**
                     *
                     * @param cm
                     * The cm
                     */
                    public void setCm(Double cm) {
                        this.cm = cm;
                    }

                }



                public class SnowNight {

                    @SerializedName("in")
                    @Expose
                    private Double in;
                    @SerializedName("cm")
                    @Expose
                    private Double cm;

                    /**
                     *
                     * @return
                     * The in
                     */
                    public Double getIn() {
                        return in;
                    }

                    /**
                     *
                     * @param in
                     * The in
                     */
                    public void setIn(Double in) {
                        this.in = in;
                    }

                    /**
                     *
                     * @return
                     * The cm
                     */
                    public Double getCm() {
                        return cm;
                    }

                    /**
                     *
                     * @param cm
                     * The cm
                     */
                    public void setCm(Double cm) {
                        this.cm = cm;
                    }

                }


                public class Avewind {

                    @SerializedName("mph")
                    @Expose
                    private Integer mph;
                    @SerializedName("kph")
                    @Expose
                    private Integer kph;
                    @SerializedName("dir")
                    @Expose
                    private String dir;
                    @SerializedName("degrees")
                    @Expose
                    private Integer degrees;

                    /**
                     *
                     * @return
                     * The mph
                     */
                    public Integer getMph() {
                        return mph;
                    }

                    /**
                     *
                     * @param mph
                     * The mph
                     */
                    public void setMph(Integer mph) {
                        this.mph = mph;
                    }

                    /**
                     *
                     * @return
                     * The kph
                     */
                    public Integer getKph() {
                        return kph;
                    }

                    /**
                     *
                     * @param kph
                     * The kph
                     */
                    public void setKph(Integer kph) {
                        this.kph = kph;
                    }

                    /**
                     *
                     * @return
                     * The dir
                     */
                    public String getDir() {
                        return dir;
                    }

                    /**
                     *
                     * @param dir
                     * The dir
                     */
                    public void setDir(String dir) {
                        this.dir = dir;
                    }

                    /**
                     *
                     * @return
                     * The degrees
                     */
                    public Integer getDegrees() {
                        return degrees;
                    }

                    /**
                     *
                     * @param degrees
                     * The degrees
                     */
                    public void setDegrees(Integer degrees) {
                        this.degrees = degrees;
                    }

                }

            }  // End OF ForcastDay_

        }  // End  Of Simpleforcast



    }// End OF Forcast

}



















/*
package theateam.com.tourmanager.Weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

*/
/**
 * Created by Hasibuzzaman on 8/22/2016.
 *//*

public class WeatherResponse {

    @SerializedName("response")
    @Expose
    private Response response;
*/
/*    @SerializedName("location")
    @Expose
    private Location location;*//*

    @SerializedName("current_observation")
    @Expose
    private CurrentObservation currentObservation;
    @SerializedName("forecast")
    @Expose
    private Forecast forecast;

    */
/**
     *
     * @return
     * The response
     *//*

    public Response getResponse() {
        return response;
    }

    */
/**
     *
     * @param response
     * The response
     *//*

    public void setResponse(Response response) {
        this.response = response;
    }

    */
/**
     *
     * @return
    */
/* * The location
     *//*
*/
/*
    public Location getLocation() {
        return location;
    }

    *//*
*/
/**
     *
     * @param location
     * The location
     *//*
*/
/*
    public void setLocation(Location location) {
        this.location = location;
    }*//*


    */
/**
     *
     * @return
     * The currentObservation
     *//*

    public CurrentObservation getCurrentObservation() {
        return currentObservation;
    }

    */
/**
     *
     * @param currentObservation
     * The current_observation
     *//*

    public void setCurrentObservation(CurrentObservation currentObservation) {
        this.currentObservation = currentObservation;
    }

    */
/**
     *
     * @return
     * The forecast
     *//*

    public Forecast getForecast() {
        return forecast;
    }

    */
/**
     *
     * @param forecast
     * The forecast
     *//*

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }



    // Response class

    public class Response {

        @SerializedName("version")
        @Expose
        private String version;
        @SerializedName("termsofService")
        @Expose
        private String termsofService;
        @SerializedName("features")
        @Expose
        private Features features;

        */
/**
         *
         * @return
         * The version
         *//*

        public String getVersion() {
            return version;
        }

        */
/**
         *
         * @param version
         * The version
         *//*

        public void setVersion(String version) {
            this.version = version;
        }

        */
/**
         *
         * @return
         * The termsofService
         *//*

        public String getTermsofService() {
            return termsofService;
        }

        */
/**
         *
         * @param termsofService
         * The termsofService
         *//*

        public void setTermsofService(String termsofService) {
            this.termsofService = termsofService;
        }

        */
/**
         *
         * @return
         * The features
         *//*

        public Features getFeatures() {
            return features;
        }

        */
/**
         *
         * @param features
         * The features
         *//*

        public void setFeatures(Features features) {
            this.features = features;
        }

        // Start Of Features

        public class Features {

      */
/*      @SerializedName("geolookup")
            @Expose
            private Integer geolookup;*//*

            @SerializedName("conditions")
            @Expose
            private Integer conditions;
            @SerializedName("forecast10day")
            @Expose
            private Integer forecast10day;

            */
/**
           */
/*  *
             * @return
             * The geolookup
             *//*
*/
/*
            public Integer getGeolookup() {
                return geolookup;
            }

            *//*
*/
/**
             *
             * @param geolookup
             * The geolookup
             *//*
*/
/*
            public void setGeolookup(Integer geolookup) {
                this.geolookup = geolookup;
            }
*//*

            */
/**
             *
             * @return
             * The conditions
             *//*

            public Integer getConditions() {
                return conditions;
            }

            */
/**
             *
             * @param conditions
             * The conditions
             *//*

            public void setConditions(Integer conditions) {
                this.conditions = conditions;
            }

            */
/**
             *
             * @return
             * The forecast10day
             *//*

            public Integer getForecast10day() {
                return forecast10day;
            }

            */
/**
             *
             * @param forecast10day
             * The forecast10day
             *//*

            public void setForecast10day(Integer forecast10day) {
                this.forecast10day = forecast10day;
            }

        }




    } // End OF Response



    // Start Of Location

*/
/*    public class Location {

        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("country")
        @Expose
        private String country;
        @SerializedName("country_iso3166")
        @Expose
        private String countryIso3166;
        @SerializedName("country_name")
        @Expose
        private String countryName;
        @SerializedName("state")
        @Expose
        private String state;
        @SerializedName("city")
        @Expose
        private String city;
        @SerializedName("tz_short")
        @Expose
        private String tzShort;
        @SerializedName("tz_long")
        @Expose
        private String tzLong;
        @SerializedName("lat")
        @Expose
        private String lat;
        @SerializedName("lon")
        @Expose
        private String lon;
        @SerializedName("zip")
        @Expose
        private String zip;
        @SerializedName("magic")
        @Expose
        private String magic;
        @SerializedName("wmo")
        @Expose
        private String wmo;
        @SerializedName("l")
        @Expose
        private String l;
        @SerializedName("requesturl")
        @Expose
        private String requesturl;
        @SerializedName("wuiurl")
        @Expose
        private String wuiurl;
        @SerializedName("nearby_weather_stations")
        @Expose
        private NearbyWeatherStations nearbyWeatherStations;

        *//*
*/
/**
         *
         * @return
         * The type
         *//*
*/
/*
        public String getType() {
            return type;
        }

        *//*
*/
/**
         *
         * @param type
         * The type
         *//*
*/
/*
        public void setType(String type) {
            this.type = type;
        }

        *//*
*/
/**
         *
         * @return
         * The country
         *//*
*/
/*
        public String getCountry() {
            return country;
        }

        *//*
*/
/**
         *
         * @param country
         * The country
         *//*
*/
/*
        public void setCountry(String country) {
            this.country = country;
        }

        *//*
*/
/**
         *
         * @return
         * The countryIso3166
         *//*
*/
/*
        public String getCountryIso3166() {
            return countryIso3166;
        }

        *//*
*/
/**
         *
         * @param countryIso3166
         * The country_iso3166
         *//*
*/
/*
        public void setCountryIso3166(String countryIso3166) {
            this.countryIso3166 = countryIso3166;
        }

        *//*
*/
/**
         *
         * @return
         * The countryName
         *//*
*/
/*
        public String getCountryName() {
            return countryName;
        }

        *//*
*/
/**
         *
         * @param countryName
         * The country_name
         *//*
*/
/*
        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }

        *//*
*/
/**
         *
         * @return
         * The state
         *//*
*/
/*
        public String getState() {
            return state;
        }

        *//*
*/
/**
         *
         * @param state
         * The state
         *//*
*/
/*
        public void setState(String state) {
            this.state = state;
        }

        *//*
*/
/**
         *
         * @return
         * The city
         *//*
*/
/*
        public String getCity() {
            return city;
        }

        *//*
*/
/**
         *
         * @param city
         * The city
         *//*
*/
/*
        public void setCity(String city) {
            this.city = city;
        }

        *//*
*/
/**
         *
         * @return
         * The tzShort
         *//*
*/
/*
        public String getTzShort() {
            return tzShort;
        }

        *//*
*/
/**
         *
         * @param tzShort
         * The tz_short
         *//*
*/
/*
        public void setTzShort(String tzShort) {
            this.tzShort = tzShort;
        }

        *//*
*/
/**
         *
         * @return
         * The tzLong
         *//*
*/
/*
        public String getTzLong() {
            return tzLong;
        }

        *//*
*/
/**
         *
         * @param tzLong
         * The tz_long
         *//*
*/
/*
        public void setTzLong(String tzLong) {
            this.tzLong = tzLong;
        }

        *//*
*/
/**
         *
         * @return
         * The lat
         *//*
*/
/*
        public String getLat() {
            return lat;
        }

        *//*
*/
/**
         *
         * @param lat
         * The lat
         *//*
*/
/*
        public void setLat(String lat) {
            this.lat = lat;
        }

        *//*
*/
/**
         *
         * @return
         * The lon
         *//*
*/
/*
        public String getLon() {
            return lon;
        }

        *//*
*/
/**
         *
         * @param lon
         * The lon
         *//*
*/
/*
        public void setLon(String lon) {
            this.lon = lon;
        }

        *//*
*/
/**
         *
         * @return
         * The zip
         *//*
*/
/*
        public String getZip() {
            return zip;
        }

        *//*
*/
/**
         *
         * @param zip
         * The zip
         *//*
*/
/*
        public void setZip(String zip) {
            this.zip = zip;
        }

        *//*
*/
/**
         *
         * @return
         * The magic
         *//*
*/
/*
        public String getMagic() {
            return magic;
        }

        *//*
*/
/**
         *
         * @param magic
         * The magic
         *//*
*/
/*
        public void setMagic(String magic) {
            this.magic = magic;
        }

        *//*
*/
/**
         *
         * @return
         * The wmo
         *//*
*/
/*
        public String getWmo() {
            return wmo;
        }

        *//*
*/
/**
         *
         * @param wmo
         * The wmo
         *//*
*/
/*
        public void setWmo(String wmo) {
            this.wmo = wmo;
        }

        *//*
*/
/**
         *
         * @return
         * The l
         *//*
*/
/*
        public String getL() {
            return l;
        }

        *//*
*/
/**
         *
         * @param l
         * The l
         *//*
*/
/*
        public void setL(String l) {
            this.l = l;
        }

        *//*
*/
/**
         *
         * @return
         * The requesturl
         *//*
*/
/*
        public String getRequesturl() {
            return requesturl;
        }

        *//*
*/
/**
         *
         * @param requesturl
         * The requesturl
         *//*
*/
/*
        public void setRequesturl(String requesturl) {
            this.requesturl = requesturl;
        }

        *//*
*/
/**
         *
         * @return
         * The wuiurl
         *//*
*/
/*
        public String getWuiurl() {
            return wuiurl;
        }

        *//*
*/
/**
         *
         * @param wuiurl
         * The wuiurl
         *//*
*/
/*
        public void setWuiurl(String wuiurl) {
            this.wuiurl = wuiurl;
        }

        *//*
*/
/**
         *
         * @return
         * The nearbyWeatherStations
         *//*
*/
/*
        public NearbyWeatherStations getNearbyWeatherStations() {
            return nearbyWeatherStations;
        }

        *//*
*/
/**
         *
         * @param nearbyWeatherStations
         * The nearby_weather_stations
         *//*
*/
/*
        public void setNearbyWeatherStations(NearbyWeatherStations nearbyWeatherStations) {
            this.nearbyWeatherStations = nearbyWeatherStations;
        }


        // Start Of NearbyWeatherStations

        public class NearbyWeatherStations {

            @SerializedName("airport")
            @Expose
            private Airport airport;
            @SerializedName("pws")
            @Expose
            private Pws pws;

            *//*
*/
/**
             *
             * @return
             * The airport
             *//*
*/
/*
            public Airport getAirport() {
                return airport;
            }

            *//*
*/
/**
             *
             * @param airport
             * The airport
             *//*
*/
/*
            public void setAirport(Airport airport) {
                this.airport = airport;
            }

            *//*
*/
/**
             *
             * @return
             * The pws
             *//*
*/
/*
            public Pws getPws() {
                return pws;
            }

            *//*
*/
/**
             *
             * @param pws
             * The pws
             *//*
*/
/*
            public void setPws(Pws pws) {
                this.pws = pws;
            }

            // Start Of Pws

            public class Pws {

                @SerializedName("station")
                @Expose
                private List<Station_> station = new ArrayList<Station_>();

                *//*
*/
/**
                 *
                 * @return
                 * The station
                 *//*
*/
/*
                public List<Station_> getStation() {
                    return station;
                }

                *//*
*/
/**
                 *
                 * @param station
                 * The station
                 *//*
*/
/*
                public void setStation(List<Station_> station) {
                    this.station = station;
                }

                // Start oF sTATION_

                public class Station_ {

                    @SerializedName("neighborhood")
                    @Expose
                    private String neighborhood;
                    @SerializedName("city")
                    @Expose
                    private String city;
                    @SerializedName("state")
                    @Expose
                    private String state;
                    @SerializedName("country")
                    @Expose
                    private String country;
                    @SerializedName("id")
                    @Expose
                    private String id;
                    @SerializedName("lat")
                    @Expose
                    private Double lat;
                    @SerializedName("lon")
                    @Expose
                    private Double lon;
                    @SerializedName("distance_km")
                    @Expose
                    private Integer distanceKm;
                    @SerializedName("distance_mi")
                    @Expose
                    private Integer distanceMi;

                    *//*
*/
/**
                     *
                     * @return
                     * The neighborhood
                     *//*
*/
/*
                    public String getNeighborhood() {
                        return neighborhood;
                    }

                    *//*
*/
/**
                     *
                     * @param neighborhood
                     * The neighborhood
                     *//*
*/
/*
                    public void setNeighborhood(String neighborhood) {
                        this.neighborhood = neighborhood;
                    }

                    *//*
*/
/**
                     *
                     * @return
                     * The city
                     *//*
*/
/*
                    public String getCity() {
                        return city;
                    }

                    *//*
*/
/**
                     *
                     * @param city
                     * The city
                     *//*
*/
/*
                    public void setCity(String city) {
                        this.city = city;
                    }

                    *//*
*/
/**
                     *
                     * @return
                     * The state
                     *//*
*/
/*
                    public String getState() {
                        return state;
                    }

                    *//*
*/
/**
                     *
                     * @param state
                     * The state
                     *//*
*/
/*
                    public void setState(String state) {
                        this.state = state;
                    }

                    *//*
*/
/**
                     *
                     * @return
                     * The country
                     *//*
*/
/*
                    public String getCountry() {
                        return country;
                    }

                    *//*
*/
/**
                     *
                     * @param country
                     * The country
                     *//*
*/
/*
                    public void setCountry(String country) {
                        this.country = country;
                    }

                    *//*
*/
/**
                     *
                     * @return
                     * The id
                     *//*
*/
/*
                    public String getId() {
                        return id;
                    }

                    *//*
*/
/**
                     *
                     * @param id
                     * The id
                     *//*
*/
/*
                    public void setId(String id) {
                        this.id = id;
                    }

                    *//*
*/
/**
                     *
                     * @return
                     * The lat
                     *//*
*/
/*
                    public Double getLat() {
                        return lat;
                    }

                    *//*
*/
/**
                     *
                     * @param lat
                     * The lat
                     *//*
*/
/*
                    public void setLat(Double lat) {
                        this.lat = lat;
                    }

                    *//*
*/
/**
                     *
                     * @return
                     * The lon
                     *//*
*/
/*
                    public Double getLon() {
                        return lon;
                    }

                    *//*
*/
/**
                     *
                     * @param lon
                     * The lon
                     *//*
*/
/*
                    public void setLon(Double lon) {
                        this.lon = lon;
                    }

                    *//*
*/
/**
                     *
                     * @return
                     * The distanceKm
                     *//*
*/
/*
                    public Integer getDistanceKm() {
                        return distanceKm;
                    }

                    *//*
*/
/**
                     *
                     * @param distanceKm
                     * The distance_km
                     *//*
*/
/*
                    public void setDistanceKm(Integer distanceKm) {
                        this.distanceKm = distanceKm;
                    }

                    *//*
*/
/**
                     *
                     * @return
                     * The distanceMi
                     *//*
*/
/*
                    public Integer getDistanceMi() {
                        return distanceMi;
                    }

                    *//*
*/
/**
                     *
                     * @param distanceMi
                     * The distance_mi
                     *//*
*/
/*
                    public void setDistanceMi(Integer distanceMi) {
                        this.distanceMi = distanceMi;
                    }

                }



            }



        }// End Of NearbySearch Stations


        // Start Of Airport
        public class Airport {

            @SerializedName("station")
            @Expose
            private List<Station> station = new ArrayList<Station>();

            *//*
*/
/**
             *
             * @return
             * The station
             *//*
*/
/*
            public List<Station> getStation() {
                return station;
            }

            *//*
*/
/**
             *
             * @param station
             * The station
             *//*
*/
/*
            public void setStation(List<Station> station) {
                this.station = station;
            }

        }

        // Start Of Station



        public class Station {

            @SerializedName("city")
            @Expose
            private String city;
            @SerializedName("state")
            @Expose
            private String state;
            @SerializedName("country")
            @Expose
            private String country;
            @SerializedName("icao")
            @Expose
            private String icao;
            @SerializedName("lat")
            @Expose
            private String lat;
            @SerializedName("lon")
            @Expose
            private String lon;

            *//*
*/
/**
             *
             * @return
             * The city
             *//*
*/
/*
            public String getCity() {
                return city;
            }

            *//*
*/
/**
             *
             * @param city
             * The city
             *//*
*/
/*
            public void setCity(String city) {
                this.city = city;
            }

            *//*
*/
/**
             *
             * @return
             * The state
             *//*
*/
/*
            public String getState() {
                return state;
            }

            *//*
*/
/**
             *
             * @param state
             * The state
             *//*
*/
/*
            public void setState(String state) {
                this.state = state;
            }

            *//*
*/
/**
             *
             * @return
             * The country
             *//*
*/
/*
            public String getCountry() {
                return country;
            }

            *//*
*/
/**
             *
             * @param country
             * The country
             *//*
*/
/*
            public void setCountry(String country) {
                this.country = country;
            }

            *//*
*/
/**
             *
             * @return
             * The icao
             *//*
*/
/*
            public String getIcao() {
                return icao;
            }

            *//*
*/
/**
             *
             * @param icao
             * The icao
             *//*
*/
/*
            public void setIcao(String icao) {
                this.icao = icao;
            }

            *//*
*/
/**
             *
             * @return
             * The lat
             *//*
*/
/*
            public String getLat() {
                return lat;
            }

            *//*
*/
/**
             *
             * @param lat
             * The lat
             *//*
*/
/*
            public void setLat(String lat) {
                this.lat = lat;
            }

            *//*
*/
/**
             *
             * @return
             * The lon
             *//*
*/
/*
            public String getLon() {
                return lon;
            }

            *//*
*/
/**
             *

             * The lon
             *//*
*/
/*
            public void setLon(String lon) {
                this.lon = lon;
            }

        }



    }  // End Of Location*//*


   //Start Of Current Obserbation



    public class CurrentObservation {

        @SerializedName("image")
        @Expose
        private Image image;
        @SerializedName("display_location")
        @Expose
        private DisplayLocation displayLocation;
        @SerializedName("observation_location")
        @Expose
        private ObservationLocation observationLocation;
        @SerializedName("estimated")
        @Expose
        private Estimated estimated;
        @SerializedName("station_id")
        @Expose
        private String stationId;
        @SerializedName("observation_time")
        @Expose
        private String observationTime;
        @SerializedName("observation_time_rfc822")
        @Expose
        private String observationTimeRfc822;
        @SerializedName("observation_epoch")
        @Expose
        private String observationEpoch;
        @SerializedName("local_time_rfc822")
        @Expose
        private String localTimeRfc822;
        @SerializedName("local_epoch")
        @Expose
        private String localEpoch;
        @SerializedName("local_tz_short")
        @Expose
        private String localTzShort;
        @SerializedName("local_tz_long")
        @Expose
        private String localTzLong;
        @SerializedName("local_tz_offset")
        @Expose
        private String localTzOffset;
        @SerializedName("weather")
        @Expose
        private String weather;
        @SerializedName("temperature_string")
        @Expose
        private String temperatureString;
        @SerializedName("temp_f")
        @Expose
        private Integer tempF;
        @SerializedName("temp_c")
        @Expose
        private Integer tempC;
        @SerializedName("relative_humidity")
        @Expose
        private String relativeHumidity;
        @SerializedName("wind_string")
        @Expose
        private String windString;
        @SerializedName("wind_dir")
        @Expose
        private String windDir;
        @SerializedName("wind_degrees")
        @Expose
        private Integer windDegrees;
        @SerializedName("wind_mph")
        @Expose
        private Integer windMph;
        @SerializedName("wind_gust_mph")
        @Expose
        private Integer windGustMph;
        @SerializedName("wind_kph")
        @Expose
        private Integer windKph;
        @SerializedName("wind_gust_kph")
        @Expose
        private Integer windGustKph;
        @SerializedName("pressure_mb")
        @Expose
        private String pressureMb;
        @SerializedName("pressure_in")
        @Expose
        private String pressureIn;
        @SerializedName("pressure_trend")
        @Expose
        private String pressureTrend;
        @SerializedName("dewpoint_string")
        @Expose
        private String dewpointString;
        @SerializedName("dewpoint_f")
        @Expose
        private Integer dewpointF;
        @SerializedName("dewpoint_c")
        @Expose
        private Integer dewpointC;
        @SerializedName("heat_index_string")
        @Expose
        private String heatIndexString;
        @SerializedName("heat_index_f")
        @Expose
        private String heatIndexF;
        @SerializedName("heat_index_c")
        @Expose
        private String heatIndexC;
        @SerializedName("windchill_string")
        @Expose
        private String windchillString;
        @SerializedName("windchill_f")
        @Expose
        private String windchillF;
        @SerializedName("windchill_c")
        @Expose
        private String windchillC;
        @SerializedName("feelslike_string")
        @Expose
        private String feelslikeString;
        @SerializedName("feelslike_f")
        @Expose
        private String feelslikeF;
        @SerializedName("feelslike_c")
        @Expose
        private String feelslikeC;
        @SerializedName("visibility_mi")
        @Expose
        private String visibilityMi;
        @SerializedName("visibility_km")
        @Expose
        private String visibilityKm;
        @SerializedName("solarradiation")
        @Expose
        private String solarradiation;
        @SerializedName("UV")
        @Expose
        private String uV;
        @SerializedName("precip_1hr_string")
        @Expose
        private String precip1hrString;
        @SerializedName("precip_1hr_in")
        @Expose
        private String precip1hrIn;
        @SerializedName("precip_1hr_metric")
        @Expose
        private String precip1hrMetric;
        @SerializedName("precip_today_string")
        @Expose
        private String precipTodayString;
        @SerializedName("precip_today_in")
        @Expose
        private String precipTodayIn;
        @SerializedName("precip_today_metric")
        @Expose
        private String precipTodayMetric;
        @SerializedName("icon")
        @Expose
        private String icon;
        @SerializedName("icon_url")
        @Expose
        private String iconUrl;
        @SerializedName("forecast_url")
        @Expose
        private String forecastUrl;
        @SerializedName("history_url")
        @Expose
        private String historyUrl;
        @SerializedName("ob_url")
        @Expose
        private String obUrl;
        @SerializedName("nowcast")
        @Expose
        private String nowcast;

        */
/**
         *
         * @return
         * The image
         *//*

        public Image getImage() {
            return image;
        }

        */
/**
         *
         * @param image
         * The image
         *//*

        public void setImage(Image image) {
            this.image = image;
        }

        */
/**
         *
         * @return
         * The displayLocation
         *//*

        public DisplayLocation getDisplayLocation() {
            return displayLocation;
        }

        */
/**
         *
         * @param displayLocation
         * The display_location
         *//*

        public void setDisplayLocation(DisplayLocation displayLocation) {
            this.displayLocation = displayLocation;
        }

        */
/**
         *
         * @return
         * The observationLocation
         *//*

        public ObservationLocation getObservationLocation() {
            return observationLocation;
        }

        */
/**
         *
         * @param observationLocation
         * The observation_location
         *//*

        public void setObservationLocation(ObservationLocation observationLocation) {
            this.observationLocation = observationLocation;
        }

        */
/**
         *
         * @return
         * The estimated
         *//*

        public Estimated getEstimated() {
            return estimated;
        }

        */
/**
         *
         * @param estimated
         * The estimated
         *//*

        public void setEstimated(Estimated estimated) {
            this.estimated = estimated;
        }

        */
/**
         *
         * @return
         * The stationId
         *//*

        public String getStationId() {
            return stationId;
        }

        */
/**
         *
         * @param stationId
         * The station_id
         *//*

        public void setStationId(String stationId) {
            this.stationId = stationId;
        }

        */
/**
         *
         * @return
         * The observationTime
         *//*

        public String getObservationTime() {
            return observationTime;
        }

        */
/**
         *
         * @param observationTime
         * The observation_time
         *//*

        public void setObservationTime(String observationTime) {
            this.observationTime = observationTime;
        }

        */
/**
         *
         * @return
         * The observationTimeRfc822
         *//*

        public String getObservationTimeRfc822() {
            return observationTimeRfc822;
        }

        */
/**
         *
         * @param observationTimeRfc822
         * The observation_time_rfc822
         *//*

        public void setObservationTimeRfc822(String observationTimeRfc822) {
            this.observationTimeRfc822 = observationTimeRfc822;
        }

        */
/**
         *
         * @return
         * The observationEpoch
         *//*

        public String getObservationEpoch() {
            return observationEpoch;
        }

        */
/**
         *
         * @param observationEpoch
         * The observation_epoch
         *//*

        public void setObservationEpoch(String observationEpoch) {
            this.observationEpoch = observationEpoch;
        }

        */
/**
         *
         * @return
         * The localTimeRfc822
         *//*

        public String getLocalTimeRfc822() {
            return localTimeRfc822;
        }

        */
/**
         *
         * @param localTimeRfc822
         * The local_time_rfc822
         *//*

        public void setLocalTimeRfc822(String localTimeRfc822) {
            this.localTimeRfc822 = localTimeRfc822;
        }

        */
/**
         *
         * @return
         * The localEpoch
         *//*

        public String getLocalEpoch() {
            return localEpoch;
        }

        */
/**
         *
         * @param localEpoch
         * The local_epoch
         *//*

        public void setLocalEpoch(String localEpoch) {
            this.localEpoch = localEpoch;
        }

        */
/**
         *
         * @return
         * The localTzShort
         *//*

        public String getLocalTzShort() {
            return localTzShort;
        }

        */
/**
         *
         * @param localTzShort
         * The local_tz_short
         *//*

        public void setLocalTzShort(String localTzShort) {
            this.localTzShort = localTzShort;
        }

        */
/**
         *
         * @return
         * The localTzLong
         *//*

        public String getLocalTzLong() {
            return localTzLong;
        }

        */
/**
         *
         * @param localTzLong
         * The local_tz_long
         *//*

        public void setLocalTzLong(String localTzLong) {
            this.localTzLong = localTzLong;
        }

        */
/**
         *
         * @return
         * The localTzOffset
         *//*

        public String getLocalTzOffset() {
            return localTzOffset;
        }

        */
/**
         *
         * @param localTzOffset
         * The local_tz_offset
         *//*

        public void setLocalTzOffset(String localTzOffset) {
            this.localTzOffset = localTzOffset;
        }

        */
/**
         *
         * @return
         * The weather
         *//*

        public String getWeather() {
            return weather;
        }

        */
/**
         *
         * @param weather
         * The weather
         *//*

        public void setWeather(String weather) {
            this.weather = weather;
        }

        */
/**
         *
         * @return
         * The temperatureString
         *//*

        public String getTemperatureString() {
            return temperatureString;
        }

        */
/**
         *
         * @param temperatureString
         * The temperature_string
         *//*

        public void setTemperatureString(String temperatureString) {
            this.temperatureString = temperatureString;
        }

        */
/**
         *
         * @return
         * The tempF
         *//*

        public Integer getTempF() {
            return tempF;
        }

        */
/**
         *
         * @param tempF
         * The temp_f
         *//*

        public void setTempF(Integer tempF) {
            this.tempF = tempF;
        }

        */
/**
         *
         * @return
         * The tempC
         *//*

        public Integer getTempC() {
            return tempC;
        }

        */
/**
         *
         * @param tempC
         * The temp_c
         *//*

        public void setTempC(Integer tempC) {
            this.tempC = tempC;
        }

        */
/**
         *
         * @return
         * The relativeHumidity
         *//*

        public String getRelativeHumidity() {
            return relativeHumidity;
        }

        */
/**
         *
         * @param relativeHumidity
         * The relative_humidity
         *//*

        public void setRelativeHumidity(String relativeHumidity) {
            this.relativeHumidity = relativeHumidity;
        }

        */
/**
         *
         * @return
         * The windString
         *//*

        public String getWindString() {
            return windString;
        }

        */
/**
         *
         * @param windString
         * The wind_string
         *//*

        public void setWindString(String windString) {
            this.windString = windString;
        }

        */
/**
         *
         * @return
         * The windDir
         *//*

        public String getWindDir() {
            return windDir;
        }

        */
/**
         *
         * @param windDir
         * The wind_dir
         *//*

        public void setWindDir(String windDir) {
            this.windDir = windDir;
        }

        */
/**
         *
         * @return
         * The windDegrees
         *//*

        public Integer getWindDegrees() {
            return windDegrees;
        }

        */
/**
         *
         * @param windDegrees
         * The wind_degrees
         *//*

        public void setWindDegrees(Integer windDegrees) {
            this.windDegrees = windDegrees;
        }

        */
/**
         *
         * @return
         * The windMph
         *//*

        public Integer getWindMph() {
            return windMph;
        }

        */
/**
         *
         * @param windMph
         * The wind_mph
         *//*

        public void setWindMph(Integer windMph) {
            this.windMph = windMph;
        }

        */
/**
         *
         * @return
         * The windGustMph
         *//*

        public Integer getWindGustMph() {
            return windGustMph;
        }

        */
/**
         *
         * @param windGustMph
         * The wind_gust_mph
         *//*

        public void setWindGustMph(Integer windGustMph) {
            this.windGustMph = windGustMph;
        }

        */
/**
         *
         * @return
         * The windKph
         *//*

        public Integer getWindKph() {
            return windKph;
        }

        */
/**
         *
         * @param windKph
         * The wind_kph
         *//*

        public void setWindKph(Integer windKph) {
            this.windKph = windKph;
        }

        */
/**
         *
         * @return
         * The windGustKph
         *//*

        public Integer getWindGustKph() {
            return windGustKph;
        }

        */
/**
         *
         * @param windGustKph
         * The wind_gust_kph
         *//*

        public void setWindGustKph(Integer windGustKph) {
            this.windGustKph = windGustKph;
        }

        */
/**
         *
         * @return
         * The pressureMb
         *//*

        public String getPressureMb() {
            return pressureMb;
        }

        */
/**
         *
         * @param pressureMb
         * The pressure_mb
         *//*

        public void setPressureMb(String pressureMb) {
            this.pressureMb = pressureMb;
        }

        */
/**
         *
         * @return
         * The pressureIn
         *//*

        public String getPressureIn() {
            return pressureIn;
        }

        */
/**
         *
         * @param pressureIn
         * The pressure_in
         *//*

        public void setPressureIn(String pressureIn) {
            this.pressureIn = pressureIn;
        }

        */
/**
         *
         * @return
         * The pressureTrend
         *//*

        public String getPressureTrend() {
            return pressureTrend;
        }

        */
/**
         *
         * @param pressureTrend
         * The pressure_trend
         *//*

        public void setPressureTrend(String pressureTrend) {
            this.pressureTrend = pressureTrend;
        }

        */
/**
         *
         * @return
         * The dewpointString
         *//*

        public String getDewpointString() {
            return dewpointString;
        }

        */
/**
         *
         * @param dewpointString
         * The dewpoint_string
         *//*

        public void setDewpointString(String dewpointString) {
            this.dewpointString = dewpointString;
        }

        */
/**
         *
         * @return
         * The dewpointF
         *//*

        public Integer getDewpointF() {
            return dewpointF;
        }

        */
/**
         *
         * @param dewpointF
         * The dewpoint_f
         *//*

        public void setDewpointF(Integer dewpointF) {
            this.dewpointF = dewpointF;
        }

        */
/**
         *
         * @return
         * The dewpointC
         *//*

        public Integer getDewpointC() {
            return dewpointC;
        }

        */
/**
         *
         * @param dewpointC
         * The dewpoint_c
         *//*

        public void setDewpointC(Integer dewpointC) {
            this.dewpointC = dewpointC;
        }

        */
/**
         *
         * @return
         * The heatIndexString
         *//*

        public String getHeatIndexString() {
            return heatIndexString;
        }

        */
/**
         *
         * @param heatIndexString
         * The heat_index_string
         *//*

        public void setHeatIndexString(String heatIndexString) {
            this.heatIndexString = heatIndexString;
        }

        */
/**
         *
         * @return
         * The heatIndexF
         *//*

        public String getHeatIndexF() {
            return heatIndexF;
        }

        */
/**
         *
         * @param heatIndexF
         * The heat_index_f
         *//*

        public void setHeatIndexF(String heatIndexF) {
            this.heatIndexF = heatIndexF;
        }

        */
/**
         *
         * @return
         * The heatIndexC
         *//*

        public String getHeatIndexC() {
            return heatIndexC;
        }

        */
/**
         *
         * @param heatIndexC
         * The heat_index_c
         *//*

        public void setHeatIndexC(String heatIndexC) {
            this.heatIndexC = heatIndexC;
        }

        */
/**
         *
         * @return
         * The windchillString
         *//*

        public String getWindchillString() {
            return windchillString;
        }

        */
/**
         *
         * @param windchillString
         * The windchill_string
         *//*

        public void setWindchillString(String windchillString) {
            this.windchillString = windchillString;
        }

        */
/**
         *
         * @return
         * The windchillF
         *//*

        public String getWindchillF() {
            return windchillF;
        }

        */
/**
         *
         * @param windchillF
         * The windchill_f
         *//*

        public void setWindchillF(String windchillF) {
            this.windchillF = windchillF;
        }

        */
/**
         *
         * @return
         * The windchillC
         *//*

        public String getWindchillC() {
            return windchillC;
        }

        */
/**
         *
         * @param windchillC
         * The windchill_c
         *//*

        public void setWindchillC(String windchillC) {
            this.windchillC = windchillC;
        }

        */
/**
         *
         * @return
         * The feelslikeString
         *//*

        public String getFeelslikeString() {
            return feelslikeString;
        }

        */
/**
         *
         * @param feelslikeString
         * The feelslike_string
         *//*

        public void setFeelslikeString(String feelslikeString) {
            this.feelslikeString = feelslikeString;
        }

        */
/**
         *
         * @return
         * The feelslikeF
         *//*

        public String getFeelslikeF() {
            return feelslikeF;
        }

        */
/**
         *
         * @param feelslikeF
         * The feelslike_f
         *//*

        public void setFeelslikeF(String feelslikeF) {
            this.feelslikeF = feelslikeF;
        }

        */
/**
         *
         * @return
         * The feelslikeC
         *//*

        public String getFeelslikeC() {
            return feelslikeC;
        }

        */
/**
         *
         * @param feelslikeC
         * The feelslike_c
         *//*

        public void setFeelslikeC(String feelslikeC) {
            this.feelslikeC = feelslikeC;
        }

        */
/**
         *
         * @return
         * The visibilityMi
         *//*

        public String getVisibilityMi() {
            return visibilityMi;
        }

        */
/**
         *
         * @param visibilityMi
         * The visibility_mi
         *//*

        public void setVisibilityMi(String visibilityMi) {
            this.visibilityMi = visibilityMi;
        }

        */
/**
         *
         * @return
         * The visibilityKm
         *//*

        public String getVisibilityKm() {
            return visibilityKm;
        }

        */
/**
         *
         * @param visibilityKm
         * The visibility_km
         *//*

        public void setVisibilityKm(String visibilityKm) {
            this.visibilityKm = visibilityKm;
        }

        */
/**
         *
         * @return
         * The solarradiation
         *//*

        public String getSolarradiation() {
            return solarradiation;
        }

        */
/**
         *
         * @param solarradiation
         * The solarradiation
         *//*

        public void setSolarradiation(String solarradiation) {
            this.solarradiation = solarradiation;
        }

        */
/**
         *
         * @return
         * The uV
         *//*

        public String getUV() {
            return uV;
        }

        */
/**
         *
         * @param uV
         * The UV
         *//*

        public void setUV(String uV) {
            this.uV = uV;
        }

        */
/**
         *
         * @return
         * The precip1hrString
         *//*

        public String getPrecip1hrString() {
            return precip1hrString;
        }

        */
/**
         *
         * @param precip1hrString
         * The precip_1hr_string
         *//*

        public void setPrecip1hrString(String precip1hrString) {
            this.precip1hrString = precip1hrString;
        }

        */
/**
         *
         * @return
         * The precip1hrIn
         *//*

        public String getPrecip1hrIn() {
            return precip1hrIn;
        }

        */
/**
         *
         * @param precip1hrIn
         * The precip_1hr_in
         *//*

        public void setPrecip1hrIn(String precip1hrIn) {
            this.precip1hrIn = precip1hrIn;
        }

        */
/**
         *
         * @return
         * The precip1hrMetric
         *//*

        public String getPrecip1hrMetric() {
            return precip1hrMetric;
        }

        */
/**
         *
         * @param precip1hrMetric
         * The precip_1hr_metric
         *//*

        public void setPrecip1hrMetric(String precip1hrMetric) {
            this.precip1hrMetric = precip1hrMetric;
        }

        */
/**
         *
         * @return
         * The precipTodayString
         *//*

        public String getPrecipTodayString() {
            return precipTodayString;
        }

        */
/**
         *
         * @param precipTodayString
         * The precip_today_string
         *//*

        public void setPrecipTodayString(String precipTodayString) {
            this.precipTodayString = precipTodayString;
        }

        */
/**
         *
         * @return
         * The precipTodayIn
         *//*

        public String getPrecipTodayIn() {
            return precipTodayIn;
        }

        */
/**
         *
         * @param precipTodayIn
         * The precip_today_in
         *//*

        public void setPrecipTodayIn(String precipTodayIn) {
            this.precipTodayIn = precipTodayIn;
        }

        */
/**
         *
         * @return
         * The precipTodayMetric
         *//*

        public String getPrecipTodayMetric() {
            return precipTodayMetric;
        }

        */
/**
         *
         * @param precipTodayMetric
         * The precip_today_metric
         *//*

        public void setPrecipTodayMetric(String precipTodayMetric) {
            this.precipTodayMetric = precipTodayMetric;
        }

        */
/**
         *
         * @return
         * The icon
         *//*

        public String getIcon() {
            return icon;
        }

        */
/**
         *
         * @param icon
         * The icon
         *//*

        public void setIcon(String icon) {
            this.icon = icon;
        }

        */
/**
         *
         * @return
         * The iconUrl
         *//*

        public String getIconUrl() {
            return iconUrl;
        }

        */
/**
         *
         * @param iconUrl
         * The icon_url
         *//*

        public void setIconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
        }

        */
/**
         *
         * @return
         * The forecastUrl
         *//*

        public String getForecastUrl() {
            return forecastUrl;
        }

        */
/**
         *
         * @param forecastUrl
         * The forecast_url
         *//*

        public void setForecastUrl(String forecastUrl) {
            this.forecastUrl = forecastUrl;
        }

        */
/**
         *
         * @return
         * The historyUrl
         *//*

        public String getHistoryUrl() {
            return historyUrl;
        }

        */
/**
         *
         * @param historyUrl
         * The history_url
         *//*

        public void setHistoryUrl(String historyUrl) {
            this.historyUrl = historyUrl;
        }

        */
/**
         *
         * @return
         * The obUrl
         *//*

        public String getObUrl() {
            return obUrl;
        }

        */
/**
         *
         * @param obUrl
         * The ob_url
         *//*

        public void setObUrl(String obUrl) {
            this.obUrl = obUrl;
        }

        */
/**
         *
         * @return
         * The nowcast
         *//*

        public String getNowcast() {
            return nowcast;
        }

        */
/**
         *
         * @param nowcast
         * The nowcast
         *//*

        public void setNowcast(String nowcast) {
            this.nowcast = nowcast;
        }




        // Start of image

        public class Image {

            @SerializedName("url")
            @Expose
            private String url;
            @SerializedName("title")
            @Expose
            private String title;
            @SerializedName("link")
            @Expose
            private String link;

            */
/**
             *
             * @return
             * The url
             *//*

            public String getUrl() {
                return url;
            }

            */
/**
             *
             * @param url
             * The url
             *//*

            public void setUrl(String url) {
                this.url = url;
            }

            */
/**
             *
             * @return
             * The title
             *//*

            public String getTitle() {
                return title;
            }

            */
/**
             *
             * @param title
             * The title
             *//*

            public void setTitle(String title) {
                this.title = title;
            }

            */
/**
             *
             * @return
             * The link
             *//*

            public String getLink() {
                return link;
            }

            */
/**
             *
             * @param link
             * The link
             *//*

            public void setLink(String link) {
                this.link = link;
            }

        }// End Of Image

        // Start Of DisplayLocation

        public class DisplayLocation {

            @SerializedName("full")
            @Expose
            private String full;
            @SerializedName("city")
            @Expose
            private String city;
            @SerializedName("state")
            @Expose
            private String state;
            @SerializedName("state_name")
            @Expose
            private String stateName;
            @SerializedName("country")
            @Expose
            private String country;
            @SerializedName("country_iso3166")
            @Expose
            private String countryIso3166;
            @SerializedName("zip")
            @Expose
            private String zip;
            @SerializedName("magic")
            @Expose
            private String magic;
            @SerializedName("wmo")
            @Expose
            private String wmo;
            @SerializedName("latitude")
            @Expose
            private String latitude;
            @SerializedName("longitude")
            @Expose
            private String longitude;
            @SerializedName("elevation")
            @Expose
            private String elevation;

            */
/**
             *
             * @return
             * The full
             *//*

            public String getFull() {
                return full;
            }

            */
/**
             *
             * @param full
             * The full
             *//*

            public void setFull(String full) {
                this.full = full;
            }

            */
/**
             *
             * @return
             * The city
             *//*

            public String getCity() {
                return city;
            }

            */
/**
             *
             * @param city
             * The city
             *//*

            public void setCity(String city) {
                this.city = city;
            }

            */
/**
             *
             * @return
             * The state
             *//*

            public String getState() {
                return state;
            }

            */
/**
             *
             * @param state
             * The state
             *//*

            public void setState(String state) {
                this.state = state;
            }

            */
/**
             *
             * @return
             * The stateName
             *//*

            public String getStateName() {
                return stateName;
            }

            */
/**
             *
             * @param stateName
             * The state_name
             *//*

            public void setStateName(String stateName) {
                this.stateName = stateName;
            }

            */
/**
             *
             * @return
             * The country
             *//*

            public String getCountry() {
                return country;
            }

            */
/**
             *
             * @param country
             * The country
             *//*

            public void setCountry(String country) {
                this.country = country;
            }

            */
/**
             *
             * @return
             * The countryIso3166
             *//*

            public String getCountryIso3166() {
                return countryIso3166;
            }

            */
/**
             *
             * @param countryIso3166
             * The country_iso3166
             *//*

            public void setCountryIso3166(String countryIso3166) {
                this.countryIso3166 = countryIso3166;
            }

            */
/**
             *
             * @return
             * The zip
             *//*

            public String getZip() {
                return zip;
            }

            */
/**
             *
             * @param zip
             * The zip
             *//*

            public void setZip(String zip) {
                this.zip = zip;
            }

            */
/**
             *
             * @return
             * The magic
             *//*

            public String getMagic() {
                return magic;
            }

            */
/**
             *
             * @param magic
             * The magic
             *//*

            public void setMagic(String magic) {
                this.magic = magic;
            }

            */
/**
             *
             * @return
             * The wmo
             *//*

            public String getWmo() {
                return wmo;
            }

            */
/**
             *
             * @param wmo
             * The wmo
             *//*

            public void setWmo(String wmo) {
                this.wmo = wmo;
            }

            */
/**
             *
             * @return
             * The latitude
             *//*

            public String getLatitude() {
                return latitude;
            }

            */
/**
             *
             * @param latitude
             * The latitude
             *//*

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            */
/**
             *
             * @return
             * The longitude
             *//*

            public String getLongitude() {
                return longitude;
            }

            */
/**
             *
             * @param longitude
             * The longitude
             *//*

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            */
/**
             *
             * @return
             * The elevation
             *//*

            public String getElevation() {
                return elevation;
            }

            */
/**
             *
             * @param elevation
             * The elevation
             *//*

            public void setElevation(String elevation) {
                this.elevation = elevation;
            }

        }  // DisplayLocation

        public class ObservationLocation {

            @SerializedName("full")
            @Expose
            private String full;
            @SerializedName("city")
            @Expose
            private String city;
            @SerializedName("state")
            @Expose
            private String state;
            @SerializedName("country")
            @Expose
            private String country;
            @SerializedName("country_iso3166")
            @Expose
            private String countryIso3166;
            @SerializedName("latitude")
            @Expose
            private String latitude;
            @SerializedName("longitude")
            @Expose
            private String longitude;
            @SerializedName("elevation")
            @Expose
            private String elevation;

            */
/**
             *
             * @return
             * The full
             *//*

            public String getFull() {
                return full;
            }

            */
/**
             *
             * @param full
             * The full
             *//*

            public void setFull(String full) {
                this.full = full;
            }

            */
/**
             *
             * @return
             * The city
             *//*

            public String getCity() {
                return city;
            }

            */
/**
             *
             * @param city
             * The city
             *//*

            public void setCity(String city) {
                this.city = city;
            }

            */
/**
             *
             * @return
             * The state
             *//*

            public String getState() {
                return state;
            }

            */
/**
             *
             * @param state
             * The state
             *//*

            public void setState(String state) {
                this.state = state;
            }

            */
/**
             *
             * @return
             * The country
             *//*

            public String getCountry() {
                return country;
            }

            */
/**
             *
             * @param country
             * The country
             *//*

            public void setCountry(String country) {
                this.country = country;
            }

            */
/**
             *
             * @return
             * The countryIso3166
             *//*

            public String getCountryIso3166() {
                return countryIso3166;
            }

            */
/**
             *
             * @param countryIso3166
             * The country_iso3166
             *//*

            public void setCountryIso3166(String countryIso3166) {
                this.countryIso3166 = countryIso3166;
            }

            */
/**
             *
             * @return
             * The latitude
             *//*

            public String getLatitude() {
                return latitude;
            }

            */
/**
             *
             * @param latitude
             * The latitude
             *//*

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            */
/**
             *
             * @return
             * The longitude
             *//*

            public String getLongitude() {
                return longitude;
            }

            */
/**
             *
             * @param longitude
             * The longitude
             *//*

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            */
/**
             *
             * @return
             * The elevation
             *//*

            public String getElevation() {
                return elevation;
            }

            */
/**
             *
             * @param elevation
             * The elevation
             *//*

            public void setElevation(String elevation) {
                this.elevation = elevation;
            }

        }


        public class Estimated {


        }




    }  // End Of Current Obserbation

    public class Forecast {

        @SerializedName("txt_forecast")
        @Expose
        private TxtForecast txtForecast;
        @SerializedName("simpleforecast")
        @Expose
        private Simpleforecast simpleforecast;

        */
/**
         *
         * @return
         * The txtForecast
         *//*

        public TxtForecast getTxtForecast() {
            return txtForecast;
        }

        */
/**
         *
         * @param txtForecast
         * The txt_forecast
         *//*

        public void setTxtForecast(TxtForecast txtForecast) {
            this.txtForecast = txtForecast;
        }

        */
/**
         *
         * @return
         * The simpleforecast
         *//*

        public Simpleforecast getSimpleforecast() {
            return simpleforecast;
        }

        */
/**
         *
         * @param simpleforecast
         * The simpleforecast
         *//*

        public void setSimpleforecast(Simpleforecast simpleforecast) {
            this.simpleforecast = simpleforecast;
        }


        // Start of TXTFORCAST

        public class TxtForecast {

            @SerializedName("date")
            @Expose
            private String date;
            @SerializedName("forecastday")
            @Expose
            private List<Forecastday> forecastday = new ArrayList<Forecastday>();

            */
/**
             *
             * @return
             * The date
             *//*

            public String getDate() {
                return date;
            }

            */
/**
             *
             * @param date
             * The date
             *//*

            public void setDate(String date) {
                this.date = date;
            }

            */
/**
             *
             * @return
             * The forecastday
             *//*

            public List<Forecastday> getForecastday() {
                return forecastday;
            }

            */
/**
             *
             * @param forecastday
             * The forecastday
             *//*

            public void setForecastday(List<Forecastday> forecastday) {
                this.forecastday = forecastday;
            }


            // Start Of ForecastDay

            public class Forecastday {

                @SerializedName("period")
                @Expose
                private Integer period;
                @SerializedName("icon")
                @Expose
                private String icon;
                @SerializedName("icon_url")
                @Expose
                private String iconUrl;
                @SerializedName("title")
                @Expose
                private String title;
                @SerializedName("fcttext")
                @Expose
                private String fcttext;
                @SerializedName("fcttext_metric")
                @Expose
                private String fcttextMetric;
                @SerializedName("pop")
                @Expose
                private String pop;

                */
/**
                 *
                 * @return
                 * The period
                 *//*

                public Integer getPeriod() {
                    return period;
                }

                */
/**
                 *
                 * @param period
                 * The period
                 *//*

                public void setPeriod(Integer period) {
                    this.period = period;
                }

                */
/**
                 *
                 * @return
                 * The icon
                 *//*

                public String getIcon() {
                    return icon;
                }

                */
/**
                 *
                 * @param icon
                 * The icon
                 *//*

                public void setIcon(String icon) {
                    this.icon = icon;
                }

                */
/**
                 *
                 * @return
                 * The iconUrl
                 *//*

                public String getIconUrl() {
                    return iconUrl;
                }

                */
/**
                 *
                 * @param iconUrl
                 * The icon_url
                 *//*

                public void setIconUrl(String iconUrl) {
                    this.iconUrl = iconUrl;
                }

                */
/**
                 *
                 * @return
                 * The title
                 *//*

                public String getTitle() {
                    return title;
                }

                */
/**
                 *
                 * @param title
                 * The title
                 *//*

                public void setTitle(String title) {
                    this.title = title;
                }

                */
/**
                 *
                 * @return
                 * The fcttext
                 *//*

                public String getFcttext() {
                    return fcttext;
                }

                */
/**
                 *
                 * @param fcttext
                 * The fcttext
                 *//*

                public void setFcttext(String fcttext) {
                    this.fcttext = fcttext;
                }

                */
/**
                 *
                 * @return
                 * The fcttextMetric
                 *//*

                public String getFcttextMetric() {
                    return fcttextMetric;
                }

                */
/**
                 *
                 * @param fcttextMetric
                 * The fcttext_metric
                 *//*

                public void setFcttextMetric(String fcttextMetric) {
                    this.fcttextMetric = fcttextMetric;
                }

                */
/**
                 *
                 * @return
                 * The pop
                 *//*

                public String getPop() {
                    return pop;
                }

                */
/**
                 *
                 * @param pop
                 * The pop
                 *//*

                public void setPop(String pop) {
                    this.pop = pop;
                }

            }



        }// End OF TXTforcast

        // Satrt Of Simpleforcast

        public class Simpleforecast {

            @SerializedName("forecastday")
            @Expose
            private List<Forecastday_> forecastday = new ArrayList<Forecastday_>();

            */
/**
             *
             * @return
             * The forecastday
             *//*

            public List<Forecastday_> getForecastday() {
                return forecastday;
            }

            */
/**
             *
             * @param forecastday
             * The forecastday
             *//*

            public void setForecastday(List<Forecastday_> forecastday) {
                this.forecastday = forecastday;
            }


            // Start Of ForecastDay_

            public class Forecastday_ {

                @SerializedName("date")
                @Expose
                private Date date;
                @SerializedName("period")
                @Expose
                private Integer period;
                @SerializedName("high")
                @Expose
                private High high;
                @SerializedName("low")
                @Expose
                private Low low;
                @SerializedName("conditions")
                @Expose
                private String conditions;
                @SerializedName("icon")
                @Expose
                private String icon;
                @SerializedName("icon_url")
                @Expose
                private String iconUrl;
                @SerializedName("skyicon")
                @Expose
                private String skyicon;
                @SerializedName("pop")
                @Expose
                private Integer pop;
                @SerializedName("qpf_allday")
                @Expose
                private QpfAllday qpfAllday;
                @SerializedName("qpf_day")
                @Expose
                private QpfDay qpfDay;
                @SerializedName("qpf_night")
                @Expose
                private QpfNight qpfNight;
                @SerializedName("snow_allday")
                @Expose
                private SnowAllday snowAllday;
                @SerializedName("snow_day")
                @Expose
                private SnowDay snowDay;
                @SerializedName("snow_night")
                @Expose
                private SnowNight snowNight;
                @SerializedName("maxwind")
                @Expose
                private Maxwind maxwind;
                @SerializedName("avewind")
                @Expose
                private Avewind avewind;
                @SerializedName("avehumidity")
                @Expose
                private Integer avehumidity;
                @SerializedName("maxhumidity")
                @Expose
                private Integer maxhumidity;
                @SerializedName("minhumidity")
                @Expose
                private Integer minhumidity;

                */
/**
                 *
                 * @return
                 * The date
                 *//*

                public Date getDate() {
                    return date;
                }

                */
/**
                 *
                 * @param date
                 * The date
                 *//*

                public void setDate(Date date) {
                    this.date = date;
                }

                */
/**
                 *
                 * @return
                 * The period
                 *//*

                public Integer getPeriod() {
                    return period;
                }

                */
/**
                 *
                 * @param period
                 * The period
                 *//*

                public void setPeriod(Integer period) {
                    this.period = period;
                }

                */
/**
                 *
                 * @return
                 * The high
                 *//*

                public High getHigh() {
                    return high;
                }

                */
/**
                 *
                 * @param high
                 * The high
                 *//*

                public void setHigh(High high) {
                    this.high = high;
                }

                */
/**
                 *
                 * @return
                 * The low
                 *//*

                public Low getLow() {
                    return low;
                }

                */
/**
                 *
                 * @param low
                 * The low
                 *//*

                public void setLow(Low low) {
                    this.low = low;
                }

                */
/**
                 *
                 * @return
                 * The conditions
                 *//*

                public String getConditions() {
                    return conditions;
                }

                */
/**
                 *
                 * @param conditions
                 * The conditions
                 *//*

                public void setConditions(String conditions) {
                    this.conditions = conditions;
                }

                */
/**
                 *
                 * @return
                 * The icon
                 *//*

                public String getIcon() {
                    return icon;
                }

                */
/**
                 *
                 * @param icon
                 * The icon
                 *//*

                public void setIcon(String icon) {
                    this.icon = icon;
                }

                */
/**
                 *
                 * @return
                 * The iconUrl
                 *//*

                public String getIconUrl() {
                    return iconUrl;
                }

                */
/**
                 *
                 * @param iconUrl
                 * The icon_url
                 *//*

                public void setIconUrl(String iconUrl) {
                    this.iconUrl = iconUrl;
                }

                */
/**
                 *
                 * @return
                 * The skyicon
                 *//*

                public String getSkyicon() {
                    return skyicon;
                }

                */
/**
                 *
                 * @param skyicon
                 * The skyicon
                 *//*

                public void setSkyicon(String skyicon) {
                    this.skyicon = skyicon;
                }

                */
/**
                 *
                 * @return
                 * The pop
                 *//*

                public Integer getPop() {
                    return pop;
                }

                */
/**
                 *
                 * @param pop
                 * The pop
                 *//*

                public void setPop(Integer pop) {
                    this.pop = pop;
                }

                */
/**
                 *
                 * @return
                 * The qpfAllday
                 *//*

                public QpfAllday getQpfAllday() {
                    return qpfAllday;
                }

                */
/**
                 *
                 * @param qpfAllday
                 * The qpf_allday
                 *//*

                public void setQpfAllday(QpfAllday qpfAllday) {
                    this.qpfAllday = qpfAllday;
                }

                */
/**
                 *
                 * @return
                 * The qpfDay
                 *//*

                public QpfDay getQpfDay() {
                    return qpfDay;
                }

                */
/**
                 *
                 * @param qpfDay
                 * The qpf_day
                 *//*

                public void setQpfDay(QpfDay qpfDay) {
                    this.qpfDay = qpfDay;
                }

                */
/**
                 *
                 * @return
                 * The qpfNight
                 *//*

                public QpfNight getQpfNight() {
                    return qpfNight;
                }

                */
/**
                 *
                 * @param qpfNight
                 * The qpf_night
                 *//*

                public void setQpfNight(QpfNight qpfNight) {
                    this.qpfNight = qpfNight;
                }

                */
/**
                 *
                 * @return
                 * The snowAllday
                 *//*

                public SnowAllday getSnowAllday() {
                    return snowAllday;
                }

                */
/**
                 *
                 * @param snowAllday
                 * The snow_allday
                 *//*

                public void setSnowAllday(SnowAllday snowAllday) {
                    this.snowAllday = snowAllday;
                }

                */
/**
                 *
                 * @return
                 * The snowDay
                 *//*

                public SnowDay getSnowDay() {
                    return snowDay;
                }

                */
/**
                 *
                 * @param snowDay
                 * The snow_day
                 *//*

                public void setSnowDay(SnowDay snowDay) {
                    this.snowDay = snowDay;
                }

                */
/**
                 *
                 * @return
                 * The snowNight
                 *//*

                public SnowNight getSnowNight() {
                    return snowNight;
                }

                */
/**
                 *
                 * @param snowNight
                 * The snow_night
                 *//*

                public void setSnowNight(SnowNight snowNight) {
                    this.snowNight = snowNight;
                }

                */
/**
                 *
                 * @return
                 * The maxwind
                 *//*

                public Maxwind getMaxwind() {
                    return maxwind;
                }

                */
/**
                 *
                 * @param maxwind
                 * The maxwind
                 *//*

                public void setMaxwind(Maxwind maxwind) {
                    this.maxwind = maxwind;
                }

                */
/**
                 *
                 * @return
                 * The avewind
                 *//*

                public Avewind getAvewind() {
                    return avewind;
                }

                */
/**
                 *
                 * @param avewind
                 * The avewind
                 *//*

                public void setAvewind(Avewind avewind) {
                    this.avewind = avewind;
                }

                */
/**
                 *
                 * @return
                 * The avehumidity
                 *//*

                public Integer getAvehumidity() {
                    return avehumidity;
                }

                */
/**
                 *
                 * @param avehumidity
                 * The avehumidity
                 *//*

                public void setAvehumidity(Integer avehumidity) {
                    this.avehumidity = avehumidity;
                }

                */
/**
                 *
                 * @return
                 * The maxhumidity
                 *//*

                public Integer getMaxhumidity() {
                    return maxhumidity;
                }

                */
/**
                 *
                 * @param maxhumidity
                 * The maxhumidity
                 *//*

                public void setMaxhumidity(Integer maxhumidity) {
                    this.maxhumidity = maxhumidity;
                }

                */
/**
                 *
                 * @return
                 * The minhumidity
                 *//*

                public Integer getMinhumidity() {
                    return minhumidity;
                }

                */
/**
                 *
                 * @param minhumidity
                 * The minhumidity
                 *//*

                public void setMinhumidity(Integer minhumidity) {
                    this.minhumidity = minhumidity;
                }


                public class Date {

                    @SerializedName("epoch")
                    @Expose
                    private String epoch;
                    @SerializedName("pretty")
                    @Expose
                    private String pretty;
                    @SerializedName("day")
                    @Expose
                    private Integer day;
                    @SerializedName("month")
                    @Expose
                    private Integer month;
                    @SerializedName("year")
                    @Expose
                    private Integer year;
                    @SerializedName("yday")
                    @Expose
                    private Integer yday;
                    @SerializedName("hour")
                    @Expose
                    private Integer hour;
                    @SerializedName("min")
                    @Expose
                    private String min;
                    @SerializedName("sec")
                    @Expose
                    private Integer sec;
                    @SerializedName("isdst")
                    @Expose
                    private String isdst;
                    @SerializedName("monthname")
                    @Expose
                    private String monthname;
                    @SerializedName("monthname_short")
                    @Expose
                    private String monthnameShort;
                    @SerializedName("weekday_short")
                    @Expose
                    private String weekdayShort;
                    @SerializedName("weekday")
                    @Expose
                    private String weekday;
                    @SerializedName("ampm")
                    @Expose
                    private String ampm;
                    @SerializedName("tz_short")
                    @Expose
                    private String tzShort;
                    @SerializedName("tz_long")
                    @Expose
                    private String tzLong;

                    */
/**
                     *
                     * @return
                     * The epoch
                     *//*

                    public String getEpoch() {
                        return epoch;
                    }

                    */
/**
                     *
                     * @param epoch
                     * The epoch
                     *//*

                    public void setEpoch(String epoch) {
                        this.epoch = epoch;
                    }

                    */
/**
                     *
                     * @return
                     * The pretty
                     *//*

                    public String getPretty() {
                        return pretty;
                    }

                    */
/**
                     *
                     * @param pretty
                     * The pretty
                     *//*

                    public void setPretty(String pretty) {
                        this.pretty = pretty;
                    }

                    */
/**
                     *
                     * @return
                     * The day
                     *//*

                    public Integer getDay() {
                        return day;
                    }

                    */
/**
                     *
                     * @param day
                     * The day
                     *//*

                    public void setDay(Integer day) {
                        this.day = day;
                    }

                    */
/**
                     *
                     * @return
                     * The month
                     *//*

                    public Integer getMonth() {
                        return month;
                    }

                    */
/**
                     *
                     * @param month
                     * The month
                     *//*

                    public void setMonth(Integer month) {
                        this.month = month;
                    }

                    */
/**
                     *
                     * @return
                     * The year
                     *//*

                    public Integer getYear() {
                        return year;
                    }

                    */
/**
                     *
                     * @param year
                     * The year
                     *//*

                    public void setYear(Integer year) {
                        this.year = year;
                    }

                    */
/**
                     *
                     * @return
                     * The yday
                     *//*

                    public Integer getYday() {
                        return yday;
                    }

                    */
/**
                     *
                     * @param yday
                     * The yday
                     *//*

                    public void setYday(Integer yday) {
                        this.yday = yday;
                    }

                    */
/**
                     *
                     * @return
                     * The hour
                     *//*

                    public Integer getHour() {
                        return hour;
                    }

                    */
/**
                     *
                     * @param hour
                     * The hour
                     *//*

                    public void setHour(Integer hour) {
                        this.hour = hour;
                    }

                    */
/**
                     *
                     * @return
                     * The min
                     *//*

                    public String getMin() {
                        return min;
                    }

                    */
/**
                     *
                     * @param min
                     * The min
                     *//*

                    public void setMin(String min) {
                        this.min = min;
                    }

                    */
/**
                     *
                     * @return
                     * The sec
                     *//*

                    public Integer getSec() {
                        return sec;
                    }

                    */
/**
                     *
                     * @param sec
                     * The sec
                     *//*

                    public void setSec(Integer sec) {
                        this.sec = sec;
                    }

                    */
/**
                     *
                     * @return
                     * The isdst
                     *//*

                    public String getIsdst() {
                        return isdst;
                    }

                    */
/**
                     *
                     * @param isdst
                     * The isdst
                     *//*

                    public void setIsdst(String isdst) {
                        this.isdst = isdst;
                    }

                    */
/**
                     *
                     * @return
                     * The monthname
                     *//*

                    public String getMonthname() {
                        return monthname;
                    }

                    */
/**
                     *
                     * @param monthname
                     * The monthname
                     *//*

                    public void setMonthname(String monthname) {
                        this.monthname = monthname;
                    }

                    */
/**
                     *
                     * @return
                     * The monthnameShort
                     *//*

                    public String getMonthnameShort() {
                        return monthnameShort;
                    }

                    */
/**
                     *
                     * @param monthnameShort
                     * The monthname_short
                     *//*

                    public void setMonthnameShort(String monthnameShort) {
                        this.monthnameShort = monthnameShort;
                    }

                    */
/**
                     *
                     * @return
                     * The weekdayShort
                     *//*

                    public String getWeekdayShort() {
                        return weekdayShort;
                    }

                    */
/**
                     *
                     * @param weekdayShort
                     * The weekday_short
                     *//*

                    public void setWeekdayShort(String weekdayShort) {
                        this.weekdayShort = weekdayShort;
                    }

                    */
/**
                     *
                     * @return
                     * The weekday
                     *//*

                    public String getWeekday() {
                        return weekday;
                    }

                    */
/**
                     *
                     * @param weekday
                     * The weekday
                     *//*

                    public void setWeekday(String weekday) {
                        this.weekday = weekday;
                    }

                    */
/**
                     *
                     * @return
                     * The ampm
                     *//*

                    public String getAmpm() {
                        return ampm;
                    }

                    */
/**
                     *
                     * @param ampm
                     * The ampm
                     *//*

                    public void setAmpm(String ampm) {
                        this.ampm = ampm;
                    }

                    */
/**
                     *
                     * @return
                     * The tzShort
                     *//*

                    public String getTzShort() {
                        return tzShort;
                    }

                    */
/**
                     *
                     * @param tzShort
                     * The tz_short
                     *//*

                    public void setTzShort(String tzShort) {
                        this.tzShort = tzShort;
                    }

                    */
/**
                     *
                     * @return
                     * The tzLong
                     *//*

                    public String getTzLong() {
                        return tzLong;
                    }

                    */
/**
                     *
                     * @param tzLong
                     * The tz_long
                     *//*

                    public void setTzLong(String tzLong) {
                        this.tzLong = tzLong;
                    }

                }



                public class High {

                    @SerializedName("fahrenheit")
                    @Expose
                    private String fahrenheit;
                    @SerializedName("celsius")
                    @Expose
                    private String celsius;

                    */
/**
                     *
                     * @return
                     * The fahrenheit
                     *//*

                    public String getFahrenheit() {
                        return fahrenheit;
                    }

                    */
/**
                     *
                     * @param fahrenheit
                     * The fahrenheit
                     *//*

                    public void setFahrenheit(String fahrenheit) {
                        this.fahrenheit = fahrenheit;
                    }

                    */
/**
                     *
                     * @return
                     * The celsius
                     *//*

                    public String getCelsius() {
                        return celsius;
                    }

                    */
/**
                     *
                     * @param celsius
                     * The celsius
                     *//*

                    public void setCelsius(String celsius) {
                        this.celsius = celsius;
                    }

                }



                public class QpfAllday {

                    @SerializedName("in")
                    @Expose
                    private Double in;
                    @SerializedName("mm")
                    @Expose
                    private Integer mm;

                    */
/**
                     *
                     * @return
                     * The in
                     *//*

                    public Double getIn() {
                        return in;
                    }

                    */
/**
                     *
                     * @param in
                     * The in
                     *//*

                    public void setIn(Double in) {
                        this.in = in;
                    }

                    */
/**
                     *
                     * @return
                     * The mm
                     *//*

                    public Integer getMm() {
                        return mm;
                    }

                    */
/**
                     *
                     * @param mm
                     * The mm
                     *//*

                    public void setMm(Integer mm) {
                        this.mm = mm;
                    }

                }


                public class QpfDay {

                    @SerializedName("in")
                    @Expose
                    private Double in;
                    @SerializedName("mm")
                    @Expose
                    private Integer mm;

                    */
/**
                     *
                     * @return
                     * The in
                     *//*

                    public Double getIn() {
                        return in;
                    }

                    */
/**
                     *
                     * @param in
                     * The in
                     *//*

                    public void setIn(Double in) {
                        this.in = in;
                    }

                    */
/**
                     *
                     * @return
                     * The mm
                     *//*

                    public Integer getMm() {
                        return mm;
                    }

                    */
/**
                     *
                     * @param mm
                     * The mm
                     *//*

                    public void setMm(Integer mm) {
                        this.mm = mm;
                    }

                }

                public class Low {

                    @SerializedName("fahrenheit")
                    @Expose
                    private String fahrenheit;
                    @SerializedName("celsius")
                    @Expose
                    private String celsius;

                    */
/**
                     *
                     * @return
                     * The fahrenheit
                     *//*

                    public String getFahrenheit() {
                        return fahrenheit;
                    }

                    */
/**
                     *
                     * @param fahrenheit
                     * The fahrenheit
                     *//*

                    public void setFahrenheit(String fahrenheit) {
                        this.fahrenheit = fahrenheit;
                    }

                    */
/**
                     *
                     * @return
                     * The celsius
                     *//*

                    public String getCelsius() {
                        return celsius;
                    }

                    */
/**
                     *
                     * @param celsius
                     * The celsius
                     *//*

                    public void setCelsius(String celsius) {
                        this.celsius = celsius;
                    }

                }


                public class QpfNight {

                    @SerializedName("in")
                    @Expose
                    private Double in;
                    @SerializedName("mm")
                    @Expose
                    private Integer mm;

                    */
/**
                     *
                     * @return
                     * The in
                     *//*

                    public Double getIn() {
                        return in;
                    }

                    */
/**
                     *
                     * @param in
                     * The in
                     *//*

                    public void setIn(Double in) {
                        this.in = in;
                    }

                    */
/**
                     *
                     * @return
                     * The mm
                     *//*

                    public Integer getMm() {
                        return mm;
                    }

                    */
/**
                     *
                     * @param mm
                     * The mm
                     *//*

                    public void setMm(Integer mm) {
                        this.mm = mm;
                    }

                }


                public class SnowAllday {

                    @SerializedName("in")
                    @Expose
                    private Double in;
                    @SerializedName("cm")
                    @Expose
                    private Double cm;

                    */
/**
                     *
                     * @return
                     * The in
                     *//*

                    public Double getIn() {
                        return in;
                    }

                    */
/**
                     *
                     * @param in
                     * The in
                     *//*

                    public void setIn(Double in) {
                        this.in = in;
                    }

                    */
/**
                     *
                     * @return
                     * The cm
                     *//*

                    public Double getCm() {
                        return cm;
                    }

                    */
/**
                     *
                     * @param cm
                     * The cm
                     *//*

                    public void setCm(Double cm) {
                        this.cm = cm;
                    }

                }


                public class Maxwind {

                    @SerializedName("mph")
                    @Expose
                    private Integer mph;
                    @SerializedName("kph")
                    @Expose
                    private Integer kph;
                    @SerializedName("dir")
                    @Expose
                    private String dir;
                    @SerializedName("degrees")
                    @Expose
                    private Integer degrees;

                    */
/**
                     *
                     * @return
                     * The mph
                     *//*

                    public Integer getMph() {
                        return mph;
                    }

                    */
/**
                     *
                     * @param mph
                     * The mph
                     *//*

                    public void setMph(Integer mph) {
                        this.mph = mph;
                    }

                    */
/**
                     *
                     * @return
                     * The kph
                     *//*

                    public Integer getKph() {
                        return kph;
                    }

                    */
/**
                     *
                     * @param kph
                     * The kph
                     *//*

                    public void setKph(Integer kph) {
                        this.kph = kph;
                    }

                    */
/**
                     *
                     * @return
                     * The dir
                     *//*

                    public String getDir() {
                        return dir;
                    }

                    */
/**
                     *
                     * @param dir
                     * The dir
                     *//*

                    public void setDir(String dir) {
                        this.dir = dir;
                    }

                    */
/**
                     *
                     * @return
                     * The degrees
                     *//*

                    public Integer getDegrees() {
                        return degrees;
                    }

                    */
/**
                     *
                     * @param degrees
                     * The degrees
                     *//*

                    public void setDegrees(Integer degrees) {
                        this.degrees = degrees;
                    }

                }



                public class SnowDay {

                    @SerializedName("in")
                    @Expose
                    private Double in;
                    @SerializedName("cm")
                    @Expose
                    private Double cm;

                    */
/**
                     *
                     * @return
                     * The in
                     *//*

                    public Double getIn() {
                        return in;
                    }

                    */
/**
                     *
                     * @param in
                     * The in
                     *//*

                    public void setIn(Double in) {
                        this.in = in;
                    }

                    */
/**
                     *
                     * @return
                     * The cm
                     *//*

                    public Double getCm() {
                        return cm;
                    }

                    */
/**
                     *
                     * @param cm
                     * The cm
                     *//*

                    public void setCm(Double cm) {
                        this.cm = cm;
                    }

                }



                public class SnowNight {

                    @SerializedName("in")
                    @Expose
                    private Double in;
                    @SerializedName("cm")
                    @Expose
                    private Double cm;

                    */
/**
                     *
                     * @return
                     * The in
                     *//*

                    public Double getIn() {
                        return in;
                    }

                    */
/**
                     *
                     * @param in
                     * The in
                     *//*

                    public void setIn(Double in) {
                        this.in = in;
                    }

                    */
/**
                     *
                     * @return
                     * The cm
                     *//*

                    public Double getCm() {
                        return cm;
                    }

                    */
/**
                     *
                     * @param cm
                     * The cm
                     *//*

                    public void setCm(Double cm) {
                        this.cm = cm;
                    }

                }


                public class Avewind {

                    @SerializedName("mph")
                    @Expose
                    private Integer mph;
                    @SerializedName("kph")
                    @Expose
                    private Integer kph;
                    @SerializedName("dir")
                    @Expose
                    private String dir;
                    @SerializedName("degrees")
                    @Expose
                    private Integer degrees;

                    */
/**
                     *
                     * @return
                     * The mph
                     *//*

                    public Integer getMph() {
                        return mph;
                    }

                    */
/**
                     *
                     * @param mph
                     * The mph
                     *//*

                    public void setMph(Integer mph) {
                        this.mph = mph;
                    }

                    */
/**
                     *
                     * @return
                     * The kph
                     *//*

                    public Integer getKph() {
                        return kph;
                    }

                    */
/**
                     *
                     * @param kph
                     * The kph
                     *//*

                    public void setKph(Integer kph) {
                        this.kph = kph;
                    }

                    */
/**
                     *
                     * @return
                     * The dir
                     *//*

                    public String getDir() {
                        return dir;
                    }

                    */
/**
                     *
                     * @param dir
                     * The dir
                     *//*

                    public void setDir(String dir) {
                        this.dir = dir;
                    }

                    */
/**
                     *
                     * @return
                     * The degrees
                     *//*

                    public Integer getDegrees() {
                        return degrees;
                    }

                    */
/**
                     *
                     * @param degrees
                     * The degrees
                     *//*

                    public void setDegrees(Integer degrees) {
                        this.degrees = degrees;
                    }

                }

            }  // End OF ForcastDay_

        }  // End  Of Simpleforcast



    }// End OF Forcast

}
*/
