package com.spectrum.androidndkplayground;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("name-generator-lib");
    }

    private EditText age;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        age = findViewById(R.id.editTextTextPersonName);
        button = findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ageValue = age.getText().toString();
                if (ageValue.trim().isEmpty()) {
                    age.setError("Enter an age");
                    return;
                }
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle(generateRandomName(Integer.parseInt(ageValue)))
                        .setMessage("is your epic mythical name")
                        .setPositiveButton(android.R.string.ok, null)
                        .show();
            }
        });
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String generateRandomName(int age);
}
