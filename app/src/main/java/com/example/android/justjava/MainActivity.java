/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity;
//    boolean hasWhippedCream;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * This method gives back the status of the Check Box
     *
     *
     */

//    public void hasWhippedCream(View view) {
//        boolean checked = ((CheckBox) view).isChecked();
//        Log.v("MainActivity", "the checkbox is " + checked);
//
//        hasWhippedCream = checked;
//
//        }






    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        Log.v("MainActivity", "the whipped cream checkbox is " + hasWhippedCream);
        Log.v("MainActivity", "the chocolate checkbox is " + hasChocolate);


        int price = calculatePrice();
        Log.v("MainActivity", "the price is " + price);

        displayMessage(createOrderSummary(price, hasWhippedCream, hasChocolate));
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
     * @param price of order
     * @param addWhippedCream is whether or not the user wanted whipped cream topping
     */

    private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate) {


        String priceMessage = "Name: Luis Santana-Holmes";
        priceMessage +="\nAdd whipped cream? " + addWhippedCream;
        priceMessage +="\nAdd chocolate? " + addChocolate;
        priceMessage += "\nTotal: £" + price;
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
        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}