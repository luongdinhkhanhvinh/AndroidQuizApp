package com.ldkvinh.quizandroid.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ldkvinh.quizandroid.R;

import static com.ldkvinh.quizandroid.Activity.DangNhapActivity.KEY_DANGNHAP_TENDANGNHAP;

public class MangHinhChinhActivity extends AppCompatActivity {
    private TextView tvTenDangNhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mang_hinh_chinh);

        Radiation();
        SetNameUser();


    }

    private void SetNameUser() {
        Intent intent = getIntent();
        String tenDangNhap = intent.getStringExtra(KEY_DANGNHAP_TENDANGNHAP);
        tvTenDangNhap.setText(tenDangNhap);
    }

    private void Radiation() {
        tvTenDangNhap = findViewById(R.id.tvTenDangNhap);
    }

    public void XuLiQuanLiTaiKhoan(View view) {
        startActivity(new Intent(this,QuanLiTaiKhoanActivity.class));
    }

    public void XuLiTroChoiMoi(View view) {
        startActivity(new Intent(this,MangHinhTroChoiActivity.class));
    }

    public void XuLiLichSuChoi(View view) {
        startActivity(new Intent(this,LichSuCauHoiActivity.class));
    }

    public void XuLiBangXepHang(View view) {
        startActivity(new Intent(this,BangXepHangActivity.class));
    }

    public void XuLiMuaCreadit(View view) {
        startActivity(new Intent(this,MuaCreaditActivity.class));
    }

    public void XuLiHuongDan(View view) {
        startActivity(new Intent(this,HuongDanActivity.class));
    }
}
