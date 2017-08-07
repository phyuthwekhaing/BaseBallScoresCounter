package com.example.android.baseballscorescounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int inning = 1;
    int total_inning = 9;
    int teamAScore = 0;
    int teamBScore = 0;
    int out = 0;
    String runs = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        teamBDefense();
    }

    private void displayTeamAScore(int score) {
        TextView t = (TextView) findViewById(R.id.team_a_score);
        t.setText(String.valueOf(score));
    }

    private void displayTeamBScore(int score) {
        TextView t = (TextView) findViewById(R.id.team_b_score);
        t.setText(String.valueOf(score));
    }

    private void displayTeamAOut(int out) {
        TextView t = (TextView) findViewById(R.id.team_a_game_condition);
        t.setText(String.valueOf(out) + "/3 outs");
    }

    private void displayTeamBOut(int out) {
        TextView t = (TextView) findViewById(R.id.team_b_game_condition);
        t.setText(String.valueOf(out) + "/3 outs");
    }

    private void displayTeamARuns(String runs) {
        TextView t = (TextView) findViewById(R.id.team_a_game_condition);
        t.setText(runs);
    }

    private void displayTeamBRuns(String runs) {
        TextView t = (TextView) findViewById(R.id.team_b_game_condition);
        t.setText(runs);
    }

    private void displayTeamAStatus(String status) {
        TextView t = (TextView) findViewById(R.id.team_a_status);
        t.setText(status);
    }

    private void displayTeamBStatus(String status) {
        TextView t = (TextView) findViewById(R.id.team_b_status);
        t.setText(status);
    }

    private void teamADefense() {
        displayTeamAStatus("Defense");
        displayTeamBStatus("Battling");
        displayTeamAScore(teamAScore);
        displayTeamBScore(teamBScore);
        displayTeamBOut(out);
        displayTeamARuns(runs);
        Button b = (Button) findViewById(R.id.team_a_out_button);
        b.setVisibility(View.GONE);
        Button b1 = (Button) findViewById(R.id.team_b_first_base_button);
        b1.setVisibility(View.GONE);
        Button b2 = (Button) findViewById(R.id.team_b_second_base_button);
        b2.setVisibility(View.GONE);
        Button b3 = (Button) findViewById(R.id.team_b_third_base_button);
        b3.setVisibility(View.GONE);
        Button b4 = (Button) findViewById(R.id.team_b_home_run_button);
        b4.setVisibility(View.GONE);
        Button b5 = (Button) findViewById(R.id.team_b_reset_run);
        b5.setVisibility(View.GONE);

        Button b6 = (Button) findViewById(R.id.team_b_out_button);
        b6.setVisibility(View.VISIBLE);
        Button b7 = (Button) findViewById(R.id.team_a_first_base_button);
        b7.setVisibility(View.VISIBLE);
        Button b8 = (Button) findViewById(R.id.team_a_second_base_button);
        b8.setVisibility(View.VISIBLE);
        Button b9 = (Button) findViewById(R.id.team_a_third_base_button);
        b9.setVisibility(View.VISIBLE);
        Button b10 = (Button) findViewById(R.id.team_a_home_run_button);
        b10.setVisibility(View.VISIBLE);
        Button b11 = (Button) findViewById(R.id.team_a_reset_run);
        b11.setVisibility(View.VISIBLE);

    }

    private void teamBDefense() {
        displayTeamAStatus("Battling");
        displayTeamBStatus("Defense");
        displayTeamAScore(teamAScore);
        displayTeamBScore(teamBScore);
        displayTeamAOut(out);
        displayTeamBRuns(runs);
        Button b = (Button) findViewById(R.id.team_b_out_button);
        b.setVisibility(View.GONE);
        Button b1 = (Button) findViewById(R.id.team_a_first_base_button);
        b1.setVisibility(View.GONE);
        Button b2 = (Button) findViewById(R.id.team_a_second_base_button);
        b2.setVisibility(View.GONE);
        Button b3 = (Button) findViewById(R.id.team_a_third_base_button);
        b3.setVisibility(View.GONE);
        Button b4 = (Button) findViewById(R.id.team_a_home_run_button);
        b4.setVisibility(View.GONE);
        Button b5 = (Button) findViewById(R.id.team_a_reset_run);
        b5.setVisibility(View.GONE);
        Button b6 = (Button) findViewById(R.id.team_a_out_button);
        b6.setVisibility(View.VISIBLE);
        Button b7 = (Button) findViewById(R.id.team_b_first_base_button);
        b7.setVisibility(View.VISIBLE);
        Button b8 = (Button) findViewById(R.id.team_b_second_base_button);
        b8.setVisibility(View.VISIBLE);
        Button b9 = (Button) findViewById(R.id.team_b_third_base_button);
        b9.setVisibility(View.VISIBLE);
        Button b10 = (Button) findViewById(R.id.team_b_home_run_button);
        b10.setVisibility(View.VISIBLE);
        Button b11 = (Button) findViewById(R.id.team_b_reset_run);
        b11.setVisibility(View.VISIBLE);
    }


    public void teamAOut(View view) {
        out += 1;
        displayTeamAOut(out);
        if (out >= 3) {
            out = 0;
            runs = "";
            teamADefense();
        }
    }

    public void teamBOut(View view) {
        out += 1;
        displayTeamBOut(out);
        if (out >= 3) {
            out = 0;
            runs = "";
            teamBDefense();
            inning += 1;
            displayInning(inning);
            if (inning > 9) {
                statusInning("GAME OVER");
                if(teamAScore > teamBScore) {
                    displayTeamAStatus("Won");
                    displayTeamBStatus("Lose");
                }
                else{
                    displayTeamAStatus("Lose");
                    displayTeamBStatus("Win");
                }
                displayTeamARuns("");
                displayTeamBRuns("");
                Button b = (Button) findViewById(R.id.team_b_out_button);
                b.setVisibility(View.GONE);
                Button b1 = (Button) findViewById(R.id.team_a_first_base_button);
                b1.setVisibility(View.GONE);
                Button b2 = (Button) findViewById(R.id.team_a_second_base_button);
                b2.setVisibility(View.GONE);
                Button b3 = (Button) findViewById(R.id.team_a_third_base_button);
                b3.setVisibility(View.GONE);
                Button b4 = (Button) findViewById(R.id.team_a_home_run_button);
                b4.setVisibility(View.GONE);
                Button b5 = (Button) findViewById(R.id.team_a_reset_run);
                b5.setVisibility(View.GONE);
                Button b6 = (Button) findViewById(R.id.team_a_out_button);
                b6.setVisibility(View.GONE);
                Button b7 = (Button) findViewById(R.id.team_b_first_base_button);
                b7.setVisibility(View.GONE);
                Button b8 = (Button) findViewById(R.id.team_b_second_base_button);
                b8.setVisibility(View.GONE);
                Button b9 = (Button) findViewById(R.id.team_b_third_base_button);
                b9.setVisibility(View.GONE);
                Button b10 = (Button) findViewById(R.id.team_b_home_run_button);
                b10.setVisibility(View.GONE);
                Button b11 = (Button) findViewById(R.id.team_b_reset_run);
                b11.setVisibility(View.GONE);
            }
        }
    }

    private void statusInning(String inning) {
        TextView t = (TextView) findViewById(R.id.inning_number);
        t.setText(inning);
    }

    private void displayInning(int inning) {
        switch (inning) {
            case 1:
                statusInning("1ST INNING");
                break;
            case 2:
                statusInning("2ND INNING");
                break;
            case 3:
                statusInning("3RD INNING");
                break;
            case 4:
                statusInning("4TH INNING");
                break;
            case 5:
                statusInning("5TH INNING");
                break;
            case 6:
                statusInning("6TH INNING");
                break;
            case 7:
                statusInning("7TH INNING");
                break;
            case 8:
                statusInning("8TH INNING");
                break;
            case 9:
                statusInning("9TH INNING");
                break;
        }
    }


    public void teamAFirstBase(View view) {
        if (runs == "") {
            runs += "First Base";
        } else {
            runs += ", First base";
        }

        displayTeamARuns(runs);

    }

    public void teamBFirstBase(View view) {
        if (runs == "") {
            runs += "First Base";
        } else {
            runs += ", First base";
        }
        displayTeamBRuns(runs);

    }

    public void teamASecondBase(View view) {
        if (runs == "") {
            runs += "Second Base";
        } else {
            runs += ", Second base";
        }

        displayTeamARuns(runs);

    }

    public void teamBSecondBase(View view) {
        if (runs == "") {
            runs += "Second Base";
        } else {
            runs += ", Second base";
        }
        displayTeamBRuns(runs);

    }

    public void teamAThirdBase(View view) {
        if (runs == "") {
            runs += "Third Base";
        } else {
            runs += ", Third base";
        }

        displayTeamARuns(runs);

    }

    public void teamBThirdBase(View view) {
        if (runs == "") {
            runs += "First Base";
        } else {
            runs += ", Third base";
        }
        displayTeamBRuns(runs);

    }

    public void teamAHomeRun(View view) {
        teamBScore += 1;
        displayTeamBScore(teamBScore);
        resetRun();
        displayTeamARuns(runs);
    }

    public void teamBHomeRun(View view) {
        teamAScore += 1;
        displayTeamAScore(teamAScore);
        resetRun();
        displayTeamBRuns(runs);
    }

    public void resetRun() {
        runs = "";
    }

    public void teamAResetRun(View view) {
        runs = "";
        displayTeamARuns(runs);
    }

    public void teamBResetRun(View view) {
        runs = "";
        displayTeamBRuns(runs);
    }

    public void resetGame(View view) {
        inning = 1;
        teamAScore = 0;
        teamBScore = 0;
        displayTeamAScore(teamAScore);
        displayTeamBScore(teamBScore);
        out = 0;
        runs = "";
        displayTeamARuns(runs);
        displayTeamBRuns(runs);
        displayInning(inning);
        teamBDefense();
    }


}
