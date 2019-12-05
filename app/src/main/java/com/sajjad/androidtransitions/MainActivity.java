package com.sajjad.androidtransitions;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView profileImage;
    TextView imageTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //doTransition();
        super.onCreate(savedInstanceState);
//        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_main);


        profileImage = findViewById(R.id.profileImage);
        imageTitle = findViewById(R.id.imageTitle);
    }

    public void openWithSharedTransition(View view) {

        Pair[] pairs = new Pair[2];
        pairs[0] = new Pair<View, String>(profileImage, "sharedProfile");
        pairs[1] = new Pair<View, String>(imageTitle, "sharedTitle");

        ActivityOptions options =
                ActivityOptions.makeSceneTransitionAnimation(this, pairs);
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("transitionName", "shared");
        startActivity(intent, options.toBundle());
    }

    private void startSecondActivity(String name) {
        ActivityOptions options =
                ActivityOptions.makeSceneTransitionAnimation(this);
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("transitionName", name);
        startActivity(intent, options.toBundle());
    }

    public void doExplodeTransition(View view) {
        startSecondActivity("explode");
    }

    public void doSlideTransition(View view) {
        startSecondActivity("slide");
    }

    public void doFadeTransition(View view) {
        startSecondActivity("fade");
    }

    void doTransition() {
        Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.explode);
        getWindow().setExitTransition(transition);
    }
}