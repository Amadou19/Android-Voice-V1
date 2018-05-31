package com.example.amadoutirera.a3ecrans.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.amadoutirera.a3ecrans.Model.MessageModel;

import java.util.ArrayList;
import java.util.List;

// Classe qui permet de partage les donnés entre les Fragments
public class SharedViewModel extends ViewModel {
    private final MutableLiveData<List<MessageModel>> messageModelMutableLiveData = new MutableLiveData<List<MessageModel>>();
    List<MessageModel> messageListe = new ArrayList<>();

    // recuper le message enregistré par l'uttilisateur et l'ajouté a la liste
    public void recovers(String messag) {
        messageListe.add(new MessageModel(messag));
        messageModelMutableLiveData.setValue(messageListe);
    }

    // Notify les observateur d'un eventuelle changement
    public MutableLiveData<List<MessageModel>> getMessageModelMutableLiveData() {
        return messageModelMutableLiveData;
    }
}