package com.or2go.vendor.showstorenearme;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ListedStoreFragment extends Fragment {

    RecyclerView recyclerView;

    public ListedStoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_listed_store, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_StoreList);
        
        return view;
    }
}