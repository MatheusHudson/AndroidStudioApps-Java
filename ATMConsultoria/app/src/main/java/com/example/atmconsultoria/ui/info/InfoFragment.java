package com.example.atmconsultoria.ui.info;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.atmconsultoria.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InfoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InfoFragment newInstance(String param1, String param2) {
        InfoFragment fragment = new InfoFragment();
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
        //return inflater.inflate(R.layout.fragment_info, container, false);

        String descricao = "A ATM consultoria tem como missão apoiar organizações " +
                " que desejam balcançar o sucesso atráves da excelência em gestão e " +
                "da busca pela qualidade.";
        Element versao = new Element();
        versao.setTitle("Versão 1.0");

        return new AboutPage(getActivity()).setDescription(descricao)
                .setImage(R.drawable.logo)
                .addGroup("Entre em Contato")
                .addEmail("atendimento@atmconsultoria.com.br", "Envie um email")
                .addWebsite("www.google.com.br", "Entre no Site")
                .addGroup("Redes Sociais")
                .addFacebook("Facebook", "Facebook")
                .addInstagram("Instagram", "Instagram")
                .addYoutube("Youtube", "Youtube")
                .addGitHub("github", "GitHub")
                .addPlayStore("PlayStore", "PlayStore")

                .addItem(versao)

                .create();




    }
}