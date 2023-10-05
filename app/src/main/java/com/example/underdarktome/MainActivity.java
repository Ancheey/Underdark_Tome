package com.example.underdarktome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addTextChangedListeners();
        findViewById(R.id.strengthRoll).setOnClickListener(view -> Snackbar.make(view,"You rolled a " + Roll(str) + " for Strength", Snackbar.LENGTH_SHORT).show());
        findViewById(R.id.dexterityRoll).setOnClickListener(view -> Snackbar.make(view,"You rolled a " + Roll(dex) + " for Dexterity", Snackbar.LENGTH_SHORT).show());
        findViewById(R.id.constitutionRoll).setOnClickListener(view -> Snackbar.make(view,"You rolled a " + Roll(con) + " for Constitution", Snackbar.LENGTH_SHORT).show());
        findViewById(R.id.intelligenceRoll).setOnClickListener(view -> Snackbar.make(view,"You rolled a " + Roll(in) + " for Intelligence", Snackbar.LENGTH_SHORT).show());
        findViewById(R.id.wisdomRoll).setOnClickListener(view -> Snackbar.make(view,"You rolled a " + Roll(wis) + " for Wisdom", Snackbar.LENGTH_SHORT).show());
        findViewById(R.id.charismaRoll).setOnClickListener(view -> Snackbar.make(view,"You rolled a " + Roll(cha) + " for Charisma", Snackbar.LENGTH_SHORT).show());

        findViewById(R.id.WP1B).setOnClickListener(view -> Snackbar.make(view,"You strike for " + Roll(in) + " damage", Snackbar.LENGTH_SHORT).show());
        findViewById(R.id.WP2B).setOnClickListener(view -> Snackbar.make(view,"You strike for " + Roll(wis) + " damage", Snackbar.LENGTH_SHORT).show());
        findViewById(R.id.WP3B).setOnClickListener(view -> Snackbar.make(view,"You strike for " + Roll(cha) + " damage", Snackbar.LENGTH_SHORT).show());
        LoadState();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SaveState();
    }

    int str = 0,dex = 0,con = 0,in = 0,wis = 0,cha = 0;
    protected void addTextChangedListeners(){
        ((EditText)findViewById(R.id.strengthValue)).addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try {
                    int val = (Integer.parseInt(editable.toString()) - 10) / 2;
                    str = val;
                    ((TextView)findViewById(R.id.strengthModifier)).setText(val > 0 ? "+"+val : String.valueOf(val));

                }
                catch(Exception e){}

            }
        });
        ((EditText)findViewById(R.id.dexterityValue)).addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try {
                    int val = (Integer.parseInt(editable.toString()) - 10) / 2;
                    dex = val;
                    ((TextView)findViewById(R.id.dexterityModifier)).setText(val > 0 ? "+"+val : String.valueOf(val));

                }
                catch(Exception e){}

            }
        });
        ((EditText)findViewById(R.id.constitutionValue)).addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try {
                    int val = (Integer.parseInt(editable.toString()) - 10) / 2;
                    con = val;
                    ((TextView)findViewById(R.id.constitutionModifier)).setText(val > 0 ? "+"+val : String.valueOf(val));

                }
                catch(Exception e){}

            }
        });
        ((EditText)findViewById(R.id.intelligenceValue)).addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try {
                    int val = (Integer.parseInt(editable.toString()) - 10) / 2;
                    in = val;
                    ((TextView)findViewById(R.id.intelligenceModifier)).setText(val > 0 ? "+"+val : String.valueOf(val));

                }
                catch(Exception e){}

            }
        });
        ((EditText)findViewById(R.id.wisdomValue)).addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try {
                    int val = (Integer.parseInt(editable.toString()) - 10) / 2;
                    wis = val;
                    ((TextView)findViewById(R.id.wisdomModifier)).setText(val > 0 ? "+"+val : String.valueOf(val));

                }
                catch(Exception e){}

            }
        });
        ((EditText)findViewById(R.id.charismaValue)).addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try {
                    int val = (Integer.parseInt(editable.toString()) - 10) / 2;
                    cha = val;
                    ((TextView)findViewById(R.id.charismaModifier)).setText(val > 0 ? "+"+val : String.valueOf(val));

                }
                catch(Exception e){}

            }
        });
    }
    protected int Roll(int plus){
        Random r = new Random();
        return r.nextInt(20) + 1 + plus;
    }
    protected WeaponStats GetWeaponStats(Weapons weapon){
        var stats = new WeaponStats();
        switch(weapon){
            case MAIN: {
                stats.dice = Integer.parseInt(((EditText)findViewById(R.id.WP1D)).getText().toString());
                stats.sides = Integer.parseInt(((EditText)findViewById(R.id.WP1S)).getText().toString());
                stats.mod = GetModForWeaponType(((Spinner)findViewById(R.id.WP1T)).getSelectedItem().toString());
            }
            case OFF: {
                stats.dice = Integer.parseInt(((EditText)findViewById(R.id.WP2D)).getText().toString());
                stats.sides = Integer.parseInt(((EditText)findViewById(R.id.WP2S)).getText().toString());
                stats.mod = GetModForWeaponType(((Spinner)findViewById(R.id.WP2T)).getSelectedItem().toString());
            }
            case RANGED: {
                stats.dice = Integer.parseInt(((EditText)findViewById(R.id.WP3D)).getText().toString());
                stats.sides = Integer.parseInt(((EditText)findViewById(R.id.WP3S)).getText().toString());
                stats.mod = GetModForWeaponType(((Spinner)findViewById(R.id.WP3T)).getSelectedItem().toString());
            }
        }
        return stats;
    }
    protected int Roll(int dice, int sides, int mod){
        Random r = new Random();
        return dice + r.nextInt(dice * sides) + mod;
    }
    protected int GetModForWeaponType(String Type){
        switch(Type){
            case "Finesse":
                return dex;
            case "Blunt":
                return str;
            case "Martial":
                return str + dex;
            default:
                return 0;
        }
    }
    protected void LoadState(){
        SharedPreferences prefs = getSharedPreferences("SavedCharacters", Context.MODE_PRIVATE);
        ((EditText)findViewById(R.id.characterNameEditText)).setText(prefs.getString("Name", ""));
        ((Spinner)findViewById(R.id.raceSpinner)).setSelection(prefs.getInt("Race",-1));

        ((Spinner)findViewById(R.id.class1Spinner)).setSelection(prefs.getInt("Class1",-1));
        ((Spinner)findViewById(R.id.class2Spinner)).setSelection(prefs.getInt("Class2",-1));
        ((Spinner)findViewById(R.id.class3Spinner)).setSelection(prefs.getInt("Class3",-1));

        ((EditText)findViewById(R.id.level1EditText)).setText(prefs.getString("Class1l", ""));
        ((EditText)findViewById(R.id.level2EditText)).setText(prefs.getString("Class2l", ""));
        ((EditText)findViewById(R.id.level3EditText)).setText(prefs.getString("Class3l", ""));

        ((EditText)findViewById(R.id.strengthValue)).setText(prefs.getString("S1", "10"));
        ((EditText)findViewById(R.id.dexterityValue)).setText(prefs.getString("S2", "10"));
        ((EditText)findViewById(R.id.constitutionValue)).setText(prefs.getString("S3", "10"));
        ((EditText)findViewById(R.id.intelligenceValue)).setText(prefs.getString("S4", "10"));
        ((EditText)findViewById(R.id.wisdomValue)).setText(prefs.getString("S5", "10"));
        ((EditText)findViewById(R.id.charismaValue)).setText(prefs.getString("S6", "10"));

        ((EditText)findViewById(R.id.WP1N)).setText(prefs.getString("wp1n", "Fists"));
        ((EditText)findViewById(R.id.WP2N)).setText(prefs.getString("wp2n", ""));
        ((EditText)findViewById(R.id.WP3N)).setText(prefs.getString("wp3n", ""));

        ((EditText)findViewById(R.id.WP1D)).setText(prefs.getString("wp1d", "1"));
        ((EditText)findViewById(R.id.WP2D)).setText(prefs.getString("wp2d", ""));
        ((EditText)findViewById(R.id.WP3D)).setText(prefs.getString("wp3d", ""));

        ((EditText)findViewById(R.id.WP1S)).setText(prefs.getString("wp1s", "4"));
        ((EditText)findViewById(R.id.WP2S)).setText(prefs.getString("wp2s", ""));
        ((EditText)findViewById(R.id.WP3S)).setText(prefs.getString("wp3s", ""));

        ((Spinner)findViewById(R.id.WP1T)).setSelection(prefs.getInt("wp1t",1));
        ((Spinner)findViewById(R.id.WP2T)).setSelection(prefs.getInt("wp2t",-1));
        ((Spinner)findViewById(R.id.WP3T)).setSelection(prefs.getInt("wp3t",-1));
    }
    protected void SaveState(){
        SharedPreferences sharedPreferences = getSharedPreferences("SavedCharacters", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Name", ((EditText)findViewById(R.id.characterNameEditText)).getText().toString());
        editor.putInt("Race", ((Spinner)findViewById(R.id.raceSpinner)).getSelectedItemPosition());

        editor.putInt("Class1", ((Spinner)findViewById(R.id.class1Spinner)).getSelectedItemPosition());
        editor.putInt("Class2", ((Spinner)findViewById(R.id.class2Spinner)).getSelectedItemPosition());
        editor.putInt("Class3", ((Spinner)findViewById(R.id.class3Spinner)).getSelectedItemPosition());

        editor.putString("Class1l", ((EditText)findViewById(R.id.level1EditText)).getText().toString());
        editor.putString("Class2l", ((EditText)findViewById(R.id.level1EditText)).getText().toString());
        editor.putString("Class3l", ((EditText)findViewById(R.id.level1EditText)).getText().toString());

        editor.putString("S1", ((EditText)findViewById(R.id.strengthValue)).getText().toString());
        editor.putString("S2", ((EditText)findViewById(R.id.dexterityValue)).getText().toString());
        editor.putString("S3", ((EditText)findViewById(R.id.constitutionValue)).getText().toString());
        editor.putString("S4", ((EditText)findViewById(R.id.intelligenceValue)).getText().toString());
        editor.putString("S5", ((EditText)findViewById(R.id.wisdomValue)).getText().toString());
        editor.putString("S6", ((EditText)findViewById(R.id.charismaValue)).getText().toString());

        var w1 = GetWeaponStats(Weapons.MAIN);
        String w1n = ((EditText)findViewById(R.id.WP1N)).getText().toString();
        var w2 = GetWeaponStats(Weapons.OFF);
        String w2n = ((EditText)findViewById(R.id.WP2N)).getText().toString();
        var w3 = GetWeaponStats(Weapons.RANGED);
        String w3n = ((EditText)findViewById(R.id.WP3N)).getText().toString();

        editor.putString("wp1n",w1n);
        editor.putInt("wp1d",w1.dice);
        editor.putInt("wp1s",w1.sides);
        editor.putInt("wp1t",((Spinner)findViewById(R.id.WP1T)).getSelectedItemPosition());

        editor.putString("wp2n",w2n);
        editor.putInt("wp2d",w2.dice);
        editor.putInt("wp2s",w2.sides);
        editor.putInt("wp2t",((Spinner)findViewById(R.id.WP2T)).getSelectedItemPosition());

        editor.putString("wp3n",w3n);
        editor.putInt("wp3d",w3.dice);
        editor.putInt("wp3s",w3.sides);
        editor.putInt("wp3t",((Spinner)findViewById(R.id.WP3T)).getSelectedItemPosition());

        editor.apply();
    }
    enum Weapons{
        MAIN,
        OFF,
        RANGED
    }
    class WeaponStats{
        public int dice = 0;
        public int sides = 0;
        public int mod = 0;
    }

}