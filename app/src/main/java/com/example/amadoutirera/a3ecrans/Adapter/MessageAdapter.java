package com.example.amadoutirera.a3ecrans.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.amadoutirera.a3ecrans.Model.MessageModel;
import com.example.amadoutirera.a3ecrans.R;

import java.util.List;

// Adapdateur RecyclerView  Historique Fragment

public class MessageAdapter extends RecyclerView.Adapter <MessageAdapter.NotViewHolder>{
    private List<MessageModel> messageList;

    //Constructeur
    public MessageAdapter(List<MessageModel> messageListe) {
        this.messageList = messageListe;

    }


    @NonNull
    @Override
    public NotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new  NotViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.message_card,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull final NotViewHolder holder, int position) {
        MessageModel messageModel = messageList.get(position);

        holder.messageId.setText(String.valueOf(position+1));
        holder.message.setText(messageModel.getMessage());

    }

    public void addMessage(List<MessageModel> messageList){
        this.messageList = messageList;
        notifyDataSetChanged();

    }

   /* public void addMessage(List<MessageModel> messageList){
        this.messageList = messageList;
        notifyDataSetChanged();

    }*/

    @Override
    public int getItemCount() {
        return messageList.size();

    }

    /******************************************************************/
    public class NotViewHolder extends RecyclerView.ViewHolder {

        public CardView histotiqueCardID;
        public TextView messageId;
        public TextView message;

        public NotViewHolder(View itemView) {
            super(itemView);

            histotiqueCardID = (CardView) itemView.findViewById(R.id.histotiqueCardID);
            messageId = (TextView) itemView.findViewById(R.id.messageId);
            message = (TextView) itemView.findViewById(R.id.message);


        }
    }
}
