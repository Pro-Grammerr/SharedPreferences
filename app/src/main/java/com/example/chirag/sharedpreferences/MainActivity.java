package com.example.chirag.sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView countTv;
    Button increment;
    Button go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialization.
        countTv = findViewById(R.id.count_tv);
        increment = findViewById(R.id.increment_button);
        go = findViewById(R.id.go);

        // Getting shared prefs value using the SharedPreferences object.
        final SharedPreferences prefs = MainActivity.this.getSharedPreferences(Keys.PREFS_KEY, Context.MODE_PRIVATE);
        final int cnt = prefs.getInt(Keys.COUNT, 0);

        //Displaying the shared preferences value.
        countTv.setText("Shared Prefs Value - "+ String.valueOf(cnt));

        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int value = prefs.getInt(Keys.COUNT, 0);

                //Incrementing the shared prefs, storing it and updating display.
                prefs.edit().putInt(Keys.COUNT, (value+1)).apply();
                int refreshedValue = prefs.getInt(Keys.COUNT, 0);
                countTv.setText("Shared Prefs Value - "+ String.valueOf(refreshedValue));
            }
        });

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Going to the second activity
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });

    }
}
