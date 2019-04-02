package com.example.thegram.View;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thegram.Adapter.CarsAdapter;
import com.example.thegram.Model.CarsModel;
import com.example.thegram.Presenter.CarsPresenter;
import com.example.thegram.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RCV extends Fragment implements MainView {
    CarsAdapter adapter;
    CarsPresenter listdata;
    List<CarsModel> carsModel = new ArrayList<>();
    View v;
    public RCV() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v =  inflater.inflate(R.layout.fragment_rcv, container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView  A = (RecyclerView) v.findViewById(R.id.Rc_H);

        A.setLayoutManager(new LinearLayoutManager(this.getContext()));
        adapter = new CarsAdapter(getContext(), carsModel);
        A.setAdapter(adapter);
        listdata = new CarsPresenter(this,getContext());
        listdata.setData();
    }

    @Override
    public void onSucsess(List<CarsModel> carsModels) {
        this.carsModel.clear();
        this.carsModel.addAll(carsModels);
        this.adapter.notifyDataSetChanged();
    }
}
