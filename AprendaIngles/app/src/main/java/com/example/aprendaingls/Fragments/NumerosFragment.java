package com.example.aprendaingls.Fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.aprendaingls.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NumerosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NumerosFragment extends Fragment implements  View.OnClickListener {

    ImageView numeroUm, numeroDois, numeroTres, numeroQuatro, numeroCinco, numeroSeis;
    MediaPlayer mediaPlayer;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NumerosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NumerosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NumerosFragment newInstance(String param1, String param2) {
        NumerosFragment fragment = new NumerosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_numeros, container, false);


        numeroUm = view.findViewById(R.id.imageUm);
        numeroDois = view.findViewById(R.id.imageDois);
        numeroTres = view.findViewById(R.id.imageTres);
        numeroQuatro = view.findViewById(R.id.imageQuatro);
        numeroCinco = view.findViewById(R.id.imageCinco);
        numeroSeis = view.findViewById(R.id.imageSeis);



        numeroUm.setOnClickListener(this);
        numeroDois.setOnClickListener(this);
        numeroTres.setOnClickListener(this);
        numeroQuatro.setOnClickListener(this);
        numeroCinco.setOnClickListener(this);
        numeroSeis.setOnClickListener(this);

        return  view;

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageUm:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.one);
                tocarSom();
                break;
            case R.id.imageDois:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.two);
                tocarSom();
                break;
            case R.id.imageTres:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.three);
                tocarSom();
                break;
            case R.id.imageQuatro:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.four);
                tocarSom();
                break;
            case R.id.imageCinco:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.five);
                tocarSom();
                break;
            case R.id.imageSeis:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.six);
                tocarSom();
                break;
        }
    }


    public void tocarSom() {
        if(mediaPlayer != null) {
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }
    }


}