package com.example.atmconsultoria.ui.service;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.atmconsultoria.R;

public class ServiceFragment extends Fragment {

    private ServiceViewModel serviceViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        serviceViewModel =
                ViewModelProviders.of(this).get(ServiceViewModel.class);
        View root = inflater.inflate(R.layout.fragment_service, container, false);

        return root;
    }
}