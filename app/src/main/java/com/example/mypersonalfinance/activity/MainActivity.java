package com.example.mypersonalfinance.activity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.mypersonalfinance.R;
import com.example.mypersonalfinance.fragment.KeHoachFragment;
import com.example.mypersonalfinance.fragment.MoRongFragment;
import com.example.mypersonalfinance.fragment.ThongKeFragment;
import com.example.mypersonalfinance.fragment.TrangChuFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private FloatingActionButton fab;
    private Toolbar toolbar;
    BottomNavigationView bottomNavigationView;
private static final String TAG="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener( this);
        bottomNavigationView.setSelectedItemId(R.id.home);

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GiaoDichActivity.class);
                startActivity(intent);
            }
        });

    }
//

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
//
//       // noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
//
//        switch (item.getItemId()){
//            case R.id.home:
//                getSupportFragmentManager().beginTransaction().replace(R.id.container,trangChuFragment).commit();
//                return  true    ;
//        }
//     return true;
   }
    TrangChuFragment trangChuFragment=new TrangChuFragment();
    ThongKeFragment thongKeFragment=new ThongKeFragment();
KeHoachFragment keHoachFragment=new KeHoachFragment();
MoRongFragment moRongFragment=new MoRongFragment();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,trangChuFragment).commit();
                return  true    ;
            case R.id.statistic:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,thongKeFragment).commit();
                return  true    ;
            case R.id.event:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,keHoachFragment).commit();
                return  true    ;
            case R.id.more:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,moRongFragment).commit();
                return  true    ;
        }
      return false;

    }
}
