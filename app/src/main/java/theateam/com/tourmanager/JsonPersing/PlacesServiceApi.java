package theateam.com.tourmanager.JsonPersing;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by Hasibuzzaman on 8/19/2016.
 */
public interface PlacesServiceApi {
    @GET
    Call<PlacesResponse> getPlaces(@Url String url);
}
