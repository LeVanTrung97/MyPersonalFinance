package com.example.mypersonalfinance.activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mypersonalfinance.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GiaoDichActivity extends AppCompatActivity {
    private LinearLayout chonnhom;
    private LinearLayout ghichu,chonngay,map,nguoi_gd;
    private TextView ngay,ai;
    private TextView gc;
    RelativeLayout relativeLayout;
    public static final int CODE=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giao_dich);

        ghichu =  findViewById (R.id.ghichu);
        gc = findViewById(R.id.gchu);

        ghichu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GiaoDichActivity.this, GhichuActivity.class);

                startActivityForResult(intent,1);
            }
        });
        chonnhom = (LinearLayout) findViewById(R.id.chonnhom);
        chonnhom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GiaoDichActivity.this, ChonNhomActivity.class);
                startActivity(intent);
            }
        });
        chonngay=(LinearLayout) findViewById(R.id.chonngay);
        chonngay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chonngay();
            }
        });
        map=findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri addressURri = Uri.parse("geo:0,0?q=" );
                Intent intent = new Intent(Intent.ACTION_VIEW, addressURri);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
        ai=findViewById(R.id.ai);
        nguoi_gd=findViewById(R.id.who);
        nguoi_gd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GiaoDichActivity.this, NguoiGdActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }
    private void chonngay(){
        final Calendar calendar=Calendar.getInstance();
        int ngay=calendar.get(Calendar.DATE);
        int thang=calendar.get(Calendar.MONTH);
        int nam=calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog= new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                calendar.set(year,monthOfYear,dayOfMonth);
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
                TextView ngay=(TextView) findViewById(R.id.ngay);
                ngay.setText(simpleDateFormat.format(calendar.getTime()));
            }
        },nam,thang,ngay);
        datePickerDialog.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                String result=data.getStringExtra("ghichu");

                gc.setText(result);

            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result


            }
        }

    }


}
