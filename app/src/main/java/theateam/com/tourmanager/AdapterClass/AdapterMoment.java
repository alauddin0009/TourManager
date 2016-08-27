package theateam.com.tourmanager.AdapterClass;


import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import theateam.com.tourmanager.CircleTransform;
import theateam.com.tourmanager.ModelClass.MomentModel;
import theateam.com.tourmanager.R;

public class AdapterMoment extends ArrayAdapter<MomentModel> {
	    private Context context;
	    private ArrayList<MomentModel>moments;
	    public AdapterMoment(Context context, ArrayList<MomentModel> moments) {
	        super(context, R.layout.activity_listview_row_moment,moments);
	        this.context=context;
	        this.moments=moments;
	    }
	    private class ViewHolder
	    {
	        TextView momentTitle;
	        ImageView momentImage;
			TextView momentTimeInList;
	    }

	    @Override
	    public View getView(final int position, View convertView, ViewGroup parent) {
	        ViewHolder viewHolder;
	        if (convertView==null)
	        {
	            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	            convertView=inflater.inflate(R.layout.activity_listview_row_moment,null,true);
	            viewHolder=new ViewHolder();
	            viewHolder.momentTitle= (TextView) convertView.findViewById(R.id.momentTitleInList);
	            viewHolder.momentImage= (ImageView) convertView.findViewById(R.id.momentImageInList);
				viewHolder.momentTimeInList= (TextView) convertView.findViewById(R.id.momentTimeInList);
	            convertView.setTag(viewHolder);
	        }
	        else
	        {
	            viewHolder= (ViewHolder) convertView.getTag();
	        }

	        viewHolder.momentTitle.setText(moments.get(position).getM_name());
			viewHolder.momentTimeInList.setText(moments.get(position).getM_time());
			//  viewHolder.momentImage.setImageURI(Uri.parse(moments.get(position).getM_image()));
			Picasso.with(context).load(Uri.parse(moments.get(position).getM_image()))
					.transform(new CircleTransform())
					.fit()
					.into(viewHolder.momentImage);


//	        Bitmap bm = BitmapFactory.decodeResource(getContext().getResources(), R.mipmap.ic_launcher);
//	        viewHolder.momentImage.setImageBitmap(bm);
	        return convertView;

	    }
	}
