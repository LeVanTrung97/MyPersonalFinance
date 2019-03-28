package com.example.mypersonalfinance.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.mypersonalfinance.R;
import com.example.mypersonalfinance.adapter.TheLoaiAdapter;
import com.example.mypersonalfinance.object.TheLoai;

import java.util.ArrayList;

public class NoChoVayFragment extends Fragment {
    ArrayList<TheLoai> mlistTheloai = new ArrayList<TheLoai>();
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_no_cho_vay,container,false);
        onCreatFakeData();
        ListView listTL =view.findViewById(R.id.lv_nochovay);
        TheLoaiAdapter adapter = new TheLoaiAdapter(getActivity(), R.layout.chonnhom_activity, mlistTheloai);
        listTL.setAdapter(adapter);
        return view;

    }
    private void onCreatFakeData(){
        TheLoai t1 = new TheLoai();
        t1.setName("Cho vay");
        t1.setFlag(R.mipmap.cho_vay);
        TheLoai t2 = new TheLoai();
        t2.setName("Đi vay");
        t2.setFlag(R.mipmap.vay_tien);
        mlistTheloai.add(t1);
        mlistTheloai.add(t2);

    }
}
