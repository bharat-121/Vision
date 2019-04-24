package com.example.bharat.firstproject;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

public class Interest extends AppCompatActivity {

    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest);

        mainGrid=findViewById(R.id.mainGrid);

        //set Event

        setToggleEvent(mainGrid);
    }

    private void setToggleEvent(GridLayout mainGrid) {
        for(int i=0;i<mainGrid.getChildCount();i++)
        {
            //you can see all child objects in cardview so just cast in cardview
            final CardView cardView=(CardView) mainGrid.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(cardView.getCardBackgroundColor().getDefaultColor()==-1)
                    {
                        cardView.setCardBackgroundColor(Color.parseColor("#32cd32"));
                    }
                    else
                    {

                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                    }
                }
            });
    }

    }}
