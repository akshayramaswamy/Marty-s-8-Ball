 /*
 * Akshay Ramaswamy <aramaswa@@stanford.edu>
 * CS 193A, Winter 2017
 * Homework Assignment 1
 * Marty's 8 Ball - This app gives the user two options to get advice from Marty.
 * They can enter a yes-no question and hit ask question, and Marty will respond with the
 * likelihood of the outcome.
 * They can also just hit Get Your Fortune, and Marty will tell them what is in store for their
 * future
 */
package com.example.akshayramaswamy.cs193a_hw1_aramaswa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    /* Method: questionClick
     * This method is called when the user clicks on Ask Question. If the input question isn't empty, then
     * a Toast pops up with an answer to their question. The placeholder of the input TextView is then changed to
     * "Marty says ..." to reflect that a question has been entered successfully, and the text is reset.
     *
     */
    public void questionClick(View view) {
        TextView display = (TextView) findViewById(R.id.editText);
        if (display.getText().length() != 0) {
            String answer = getAnswer(1); //passes 1 into method to get string from questionAnswers array
            Toast.makeText(this, answer, Toast.LENGTH_SHORT).show();
            display.setHint("Marty says ... ");
            display.setText("");
        }
    }

    /* Method: fortuneClick
     * This method is called when the user clicks on Get Your Fortune. A random fortune from the fortuneAnswers array then
     * pops up as a Toast on their screen.
     */
    public void fortuneClick(View view) {
        String answer = getAnswer(2); //passes in 2 into method to get string from fortuneAnswers array
        Toast.makeText(this, answer, Toast.LENGTH_SHORT).show();
    }

    /* Method: getAnswer
     * This method is called by both the fortuneClick and questionClick methods. If a 1 is passed in, then
     * randomAnswer is set to a random string from the questionAnswers array. If a 2 is passed in, then randomAnswer is set
     * to a random string from the fortuneAnswers array.
     * We then return randomAnswer to the method that called getAnswer.
     */
    public String getAnswer(int displayText){
        String[] questionAnswers = {"YES!!", "If Marty says so", "Probably not :(" , "Unclear, please try again",
                "Never in your wildest dreams", "There is a very strong likelihood", "The world may never know"};
        String[] fortuneAnswers = { "You will find true love today", "Marty will give you an A+ in this class",
                "You will become a millionare", "You will become a philosophy major",
                "You will end up in China as a Buddhist Monk", "You will meet Kanye West",
                "You will beat Trump in his 2020 re-election campaign"};
        Random randy = new Random();
        String randomAnswer;
        int rand1 = randy.nextInt(7);
        if (displayText == 1) {
            randomAnswer = questionAnswers[rand1];
        } else{
            randomAnswer = fortuneAnswers[rand1];
        }
        return randomAnswer;

    }
}
