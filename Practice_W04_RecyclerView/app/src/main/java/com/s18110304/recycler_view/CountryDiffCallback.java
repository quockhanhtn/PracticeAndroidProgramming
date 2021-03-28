package com.s18110304.recycler_view;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import java.util.List;

public class CountryDiffCallback extends DiffUtil.Callback{

   private final List<Country> oldList;
   private final List<Country> newList;

   public CountryDiffCallback(List<Country> oldList, List<Country> newList) {
      this.oldList = oldList;
      this.newList = newList;
   }

   @Override
   public int getOldListSize() {
      return oldList.size();
   }

   @Override
   public int getNewListSize() {
      return newList.size();
   }

   @Override
   public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
      return oldList.get(oldItemPosition).getId() == newList.get(newItemPosition).getId();
   }

   @Override
   public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
      final Country oldItem = oldList.get(oldItemPosition);
      final Country newItem = newList.get(newItemPosition);

      return oldItem.getCountryName().equals(newItem.getCountryName());
   }

   @Nullable
   @Override
   public Object getChangePayload(int oldItemPosition, int newItemPosition) {
      // Implement method if you're going to use ItemAnimator
      return super.getChangePayload(oldItemPosition, newItemPosition);
   }
}

