package com.example.amadoutirera.a3ecrans.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.amadoutirera.a3ecrans.Model.MessageModel;

// Classe qui permet de partage les donnés entre les Fragments
public class SharedViewModel extends ViewModel {
    private final MutableLiveData<MessageModel> messageModelMutableLiveData = new MutableLiveData<MessageModel>();

    public void select(MessageModel messageModel) {
        messageModelMutableLiveData.setValue(messageModel);
    }


    public LiveData<MessageModel> getMessageModelMutableLiveData() {
        return messageModelMutableLiveData;
    }
}