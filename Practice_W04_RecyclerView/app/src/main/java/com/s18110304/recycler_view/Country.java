package com.s18110304.recycler_view;

import android.graphics.drawable.Drawable;

public class Country {
   static Integer lastId = 0;

   Integer id;
   String countryName;
   String countryCode;
   String isoCode;
   Integer image;

   public Country(String countryName, String countryCode, String isoCode, Integer image) {
      this.id = ++lastId;
      this.countryName = countryName;
      this.countryCode = countryCode;
      this.isoCode = isoCode;
      this.image = image;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getCountryName() {
      return countryName;
   }

   public void setCountryName(String countryName) {
      this.countryName = countryName;
   }

   public String getCountryCode() {
      return countryCode;
   }

   public void setCountryCode(String countryCode) {
      this.countryCode = countryCode;
   }

   public String getIsoCode() {
      return isoCode;
   }

   public void setIsoCode(String isoCode) {
      this.isoCode = isoCode;
   }

   public Integer getImage() {
      return image;
   }

   public void setImage(Integer image) {
      this.image = image;
   }
}
