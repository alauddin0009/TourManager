package theateam.com.tourmanager.Weather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import theateam.com.tourmanager.R;

/**
 * Created by Hasibuzzaman on 8/23/2016.
 */
public class MyWeatherAdapter extends BaseAdapter {
    Context context;
    LayoutInflater layoutInflater;
    List<WeatherResponse.Forecast.Simpleforecast.Forecastday_> forecastday;

    public MyWeatherAdapter(Context context, LayoutInflater layoutInflater, List<WeatherResponse.Forecast.Simpleforecast.Forecastday_> forecastday) {
        this.context = context;
        this.layoutInflater = layoutInflater;
        this.forecastday = forecastday;
    }
    public class ViewHolder
    {
        TextView weather_dateTV,weatherDayTV,forecast_weather_desTV,HighTV,lowTv;
    }

    @Override
    public int getCount() {
        return forecastday.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view==null)
        {
            viewHolder=new ViewHolder();
            view=layoutInflater.inflate(R.layout.forecast_list_item,null,false);
            viewHolder.weather_dateTV= (TextView) view.findViewById(R.id.weather_dateTV);
            viewHolder.weatherDayTV= (TextView) view.findViewById(R.id.weatherDayTV);
            viewHolder.forecast_weather_desTV= (TextView) view.findViewById(R.id.forecast_weather_desTV);
            viewHolder.HighTV= (TextView) view.findViewById(R.id.HighTV);
            viewHolder.lowTv= (TextView) view.findViewById(R.id.lowTv);

            view.setTag(viewHolder);

        }
        else
        {
            viewHolder = (ViewHolder) view.getTag();
        }
        WeatherResponse.Forecast.Simpleforecast.Forecastday_.Date date = forecastday.get(i).getDate();
        viewHolder.weather_dateTV.setText(date.getDay()+"/"+date.getMonth()+"/"+date.getYear());
        viewHolder.weatherDayTV.setText(date.getMonthname()+"");
        viewHolder.forecast_weather_desTV.setText(forecastday.get(i).getConditions()+"");
        viewHolder.HighTV.setText(forecastday.get(i).getHigh().getCelsius()+"℃ / ");
        viewHolder.lowTv.setText(forecastday.get(i).getLow().getCelsius()+"℃");

        return view;
    }
}
