package com.example.amadoutirera.a3ecrans.View;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.amadoutirera.a3ecrans.Adapter.MessageAdapter;
import com.example.amadoutirera.a3ecrans.Model.MessageModel;
import com.example.amadoutirera.a3ecrans.R;
import com.example.amadoutirera.a3ecrans.ViewModel.SharedViewModel;

import java.util.ArrayList;

public class Historique_fragment extends Fragment {
    private RecyclerView recyclerView;
    private  MessageAdapter messageAdapter;
    private TextView chek;


        public Historique_fragment() { }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.historique_fragment, container, false);

            recyclerView=(RecyclerView)rootView.findViewById(R.id.historiqueRecyclerView);
            chek=(TextView)rootView.findViewById(R.id.chek);

            /******************************************************************************/

            messageAdapter = new MessageAdapter(new ArrayList<MessageModel>());
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(messageAdapter);

            /********************************************************************************/

            // Observe tous les changement au niveau des donnés et les ajoute dinamiquement a notre vue en fontion du cycle de vie de lactivité
            SharedViewModel model = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
            model.getMessageModelMutableLiveData().observe(getActivity(), messageList ->{
                chek.setVisibility(View.GONE);
                messageAdapter.addMessage(messageList);
            });
            /********************************************************************************/

            return rootView;
        }
    }

