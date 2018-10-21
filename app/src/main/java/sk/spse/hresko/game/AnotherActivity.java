package sk.spse.hresko.game;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AnotherActivity extends AppCompatActivity {
    private int countBottom;
    private int countTop;
    private int countMax;
    private TextView topTextView;
    private TextView bottomTextView;
    private Button bottomButton;
    private Button topButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        topTextView = findViewById(R.id.topText);
        bottomTextView = findViewById(R.id.bottomText);
        bottomButton = findViewById(R.id.bottomButton);
        topButton = findViewById(R.id.topButton);

        countMax = getIntent().getExtras().getInt("clicks");
        CountDownTimer countDownTimer = new CountDownTimer(4000, 1000) {

            public void onTick(long millisUntilFinished) {
                bottomTextView.setText(String.valueOf(millisUntilFinished / 1000));
                topTextView.setText(String.valueOf(millisUntilFinished/1000));
            }

            public void onFinish() {
                bottomTextView.setText("Start!");
                topTextView.setText("Start !");
                bottomButton.setClickable(true);
                topButton.setClickable(true);
                bottomButton.setEnabled(true);
                topButton.setEnabled(true);
            }
        }.start();
    }


    public void clickTop(View view) {

        if (countTop < countMax && countBottom!=countMax) {
            countTop++;
            topTextView.setText(countTop + " / " + countMax);
        }  if (countTop == countMax && countBottom < countMax) {
           topTextView.setText("You won !");
           bottomTextView.setText("You lost !");

        }


    }

    public void clickBottom(View view) {


        if (countBottom < countMax && countTop!=countMax) {
            countBottom++;
            bottomTextView.setText(countBottom + " / " + countMax);
        }  if (countBottom == countMax && countTop < countMax) {
            bottomTextView.setText("You won !");
            topTextView.setText("You lost !");

        }
    }



}
