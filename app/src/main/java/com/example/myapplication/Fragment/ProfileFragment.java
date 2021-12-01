package com.example.myapplication.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myapplication.Adapter.ProfileBelongGroupAdapter;
import com.example.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {
    Context context;
    View view;
    RecyclerView maparam_I_have_recycler;
    ProfileBelongGroupAdapter adapter;
    Button backBtn;
    public ProfileFragment() {
        // Required empty public constructor
    }


    public static ProfileFragment newInstance(Context context) {
        ProfileFragment fragment = new ProfileFragment();
        fragment.context = context;
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        maparam_I_have_recycler = view.findViewById(R.id.maparam_I_have_recycler);
        backBtn = view.findViewById(R.id.backBtn);
        backBtn.setVisibility(View.INVISIBLE);
        makingAdapter();
        return view;
    }

    private void makingAdapter() {
        adapter = new ProfileBelongGroupAdapter(true);
        maparam_I_have_recycler.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        maparam_I_have_recycler.setAdapter(adapter);
    }
}