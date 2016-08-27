package theateam.com.tourmanager.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by Hasibuzzaman on 8/22/2016.
 */
public interface WeatherServiceAPI {
   @GET
   Call<WeatherResponse> getWeather(@Url String url);
}
