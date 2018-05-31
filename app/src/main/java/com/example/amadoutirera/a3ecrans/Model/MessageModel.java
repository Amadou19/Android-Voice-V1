package com.example.amadoutirera.a3ecrans.Model;

import android.arch.lifecycle.ViewModel;

public class MessageModel extends ViewModel {
    String message;

    public MessageModel(String message) {
        this.message=message;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
