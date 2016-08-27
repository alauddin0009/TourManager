/*package com.manishkpr.autotextviewexample;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JsonParse {
	 double current_latitude,current_longitude;
	CityResponseApi cityResponseApi;
	List<SuggestGetSet> ListData;

	 public JsonParse(CityResponseApi cityResponseApi){
		 this.cityResponseApi=cityResponseApi;
		 ListData = new ArrayList<SuggestGetSet>();

	 }
	 public JsonParse(double current_latitude,double current_longitude){
		 this.current_latitude=current_latitude;
		 this.current_longitude=current_longitude;
	 }
	 public List<SuggestGetSet> getParseJsonWCF(String sName)
		{

		 try {
             String url = "aq?query="+sName;
			 Call<CityResponse> cities = cityResponseApi.getCities(url);

			 cities.enqueue(new Callback<CityResponse>() {
				 @Override
				 public void onResponse(Call<CityResponse> call, Response<CityResponse> response) {
					  CityResponse cityResponse = response.body();
					 List<CityResponse.RESULT> results = cityResponse.getRESULTS();
					 Log.e("Getted size ",results.size()+"");

					 for(int i = 0; i < results.size(); i++){
						 ListData.add(new SuggestGetSet(results.get(i).getName(),results.get(i).getC()));
						// Log.e("City My ",ListData.get(i).getCity());
					 }


					   Log.e("ListData size 1",ListData.size()+"");

				 }

				 @Override
				 public void onFailure(Call<CityResponse> call, Throwable t) {

				 }
			 });



		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			Log.e("ListData size 2",ListData.size()+"");
		// return ListData;
		 
		}





	 
}*/




package theateam.com.tourmanager.Weather.Autocomplete;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class JsonParse {
	double current_latitude,current_longitude;
	public JsonParse(){}
	public JsonParse(double current_latitude,double current_longitude){
		this.current_latitude=current_latitude;
		this.current_longitude=current_longitude;
	}
	public List<SuggestGetSet> getParseJsonWCF(String sName)
	{
		List<SuggestGetSet> ListData = new ArrayList<SuggestGetSet>();
		String result;
		try {
			String temp=sName.replace(" ", "%20");
			URL js = new URL("http://autocomplete.wunderground.com/aq?query="+temp);
			Log.e("Kahani ", temp+"");
			URLConnection jc = js.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(jc.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line ;

			while ((line = reader.readLine()) != null)
			{
				sb.append(line + "\n");
			}
			result = sb.toString();

			JSONObject jsonResponse = new JSONObject(result);
			JSONArray jsonArray = jsonResponse.getJSONArray("RESULTS");
			Log.e("JSON",jsonArray.length()+"");

			for(int i = 0; i < jsonArray.length(); i++){
				JSONObject r = jsonArray.getJSONObject(i);
				ListData.add(new SuggestGetSet(r.getString("name"),r.getString("c")));
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return ListData;

	}

}

