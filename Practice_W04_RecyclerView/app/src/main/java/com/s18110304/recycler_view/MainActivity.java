package com.s18110304.recycler_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

   private RecyclerView recyclerView;
   private CountryAdapter adapter;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      adapter = new CountryAdapter(CountryRepository.getOriginalCountryList());
      recyclerView = (RecyclerView) findViewById(R.id.rvContacts);
      recyclerView.setLayoutManager(new LinearLayoutManager(this));
      recyclerView.setAdapter(adapter);
   }

   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      getMenuInflater().inflate(R.menu.sort_menu, menu);
      return super.onCreateOptionsMenu(menu);
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
      switch (item.getItemId()) {
         case R.id.sort_by_name:
            adapter.swapItems(CountryRepository.getCountryListSortedByName());
            return true;
         case R.id.sort_by_phone_code:
            adapter.swapItems(CountryRepository.getCountryListSortedByCode());
            return true;
         case R.id.sort_by_iso:
            adapter.swapItems(CountryRepository.getCountryListSortedByIso());
            return true;
      }

      return super.onOptionsItemSelected(item);
   }
}