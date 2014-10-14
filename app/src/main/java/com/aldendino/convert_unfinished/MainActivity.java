package com.aldendino.convert_unfinished;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class MainActivity extends Activity {

    private EditText inputEditText;
    /**
     * Fill in the definition of the output EditText.
     */
    private TextView inputLabel;
    private TextView outputLabel;
    /**
     * Fill in the definition of the switch Button.
     */
    private Button convertButton;

    private Boolean isCtoF;
    private DecimalFormat decimalFormat;

    private String celsius;
    private String fahrenheit;
    private String celsiusLabel;
    private String fahrenheitLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        celsius = getResources().getString(R.string.celsius);
        fahrenheit = getResources().getString(R.string.fahrenheit);
        celsiusLabel = getResources().getString(R.string.celsius_label);
        fahrenheitLabel = getResources().getString(R.string.fahrenheit_label);

        inputEditText = (EditText) findViewById(R.id.inputEditText);
        /**
         * Fill in the instantiation for the output EditText.
         */
        inputLabel = (TextView) findViewById(R.id.inputLabel);
        outputLabel = (TextView) findViewById(R.id.outputLabel);
        /**
         * Fill in the instantiation for the convert Button.
         */
        convertButton = (Button) findViewById(R.id.convertButton);

        /**
         * Fill in the action for the switch Button.
         */

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display();
            }
        });

        decimalFormat = new DecimalFormat("0.0");
        isCtoF = true;
        update();
    }

    private double convert(double input) {
        double converted = 0;
        if(isCtoF) {
            /**
             * Convert "input" from Celsius to Fahrenheit
             * and assign it to "converted".
             */
        }
        else {
            /**
             * Convert "input" from Fahrenheit to Celsius
             * and assign it to "converted".
             */
        }
        return converted;
    }

    private void display() {
        String input = inputEditText.getText().toString();
        if(!input.equals("")) {
            try {
                double inputTemp = Double.parseDouble(input);
                double outputTemp = convert(inputTemp);
                String outputFormatted = decimalFormat.format(outputTemp);
                /**
                 * Set the output text to the
                 * converted and formatted value
                 */
            } catch(NullPointerException npe) {
                showToast("Input String is Null");
            } catch(NumberFormatException nfe) {
                showToast("Input String is not a Double");
            }
        } else {
            /**
             * Set the output EditText text
             * for the case where the input is blank
             */
        }
    }

    private void switchDirection() {
        isCtoF = !isCtoF;
        update();
        display();
    }

    private void update() {
        setHints();
        setLabels();
    }

    private void setHints() {
        if(isCtoF) {
            inputEditText.setHint(celsius);
            /**
             * Set the output EditText hint
             * for Celsius to Fahrenheit conversion.
             */
        } else {
            inputEditText.setHint(fahrenheit);
            /**
             * Set the output EditText hint
             * for Fahrenheit to Celsius conversion.
             */
        }
    }

    private void setLabels() {
        if(isCtoF) {
            inputLabel.setText(celsiusLabel);
            outputLabel.setText(fahrenheitLabel);
        } else {
            inputLabel.setText(fahrenheitLabel);
            outputLabel.setText(celsiusLabel);
        }
    }

    private void showToast(String message) {
        Toast.makeText(getApplication(), message, Toast.LENGTH_SHORT).show();
    }
}
