package com.PradipSahoo7722.ciphertalk.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.PradipSahoo7722.ciphertalk.Model.UserInfoModel;
import com.PradipSahoo7722.ciphertalk.R;
import com.PradipSahoo7722.ciphertalk.adapters.UsersAdapter;

import java.util.ArrayList;

public class ChatsFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<UserInfoModel> userDataHolder = new ArrayList<>();

    public ChatsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chats, container, false);

        recyclerView = view.findViewById(R.id.chatFragment_RecyclerView);

        UsersAdapter adapter = new UsersAdapter(userDataHolder);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        UserInfoModel obj1 = new UserInfoModel(R.drawable.user_profile,"Pradip Sahoo", "Hello");
        userDataHolder.add(obj1);

        UserInfoModel obj2 = new UserInfoModel(R.drawable.user_profile,"Kalyani Sahoo", "Hiii");
        userDataHolder.add(obj2);

        UserInfoModel obj3 = new UserInfoModel(R.drawable.user_profile,"sonu Sahoo", "How are you?");
        userDataHolder.add(obj3);

        return view;
    }
}