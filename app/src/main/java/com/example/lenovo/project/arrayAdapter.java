package com.example.lenovo.project;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class arrayAdapter extends BaseAdapter {
        private Context mContext;
        private LayoutInflater inflater;
        private ArrayList<Shirts> modellist;
        private ArrayList<Shirts> ShirtList;

        public  arrayAdapter(Context context, ArrayList<Shirts> list) {
            mContext = context;
            this.ShirtList = list;
            inflater = LayoutInflater.from(mContext);
            this.modellist = new ArrayList<Shirts>();
            this.modellist.addAll(list);
        }
        static class ViewHolder{
            TextView Name;
            TextView Price;
            ImageView Image;
        }
        @Override
        public int getCount() {
            return ShirtList.size();
        }

        @Override
        public Object getItem(int i) {
            return ShirtList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }
        @SuppressLint("SetTextI18n")
        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
           Shirts currentShirt= ShirtList.get(position);

            if(convertView == null) {
                convertView = inflater.inflate(R.layout.list, null, false);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.Name =
                        (TextView) convertView.findViewById(R.id.NAME);
                viewHolder.Price =
                        (TextView) convertView.findViewById(R.id.Price);
                viewHolder.Image =
                        (ImageView) convertView.findViewById(R.id.Image);

                convertView.setTag(viewHolder);
            }

            TextView Name =
                    ((ViewHolder) convertView.getTag()).Name;
            TextView Price=
                    ((ViewHolder) convertView.getTag()).Price;
            ImageView ContactImage =
                    ((ViewHolder) convertView.getTag()).Image;

            Name.setText(currentShirt.name);
            Price.setText(Integer.toString(currentShirt.price));

            ContactImage.setImageResource(R.drawable.shirt_pic);

            return convertView;
        }
};



/*
public View getView(int position, View convertView, ViewGroup parent)
        {
        Shirts currentShirt= ShirtList.get(position);

        if(convertView == null) {
        convertView = inflater.inflate(R.layout.list, null, false);

        ViewHolder viewHolder = new ViewHolder();
        viewHolder.Name =
        (TextView) convertView.findViewById(R.id.NAME);
        viewHolder.Price =
        (TextView) convertView.findViewById(R.id.Price);
        viewHolder.Quantity =
        (TextView) convertView.findViewById(R.id.Quantity);
        viewHolder.Image =
        (ImageView) convertView.findViewById(R.id.Image);

        convertView.setTag(viewHolder);

        }

        TextView Name =
        ((ViewHolder) convertView.getTag()).Name;
        TextView Price=
        ((ViewHolder) convertView.getTag()).Price;
        TextView Quantity =
        ((ViewHolder) convertView.getTag()).Quantity;
        ImageView ContactImage =
        ((ViewHolder) convertView.getTag()).Image;

        Name.setText(currentShirt.name);
        Price.setText(currentShirt.price);
        Quantity.setText(currentShirt.quantity);

        ContactImage.setImageResource(R.drawable.shirt_pic);

        return convertView;
        }

      */
/*  public void filter(String charText) {
            charText = charText.toLowerCase(Locale.getDefault());
            ShirtList.clear();
            if (charText.length() == 0) {
                ShirtList.addAll(modellist);
            } else {
                for (Shirts latest : modellist) {
                    if (latest.getName().toLowerCase(Locale.getDefault()).contains(charText)) {
                        contactList.add(latest);
                    }
                }
            }
            notifyDataSetChanged();
        }*/

