package com.example.amadoutirera.a3ecrans.View;

import android.arch.lifecycle.ViewModelProviders;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import com.example.amadoutirera.a3ecrans.Model.MessageModel;
import com.example.amadoutirera.a3ecrans.R;
import com.example.amadoutirera.a3ecrans.ViewModel.SharedViewModel;

import java.util.List;
import java.util.Locale;


public class Enregistrement_fragment extends Fragment {

    TextView textOutput;
    ImageButton micButton;
    private static final int REQ_CODE_SPEECH_INPUT = 100;
    private SharedViewModel model;

    public Enregistrement_fragment() { }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.enregistrement_fragment, container, false);
            textOutput = (TextView) rootView.findViewById(R.id.textOutput);
            micButton = (ImageButton) rootView.findViewById(R.id.micButton);

            /**************************************************************/
            micButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startVoiceInput();
                }
            });

            return rootView;
        }

            /*******************************************************************/
            private void startVoiceInput() {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, getString(R.string.speech_prompt));
                try {
                    startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
                } catch (ActivityNotFoundException a) {
                    Toast.makeText(getActivity().getApplicationContext(),
                            getString(R.string.speech_not_supported), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onActivityResult(int requestCode, int resultCode, Intent data) {
                super.onActivityResult(requestCode, resultCode, data);

                switch (requestCode) {
                    case REQ_CODE_SPEECH_INPUT: {
                        if (resultCode == getActivity().RESULT_OK && null != data) {
                            List<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                            // Convertir la premiere lettre en majuscule
                            String resultText = result.get(0).substring(0, 1).toUpperCase() + result.get(0).substring(1);;
                            textOutput.setText(resultText);
                            updateRecyclerVier(resultText);

                        }
                        break;
                    }

                }
            }
            /**************************** me ajour des Donné au niveau du  ViewModel ==>SharedViewModel  ***************************/

            public void updateRecyclerVier(String message) {
                model = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
                model.select(new MessageModel(message));
            }

            /*******************************************************************/



}

