package com.ldkvinh.quizandroid.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ldkvinh.quizandroid.R;

public class MangHinhTroChoiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mang_hinh_tro_choi);
    }

    public void XuLiHienThiCauHoi(View view) {
        startActivity(new Intent(this,HienThiCauHoiActivity.class));
    }
}
