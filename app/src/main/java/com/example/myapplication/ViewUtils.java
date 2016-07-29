package com.example.myapplication;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

public class ViewUtils {

    /**
     * 修复使用9图作背景重置Padding问题
     *
     * @param view
     * @param resId
     */
	public static void setBackgroundAndKeepPadding(View view, int resId) {
		if (view == null)
			return;
		int left = view.getPaddingLeft();
		int top = view.getPaddingTop();
		int right = view.getPaddingRight();
		int bottom = view.getPaddingBottom();

		view.setBackgroundResource(resId);
		view.setPadding(left, top, right, bottom);
	}

	public static Bitmap getBitmap(View view, int width, int height) {
		Bitmap result = null;
		try {
			result = Bitmap
					.createBitmap(width, height, Bitmap.Config.ARGB_8888);
			Canvas canvas = new Canvas(result);
			view.draw(canvas);

		} catch (Exception e) {
		}

		return result;
	}

    /**
     * 获取view的截图bitmap
     *
     * @param view
     * @return
     */
	public static Bitmap getBitmap(View view) {
		Bitmap result = null;
		try {
			int width = view.getWidth();
			int height = view.getHeight();

			result = Bitmap
					.createBitmap(width, height, Bitmap.Config.ARGB_8888);
			Canvas canvas = new Canvas(result);
			view.draw(canvas);

		} catch (Exception e) {
		}

		return result;
	}
	
	public static Bitmap getBitmap2(View view) {
		Bitmap result = null;
		try {
			view.setDrawingCacheEnabled(true);
			result = Bitmap.createBitmap(view.getDrawingCache());
			view.setDrawingCacheEnabled(false);
		} catch (Exception e) {
		}

		return result;
	}


	public static boolean isInView(View view,MotionEvent ev){
		if(view == null || ev == null)
			return false;
		
		int[] location = new int[2];
		view.getLocationOnScreen(location);
		int x = location[0];
		int y = location[1];
		int width  = view.getWidth();
		int height = view.getHeight(); 
		float evX = ev.getRawX();
		float evY = ev.getRawY();
		if (evX < x 
			|| evX > (x + width) 
			|| evY < y
			|| evY > (y + height)) {
				return false;
		}
		return true;
	}

    @SuppressLint("NewApi")
    public static void activateWebview(WebView webview, boolean active) {
        if (webview != null && android.os.Build.VERSION.SDK_INT > 10) {
            if (active) {
                webview.onResume();
            } else {
                webview.onPause();
            }
        }
    }

	public static void setText(TextView v,String text){
		if(TextUtils.isEmpty(text)){
			setViewVisibility(v, View.GONE);
		}else{
			setViewVisibility(v, View.VISIBLE);
			v.setText(text);
		}
	}
	
	public static void setViewVisibility(View view,int visibility){
		if(null != view && view.getVisibility() != visibility){
			view.setVisibility(visibility);
		}
	}
	
}