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

public class ThuNhapFragment extends Fragment {
    ArrayList<TheLoai> mlistTheloai = new ArrayList<TheLoai>();
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_thunhap,container,false);
        onCreatFakeData();
        ListView listTL =view.findViewById(R.id.lv_thunhap);
        TheLoaiAdapter adapter = new TheLoaiAdapter(getActivity(), R.layout.chonnhom_activity, mlistTheloai);
        listTL.setAdapter(adapter);
        return view;

    }
    private void onCreatFakeData(){
        TheLoai t1 = new TheLoai();
        t1.setName("Tiền lãi");
        t1.setFlag(R.mipmap.tien_lai);
        TheLoai t2 = new TheLoai();
        t2.setName("Bán đồ");
        t2.setFlag(R.mipmap.ban_do);
        TheLoai t3 = new TheLoai();
        t3.setName("Lương");
        t3.setFlag(R.mipmap.luong);
        TheLoai t4 = new TheLoai();
        t4.setName("Dược tặng");
        t4.setFlag(R.mipmap.qua);
        TheLoai t5 = new TheLoai();
        t5.setName("Thưởng");
        t5.setFlag(R.mipmap.tien_thuong);
        mlistTheloai.add(t1);
        mlistTheloai.add(t2);
        mlistTheloai.add(t3);
        mlistTheloai.add(t4);
        mlistTheloai.add(t5);
    }
}
