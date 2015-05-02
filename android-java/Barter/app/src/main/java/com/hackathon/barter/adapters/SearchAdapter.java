package com.hackathon.barter.adapters;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hackathon.barter.R;
import com.hackathon.barter.SearchActivity;
import com.hackathon.barter.image.ImageLoader;
import com.hackathon.barter.listeners.OnSearchItemClickedListener;
import com.hackathon.barter.structs.MyItems;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Charlton on 5/2/2015.
 */
public class SearchAdapter extends BaseAdapter {

    private Activity activity;
    private List<MyItems> myItemsList;
    private OnSearchItemClickedListener onSearchItemClickedListener;

    public SearchAdapter(Activity activity, List<MyItems> myItemsList, OnSearchItemClickedListener onSearchItemClickedListener){
        this.activity = activity;
        this.myItemsList = myItemsList;
        this.onSearchItemClickedListener = onSearchItemClickedListener;
    }

    public void clear(){
        myItemsList.clear();
    }
    public void add_item(MyItems myItems){
        myItemsList.add(myItems);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return myItemsList.size();
    }

    @Override
    public Object getItem(int position) {
        return myItemsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = null;

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.item_temp, parent, false);
        }else{
            row = convertView;
        }
        CircleImageView circleImageView = (CircleImageView) row.findViewById(R.id.item_img);
        TextView title = (TextView) row.findViewById(R.id.item_title), owner = (TextView) row.findViewById(R.id.item_owner), desc = (TextView) row.findViewById(R.id.item_desc);
        title.setText(myItemsList.get(position).getName());
        owner.setText(myItemsList.get(position).getOwner());
        desc.setText(myItemsList.get(position).getDesc());
        ImageLoader imageLoader = new ImageLoader(activity);
        imageLoader.DisplayImage(myItemsList.get(position).getImg(),circleImageView);
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSearchItemClickedListener.OnSearchItemClicked(myItemsList.get(position),position);
            }
        });
        return row;
    }
}
