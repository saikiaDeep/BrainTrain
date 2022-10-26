package com.deepsaikia.braintrain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //variables declaration
    TextView timerTV;
    TextView resultTV;
    TextView counterTV;
    TextView resultFinalTV;
    TextView displayTV;
    Button gb1;
    Button gb2;
    Button gb3;
    Button gb4;
    Button mainStart;
    ConstraintLayout constraintLayout;
    int tag=1;
    int upCounter=0;
    int downCounter=0;
    int result=0;
    int rand_1=0;
    int rand_2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Linking of variable
        timerTV=findViewById(R.id.timerTV);
        counterTV=findViewById(R.id.counterTV);
        resultTV=findViewById(R.id.resultTV);
        resultFinalTV=findViewById(R.id.resultFinalTV);
        displayTV=findViewById(R.id.displayTV);
        gb1=findViewById(R.id.gridBut1);
        gb2=findViewById(R.id.gridBut2);
        gb3=findViewById(R.id.gridBut3);
        gb4=findViewById(R.id.gridBut4);
        mainStart=findViewById(R.id.mainGoButton);
        constraintLayout=findViewById(R.id.constraintLayout);

        mainStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainStart.setVisibility(View.INVISIBLE);
                resultFinalTV.setVisibility(View.INVISIBLE);
                constraintLayout.setVisibility(View.VISIBLE);
                tag=generateNumbers();
                startTimer();
            }
        });
        gb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               if((Integer.toString(tag).equals(gb1.getTag().toString())))
               {
                   //successful
                   resultTV.setText("CORRECT :-)");
                   upCounter++;
                   String show= upCounter +"/"+ ++downCounter;
                   counterTV.setText(show);

               }
               else
               {
                   //unsuccessful
                   resultTV.setText("WRONG :-(");
                   String show= upCounter +"/"+ ++downCounter;
                   counterTV.setText(show);

               }
                tag=generateNumbers();
            }
        });
        gb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if((Integer.toString(tag).equals(gb2.getTag().toString())))
                {
                    //successful
                    resultTV.setText("CORRECT :-)");
                    upCounter++;
                    String show= upCounter +"/"+ ++downCounter;
                    counterTV.setText(show);

                }
                else
                {
                    //unsuccessful
                    resultTV.setText("WRONG :-(");
                    String show= upCounter +"/"+ ++downCounter;
                    counterTV.setText(show);

                }
                tag=generateNumbers();
            }
        });
        gb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if((Integer.toString(tag).equals(gb3.getTag().toString())))
                {
                    //successful
                    resultTV.setText("CORRECT :-)");
                    upCounter++;
                    String show= upCounter +"/"+ ++downCounter;
                    counterTV.setText(show);

                }
                else
                {
                    //unsuccessful
                    resultTV.setText("WRONG :-(");
                    String show= upCounter +"/"+ ++downCounter;
                    counterTV.setText(show);

                }
                tag=generateNumbers();
            }
        });
        gb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if((Integer.toString(tag).equals(gb4.getTag().toString())))
                {
                    //successful
                    resultTV.setText("CORRECT :-)");
                    upCounter++;
                    String show= upCounter +"/"+ ++downCounter;
                    counterTV.setText(show);

                }
                else
                {
                    //unsuccessful
                    resultTV.setText("WRONG :-(");
                    String show= upCounter +"/"+ ++downCounter;
                    counterTV.setText(show);

                }
                tag=generateNumbers();
            }
        });


    }



    //functions

    int generateNumbers()
    {
        Random rand = new Random();
        rand_1= rand.nextInt(40);
        rand_2=rand.nextInt(40)+1;
        displayTV.setText(rand_1+" + "+rand_2);
        result=rand_1+rand_2;
        return fillSpaces(result);
    }
    int fillSpaces(int storeResult)
    {
        Random rand = new Random();
        int rand_box= rand.nextInt(4)+1;
        tag=rand_box;
        if(Integer.toString(tag).equals(gb1.getTag().toString()))
        {
            gb1.setText(Integer.toString(storeResult));
        }
        else
        {
            int rand_var=rand.nextInt(30)-15;
            if(rand_var<=0)
            {
                rand_var=3;
            }
            gb1.setText(Integer.toString(storeResult+rand_var));
        }
        if(Integer.toString(tag).equals(gb2.getTag().toString()))
        {
            gb2.setText(Integer.toString(storeResult));
        }
        else
        {
            int rand_var=rand.nextInt(30)-15;
            if(rand_var==0)
            {
                rand_var=-6;
            }
            gb2.setText(Integer.toString(storeResult+rand_var));
        }
        if(Integer.toString(tag).equals(gb3.getTag().toString()))
        {
            gb3.setText(Integer.toString(storeResult));
        }
        else
        {
            int rand_var=rand.nextInt(30)-15;
            if(rand_var==0)
            {
                rand_var=-8;
            }
            gb3.setText(Integer.toString(storeResult+rand_var));
        }
        if(Integer.toString(tag).equals(gb4.getTag().toString()))
        {
            gb4.setText(Integer.toString(storeResult));
        }
        else
        {
            int rand_var=rand.nextInt(30)-15;
            if(rand_var==0)
            {
                rand_var=-2;
            }
            gb4.setText(Integer.toString(storeResult+rand_var));
        }
        return rand_box;
    }
    void startTimer()
    {
        new CountDownTimer(31000,1000)
        {
            @Override
            public void onTick(long l) {
                //l/1000
                String onTick=l/1000+"s";
                timerTV.setText(onTick);
            }

            @Override
            public void onFinish() {
                timerTV.setText("30s");
                String result="Your Score: "+counterTV.getText().toString();
                resultFinalTV.setText(result);
                String counter=0+"/"+0;
                upCounter=0;
                downCounter=1;
                counterTV.setText(counter);
                mainStart.setVisibility(View.VISIBLE);

                resultFinalTV.setVisibility(View.VISIBLE);
                constraintLayout.setVisibility(View.INVISIBLE);

            }
        }.start();
        }
}