package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mStoryTextView;
    Button mButtonTop;
    Button mButtonBottom;
    int mStoryLevel; // what level the story is on - 0 based, so 0 is level 1, etc.
    int[] mStory = {R.string.T1_Story, R.string.T2_Story, R.string.T3_Story, R.string.T4_End, R.string.T5_End, R.string.T6_End};
    int[] mStoryChoice1 = {R.string.T1_Ans1, R.string.T2_Ans1, R.string.T3_Ans1}; // holds what will show on the ans1 button for that story level
    int[] mStoryChoice2 = {R.string.T1_Ans2, R.string.T2_Ans2, R.string.T3_Ans2}; //holds what will show on the ans2 button for that story level.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //  Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "mButtonTop onClick: was story level " + mStoryLevel);
                if ((mStoryLevel == 0) || (mStoryLevel == 1)) {
                    mStoryLevel = 2;
                } else if (mStoryLevel == 2) {
                    mStoryLevel = 5;
                }
                updateDisplayAndButtons(mStoryLevel);
                Log.d(TAG, "mButtonTop onClick: now on story level " + mStoryLevel);
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "mButtonBottom onClick: was story level " + mStoryLevel);
                if (mStoryLevel == 0) {
                    mStoryLevel = 1;
                } else if (mStoryLevel == 1) {
                    mStoryLevel = 3;
                } else if (mStoryLevel == 2) {
                    mStoryLevel = 4;
                }
                updateDisplayAndButtons(mStoryLevel);
                Log.d(TAG, "mButtonButton onClick: now on story level " + mStoryLevel);
            }
        });

    }

    private void updateDisplayAndButtons(int storyLevel) {
        mStoryTextView.setText(mStory[storyLevel]);
        if (storyLevel < 3) {
            mButtonTop.setText(mStoryChoice1[storyLevel]);
            mButtonBottom.setText(mStoryChoice2[storyLevel]);
        } else {
            mButtonTop.setVisibility(View.GONE);
            mButtonBottom.setVisibility(View.GONE);
        }
    }
}
