package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA, scoreTeamB = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayThreeA(View view){
        scoreTeamA = scoreTeamA+3;
        displayForTeamA(scoreTeamA);
    }

    public void displayTwoA(View view){
        scoreTeamA = scoreTeamA+2;
        displayForTeamA(scoreTeamA);
    }

    public void displayOneA(View view){
        scoreTeamA = scoreTeamA+1;
        displayForTeamA(scoreTeamA);
    }

    public void displayThreeB(View view){
        scoreTeamB = scoreTeamB+3;
        displayForTeamB(scoreTeamB);
    }

    public void displayTwoB(View view){
        scoreTeamB = scoreTeamB+2;
        displayForTeamB(scoreTeamB);
    }

    public void displayOneB(View view){
        scoreTeamB = scoreTeamB+1;
        displayForTeamB(scoreTeamB);
    }

    public void callReset(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamB(scoreTeamA);
        displayForTeamA(scoreTeamB);
    }
}
