package com.arasvitkus.ezweather;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class ChangeCityController extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Set layout view
        setContentView(R.layout.change_city_layout);

        //Find the constraints in layout
        final EditText editTextField = findViewById(R.id.queryET);
        ImageButton backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //Action Listener for changing the city textfield
        editTextField.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                //Get text for new city
                String newCity = editTextField.getText().toString();
                //New intent from weather controller class
                Intent newCityIntent = new Intent(ChangeCityController.this, WeatherController.class);
                newCityIntent.putExtra("City", newCity);
                //startActivity(newCityIntent);
                setResult(Activity.RESULT_OK, newCityIntent);
                finish();
                return false;
            }
        });

    }
}
