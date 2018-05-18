package com.example.ramachandrans.delta1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class main extends Activity{
    EditText t1;
    ListView l1;
    Button b1;
    List<String> sa;
    ArrayAdapter a;
    AlertDialog ad;
    String f = "stones.txt";
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        b1 = findViewById(R.id.b1);
        t1 = findViewById(R.id.t1);
        l1 = (ListView) this.findViewById(R.id.l1);
        String[] stones={};
        sa = new ArrayList<String>(Arrays.asList(stones));
        a = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,sa);
        l1.setAdapter(a);

        //load();
    }

    public void listAdd(View v){
        String s="";
        int flag=0;
        int n = (int) (Math.random()*6);
        if(n==1){
            s = "Power";
            t1.setBackgroundColor(Color.MAGENTA);
        }
        else if(n==2){
            s = "Space";
            t1.setBackgroundColor(Color.BLUE);
        }
        else if(n==3){
            s = "Time";
            t1.setBackgroundColor(Color.GREEN);
        }
        else if(n==4){
            s = "Reality";
            t1.setBackgroundColor(Color.RED);
        }
        else if(n==5){
            s = "Soul";
            t1.setBackgroundColor(Color.argb(0xFF,0xFF,0xA5,0x00));
        }
        else {
            s = "Mind";
            t1.setBackgroundColor(Color.YELLOW);
        }

        for(int i=0;i<sa.size();i++) {
            if (s.equals(sa.get(i))) {
                flag = 1;
                break;
            }
        }

        if(sa.size()<6) {
            if (flag == 0) {
                sa.add(s);
                a.notifyDataSetChanged();
                t1.setText("You have obtained the " + s + " stone");
                /*try {
                    String t1i = t1.getText().toString();
                    FileOutputStream outputStream;
                    outputStream = openFileOutput(f, MODE_PRIVATE);
                    outputStream.write(t1i.getBytes());
                    //outputStream.close();

                    BufferedReader bufferedReader;
                    bufferedReader = new BufferedReader(new InputStreamReader(openFileInput(f)));
                    StringBuilder sb = new StringBuilder();
                    while (bufferedReader.readLine() != null) {
                        sb.append(bufferedReader.readLine());
                    }
                    t1.setText(sb.toString());
                }
                catch (Exception e) {
                    e.printStackTrace();
                }*/
            }
            else{
                t1.setText(s + " stone already there");
            }
        }

        if(sa.size()>=6){
            if (flag==0) {
                b1.setText("Gauntlet ready. SNAP!");
            }
            else if(flag==1&&t1.getCurrentTextColor()==Color.WHITE){
                reset();
            }
            else if(flag == 1) {
                t1.setBackgroundColor(Color.BLACK);
                t1.setTextColor(Color.WHITE);
                t1.setText("You have wiped out half the universe...");
                b1.setText("STONES");
            }
        }
    }

    public void reset(){
        t1.setText("");
        t1.setBackgroundColor(Color.WHITE);
        t1.setTextColor(Color.BLACK);
        b1.setText("STONES");
        sa.clear();
        a.notifyDataSetChanged();
    }

    public void reset(View v){
        t1.setText("");
        t1.setBackgroundColor(Color.WHITE);
        t1.setTextColor(Color.BLACK);
        b1.setText("STONES");
        sa.clear();
        a.notifyDataSetChanged();
    }

    /*public void save(View v){
        try {
            String l1i = l1.getSelectedItem().toString();
            FileOutputStream outputStream;
            outputStream = openFileOutput(f, MODE_PRIVATE);
            outputStream.write(l1i.getBytes());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    /*public void load(View v){
        try {
            BufferedReader bufferedReader;
            bufferedReader = new BufferedReader(new InputStreamReader(openFileInput(f)));
            StringBuilder sb = new StringBuilder();
            while (bufferedReader.readLine() != null) {
                sb.append(bufferedReader.readLine());
            }
            t1.setText(sb.toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }*/
}
