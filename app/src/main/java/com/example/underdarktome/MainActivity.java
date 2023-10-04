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
        findViewById(R.id.WP1B).setOnClickListener(view -> Snackbar.make(view,"You strike for " + Roll(wis) + " damage", Snackbar.LENGTH_SHORT).show());
        findViewById(R.id.WP1B).setOnClickListener(view -> Snackbar.make(view,"You strike for " + Roll(cha) + " damage", Snackbar.LENGTH_SHORT).show());

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
        return r.nextInt(dice * sides) + dice + mod;
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
    protected void GetStateKey(){
        SharedPreferences sharedPreferences = getSharedPreferences("SavedCharacters", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Name", ((EditText)findViewById(R.id.characterNameEditText)).getText().toString());
        editor.apply();
    }
    protected void UseSavedKey(String key){

    }
    enum Weapons{
        MAIN,
        OFF,
        RANGED
    }
    class WeaponStats{
        public int dice = 1;
        public int sides = 4;
        public int mod = 0;
    }

}