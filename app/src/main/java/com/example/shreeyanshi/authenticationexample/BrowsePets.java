package com.example.shreeyanshi.authenticationexample;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shreeyanshi.authenticationexample.Model.Category;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BrowsePets extends Fragment {


    View v;
    private RecyclerView myRecyclerView;
    private List<PetInfo> listPets;


    public BrowsePets() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_browse_pets, container, false);

        //setting the recycler view and layout into it

        SharedPreferences sharedPreferences=this.getActivity().getSharedPreferences("Animal_Database",Context.MODE_PRIVATE);
        List<Category> categories=new Gson().fromJson(sharedPreferences.getString("data",""), new TypeToken<List<Category>>() {
        }.getType());
        Log.e("HELLO_HI",new Gson().toJson(categories));
        myRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getContext(), categories);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerAdapter);
        return v;
    }

}
