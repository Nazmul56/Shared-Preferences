package com.droidkings.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    Button b1;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

            ed1=(EditText)findViewById(R.id.editText);
            ed2=(EditText)findViewById(R.id.editText2);
            ed3=(EditText)findViewById(R.id.editText3);
            b1=(Button)findViewById(R.id.button);
        read_sharedprefarance();
            /**Edit the shared preference*/
            sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String n  = ed1.getText().toString();
                    String ph  = ed2.getText().toString();
                    String e  = ed3.getText().toString();
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString(Name, n);
                    editor.putString(Phone, ph);
                    editor.putString(Email, e);
                    /************ Deleting Key value from SharedPreferences *****************/

                    editor.remove(Email); // will delete key key_name3
                   // editor.remove("key_name4"); // will delete key key_name4

                    // Save the changes in SharedPreferences
                    editor.commit(); // commit changes
                    editor.commit();
                    Toast.makeText(MainActivity.this, "Thanks", Toast.LENGTH_LONG).show();
                }
            });



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void read_sharedprefarance(){
        SharedPreferences sharedPref = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        //int defaultValue = getResources().getInteger(R.string.saved_high_score_default);\
        String defaultValue = "No Value";
        String username = sharedPref.getString("nameKey",defaultValue );
        String pass = sharedPref.getString("phoneKey", defaultValue);
        String email = sharedPref.getString("emailKey", defaultValue);
        ed1.setText(username);
        ed2.setText(pass);
        ed3.setText(email);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
