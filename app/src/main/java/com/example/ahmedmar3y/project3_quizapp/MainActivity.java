package com.example.ahmedmar3y.project3_quizapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    ArrayList<String> questions = new ArrayList<>();
    ArrayList<String> ans1 = new ArrayList<>();
    ArrayList<String> ans2 = new ArrayList<>();
    ArrayList<String> ans3 = new ArrayList<>();
    ArrayList<String> ans4 = new ArrayList<>();
    ArrayList<String> ans5 = new ArrayList<>();
    ArrayList<String> ans6 = new ArrayList<>();
    boolean flag1 = false;
    boolean flag2 = false;
    boolean flag3 = false;
    boolean flag4 = false;
    boolean flag5 = false;
    boolean flag6 = false;

    static int scor = 0;
    Map<Integer, List<String>> answerNumber = new HashMap<>();
    //List<RadioButton> radioButtons = new ArrayList<>();
    RadioGroup[] radioGroups = new RadioGroup[3];
    // TextView question1, question2, question3, question4, question5, question6;
    TextView question[] = new TextView[6];
    RadioButton answer1[] = new RadioButton[4];
    RadioButton answer2[] = new RadioButton[4];
    RadioButton answer3[] = new RadioButton[4];

    CheckBox answ1[] = new CheckBox[4];
    CheckBox answ2[] = new CheckBox[4];
    CheckBox answ3[] = new CheckBox[4];
    ArrayList<String> checks1 = new ArrayList();
    ArrayList<String> checks1_answer = new ArrayList();

    ArrayList<String> checks2 = new ArrayList();
    ArrayList<String> checks2_answer = new ArrayList();

    ArrayList<String> checks3 = new ArrayList();
    ArrayList<String> checks3_answer = new ArrayList();

    Map<Integer, RadioButton[]> radioNumbers = new HashMap<>();
    Map<Integer, CheckBox[]> checkNumbers = new HashMap<>();


    String[] score = new String[3];
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checks1_answer.add("java");
        checks1_answer.add("php");
        checks2_answer.add("american");
        checks2_answer.add("britich");
        checks3_answer.add("eslam");
        score[0] = "yes";
        score[1] = "arabic";
        score[2] = "java";

        question[0] = (TextView) findViewById(R.id.question1_1);
        question[1] = (TextView) findViewById(R.id.question1_2);
        question[2] = (TextView) findViewById(R.id.question1_3);
        question[3] = (TextView) findViewById(R.id.question2_1);
        question[4] = (TextView) findViewById(R.id.question2_2);
        question[5] = (TextView) findViewById(R.id.question2_3);
        answer1[0] = (RadioButton) findViewById(R.id.answer1_1);
        answer1[1] = (RadioButton) findViewById(R.id.answer1_2);
        answer1[2] = (RadioButton) findViewById(R.id.answer1_3);
        answer1[3] = (RadioButton) findViewById(R.id.answer1_4);
        radioNumbers.put(0, answer1);
        answer2[0] = (RadioButton) findViewById(R.id.answer2_1);
        answer2[1] = (RadioButton) findViewById(R.id.answer2_2);
        answer2[2] = (RadioButton) findViewById(R.id.answer2_3);
        answer2[3] = (RadioButton) findViewById(R.id.answer2_4);
        radioNumbers.put(1, answer2);
        answer3[0] = (RadioButton) findViewById(R.id.answer3_1);
        answer3[1] = (RadioButton) findViewById(R.id.answer3_2);
        answer3[2] = (RadioButton) findViewById(R.id.answer3_3);
        answer3[3] = (RadioButton) findViewById(R.id.answer3_4);
        radioNumbers.put(2, answer3);


        //  -----------------------  checkboxs ----------------------------
        answ1[0] = (CheckBox) findViewById(R.id.answer4_1);
        answ1[1] = (CheckBox) findViewById(R.id.answer4_2);
        answ1[2] = (CheckBox) findViewById(R.id.answer4_3);
        answ1[3] = (CheckBox) findViewById(R.id.answer4_4);
        checkNumbers.put(0, answ1);


        answ2[0] = (CheckBox) findViewById(R.id.answer5_1);
        answ2[1] = (CheckBox) findViewById(R.id.answer5_2);
        answ2[2] = (CheckBox) findViewById(R.id.answer5_3);
        answ2[3] = (CheckBox) findViewById(R.id.answer5_4);
        checkNumbers.put(1, answ2);


        answ3[0] = (CheckBox) findViewById(R.id.answer6_1);
        answ3[1] = (CheckBox) findViewById(R.id.answer6_2);
        answ3[2] = (CheckBox) findViewById(R.id.answer6_3);
        answ3[3] = (CheckBox) findViewById(R.id.answer6_4);
        checkNumbers.put(2, answ3);



            // add the correct answer from checkBoxes to ArrayList
            for (int t = 0; t < answ1.length; t++) {

                final int finalT = t;

                final int finalT1 = t;
                answ1[t].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                        if (isChecked == false) {

                            checks1.remove(answ1[finalT1].getText().toString());

                        } else if (isChecked == true) {
                            checks1.add(answ1[finalT1].getText().toString());

                        }

                    }
                });

            }

        // add the correct answer from checkBoxes to ArrayList
        for (int t = 0; t < answ2.length; t++) {

            final int finalT = t;

            final int finalT1 = t;
            answ2[t].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    if (isChecked == false) {
                        checks2.remove(answ2[finalT1].getText().toString());

                    } else if (isChecked == true) {
                        checks2.add(answ2[finalT1].getText().toString());

                    }

                }
            });

        }


        // add the correct answer from checkBoxes to ArrayList
        for (int t = 0; t < answ3.length; t++) {

            final int finalT = t;

            final int finalT1 = t;
            answ3[t].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    if (isChecked == false) {
                        checks3.remove(answ3[finalT1].getText().toString());

                    } else if (isChecked == true) {
                        checks3.add(answ3[finalT1].getText().toString());

                    }

                }
            });

        }





        radioGroups[0] = (RadioGroup) findViewById(R.id.group1);
        radioGroups[1] = (RadioGroup) findViewById(R.id.group2);
        radioGroups[2] = (RadioGroup) findViewById(R.id.group3);

        //radioButtons.clear();

        questions.add("do you love java  ?");
        questions.add("which language you speek ?");
        questions.add("which language make mobile app ?");
        questions.add("Programming languages ?");
        questions.add("English Types ?");
        questions.add("your sons ?");


        ans1.add("yes");
        ans1.add("no");
        ans1.add("no");
        ans1.add("no");
        answerNumber.put(0, ans1);


        ans2.add("arabic");
        ans2.add("y");
        ans2.add("y");
        ans2.add("y");
        answerNumber.put(1, ans2);


        ans3.add("java");
        ans3.add("u");
        ans3.add("u");
        ans3.add("u");
        answerNumber.put(2, ans3);

        ans4.add("java");
        ans4.add("php");
        ans4.add("a");
        ans4.add("b");
        answerNumber.put(3, ans4);


        ans5.add("american");
        ans5.add("britich");
        ans5.add("a");
        ans5.add("b");
        answerNumber.put(4, ans5);

        ans6.add("eslam");
        ans6.add("mohamed");
        ans6.add("a");
        ans6.add("b");
        answerNumber.put(5, ans6);

        score[0] = "yes";
        score[1] = "arabic";
        score[2] = "java";


        for (int i = 0; i < questions.size(); i++) {

            question[i].setText(questions.get(i));


        }
        for (int y = 0; y < radioNumbers.size(); y++) {
            RadioButton[] radioButton = radioNumbers.get(y);

            CheckBox[] checkBoxes = checkNumbers.get(y);

            List<String> ans = answerNumber.get(y);
            List<String> ansss = answerNumber.get(y + 3);
            for (int j = 0; j < radioButton.length; j++) {
                radioButton[j].setText(ans.get(j));

            }
            for (int j = 0; j < checkBoxes.length; j++) {
                checkBoxes[j].setText(ansss.get(j));

            }


        }

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    // button click action
    public void ButtonClick(View view) {
        scor = 0;

        if (flag1 && flag2 && flag3 && flag4) {

            //------------------- radio buttons ----------------
            for (int i = 0; i < radioGroups.length; i++) {

                // get selected radio button from radioGroup
                int selectedId = radioGroups[i].getCheckedRadioButtonId();

                // find the radiobutton by returned id
                RadioButton radioButton = (RadioButton) findViewById(selectedId);

                if (radioButton.getText().toString().trim().equals(score[i])) {
                    ++scor;
                }
            }
            //----------------- check boxes  ---------------------

            if(checks1.equals(checks1_answer)){
                ++scor;

            }
            if(checks2.equals(checks2_answer)){
                ++scor;

            }
            if(checks3.equals(checks3_answer)){
                ++scor;

            }

            Toast.makeText(this, "Score Is : " + String.valueOf(scor), Toast.LENGTH_SHORT).show();


        } else {

            Toast.makeText(this, "......", Toast.LENGTH_SHORT).show();

        }

    }

    public void ans11(View view) {
        flag1 = true;

    }

    public void ans12(View view) {
        flag1 = true;

    }

    public void ans13(View view) {
        flag1 = true;

    }

    public void ans14(View view) {
        flag1 = true;

    }

    public void ans21(View view) {
        flag2 = true;

    }

    public void ans22(View view) {
        flag2 = true;

    }

    public void ans23(View view) {
        flag2 = true;

    }

    public void ans24(View view) {
        flag2 = true;

    }

    public void ans31(View view) {
        flag3 = true;

    }

    public void ans32(View view) {
        flag3 = true;

    }

    public void ans33(View view) {
        flag3 = true;

    }

    public void ans34(View view) {
        flag3 = true;

    }

    //------------------- check Buttons ---------------------

    public void ans41(View view) {
        flag4 = true;

    }

    public void ans42(View view) {
        flag4 = true;

    }

    public void ans43(View view) {
        flag4 = true;

    }

    public void ans44(View view) {
        flag4 = true;

    }


    public void ans51(View view) {
        flag5 = true;

    }

    public void ans52(View view) {
        flag5 = true;

    }

    public void ans53(View view) {
        flag5 = true;

    }

    public void ans54(View view) {
        flag5 = true;

    }


    public void ans61(View view) {
        flag6 = true;

    }

    public void ans62(View view) {
        flag6 = true;

    }

    public void ans63(View view) {
        flag6 = true;

    }

    public void ans64(View view) {
        flag6 = true;

    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
