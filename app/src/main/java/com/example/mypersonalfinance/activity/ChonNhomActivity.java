package com.example.mypersonalfinance.activity;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mypersonalfinance.R;
import com.example.mypersonalfinance.fragment.NoChoVayFragment;
import com.example.mypersonalfinance.fragment.ThuNhapFragment;
import com.example.mypersonalfinance.fragment.TieuDungFragment;
import com.example.mypersonalfinance.object.TheLoai;

import java.util.ArrayList;

public class ChonNhomActivity extends AppCompatActivity {
    private TextView chovay, tieudung, thunhap;

    ArrayList<TheLoai> mlistTheloai = new ArrayList<TheLoai>();
    TieuDungFragment tieuDungFragment = new TieuDungFragment();
    NoChoVayFragment noChoVayFragment=new NoChoVayFragment();
    ThuNhapFragment thuNhapFragment=new ThuNhapFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conten_view);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.conten_view,tieuDungFragment);
        transaction.addToBackStack(null);
        transaction.commit();



        tieudung=(TextView) findViewById(R.id.tieudung);
        final TieuDungFragment tieuDungFragment=new TieuDungFragment();

        tieudung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent=new Intent(ChonNhomActivity.this, ChonNhomActivity.class);
                getSupportFragmentManager().beginTransaction().replace(R.id.conten_view,tieuDungFragment).commit();
              //  startActivity(intent);

            }
        });
        chovay=(TextView)findViewById(R.id.chovay);
        chovay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.conten_view,noChoVayFragment).commit();
    }
       });
        thunhap=findViewById(R.id.thunhap);
thunhap.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        getSupportFragmentManager().beginTransaction().replace(R.id.conten_view,thuNhapFragment).commit();
    }
});
    }


}
