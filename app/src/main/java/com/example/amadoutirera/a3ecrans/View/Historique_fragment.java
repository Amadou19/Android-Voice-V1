package com.example.amadoutirera.a3ecrans.View;

import android.arch.lifecycle.ViewModelProviders;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.amadoutirera.a3ecrans.ViewModel.MessageAdapter;
import com.example.amadoutirera.a3ecrans.Model.MessageModel;
import com.example.amadoutirera.a3ecrans.R;
import com.example.amadoutirera.a3ecrans.ViewModel.SharedViewModel;

import java.util.ArrayList;
import java.util.List;

public class Historique_fragment extends Fragment {
    private RecyclerView recyclerView;
    private  MessageAdapter messageAdapter;


        public Historique_fragment() { }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.historique_fragment, container, false);

            recyclerView=(RecyclerView)rootView.findViewById(R.id.historiqueRecyclerView);

            /******************************************************************************/

            messageAdapter = new MessageAdapter(new ArrayList<MessageModel>());
            recyclerView.setAdapter(messageAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            /********************************************************************************/

            SharedViewModel model = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
            model.getMessageModelMutableLiveData().observe(getActivity(), item ->{
                messageAdapter.addMessage(new MessageModel(item.getMessage().toUpperCase()));
            });
            /********************************************************************************/


            return rootView;
        }
    }

