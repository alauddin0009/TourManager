package theateam.com.tourmanager.AdapterClass;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import theateam.com.tourmanager.Database.ExpenseDBSource;
import theateam.com.tourmanager.ModelClass.EventModel;
import theateam.com.tourmanager.R;

public class AdapterEvent extends BaseAdapter {
	private Context context;
	private ArrayList<EventModel>events;
	ExpenseDBSource expenseDBSource;

	SharedPreferences sharedPreferences;
	SharedPreferences.Editor editor;
	int proId;
	public AdapterEvent(Context context, ArrayList<EventModel> events) {
		this.context=context;
		this.events=events;


		sharedPreferences=context.getSharedPreferences("TourManager",Context.MODE_PRIVATE);
		editor=sharedPreferences.edit();
		String profile_id_String=sharedPreferences.getString("Pofile_Id","0");
		proId=Integer.parseInt(profile_id_String);

		Log.e("Total event Adapter",events.size()+"");

	}
	private class ViewHolder
	{
		TextView eventTitle;
		TextView eventStart;
		TextView eventEnd;
		TextView eventBudget;
		TextView placeTv,budgetheading;
	}

	@Override
	public int getCount() {
		return events.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		if (convertView==null)
		{
			LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView=inflater.inflate(R.layout.activity_listview_row_event,null,true);
			viewHolder=new ViewHolder();
			viewHolder.eventTitle= (TextView) convertView.findViewById(R.id.eventHedingTVinList);
			viewHolder.eventStart= (TextView) convertView.findViewById(R.id.eventStartTVinList);
			viewHolder.eventEnd= (TextView) convertView.findViewById(R.id.eventEndTVinList);
			viewHolder.eventBudget= (TextView) convertView.findViewById(R.id.eventBudgetTVinList);
			viewHolder.placeTv= (TextView) convertView.findViewById(R.id.placeTv);
			viewHolder.budgetheading= (TextView) convertView.findViewById(R.id.budgetheading);
			convertView.setTag(viewHolder);
		}
		else
		{
			viewHolder= (ViewHolder) convertView.getTag();
		}

		viewHolder.eventTitle.setText(events.get(position).getE_name());
		viewHolder.eventStart.setText(events.get(position).getE_start());
		viewHolder.eventEnd.setText(events.get(position).getE_end());
		viewHolder.placeTv.setText(events.get(position).getE_place());
		viewHolder.eventBudget.setText(String.valueOf(events.get(position).getE_budget()));


		int profileId= proId;
		//int profileId= ProfileHomeActivity.profile_id_shared;
		int event_id=events.get(position).getE_id();
		expenseDBSource=new ExpenseDBSource(context);
		double totalExpense= expenseDBSource.getTotalExpense(profileId,event_id);
		double budgetInDB=events.get(position).getE_budget();
		Log.e("Profile and event : ","Profile "+String.valueOf(profileId)+" Event "+String.valueOf(event_id));
		Log.e("Profile and event : ","Expense "+String.valueOf(totalExpense)+" Budget "+String.valueOf(budgetInDB));
		if(totalExpense>=budgetInDB){
			viewHolder.eventBudget.setTextColor(Color.RED);
			viewHolder.budgetheading.setTextColor(Color.RED);
		}else if(totalExpense>=((budgetInDB)/4)){
			viewHolder.eventBudget.setTextColor(Color.BLUE);
			viewHolder.budgetheading.setTextColor(Color.BLUE);
		}else if(totalExpense>=(budgetInDB/2)){
			viewHolder.eventBudget.setTextColor(Color.YELLOW);
			viewHolder.budgetheading.setTextColor(Color.YELLOW);
		}

		return convertView;

	}
}


/*
package theateam.com.tourmanager.AdapterClass;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import theateam.com.tourmanager.Database.ExpenseDBSource;
import theateam.com.tourmanager.ModelClass.EventModel;
import theateam.com.tourmanager.R;

public class AdapterEvent extends ArrayAdapter<EventModel> {
	    private Context context;
	    private ArrayList<EventModel>events;
	ExpenseDBSource expenseDBSource;

	SharedPreferences sharedPreferences;
	SharedPreferences.Editor editor;
	int proId;
	    public AdapterEvent(Context context, ArrayList<EventModel> events) {
	        super(context, R.layout.activity_listview_row_event,events);
	        this.context=context;
	        this.events=events;


			sharedPreferences=context.getSharedPreferences("TourManager",Context.MODE_PRIVATE);
			editor=sharedPreferences.edit();
			String profile_id_String=sharedPreferences.getString("Pofile_Id","0");
			proId=Integer.parseInt(profile_id_String);

		}
	    private class ViewHolder
	    {
	        TextView eventTitle;
	        TextView eventStart;
	        TextView eventEnd;
	        TextView eventBudget;
	        TextView placeTv,budgetheading;
	    }

	    @Override
	    public View getView(final int position, View convertView, ViewGroup parent) {
	        ViewHolder viewHolder;
	        if (convertView==null)
	        {
	            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	            convertView=inflater.inflate(R.layout.activity_listview_row_event,null,true);
	            viewHolder=new ViewHolder();
	            viewHolder.eventTitle= (TextView) convertView.findViewById(R.id.eventHedingTVinList);
	            viewHolder.eventStart= (TextView) convertView.findViewById(R.id.eventStartTVinList);
	            viewHolder.eventEnd= (TextView) convertView.findViewById(R.id.eventEndTVinList);
	            viewHolder.eventBudget= (TextView) convertView.findViewById(R.id.eventBudgetTVinList);
	            viewHolder.placeTv= (TextView) convertView.findViewById(R.id.placeTv);
	            viewHolder.budgetheading= (TextView) convertView.findViewById(R.id.budgetheading);
	            convertView.setTag(viewHolder);
	        }
	        else
	        {
	            viewHolder= (ViewHolder) convertView.getTag();
	        }

	        viewHolder.eventTitle.setText(events.get(position).getE_name());
	        viewHolder.eventStart.setText(events.get(position).getE_start());
	        viewHolder.eventEnd.setText(events.get(position).getE_end());
	        viewHolder.placeTv.setText(events.get(position).getE_place());
	        viewHolder.eventBudget.setText(String.valueOf(events.get(position).getE_budget()));


			int profileId= proId;
			//int profileId= ProfileHomeActivity.profile_id_shared;
			int event_id=events.get(position).getE_id();
			expenseDBSource=new ExpenseDBSource(context);
			double totalExpense= expenseDBSource.getTotalExpense(profileId,event_id);
			double budgetInDB=events.get(position).getE_budget();
			Log.e("Profile and event : ","Profile "+String.valueOf(profileId)+" Event "+String.valueOf(event_id));
			Log.e("Profile and event : ","Expense "+String.valueOf(totalExpense)+" Budget "+String.valueOf(budgetInDB));
			if(totalExpense>=budgetInDB){
				viewHolder.eventBudget.setTextColor(Color.RED);
				viewHolder.budgetheading.setTextColor(Color.RED);
			}else if(totalExpense>=((budgetInDB)/2)){
				viewHolder.eventBudget.setTextColor(Color.YELLOW);
				viewHolder.budgetheading.setTextColor(Color.YELLOW);
			}else if(totalExpense>=(budgetInDB/4)){
				viewHolder.eventBudget.setTextColor(Color.BLUE);
				viewHolder.budgetheading.setTextColor(Color.BLUE);
			}

			return convertView;

	    }
	}*/
