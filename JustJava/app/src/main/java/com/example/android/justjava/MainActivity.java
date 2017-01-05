/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 */

package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;
    int price = 0;
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
        price = calculatePrice();
        checkBoxCream = (CheckBox) findViewById(R.id.notify_me_checkbox);
        checkBoxChocolate = (CheckBox) findViewById(R.id.notify_me_checkbox_choc);
        name = (EditText) findViewById(R.id.et_name);
        String value = name.getText().toString();
        isCheckedCream = checkBoxCream.isChecked();
        isCheckedChocolate = checkBoxChocolate.isChecked();

        if(isCheckedCream && isCheckedChocolate){
            price =  price + 3;
        }

        else if(isCheckedCream && isCheckedChocolate == false){
            price = price + 1;
        }

        else if(isCheckedChocolate && isCheckedCream == false){
            price = price + 2;
        }

        String summary = createOrderSummary(price, isCheckedCream, isCheckedChocolate, value, quantity);
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

    private String createOrderSummary(int price, boolean isCheckedCream, boolean isCheckedChocolate, String name, int quantity){
        String summary = "Name: " + name + "\n" + "Add whipped Cream? " + isCheckedCream + "\n" + "Add Chocolate? " + isCheckedChocolate + "\n"+ "Quantity: " + quantity + "\n" + "Total: " + price + "\n" + "Thank you!";
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
        if(quantity > 100){
            quantity = 100;
            Toast.makeText(this, "You can't order more than 100 cup of coffees", Toast.LENGTH_SHORT).show();
            return;
        }
        displayQuantity(quantity);
    }

    public void decrementOrder(View view) {
        quantity--;
        if(quantity < 1) {
            quantity = 1;
            Toast.makeText(this, "You can't order less than 1 cup of coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
        displayQuantity(quantity);
        }
    }
}