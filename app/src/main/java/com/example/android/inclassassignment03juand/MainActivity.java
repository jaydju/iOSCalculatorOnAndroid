package com.example.android.inclassassignment03juand;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String mainDisplayNumber = "";
    String runningSum = "";
    boolean runSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runSum = false;
    }

    private void mainDisplayLimiter(){
        if(mainDisplayNumber.length() > 8){
            mainDisplayNumber = mainDisplayNumber.substring(0,8);
        }
    }


    private void displayNumber(String number){
        TextView mainNumber = (TextView) findViewById(R.id.main_number);
        mainNumber.setText(number);
        if(number.length()>8){
            number = number.substring(0,8);
            mainNumber.setText(number);
            mainDisplayLimiter();
        }
        else {
            mainNumber.setText(number);
        }
    }

    private void displayMain(String number){
        TextView mainNumber = (TextView) findViewById(R.id.main_num);
        mainNumber.setText("mainDisplay: " + number);
    }

    private void displayRun(String number){
        TextView mainNumber = (TextView) findViewById(R.id.run_sum);
        mainNumber.setText("runSum: " + number);
    }

    public void clickOne(View view){
        mainDisplayNumber += "1";
        runningSum += "1";
        displayNumber(mainDisplayNumber);
        displayMain(mainDisplayNumber);
        displayRun(runningSum);
    }

    public void clickTwo(View view){
        mainDisplayNumber += "2";
        runningSum += "2";
        displayNumber(mainDisplayNumber);
        displayMain(mainDisplayNumber);
        displayRun(runningSum);
    }
    public void clickThree(View view){
        mainDisplayNumber += "3";
        runningSum += "3";
        displayNumber(mainDisplayNumber);
        displayMain(mainDisplayNumber);
        displayRun(runningSum);
    }
    public void clickFour(View view){
        mainDisplayNumber += "4";
        runningSum += "4";
        displayNumber(mainDisplayNumber);
        displayMain(mainDisplayNumber);
        displayRun(runningSum);
    }
    public void clickFive(View view){
        mainDisplayNumber += "5";
        runningSum += "5";
        displayNumber(mainDisplayNumber);
        displayMain(mainDisplayNumber);
        displayRun(runningSum);
    }
    public void clickSix(View view){
        mainDisplayNumber += "6";
        runningSum += "6";
        displayNumber(mainDisplayNumber);
        displayMain(mainDisplayNumber);
        displayRun(runningSum);
    }
    public void clickSeven(View view){
        mainDisplayNumber += "7";
        runningSum += "7";
        displayNumber(mainDisplayNumber);
        displayMain(mainDisplayNumber);
        displayRun(runningSum);
    }
    public void clickEight(View view){
        mainDisplayNumber += "8";
        runningSum += "8";
        displayNumber(mainDisplayNumber);
        displayMain(mainDisplayNumber);
        displayRun(runningSum);
    }

    public void clickNine(View view) {
        mainDisplayNumber += "9";
        runningSum += "9";
        displayNumber(mainDisplayNumber);
        displayMain(mainDisplayNumber);
        displayRun(runningSum);
    }

    public void clickZero(View view){
        mainDisplayNumber += "0";
        runningSum += "0";
        displayNumber(mainDisplayNumber);
        displayMain(mainDisplayNumber);
        displayRun(runningSum);
    }

    public void clickClear(View view){
        mainDisplayNumber = "";
        runningSum = "";
        displayNumber("0");
        runSum = false;
        displayMain(mainDisplayNumber);
        displayRun(runningSum);
    }


    public void clickDel(View view){
        if (!runSum) {
            try {
                if (mainDisplayNumber.length() == 1) {
                    mainDisplayNumber = "";
                    displayNumber("0");
                } else {
                    mainDisplayNumber = mainDisplayNumber.substring(0, mainDisplayNumber.length() - 1);
                    displayNumber(mainDisplayNumber);
                }
            } catch (Exception e) {
                displayNumber("0");
            }
            runningSum = mainDisplayNumber;
        }
        displayMain(mainDisplayNumber);
        displayRun(runningSum);
    }

    //Coding a Full-Calculator

    public void clickAdd(View view){
        if(runningSum.endsWith("+") || runningSum.endsWith("-") || runningSum.endsWith("*")){
            runningSum = runningSum.substring(0, runningSum.length() - 1);
        }
        if(mainDisplayNumber.equals("") && runningSum.length() == 0){
            runningSum = 0 + "+";
        }
        else {
            int quantity = (int) eval(runningSum);
            String quantValue = Integer.toString(quantity);
            displayNumber(quantValue);
            runningSum = runningSum + "+";
        }
        mainDisplayNumber = "";
        runSum = true;
        displayMain(mainDisplayNumber);
        displayRun(runningSum);
    }

    public void clickMinus(View view){
        if(runningSum.endsWith("-") || runningSum.endsWith("+") || runningSum.endsWith("*")){
            runningSum = runningSum.substring(0, runningSum.length() - 1);
        }
        if(mainDisplayNumber.equals("") && runningSum.length() == 0){
            runningSum = 0 + "-";
        }
        else {
            int quantity = (int) eval(runningSum);
            String quantValue = Integer.toString(quantity);
            displayNumber(quantValue);
            runningSum = runningSum + "-";
        }
        mainDisplayNumber = "";
        runSum = true;
        displayMain(mainDisplayNumber);
        displayRun(runningSum);
    }

    public void clickMultiply(View view){
        if(runningSum.endsWith("-") || runningSum.endsWith("+") || runningSum.endsWith("*")){
            runningSum = runningSum.substring(0, runningSum.length() - 1);
        }
        if(mainDisplayNumber.equals("") && runningSum.length() == 0){
            runningSum = 0 + "*";
        }
        else {
            int quantity = (int) eval(runningSum);
            String quantValue = Integer.toString(quantity);
            displayNumber(quantValue);
            runningSum = runningSum + "*";
        }
        mainDisplayNumber = "";
        runSum = true;
        displayMain(mainDisplayNumber);
        displayRun(runningSum);
    }

    public void clickEquals(View view){
//        displayNumber(runningSum);
        mainDisplayNumber = "";
        try {
            if(runningSum.endsWith("+")){
                runningSum = runningSum.substring(0, runningSum.length() - 1);
            }
            int quantity = (int) eval(runningSum);
            String quantValue = Integer.toString(quantity);
            displayNumber(quantValue);
        } catch(Exception e){
            displayNumber("Not Working");
        }
        displayMain(mainDisplayNumber);
        displayRun(runningSum);
    }

//Parser: Credits to StackOverflow User
    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }


}
