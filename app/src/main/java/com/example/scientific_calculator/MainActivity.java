package com.example.scientific_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvv,radians;
Button num1,num2,num3,num4,num5,num6,num7,num8,num9,zero,plus,minus,multiplication,division,dot,clear,equalto,pi,shortclear,modulo,sin;
double value1=0.0,value2=0.0;
String symbol="",specailsymbol="",trimforsrtclr,specialornormal="",getstrspcop;
Boolean checkingoperation=true,dotbool=true,checkingspecialoperation=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvv=findViewById(R.id.tvv);
        radians=findViewById(R.id.radians);
        findview();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
           case R.id.num1:
               tvv.setText(tvv.getText() + "1");
               break;
           case R.id.num2:
               tvv.setText(tvv.getText() + "2");
               break;
           case R.id.num3:
               tvv.setText(tvv.getText() + "3");
               break;
           case R.id.num4:
               tvv.setText(tvv.getText() + "4");
               break;
           case R.id.num5:
               tvv.setText(tvv.getText() + "5");
               break;
           case R.id.num6:
               tvv.setText(tvv.getText() + "6");
               break;
           case R.id.num7:
               tvv.setText(tvv.getText() + "7");
               break;
           case R.id.num8:
               tvv.setText(tvv.getText() + "8");
               break;
           case R.id.num9:
               tvv.setText(tvv.getText() + "9");
               break;
           case R.id.zero:
               tvv.setText(tvv.getText() + "0");
               break;
           case R.id.plus:
               symbol = "+";
               setoperation();
               break;
           case R.id.minus:
               symbol = "-";
               setoperation();
               break;
           case R.id.multiply:
               symbol = "*";
               setoperation();
               break;
           case R.id.division:
               symbol = "/";
               setoperation();
               break;
           case R.id.modulo:
               symbol = "%";
               setoperation();
               break;
           case R.id.clear:
               tvv.setText("");
               checkingoperation=true;
               checkingspecialoperation=false;
               dotbool=true;
               specialornormal="";
               radians.setText("");
               break;
           case R.id.Shortclear:
               trimforsrtclr = String.valueOf(tvv.getText());
               if (trimforsrtclr.length() > 0) {
                   if((trimforsrtclr.charAt(trimforsrtclr.length()-1))=='.')
                       dotbool=true;
                   trimforsrtclr = trimforsrtclr.substring(0, trimforsrtclr.length() - 1);
                   tvv.setText(trimforsrtclr);
               }
               break;
           case R.id.dot:
               if(tvv.getText().toString().isEmpty())
                   dotbool=false;
               if(tvv.getText().toString().equals("sin")||tvv.getText().toString().equals("cos")||tvv.getText().toString().equals("tan")||tvv.getText().toString().equals("sinh")||tvv.getText().toString().equals("cosh")||tvv.getText().toString().equals("tanh")
                       ||tvv.getText().toString().equals("log")||tvv.getText().toString().equals("log10")||tvv.getText().toString().equals("sqrt"))
               {
                   dotbool=false;
               }
               if(dotbool){
               tvv.setText(tvv.getText()+".");
                   dotbool=false;
               }
               if(tvv.getText().toString().isEmpty())
                   dotbool=true;
               if(tvv.getText().toString().equals("sin")||tvv.getText().toString().equals("cos")||tvv.getText().toString().equals("tan")||tvv.getText().toString().equals("sinh")||tvv.getText().toString().equals("cosh")||tvv.getText().toString().equals("tanh")
                       ||tvv.getText().toString().equals("log")||tvv.getText().toString().equals("log10")||tvv.getText().toString().equals("sqrt"))
               {
                   dotbool=true;
               }
               break;
           case R.id.equalto:
               dotbool=false;
               if(specialornormal.isEmpty()){ }
               else if(specialornormal.equals("a")){
               if (symbol.isEmpty())
                   Toast.makeText(this, "please select operation to be performed", Toast.LENGTH_SHORT).show();
               else if(tvv.getText().toString().isEmpty())
                   Toast.makeText(this, "please enter value", Toast.LENGTH_SHORT).show();
               else {
                   value2 = Double.parseDouble(String.valueOf(tvv.getText()));
                   radians.setText(radians.getText().toString() + (tvv.getText().toString()));
                   //if symbol empty
                   switch (symbol) {//equals switch
                       case "+":
                           symbol = "";
                           tvv.setText(String.valueOf((value1 + value2)));
                               checkingoperation=true;
                           break;
                       case "-":
                           symbol = "";
                           tvv.setText(String.valueOf((value1 - value2)));
                               checkingoperation=true;
                           break;
                       case "*":
                               symbol = "";
                               tvv.setText(String.valueOf((value1 * value2)));
                               checkingoperation=true;
                           break;
                               case "/":
                               symbol = "";
                               tvv.setText(String.valueOf((value1 / value2)));
                               checkingoperation=true;
                               break;
                       case "%":
                               symbol = "";
                               tvv.setText(String.valueOf((value1 % value2)));
                               checkingoperation=true;
                               break;
                       case "pow":
                             symbol="";
                             tvv.setText(String.valueOf(Math.pow(value1,value2)));
                           checkingoperation=true;
                           break;
                   }//equals switch close
               }}//a
               if(specialornormal.equals("b")) {
                   checkingspecialoperation=false;
                   switch (specailsymbol) {
                       case "sin":
                           getstrspcop = tvv.getText().toString();
                           if (getstrspcop.substring(3).isEmpty())
                               Toast.makeText(this, "enter value", Toast.LENGTH_SHORT).show();
                           else
                               tvv.setText(String.valueOf(Math.sin(Double.parseDouble(getstrspcop.substring(3)))));
                               radians.setText("radians");
                           break;
                       case "cos":
                           getstrspcop = tvv.getText().toString();
                           if (getstrspcop.substring(3).isEmpty())
                               Toast.makeText(this, "enter value", Toast.LENGTH_SHORT).show();
                           else
                               tvv.setText(String.valueOf(Math.cos(Double.parseDouble(getstrspcop.substring(3)))));
                                radians.setText("radians");
                           break;
                       case "tan":
                           getstrspcop = tvv.getText().toString();
                           if (getstrspcop.substring(3).isEmpty())
                               Toast.makeText(this, "enter value", Toast.LENGTH_SHORT).show();
                           else
                               tvv.setText(String.valueOf(Math.tan(Double.parseDouble(getstrspcop.substring(3)))));
                           radians.setText("radians");
                           break;
                       case "sinh":
                           getstrspcop = tvv.getText().toString();
                           if (getstrspcop.substring(4).isEmpty())
                               Toast.makeText(this, "enter value", Toast.LENGTH_SHORT).show();
                           else
                               tvv.setText(String.valueOf(Math.sinh(Double.parseDouble(getstrspcop.substring(4)))));
                           radians.setText("radians");
                           break;
                       case "cosh":
                           getstrspcop = tvv.getText().toString();
                           if (getstrspcop.substring(4).isEmpty())
                               Toast.makeText(this, "enter value", Toast.LENGTH_SHORT).show();
                           else
                               tvv.setText(String.valueOf(Math.cosh(Double.parseDouble(getstrspcop.substring(4)))));
                           radians.setText("radians");
                           break;
                       case "tanh":
                           getstrspcop = tvv.getText().toString();
                           if (getstrspcop.substring(4).isEmpty())
                               Toast.makeText(this, "enter value", Toast.LENGTH_SHORT).show();
                           else
                               tvv.setText(String.valueOf(Math.tanh(Double.parseDouble(getstrspcop.substring(4)))));
                           radians.setText("radians");
                           break;
                       case "sqrt":
                           getstrspcop = tvv.getText().toString();
                           if (getstrspcop.substring(4).isEmpty())
                               Toast.makeText(this, "enter value", Toast.LENGTH_SHORT).show();
                           else
                               tvv.setText(String.valueOf(Math.sqrt(Double.parseDouble(getstrspcop.substring(4)))));
                           break;
                       case "log":
                           getstrspcop = tvv.getText().toString();
                           if (getstrspcop.substring(3).isEmpty())
                               Toast.makeText(this, "enter value", Toast.LENGTH_SHORT).show();
                           else
                               tvv.setText(String.valueOf(Math.log(Double.parseDouble(getstrspcop.substring(3)))));
                           break;
                       case "log10":
                           getstrspcop = tvv.getText().toString();
                           if (getstrspcop.substring(5).isEmpty())
                               Toast.makeText(this, "enter value", Toast.LENGTH_SHORT).show();
                           else
                               tvv.setText(String.valueOf(Math.log10(Double.parseDouble(getstrspcop.substring(5)))));
                           break;

                   }
                   checkingspecialoperation=true;
               }//b
       }//operation and numbers switch
    }//on click
    public void sin(View view) {
        trignometry("sin");
    }

    public void cos(View view) {
        trignometry("cos");
    }

    public void tan(View view) {
        trignometry("tan");
    }

    public void sinh(View view) {
        trignometry("sinh");
    }

    public void cosh(View view) {
        trignometry("cosh");
    }

    public void tanh(View view) {
        trignometry("tanh");
    }

    public void sqrt(View view) {
        trignometry("sqrt");
    }

    public void pow(View view) {
        setoperation();
        symbol = "pow";
    }

    public void log10(View view) {
        trignometry("log10");
    }

    public void log(View view) {
        trignometry("log");

    }
    public void pi(View view) {
        if(tvv.getText().toString().isEmpty())
            Toast.makeText(this, "enter value", Toast.LENGTH_SHORT).show();
        else{
            if(checkingoperation && !checkingspecialoperation){
                value2 = Double.parseDouble(String.valueOf(tvv.getText()));
                value1=22.0/7.0;
                tvv.setText(String.valueOf(value1*value2));
                checkingspecialoperation=true;
                checkingoperation=false;
            }
            else{
                Toast.makeText(this, "already operation selected", Toast.LENGTH_SHORT).show();
                checkingoperation=true;
                checkingspecialoperation=false;
                specialornormal="";
            }}
    }

    public void setoperation()
    {
        dotbool=true;
            specialornormal="a";
        if(checkingoperation && !checkingspecialoperation){
            checkingoperation=false;
        if(tvv.getText().toString().isEmpty()){
            Toast.makeText(this, "enter value", Toast.LENGTH_SHORT).show();
        }
        else value1 = Double.parseDouble(String.valueOf(tvv.getText()));
        radians.setText(String.format("%s%s", tvv.getText(), symbol));
        tvv.setText("");
        }else{
            Toast.makeText(this, "already operation selected", Toast.LENGTH_SHORT).show();
            checkingoperation=true;
            checkingspecialoperation=false;
            specialornormal="";
            if(checkingspecialoperation)
            specialornormal="b";
        }
    }
    public void trignometry(String tosetsymbol)
    {
        dotbool=true;
        radians.setText("");
        specialornormal="b";
        specailsymbol=tosetsymbol;
        if(checkingoperation){
            tvv.setText(tosetsymbol);
            checkingoperation=false;
        }
        else{
            Toast.makeText(this, "already operation selected", Toast.LENGTH_SHORT).show();
            specialornormal="";
            checkingoperation=true;
            checkingspecialoperation=false;
        }
    }

    public void findview()
    {
        num1=findViewById(R.id.num1);
        num2=findViewById(R.id.num2);
        num3=findViewById(R.id.num3);
        num4=findViewById(R.id.num4);
        num5=findViewById(R.id.num5);
        num6=findViewById(R.id.num6);
        num7=findViewById(R.id.num7);
        num8=findViewById(R.id.num8);
        num9=findViewById(R.id.num9);
        zero=findViewById(R.id.zero);
        sin=findViewById(R.id.sin);
        plus=findViewById(R.id.plus);
        minus=findViewById(R.id.minus);
        multiplication=findViewById(R.id.multiply);
        division=findViewById(R.id.division);
        modulo=findViewById(R.id.modulo);
        dot=findViewById(R.id.dot);
        pi=findViewById(R.id.pi);
        clear=findViewById(R.id.clear);
        shortclear=findViewById(R.id.Shortclear);
        equalto=findViewById(R.id.equalto);
        num1.setOnClickListener(this);
        num2.setOnClickListener(this);
        num3.setOnClickListener(this);
        num4.setOnClickListener(this);
        num5.setOnClickListener(this);
        num6.setOnClickListener(this);
        num7.setOnClickListener(this);
        num8.setOnClickListener(this);
        num9.setOnClickListener(this);
        zero.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        multiplication.setOnClickListener(this);
        division.setOnClickListener(this);
        modulo.setOnClickListener(this);
        dot.setOnClickListener(this);
        clear.setOnClickListener(this);
        shortclear.setOnClickListener(this);
        equalto.setOnClickListener(this);
    }
}