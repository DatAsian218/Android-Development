package com.example.atriampx.donutdeliveryrequest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.NumberFormat;

public class DonutOrder extends AppCompatActivity {


    double price = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donut_order);
    }

    public void incrementRegGlazed(View view) {
        TextView qtyRegGlazed = (TextView) findViewById(R.id.qty_reg_glazed);
        int currentRegGlazed = Integer.parseInt(qtyRegGlazed.getText().toString());
        String output = Integer.toString(currentRegGlazed + 1);
        qtyRegGlazed.setText(output);
        changeQuantity(1);
        changeTotal(1);
    }

    public void decrementRegGlazed(View view) {
        TextView qtyRegGlazed = (TextView) findViewById(R.id.qty_reg_glazed);
        int currentRegGlazed = Integer.parseInt(qtyRegGlazed.getText().toString());
        if (currentRegGlazed == 0) {
            Toast.makeText(this, "Can't order negative donuts!", Toast.LENGTH_LONG).show();
        }
        else {
            String output = Integer.toString(currentRegGlazed - 1);
            qtyRegGlazed.setText(output);
            changeQuantity(0);
            changeTotal(0);
        }
    }

    public void incrementChocGlazed(View view) {
        TextView qtyChocGlazed = (TextView) findViewById(R.id.qty_choc_glazed);
        int currentChocGlazed = Integer.parseInt(qtyChocGlazed.getText().toString());
        String output = Integer.toString(currentChocGlazed + 1);
        qtyChocGlazed.setText(output);
        changeQuantity(1);
        changeTotal(1);
    }

    public void decrementChocGlazed(View view) {
        TextView qtyChocGlazed = (TextView) findViewById(R.id.qty_choc_glazed);
        int currentChocGlazed = Integer.parseInt(qtyChocGlazed.getText().toString());
        if (currentChocGlazed == 0) {
            Toast.makeText(this, "Can't order negative donuts!", Toast.LENGTH_LONG).show();
        }
        else {
            String output = Integer.toString(currentChocGlazed - 1);
            qtyChocGlazed.setText(output);
            changeQuantity(0);
            changeTotal(0);
        }
    }

    public void incrementSprinkled(View view) {
        TextView qtySprinkled = (TextView) findViewById(R.id.qty_sprinkled_glazed);
        int currentSprinkled = Integer.parseInt(qtySprinkled.getText().toString());
        String output = Integer.toString(currentSprinkled + 1);
        qtySprinkled.setText(output);
        changeQuantity(1);
        changeTotal(1);
    }

    public void decrementSprinkled(View view) {
        TextView qtySprinkled = (TextView) findViewById(R.id.qty_sprinkled_glazed);
        int currentSprinkled = Integer.parseInt(qtySprinkled.getText().toString());
        if (currentSprinkled == 0) {
            Toast.makeText(this, "Can't order negative donuts!", Toast.LENGTH_LONG).show();
        }
        else {
            String output = Integer.toString(currentSprinkled - 1);
            qtySprinkled.setText(output);
            changeQuantity(0);
            changeTotal(0);
        }
    }
    public void incrementDonutHoles(View view) {
        TextView qtyDonutHoles = (TextView) findViewById(R.id.qty_donut_holes);
        int currentDonutHoles = Integer.parseInt(qtyDonutHoles.getText().toString());
        String output = Integer.toString(currentDonutHoles + 1);
        qtyDonutHoles.setText(output);
        changeQuantity(1);
        changeTotal(1);
    }

    public void decrementDonutHoles(View view) {
        TextView qtyDonutHoles = (TextView) findViewById(R.id.qty_donut_holes);
        int currentDonutHoles = Integer.parseInt(qtyDonutHoles.getText().toString());
        if (currentDonutHoles == 0) {
            Toast.makeText(this, "Can't order negative donuts!", Toast.LENGTH_LONG).show();
        }
        else {
            String output = Integer.toString(currentDonutHoles - 1);
            qtyDonutHoles.setText(output);
            changeQuantity(0);
            changeTotal(0);
        }
    }

    public void changeQuantity(int addOrSubtract) {
        TextView totalQuantity = (TextView) findViewById(R.id.total_quantity);
        int quantity = Integer.parseInt(totalQuantity.getText().toString());
        if (addOrSubtract == 0) {
            quantity -= 1;
        }
        else {
            quantity += 1;
        }
        totalQuantity.setText(Integer.toString(quantity));
    }

    // add/subtract 1 dollar to total
    public void changeTotal(int addOrSubtract) {
        TextView totalPrice = (TextView) findViewById(R.id.total_price); // get textview
        if (addOrSubtract == 0) {
            price -= 0.69;
        }
        else {
            price += 0.69;
        }
        totalPrice.setText(NumberFormat.getCurrencyInstance().format(price));
    }

    public void checkout(View view) {
        /*
            Checkout and send information to email app
         */
        String text = "Hey Jordan,\nI'm looking to avoid the spam filter by adding some text that looks human.";
        // check if we are ordering regular glazed
        TextView regGlazed = (TextView) findViewById(R.id.qty_reg_glazed);
        int qtyRegGlazed = Integer.parseInt(regGlazed.getText().toString());
        if (qtyRegGlazed >= 1) {
            text += "\nRegular Glazed: " + Integer.toString(qtyRegGlazed);
        }
        TextView chocGlazed = (TextView) findViewById(R.id.qty_reg_glazed);
        int qtyChocGlazed = Integer.parseInt(chocGlazed.getText().toString());
        if (qtyChocGlazed >= 1) {
            text += "\nChocolate Glazed: " + Integer.toString(qtyRegGlazed);
        }
        TextView sprinkles = (TextView) findViewById(R.id.qty_reg_glazed);
        int qtySprinkles = Integer.parseInt(sprinkles.getText().toString());
        if (qtySprinkles >= 1) {
            text += "\nSprinkled Glazed: " + Integer.toString(qtyRegGlazed);
        }
        TextView donutHoles = (TextView) findViewById(R.id.qty_reg_glazed);
        int qtyDonutHoles = Integer.parseInt(donutHoles.getText().toString());
        if (qtyDonutHoles >= 1) {
            text += "\nDonut Holes: " + Integer.toString(qtyRegGlazed);
        }
        TextView totalQuantity = (TextView) findViewById(R.id.total_quantity);
        String quantity = totalQuantity.getText().toString();
        text += "\nTotal Quantity: " + quantity;
        text += "\nTotal Price: " + NumberFormat.getCurrencyInstance().format(price);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // require only email apps to handle this
//        intent.putExtra(Intent.EXTRA_EMAIL, "")
        // localized with xliff; cool stuff
        String[] addresses = {"megumi.takane@gmail.com"};
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Order for donuts ty jordan");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

}
