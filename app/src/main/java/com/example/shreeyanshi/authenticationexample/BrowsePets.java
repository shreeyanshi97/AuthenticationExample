package com.example.shreeyanshi.authenticationexample;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

        myRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getContext(), listPets);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //creating an Array of type petInfo to store all stuffs about the pets

        listPets = new ArrayList<>();
        listPets.add(new PetInfo(R.drawable.ic_menu_camera, "Dogs", "Terrier", "17kg", "1.2yr", "$400"));
        listPets.add(new PetInfo(R.drawable.ic_menu_camera, "Dogs", "Terrier", "17kg", "1.2yr", "$400"));
        listPets.add(new PetInfo(R.drawable.ic_menu_camera, "Dogs", "Terrier", "17kg", "1.2yr", "$400"));
        listPets.add(new PetInfo(R.drawable.ic_menu_camera, "Dogs", "Terrier", "17kg", "1.2yr", "$400"));

    }
}
