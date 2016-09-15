package edu.orangecoastcollege.cs273.vnguyen629.shippingcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * Controller for Shipping Calculator
 * @author Vincent Nguyen
 */
public class MainActivity extends AppCompatActivity {

    private TextView addedCostAmount;
    private TextView totalCostAmount;
    private EditText weightAmount;
    private static NumberFormat currency = NumberFormat.getCurrencyInstance();

    ShipItem newItem = new ShipItem();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addedCostAmount = (TextView) findViewById(R.id.addedCostAmountTextView);
        totalCostAmount = (TextView) findViewById(R.id.totalCostAmountTextView);

        weightAmount = (EditText) findViewById(R.id.weightEditText);
        weightAmount.addTextChangedListener(amountTextChangedListener);
    }

    private TextWatcher amountTextChangedListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            // Nothing
        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                if (s.length() > 0) {
                    int weight = Integer.parseInt(s.toString());
                    newItem.setWeight(weight);
                }
                else {
                    newItem.setWeight(0);
                }

                addedCostAmount.setText(currency.format(newItem.getAddedCost()));
                totalCostAmount.setText(currency.format(newItem.getTotalCost()));
            }
            catch (NumberFormatException err) {
                weightAmount.setText("0");
            }
        }
        @Override
        public void afterTextChanged(Editable s) {
            // Nothing
        }
    };
}
