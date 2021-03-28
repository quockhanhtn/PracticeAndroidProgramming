package com.s18110304.recycler_view;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {

   private List<Country> countries = new ArrayList<>();

   public CountryAdapter(List<Country> personList) {
      this.countries.addAll(personList);
   }

   @Override
   public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
      final View view = inflater.inflate(R.layout.country_item, parent, false);
      return new ViewHolder(view);
   }

   @Override
   public void onBindViewHolder(ViewHolder holder, int position) {
      final Country country = countries.get(position);
      holder.title.setText(country.getCountryName());
      holder.subtitle.setText(Html.fromHtml("+" + country.getCountryCode() + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ISO: <b>" + country.getIsoCode() + "</b>"));
      holder.imageView.setImageDrawable(holder.itemView.getContext().getResources().getDrawable(country.getImage()));

   }

   public void swapItems(List<Country> actors) {
      final CountryDiffCallback diffCallback = new CountryDiffCallback(this.countries, actors);
      final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);

      this.countries.clear();
      this.countries.addAll(actors);
      diffResult.dispatchUpdatesTo(this);
   }

   @Override
   public int getItemCount() {
      return countries.size();
   }

   public static class ViewHolder extends RecyclerView.ViewHolder {

      private TextView title;
      private TextView subtitle;
      ImageView imageView;

      public ViewHolder(View itemView) {
         super(itemView);
         title = (TextView) itemView.findViewById(R.id.text_view_title);
         subtitle = (TextView) itemView.findViewById(R.id.text_view_subtitle);
         imageView = (ImageView) itemView.findViewById(R.id.image_view);
      }
   }
}

