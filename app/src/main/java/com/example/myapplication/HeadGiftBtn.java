package com.example.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class HeadGiftBtn extends RelativeLayout {

    private GifImageView mBtn;
    private ImageView mReddot;
    private TextView mCountRed;
    private int mImageResId = 0;

    private Context mContext;

    public HeadGiftBtn(Context context) {
        this(context, null);
        mContext = context;
    }

    public HeadGiftBtn(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;

        LayoutInflater.from(context).inflate(R.layout.head_gif_red_layout, this);
        //getCircleHelper().resetColor(0x00567dc4,0x007797d0);
        initView();

        if(null != attrs){
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.HeadRedBtn);
            int resBtn = a.getResourceId(R.styleable.HeadRedBtn_btn, R.drawable.home_message_icon);
            int resRed = a.getResourceId(R.styleable.HeadRedBtn_red,R.drawable.in_push_btn_reddot);
            //mBtn.setImageResource(resBtn);
            //mReddot.setImageResource(resRed);
            mBtn.setBackgroundDrawable(mContext.getResources().getDrawable(resBtn));
            mReddot.setBackgroundDrawable(mContext.getResources().getDrawable(resRed));
        }
        setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideReddot();
                if(null != mOnBtnClickListener){
                    mOnBtnClickListener.onClick(HeadGiftBtn.this);
                }
            }
        });
    }
    /**
     * 换图标
     * */
    public void setGiftBtnImage(int resId){
        mImageResId = resId;
        if(mImageResId !=0) {
//            mBtn.setImageResource(resId);
            mBtn.setBackgroundDrawable(mContext.getResources().getDrawable(resId));
        }else{
//            mBtn.setImageResource(R.drawable.in_push_btn_normal);
            mBtn.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.in_push_btn_normal));
        }
    }

    public void setGiftBtnImage(Bitmap bmp){
        if(bmp == null){
//            mBtn.setImageResource(mImageResId);
            mBtn.setBackgroundDrawable(mContext.getResources().getDrawable(mImageResId));
        }else {
//            mBtn.setImageBitmap(bmp);
            mBtn.setBackgroundDrawable(new BitmapDrawable(bmp));
        }
    }

    public void clearGiftBackground(){
        mBtn.setBackgroundDrawable(null);
    }

    public GifImageView getGiftImage(){
        return mBtn;
    }

    public interface OnBtnClickListener{
        public void onClick(View v);
    }

    public OnBtnClickListener mOnBtnClickListener;

    public void setOnBtnClickListener(OnBtnClickListener l){
        mOnBtnClickListener = l;
    }

    private void initView() {
        mBtn = (GifImageView)findViewById(R.id.btn);
        mReddot = (ImageView)findViewById(R.id.red);
        mCountRed = (TextView) findViewById(R.id.red_count);
    }

    public void hideReddot(){
        ViewUtils.setViewVisibility(mReddot, View.GONE);
        ViewUtils.setViewVisibility(mCountRed, View.GONE);
    }

    public void showReddot(boolean isCountRed){
        if(isCountRed){
            ViewUtils.setViewVisibility(mCountRed, View.VISIBLE);
            ViewUtils.setViewVisibility(mReddot, View.GONE);
        } else {
            ViewUtils.setViewVisibility(mReddot, View.VISIBLE);
            ViewUtils.setViewVisibility(mCountRed, View.GONE);
        }
    }

    public void show(){
        ViewUtils.setViewVisibility(this,View.VISIBLE);
    }

    public void hide(){
        ViewUtils.setViewVisibility(this,View.GONE);
    }

    /**
     * 红点是否展示
     * @return
     */
    public boolean isReddotShow(){
        if(mReddot != null && (mReddot.getVisibility() == VISIBLE || mCountRed.getVisibility() == VISIBLE)){
            return true;
        }
        return false;
    }

    public void clear(){
        if(mBtn != null){
            mBtn.clear();
        }
    }

}
