package com.ldkvinh.quizandroid.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.ldkvinh.quizandroid.Database.DBHelper;
import com.ldkvinh.quizandroid.Model.NguoiChoi;

public class NguoiChoiController {
    private DBHelper db;
    private SQLiteDatabase sqLiteDatabase;

    public static final String TABLE_NAME = "NguoiChoi";

    //public static final String COLUMN_ID = "id";
    public static final String COLUMN_TEN_DANG_NHAP = "ten_dang_nhap";
    public static final String COLUMN_MAT_KHAU = "mat_khau";
    public static final String COLUMN_EMAIL = "email";




    public NguoiChoiController(Context context) {
        db = new DBHelper(context);
    }

    public Boolean CheckUser(String tenTaiKhoan,String matKhau){
        sqLiteDatabase = db.getReadableDatabase();
        Log.d("abcxyz", "CheckUser: "+tenTaiKhoan+matKhau);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME + " WHERE "
                        + COLUMN_TEN_DANG_NHAP + " =  '" + tenTaiKhoan + "' AND "
                        + COLUMN_MAT_KHAU      + " =  '" + matKhau +"' "
                ,null);
        Boolean result = false;
        if (cursor.getCount() > 0){
            result = true;
        }
        cursor.close();
        db.close();
        return result;
    }

    public Boolean CheckTKAndEmail(String tenTaiKhoan,String email){
        sqLiteDatabase = db.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME + " WHERE "
                        + COLUMN_TEN_DANG_NHAP + " =  '" + tenTaiKhoan + "' AND "
                        + COLUMN_EMAIL +" = '" + email +"' "
                ,null);
        Boolean result = false;
        if (cursor.getCount() > 0){
            result = true;
        }
        cursor.close();
        db.close();
        return result;
    }

    public String GetMatKhau(String tenTaiKhoan,String email){
        sqLiteDatabase = db.getReadableDatabase();
        //Log.d("abcxyz", "CheckUser: "+tenTaiKhoan+matKhau);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME + " WHERE "
                        + COLUMN_TEN_DANG_NHAP + " =  '" + tenTaiKhoan + "' AND "
                        + COLUMN_EMAIL + " = '" + email +"' "
                ,null);
        String matkhau = null;
        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            matkhau = cursor.getString(cursor.getColumnIndex(COLUMN_MAT_KHAU));
        }
        cursor.close();
        db.close();
        return matkhau;
    }

    public Boolean DangKiUser(NguoiChoi nguoiChoi){
        sqLiteDatabase = db.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_TEN_DANG_NHAP,nguoiChoi.getTenDangNhap());
        contentValues.put(COLUMN_MAT_KHAU,nguoiChoi.getMatKhau());
        contentValues.put(COLUMN_EMAIL,nguoiChoi.getEmail());
        long result = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        db.close();
        Log.d("DangKiUser", "DangKiUser: "+result);
        if (result > 0){
            return true;
        }
        return  false;
    }



}
