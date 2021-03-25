package com.example.imageview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ColorSpinnerAdapter extends BaseAdapter {

   Context context;
   List<String> colorStrs;
   List<Integer> colorInts;
   LayoutInflater layoutInflater;

   public ColorSpinnerAdapter(Context applicationContext, List<String> colorStrs, List<Integer> colorInts) {
      this.context = applicationContext;
      this.colorStrs = colorStrs;
      this.colorInts = colorInts;
      layoutInflater = (LayoutInflater.from(applicationContext));
   }

   @Override
   public int getCount() {
      return colorStrs.size();
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
      view = layoutInflater.inflate(R.layout.color_item, null);

      ImageView icon = (ImageView) view.findViewById(R.id.image_view);
      TextView title = (TextView) view.findViewById(R.id.tv_name);

      icon.setBackgroundColor(colorInts.get(i));
      title.setText(colorStrs.get(i));

      return view;
   }
}