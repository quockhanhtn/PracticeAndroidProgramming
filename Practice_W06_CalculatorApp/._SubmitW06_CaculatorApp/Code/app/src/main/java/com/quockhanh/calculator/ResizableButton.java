package com.quockhanh.calculator;

import android.content.Context;
import android.util.AttributeSet;

public class ResizableButton extends com.google.android.material.button.MaterialButton {

   public ResizableButton(Context context, AttributeSet attrs) {
      super(context, attrs);
   }

   @Override
   protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
      int w = this.getWidth();
      int h = this.getHeight();

      if (w > h) {
         this.setWidth(h);
      } else {
         this.setHeight(w);
      }
   }
}
