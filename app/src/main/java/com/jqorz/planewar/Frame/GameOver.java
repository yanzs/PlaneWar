package com.jqorz.planewar.Frame;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.jqorz.planewar.R;
import com.jqorz.planewar.Utils.ConstantUtil;

public class GameOver extends Activity implements View.OnClickListener {

    SharedPreferences sp;
    private TextView tv_MaxScore, tv_thisScore;
    private ImageButton imgBtn_restartGame, imgBtn_backHome, imgBtn_exitGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over);
        initView();
        initEvent();
        sp = getSharedPreferences("Data", MODE_PRIVATE);
        setTypeface();
        getBundle();
        ConstantUtil.CHEAT_CURRENT_STATE = 0;//还原作弊状态
    }

    private void getBundle() {
        Intent intent = getIntent();
        int thisScore = intent.getIntExtra("Score", 0);
        boolean isCheated = ConstantUtil.CHEAT_CURRENT_STATE != 0;

        int maxScore = sp.getInt("MaxScore", 0);

        if (thisScore > maxScore) {
            maxScore = thisScore;
            SharedPreferences.Editor edit = sp.edit();
            edit.putInt("MaxScore", maxScore);
            edit.putBoolean("MaxScoreCheated", isCheated);//如果作弊得到最高分，保存作弊记录至本地
            edit.apply();
        }

        boolean maxScoreCheated = sp.getBoolean("MaxScoreCheated", false);

        String showText1 = "" + thisScore;
        String showText2 = "" + maxScore;
        if (isCheated) {//如果此次作弊，用"."标识出来
            showText1 = showText1 + ".";
        }
        if (maxScoreCheated) {//如果最高分作弊，用"."标识出来
            showText2 = showText2 + ".";
        }
        tv_thisScore.setText(showText1);
        tv_MaxScore.setText(showText2);
    }

    private void initEvent() {
        imgBtn_restartGame.setOnClickListener(this);
        imgBtn_backHome.setOnClickListener(this);
        imgBtn_exitGame.setOnClickListener(this);
    }

    private void setTypeface() {
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/font.ttf");//根据路径得到Typeface
        tv_MaxScore.setTypeface(tf);//设置字体
        tv_thisScore.setTypeface(tf);//设置字体

    }

    private void initView() {
        tv_MaxScore = (TextView) findViewById(R.id.tv_MaxScore);
        tv_thisScore = (TextView) findViewById(R.id.tv_thisScore);
        imgBtn_restartGame = (ImageButton) findViewById(R.id.imgBtn_restartGame);
        imgBtn_backHome = (ImageButton) findViewById(R.id.imgBtn_backHome);
        imgBtn_exitGame = (ImageButton) findViewById(R.id.imgBtn_exitGame);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgBtn_restartGame:
                Intent intent1 = new Intent(this, GamePlaying.class);
                this.startActivity(intent1);
                this.finish();
                break;
            case R.id.imgBtn_backHome:
                Intent intent2 = new Intent(this, GameLauncher.class);
                this.startActivity(intent2);
                this.finish();
                break;
            case R.id.imgBtn_exitGame:
                this.finish();
                break;

        }
    }
}
