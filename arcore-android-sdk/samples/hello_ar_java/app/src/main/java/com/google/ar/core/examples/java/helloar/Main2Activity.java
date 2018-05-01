package com.google.ar.core.examples.java.helloar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.ArrayList;

public class Main2Activity extends Activity {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btn = (Button) findViewById(R.id.button);
        //List of items
        final CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBoxAndy);
        final CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBoxGrenade);

        checkBox1.setChecked(false);
        checkBox2.setChecked(false);

        //LaunchAR
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox1.isChecked()
                        || checkBox2.isChecked()) {
                    Intent newIntent = new Intent(Main2Activity.this, HelloArActivity.class);
                    newIntent.putExtra("checkBox1", checkBox1.isChecked());
                    newIntent.putExtra("checkBox2", checkBox2.isChecked());
                    startActivity(newIntent);
                } else if (!checkBox1.isChecked()
                        && !checkBox2.isChecked()) {
                    onCreateDialog(savedInstanceState);
                }
            }
        });

        //checking functionality
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkBox1.setChecked(isChecked);
                checkBox2.setChecked(false);
            }
        });
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkBox1.setChecked(false);
                checkBox2.setChecked(isChecked);
            }
        });
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.dialog).show();
        return builder.create();
    }
}
