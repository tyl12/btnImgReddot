package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private HeadGiftBtn mGiftBoxBtn;
    private Button mButtonLeft;
    private Button mButtonRight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mButtonLeft = (Button) findViewById(R.id.buttonleft);
        mButtonRight = (Button) findViewById(R.id.buttonright);

        mGiftBoxBtn = (HeadGiftBtn) findViewById(R.id.gift);

        mButtonLeft.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (mGiftBoxBtn.getVisibility() != View.VISIBLE) {
                    mGiftBoxBtn.show();
                }
                mGiftBoxBtn.show();
                mGiftBoxBtn.showReddot(false);
            }
        });
        mButtonRight.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (mGiftBoxBtn.getVisibility() != View.VISIBLE) {
                    mGiftBoxBtn.show();
                }
                mGiftBoxBtn.show();
                mGiftBoxBtn.showReddot(true);
                //mGiftBoxBtn.hideReddot();
            }
        });

        //mGiftBoxBtn.setOnClickListener(mGiftBoxBtnClick);
    }

    View.OnClickListener mGiftBoxBtnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("##@@##", "onclick");
            //onGiftBoxPush(mGiftBoxBtn, false);
        }
    };
}
