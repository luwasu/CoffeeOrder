/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     *
     *
     */
    public void submitOrder(View view) {
        int price = calculatePrice();


        displayMessage(createOrderSummary(price));
    }


    /**
     * Calculates the price of the order.
     *
     * @return price total price
     */

    private int calculatePrice() {
        return quantity * 5;

    }

    /**
     * Calculates the price of the order.
     *
     * @return print out message after submitting order
     */

    private String createOrderSummary(int price){

        String priceMessage = "Name: Luis Santana-Holmes";
        priceMessage +=  "\nTotal: £" + price;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nThank you!";

        return priceMessage;
    }




     /**
     * This method is called when the "-" is clicked
     */

    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);

    }


    /**
     * This method is called when the "+" is clicked
     */

    public void decrement(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }



    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
}