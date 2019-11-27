package com.ldkvinh.quizandroid.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ldkvinh.quizandroid.Controller.NguoiChoiController;
import com.ldkvinh.quizandroid.Model.NguoiChoi;
import com.ldkvinh.quizandroid.R;

public class DangKiTaiKhoanActivity extends AppCompatActivity {
    private EditText edtTenDangNhap,edtEmail,edtMatKhau,edtXacNhanMatKhau;
    private NguoiChoiController nguoiChoiController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ki_tai_khoan);

        Radiation();

    }

    private void Radiation() {
        edtTenDangNhap = findViewById(R.id.edtTenDangNhap);
        edtEmail = findViewById(R.id.edtEmail);
        edtMatKhau = findViewById(R.id.edtMatKhau);
        edtXacNhanMatKhau = findViewById(R.id.edtXacNhanMatKhau);
    }

    public void DangKy(View view) {
        NguoiChoi nguoiChoi = new NguoiChoi();
        nguoiChoi.setTenDangNhap(edtTenDangNhap.getText().toString());
        nguoiChoi.setEmail(edtEmail.getText().toString());
        nguoiChoi.setMatKhau(edtMatKhau.getText().toString());
        nguoiChoiController = new NguoiChoiController(this);
        Boolean result = nguoiChoiController.DangKiUser(nguoiChoi);
        if (result){
            Toast.makeText(this,getString(R.string.tb_dang_ky_tc),Toast.LENGTH_LONG).show();
            startActivity(new Intent(this,DangNhapActivity.class));
        }else{
            Toast.makeText(this,getString(R.string.tb_dang_ky_tb),Toast.LENGTH_LONG).show();
        }
    }


}
