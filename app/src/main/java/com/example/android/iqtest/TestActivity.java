package com.example.android.iqtest;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.MessageFormat;
import java.util.ArrayList;

/**
 * Created by v4 on 24/01/2018.
 * must implement  RadioGroup.OnCheckedChangeListener interface to implement abstract method onCheckedChanged
 */
public class TestActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    public static final String EXAME_TAKED = "exameTaked";
    // Edit text of question 1
    EditText question1Answer;
    //The cjeck boxs of quastion 2
    CheckBox correctCheckbox1ForQ2, correctCheckbox2ForQ2, wrongCheckbox1ForQ2, wrongCheckbox2ForQ2, wrongCheckbox3ForQ2, wrongCheckbox4ForQ2;
    //The radio groups of questions from 3 to 10
    RadioGroup rgq3, rgq4, rgq5, rgq6, rgq7, rgq8, rgq9, rgq10;
    //Array list of radio groups
    ArrayList<RadioGroup> radioGroups = new ArrayList<>();
    //The radio buttons of questions from 3 to 10
    RadioButton question3CorrectAnswer, question4CorrectAnswer, question5CorrectAnswer, question6CorrectAnswer, question7CorrectAnswer,
            question8CorrectAnswer, question9CorrectAnswer, question10CorrectAnswer;
    //Array list of correct radio buttons
    ArrayList<RadioButton> correctAnswer = new ArrayList<>();
    //Array list of checked radio buttons
    ArrayList<RadioButton> checkedAnswer = new ArrayList<>();
    // The text view of full answer of all question
    TextView question1FullAnswer, question2FullAnswer, question3FullAnswer, question4FullAnswer, question5FullAnswer, question6FullAnswer,
            question7FullAnswer, question8FullAnswer, question9FullAnswer, question10FullAnswer;
    //Array list of full answers
    ArrayList<TextView> fullAnswer = new ArrayList<>();
    //The total score
    int score = 0;
    // Scroll viw of the test activity
    ScrollView scrolTest;
    //Show if the applicant finished the exam or not to avoid taking it twice
    boolean exameTaked = false;
    //the name and the age sended from main activity
    String name, age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        InitilizViews();

    }

    /**
     * This method initialize all views and arrayes
     */
    public void InitilizViews() {
        //Initalize edit text of question 1
        question1Answer = findViewById(R.id.Q1_A);
        //Initialize the check boxes of question 2
        correctCheckbox1ForQ2 = findViewById(R.id.Q2_CA1);
        correctCheckbox2ForQ2 = findViewById(R.id.Q2_CA2);
        wrongCheckbox1ForQ2 = findViewById(R.id.Q2_A1);
        wrongCheckbox2ForQ2 = findViewById(R.id.Q2_A2);
        wrongCheckbox3ForQ2 = findViewById(R.id.Q2_A3);
        wrongCheckbox4ForQ2 = findViewById(R.id.Q2_A4);
        //Initilize tha rdio goup array list
        radioGroups.add(rgq3 = findViewById(R.id.rg_Q3));
        radioGroups.add(rgq4 = findViewById(R.id.rg_Q4));
        radioGroups.add(rgq5 = findViewById(R.id.rg_Q5));
        radioGroups.add(rgq6 = findViewById(R.id.rg_Q6));
        radioGroups.add(rgq7 = findViewById(R.id.rg_Q7));
        radioGroups.add(rgq8 = findViewById(R.id.rg_Q8));
        radioGroups.add(rgq9 = findViewById(R.id.rg_Q9));
        radioGroups.add(rgq10 = findViewById(R.id.rg_Q10));
        //set the setOnCheckedChangeListener of all radio groups
        rgq3.setOnCheckedChangeListener(this);
        rgq4.setOnCheckedChangeListener(this);
        rgq5.setOnCheckedChangeListener(this);
        rgq6.setOnCheckedChangeListener(this);
        rgq7.setOnCheckedChangeListener(this);
        rgq8.setOnCheckedChangeListener(this);
        rgq9.setOnCheckedChangeListener(this);
        rgq10.setOnCheckedChangeListener(this);
        // initialize the correct answer radio buttons
        correctAnswer.add(question3CorrectAnswer = findViewById(R.id.Q3_A2));
        correctAnswer.add(question4CorrectAnswer = findViewById(R.id.Q4_A5));
        correctAnswer.add(question5CorrectAnswer = findViewById(R.id.Q5_A1));
        correctAnswer.add(question6CorrectAnswer = findViewById(R.id.Q6_A1));
        correctAnswer.add(question7CorrectAnswer = findViewById(R.id.Q7_A1));
        correctAnswer.add(question8CorrectAnswer = findViewById(R.id.Q8_A5));
        correctAnswer.add(question9CorrectAnswer = findViewById(R.id.Q9_A2));
        correctAnswer.add(question10CorrectAnswer = findViewById(R.id.Q10_A1));
        //Intialize checked answer array ba the correct buttons temporary
        checkedAnswer.add(question3CorrectAnswer = findViewById(R.id.Q3_A2));
        checkedAnswer.add(question4CorrectAnswer = findViewById(R.id.Q4_A5));
        checkedAnswer.add(question5CorrectAnswer = findViewById(R.id.Q5_A1));
        checkedAnswer.add(question6CorrectAnswer = findViewById(R.id.Q6_A1));
        checkedAnswer.add(question7CorrectAnswer = findViewById(R.id.Q7_A1));
        checkedAnswer.add(question8CorrectAnswer = findViewById(R.id.Q8_A5));
        checkedAnswer.add(question9CorrectAnswer = findViewById(R.id.Q9_A2));
        checkedAnswer.add(question10CorrectAnswer = findViewById(R.id.Q10_A1));
        //Initialize the correct anser array
        fullAnswer.add(question1FullAnswer = findViewById(R.id.question_1_answer));
        fullAnswer.add(question2FullAnswer = findViewById(R.id.question_2_answer));
        fullAnswer.add(question3FullAnswer = findViewById(R.id.question_3_answer));
        fullAnswer.add(question4FullAnswer = findViewById(R.id.question_4_answer));
        fullAnswer.add(question5FullAnswer = findViewById(R.id.question_5_answer));
        fullAnswer.add(question6FullAnswer = findViewById(R.id.question_6_answer));
        fullAnswer.add(question7FullAnswer = findViewById(R.id.question_7_answer));
        fullAnswer.add(question8FullAnswer = findViewById(R.id.question_8_answer));
        fullAnswer.add(question9FullAnswer = findViewById(R.id.question_9_answer));
        fullAnswer.add(question10FullAnswer = findViewById(R.id.question_10_answer));
        //Initialize Scroll viw of the test activity
        scrolTest = findViewById(R.id.scrol_view_test);
    }
    /**
     * To save on rotating
     */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putBoolean(EXAME_TAKED, exameTaked);
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }
    /**
     * To restore
     */
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);
        exameTaked = savedInstanceState.getBoolean(EXAME_TAKED);
    }
    /**
     * method onCheckedChanged of radio groups
     * increase the score if correct answer
     *
     * @param group radio group
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        for (int i = 0; i < radioGroups.size(); i++) {
            if (group.equals(radioGroups.get(i))) {
                checkedAnswer.set(i, (RadioButton) findViewById(group.getCheckedRadioButtonId()));
                if (correctAnswer.get(i).isChecked()) {
                    score++;
                    break;
                }
            }
        }
    }

    /**
     * calculate the question one (Edit text) score and
     * question 2 (check box)score
     */
    public void calculatQ1and2Score() {
        if (correctCheckbox1ForQ2.isChecked() && correctCheckbox2ForQ2.isChecked() && !wrongCheckbox1ForQ2.isChecked()
                && !wrongCheckbox2ForQ2.isChecked() && !wrongCheckbox3ForQ2.isChecked() && !wrongCheckbox4ForQ2.isChecked()) {
            score++;
        }
        if (question1Answer.getText().toString().equals(getString(R.string.Question_one_answer))) {
            score++;
        }
    }

    /**
     * This method checks if the all questions answerd
     */
    public boolean answerAll() {
        boolean answer1, answer2, answer3To10;
        answer1 = !question1Answer.getText().toString().equals("");
        answer2 = (correctCheckbox1ForQ2.isChecked() || correctCheckbox2ForQ2.isChecked() || wrongCheckbox1ForQ2.isChecked()
                || wrongCheckbox2ForQ2.isChecked() || wrongCheckbox3ForQ2.isChecked() || wrongCheckbox4ForQ2.isChecked());
        answer3To10 = true;
        for (RadioGroup rg : radioGroups) {
            if (rg.getCheckedRadioButtonId() == -1) {
                answer3To10 = false;
                break;
            }
        }
        return answer1 && answer2 && answer3To10;
    }
    /**
     * This method when on click sacore buttons
     * if the student didn't answer all question
     * or take the exam befor it can't show the score
     */
    @SuppressLint("DefaultLocale")
    public void showScore(View view) {
        if (exameTaked) {
            Toast.makeText(this, R.string.you_already_examed, Toast.LENGTH_SHORT).show();
            return;
        }
        if (!answerAll()) {
            Toast.makeText(this, R.string.answer_all_msg, Toast.LENGTH_SHORT).show();
            return;
        }
        calculatQ1and2Score();
        exameTaked = true;

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.activity_toast,
                (ViewGroup) findViewById(R.id.toast_layout));
        Intent i = getIntent();
        name = i.getStringExtra(MainActivity.THE_NAME);
        age = i.getStringExtra(MainActivity.THT_AGE);

        // Set the Text to show in TextView
        TextView text01 = layout.findViewById(R.id.result_congrats);
        text01.setText(getString(R.string.welcome, name));

        TextView text02 = layout.findViewById(R.id.score);
        text02.setText(MessageFormat.format("{0}{1}{2}", String.format("%d", score),
                getString(R.string.of10), getString(R.string.points)));

        // show the toast
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();

    }

    /**
     * This method checks if the all questions answerd
     */
    public void showAnswer(View view) {
        //To start the scroll view from the top
        scrolTest.smoothScrollTo(0, 0);
        //show all full answer
        for (TextView fullAns : fullAnswer) {
            fullAns.setVisibility(View.VISIBLE);
            fullAns.setTextColor(getResources().getColor(R.color.correctAnswer));
        }
        //color Question 1 answer
        if (!question1Answer.getText().toString().equals(getString(R.string.Question_one_answer))) {
            question1Answer.setText(String.format("%s %s", question1Answer.getText(), getString(R.string.wrong_chosen)));
            question1Answer.setTextColor(getResources().getColor(R.color.wrongAnswer));
        } else {
            question1Answer.setTextColor(getResources().getColor(R.color.correctAnswer));
        }
        //color Question c answer
        if (wrongCheckbox1ForQ2.isChecked()) {
            wrongCheckbox1ForQ2.setText(String.format("%s %s", wrongCheckbox1ForQ2.getText(), getString(R.string.wrong_chosen)));
            wrongCheckbox1ForQ2.setTextColor(getResources().getColor(R.color.wrongAnswer));
        } if (wrongCheckbox2ForQ2.isChecked()) {
            wrongCheckbox2ForQ2.setText(String.format("%s %s", wrongCheckbox2ForQ2.getText(), getString(R.string.wrong_chosen)));
            wrongCheckbox2ForQ2.setTextColor(getResources().getColor(R.color.wrongAnswer));
        }if (wrongCheckbox3ForQ2.isChecked()) {
            wrongCheckbox3ForQ2.setText(String.format("%s %s", wrongCheckbox3ForQ2.getText(), getString(R.string.wrong_chosen)));
            wrongCheckbox3ForQ2.setTextColor(getResources().getColor(R.color.wrongAnswer));
        } if (wrongCheckbox4ForQ2.isChecked()) {
            wrongCheckbox4ForQ2.setText(String.format("%s %s", wrongCheckbox4ForQ2.getText(), getString(R.string.wrong_chosen)));
            wrongCheckbox3ForQ2.setTextColor(getResources().getColor(R.color.wrongAnswer));
        } if (correctCheckbox1ForQ2.isChecked()) {
            correctCheckbox1ForQ2.setTextColor(getResources().getColor(R.color.correctAnswer));
        } if (correctCheckbox1ForQ2.isChecked()) {
            correctCheckbox2ForQ2.setTextColor(getResources().getColor(R.color.correctAnswer));
        }

        //color Questions 3 to 10 answers
        for (int i = 0; i < radioGroups.size(); i++) {
            correctAnswer.get(i).setTextColor(getResources().getColor(R.color.correctAnswer));
            checkedAnswer.get(i).setTypeface(null, Typeface.BOLD);
            if (!correctAnswer.get(i).equals(checkedAnswer.get(i))) {
                checkedAnswer.get(i).setText(String.format("%s %s", checkedAnswer.get(i).getText(), getString(R.string.wrong_chosen)));
                checkedAnswer.get(i).setTextColor(getResources().getColor(R.color.wrongAnswer));
            }
        }
    }

    @Override
    public void onBackPressed() {
        Intent mainAct = new Intent(this, MainActivity.class);
        startActivity(mainAct);
        this.finish();
    }
}