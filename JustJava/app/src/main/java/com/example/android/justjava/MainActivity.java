/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 */

package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;
    boolean isCheckedCream;
    boolean isCheckedChocolate;
    CheckBox checkBoxCream;
    CheckBox checkBoxChocolate;
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice();
        checkBoxCream = (CheckBox) findViewById(R.id.notify_me_checkbox);
        checkBoxChocolate = (CheckBox) findViewById(R.id.notify_me_checkbox_choc);
        name = (EditText) findViewById(R.id.et_name);
        String value = name.getText().toString();
        isCheckedCream = checkBoxCream.isChecked();
        isCheckedChocolate = checkBoxChocolate.isChecked();
        String summary = createOrderSummary(price, isCheckedCream, isCheckedChocolate, value);
        displayMessage(summary);
    }

    /**
     * Calculates the price of the order.
     *
     *
     */
    private int  calculatePrice() {
        int price = quantity * 5;
        return price;
    }

    private String createOrderSummary(int price, boolean isCheckedCream, boolean isCheckedChocolate, String name){
        String summary = "Name:" + name +"\n" + "Add whipped Cream? " + isCheckedCream + "\n" + "Add Chocolate? " + isCheckedChocolate + "\n"+ "Quantity: 3\n" + "Total $15\n" + "Thank you!";
        return summary;
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    public void incrementOrder(View view) {
        quantity++;
        displayQuantity(quantity);
    }

    public void decrementOrder(View view) {
        quantity--;
        displayQuantity(quantity);
    }
}