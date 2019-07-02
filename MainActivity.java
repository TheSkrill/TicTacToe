package com.nocomp.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    int activePlayer=0; // yellow=0 red=1

    int gameState[] = {2,2,2,2,2,2,2,2,2};

    int winningPositions[][] = {{0,3,4},{1,5,7},{2,6,8},{0,1,2},{3,5,6},{4,7,8},{0,5,8},{4,5,2}};

    public void dropin (View view)
    {
        ImageView counter = (ImageView) view;

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if(gameState[tappedCounter] == 2)
        {
            gameState[tappedCounter] = activePlayer;

            counter.setTranslationY(1000f);

            if (activePlayer == 0) {

                counter.setImageResource(R.drawable.yellow);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }


            counter.animate().translationYBy(-1000f).setDuration(400);

            for(int winningPosition[] : winningPositions)
            {
                if(gameState[winningPosition[0]]==gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]]!=2)
                {

                    LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);


                    String winner = "Red";
                    if(gameState[winningPosition[0]]==0)
                    {
                        winner = "Yellow";
                    }

                    TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);

                    winnerMessage.setText(winner+" has Won!");






                    layout.setVisibility(View.VISIBLE);


                }
            }

        }



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
