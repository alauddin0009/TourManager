package theateam.com.tourmanager.AdapterClass;


import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import theateam.com.tourmanager.ModelClass.ExpenseModel;
import theateam.com.tourmanager.R;


public class AdapterExpense extends ArrayAdapter<ExpenseModel> {
	    private Context context;
	    private ArrayList<ExpenseModel>expenses;
	    public AdapterExpense(Context context, ArrayList<ExpenseModel> expense) {
	        super(context, R.layout.activity_listview_row_expense,expense);
	        this.context=context;
	        this.expenses=expense;
	    }
	    private class ViewHolder
	    {
	        TextView expenseTitle;
	        TextView expenseAmount;
	    }

	    @Override
	    public View getView(final int position, View convertView, ViewGroup parent) {
	        ViewHolder viewHolder;
	        if (convertView==null)
	        {
	            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	            convertView=inflater.inflate(R.layout.activity_listview_row_expense,null,true);
	            viewHolder=new ViewHolder();
	            viewHolder.expenseTitle= (TextView) convertView.findViewById(R.id.expenseTitleInLis);
	            viewHolder.expenseAmount= (TextView) convertView.findViewById(R.id.expenseAmountInList);
	            convertView.setTag(viewHolder);
	        }
	        else
	        {
	            viewHolder= (ViewHolder) convertView.getTag();
	        }

	        viewHolder.expenseTitle.setText(expenses.get(position).getEx_title());
	        viewHolder.expenseAmount.setText(String.valueOf(expenses.get(position).getEx_amount()));
	        return convertView;

	    }
	}
