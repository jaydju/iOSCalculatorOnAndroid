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

    public void clickOne(View view){
        mainDisplayNumber += "1";
        displayNumber(mainDisplayNumber);
    }

    public void clickTwo(View view){
        mainDisplayNumber += "2";
        displayNumber(mainDisplayNumber);
    }
    public void clickThree(View view){
        mainDisplayNumber += "3";
        displayNumber(mainDisplayNumber);
    }
    public void clickFour(View view){
        mainDisplayNumber += "4";
        displayNumber(mainDisplayNumber);
    }
    public void clickFive(View view){
        mainDisplayNumber += "5";
        displayNumber(mainDisplayNumber);
    }
    public void clickSix(View view){
        mainDisplayNumber += "6";
        displayNumber(mainDisplayNumber);
    }
    public void clickSeven(View view){
        mainDisplayNumber += "7";
        displayNumber(mainDisplayNumber);
    }
    public void clickEight(View view){
        mainDisplayNumber += "8";
        displayNumber(mainDisplayNumber);
    }

    public void clickNine(View view) {
        mainDisplayNumber += "9";
        runningSum += "9";
    }

    public void clickZero(View view){
        mainDisplayNumber += "0";
        runningSum += "0";
        displayNumber(mainDisplayNumber);
    }

    public void clickClear(View view){
        mainDisplayNumber = "";
        runningSum = "";
        displayNumber("0");
    }



    public void clickDel(View view){
        if(mainDisplayNumber.length() == 1){
            mainDisplayNumber = "";
            displayNumber("0");
        }
        else {
            mainDisplayNumber = mainDisplayNumber.substring(0, mainDisplayNumber.length() - 1);
            displayNumber(mainDisplayNumber);
        }
    }

    //Coding a Full-Calculator

    public void clickAdd(View view){
        runningSum = mainDisplayNumber + "+";
        mainDisplayNumber = "";
//        String number = "9+9";
//        int sum = (int) eval(number);
//        String value = String.valueOf(sum);
//        displayNumber(value);
    }

    public void clickEquals(View view){
        int quantity = (int) eval(runningSum);
        String quantValue = Integer.toString(quantity);
        displayNumber(quantValue);
    }



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
