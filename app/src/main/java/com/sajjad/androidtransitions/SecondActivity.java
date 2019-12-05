package com.sajjad.androidtransitions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        doTransition();
    }

    void doTransition() {
        Transition transition = null;
        String transitionName = getIntent().getStringExtra("transitionName");

        switch (transitionName) {
            case "explode":
                transition = TransitionInflater.from(this).inflateTransition(R.transition.explode);
                break;
            case "slide":
                transition = TransitionInflater.from(this).inflateTransition(R.transition.slide);
                break;
                case "fade":
                transition = TransitionInflater.from(this).inflateTransition(R.transition.fade);
                break;
                default:
                    break;
        }

        getWindow().setEnterTransition(transition);
    }
}