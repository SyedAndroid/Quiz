package com.example.syed.quiz;

import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;

        import android.content.Context;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.view.inputmethod.InputMethodManager;
        import android.widget.CheckBox;
        import android.widget.EditText;
        import android.widget.LinearLayout;
        import android.widget.RadioButton;
        import android.widget.TextView;
        import android.widget.Toast;

import static com.example.syed.quiz.R.id.welcome;

/**
 * This app Quiz celebrate Game of thrones.... the best series
 */
public class MainActivity extends AppCompatActivity {

    private String name="John";
    private int correctAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when Ready button is clicked.
     * @param view
     */
    public void greetings(View view) {
        EditText nameField = (EditText) findViewById(R.id.customer_name);
        name = nameField.getText().toString();
        TextView greetings = (TextView) findViewById(R.id.greetings);
        greetings.setText("Hi " + name + ", Winter is coming!");

        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);

        LinearLayout welQuestions = (LinearLayout) findViewById(welcome);
        welQuestions.setVisibility(View.VISIBLE);
    }


    /**
     * This methods check the number of correct answers, and displays a toast.
     *
     * @param view
     */
    public void submitAnswer(View view) {
        RadioButton honorQuestion = (RadioButton) findViewById(R.id.ned);
        if (honorQuestion.isChecked()) {
            correctAnswers++;
        }

        RadioButton viperQuestion = (RadioButton) findViewById(R.id.viper);
        if (viperQuestion.isChecked()) {
            correctAnswers++;
        }

        RadioButton starveQuestion = (RadioButton) findViewById(R.id.life);
        if (starveQuestion.isChecked()) {
            correctAnswers++;
        }

        RadioButton deadQuestion = (RadioButton) findViewById(R.id.dead);
        if (deadQuestion.isChecked()) {
            correctAnswers++;
        }

        CheckBox snow = (CheckBox) findViewById(R.id.jon);
        CheckBox stark = (CheckBox) findViewById(R.id.rob);
        CheckBox ramsay = (CheckBox) findViewById(R.id.ramsay);
        CheckBox bran = (CheckBox) findViewById(R.id.bran);
        CheckBox theon = (CheckBox) findViewById(R.id.theon);


        if (snow.isChecked() && stark.isChecked()  && !ramsay.isChecked() && !bran.isChecked() && !theon.isChecked() ) {
            correctAnswers++;
        }

        EditText dragon = (EditText) findViewById(R.id.dragon);
        String dragonName = dragon.getText().toString().trim();
        if(dragonName.equalsIgnoreCase("Drogon")) {
            correctAnswers++;
        }

        String correctlyAnswered;
        switch (correctAnswers) {
            case 6:
                correctlyAnswered = "My king " + name + " ,welcome to the kings landing of Westeros ";
                break;
            case 5:
                correctlyAnswered = "Welcome to Kings Landing, " + name + " of Westeros ";
                break;
            case 4:
                correctlyAnswered = "You are King of the North " + name + " , but Winter is coming";
                break;
            case 3:
                correctlyAnswered = "OK " + name + "Welcome to the Nights Watch!";
                break;
            case 2:
                correctlyAnswered = "Not bad " + name + "You can join the Night King";
                break;
            case 1:
                correctlyAnswered = "CareFull " + name + " You will be poisoned.";
                break;
            default:
                correctlyAnswered = "Your head will be smashed by the Mountain.";
        }
        Toast toast = Toast.makeText(this, correctlyAnswered, Toast.LENGTH_LONG);
        toast.show();
    }
}