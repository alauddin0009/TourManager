package theateam.com.tourmanager.Weather.Autocomplete;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SuggestionAdapter extends ArrayAdapter<String> {

	protected static final String TAG = "SuggestionAdapter";
	private List<String> suggestions;
	Context context;
	boolean flag= false;

	public SuggestionAdapter(Context context,String nameFilter) {
		super(context, android.R.layout.simple_dropdown_item_1line);
		suggestions = new ArrayList<String>();
		this.context=context;

	}

	@Override
	public int getCount() {
		return suggestions.size();
	}

	@Override
	public String getItem(int index) {
		return suggestions.get(index);
	}

	@Override
	public Filter getFilter() {
		Filter myFilter = new Filter() {
			@Override
			protected FilterResults performFiltering(CharSequence constraint) {
				FilterResults filterResults = new FilterResults();
				JsonParse jp=new JsonParse();
				if (constraint != null) {
					// A class that queries a web API, parses the data and
					// returns an ArrayList<GoEuroGetSet>
					List<SuggestGetSet> new_suggestions =jp.getParseJsonWCF(constraint.toString());
                    Log.e("suggesstion ,", new_suggestions.size()+"");

					if(!flag)
					{
						if(new_suggestions.size()==0)
						{
							Toast.makeText(context,"No city found",Toast.LENGTH_SHORT).show();
							Log.e("Kire ba kita hoise "," kire ba kita hoise ? ");
						}
						flag = true ;

					}

					suggestions.clear();
					for (int i=0;i<new_suggestions.size();i++) {
						suggestions.add(new_suggestions.get(i).getCity());
					//	Log.e("Suggessitions Cityes :" , new_suggestions.get(i).getCity());
					}
					
					// Now assign the values and count to the FilterResults
					// object
					filterResults.values = suggestions;
					filterResults.count = suggestions.size();
				}
				return filterResults;
			}

			@Override
			protected void publishResults(CharSequence contraint,
					FilterResults results) {
				if (results != null && results.count > 0) {
					notifyDataSetChanged();
				} else {
					notifyDataSetInvalidated();
				}
			}
		};
		return myFilter;
	}

	

}
