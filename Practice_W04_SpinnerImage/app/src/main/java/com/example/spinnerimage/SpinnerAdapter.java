package com.example.spinnerimage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class SpinnerAdapter extends BaseAdapter {

   Context context;
   List<String> countries;
   List<String> phoneCodes;
   List<Integer> flags;
   LayoutInflater layoutInflater;

   public SpinnerAdapter(Context applicationContext, List<Integer> flags, List<String> countries, List<String> phoneCodes) {
      this.context = applicationContext;
      this.flags = flags;
      this.countries = countries;
      this.phoneCodes = phoneCodes;

      layoutInflater = (LayoutInflater.from(applicationContext));
   }

   @Override
   public int getCount() {
      return flags.size();
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
      view = layoutInflater.inflate(R.layout.spinner_item, null);

      ImageView icon = (ImageView) view.findViewById(R.id.image_view);
      TextView title = (TextView) view.findViewById(R.id.text_view_title);
      TextView subtitle = (TextView) view.findViewById(R.id.text_view_subtitle);

      icon.setImageResource(flags.get(i));
      title.setText(countries.get(i));
      subtitle.setText(phoneCodes.get(i));

      return view;
   }
}