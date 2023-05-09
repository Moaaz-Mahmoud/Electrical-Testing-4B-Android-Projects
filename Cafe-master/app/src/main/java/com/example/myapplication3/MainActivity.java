package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
//import MessageBuilder

public class MainActivity extends AppCompatActivity {
    int counterOrders = 0;
    boolean hasChocolate = false;
    boolean hasWhippedCream = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Elements Variables:
        Button plusButton = findViewById(R.id.plusBut);
        Button minusButton = findViewById(R.id.minusBut);
        Button orderButton = findViewById(R.id.orderBut);
        TextView orderNum = findViewById(R.id.OrderNumbers);
        EditText nameTxt = findViewById(R.id.nameText);
        CheckBox hasWhippedCreamChk = findViewById(R.id.CreamCheck);
        CheckBox hasChocolateChk = findViewById(R.id.ChocalateCheck);

        // Plus/Minus click actions :
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counterOrders++;
                orderNum.setText(String.valueOf(counterOrders));
            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (counterOrders == 0)
                    Toast.makeText(getApplicationContext(),"Already zero!",Toast.LENGTH_SHORT).show();
                else {
                    counterOrders--;
                    orderNum.setText(String.valueOf(counterOrders));
                }
            }
        });

        // Order click action :
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String orderDetails = "";
                int totalCost = 0 , cupCost = 5;
                String userName = nameTxt.getText().toString();
                if (userName.equals("")){
                    Toast.makeText(getApplicationContext(), "Please enter your email!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!(hasWhippedCreamChk.isChecked() || hasChocolateChk.isChecked())) {
                    Toast.makeText(getApplicationContext(), "You didn't choose orders !", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (counterOrders == 0) {
                    Toast.makeText(getApplicationContext(), "You didn't choose quantity !", Toast.LENGTH_SHORT).show();
                    return;
                }

                totalCost = cupCost * counterOrders;

                if (hasWhippedCreamChk.isChecked()) {
                    orderDetails += " Whipped Cream ";
                    totalCost += counterOrders * 2;
                }
                if (hasChocolateChk.isChecked()) {
                    orderDetails += " Chocolate ";
                    totalCost += counterOrders * 3;
                }
               // Toast.makeText(getApplicationContext(),"Hello, " + userName + " Your cost is " + total_cost,Toast.LENGTH_SHORT).show();
                Intent orderIntent = new Intent(MainActivity.this,MainActivity2.class);
                orderIntent.putExtra("UserName",userName);
                orderIntent.putExtra("OrderCount" , counterOrders);
                orderIntent.putExtra("OrderDetails",orderDetails);
                orderIntent.putExtra("TotalCost",totalCost);

                startActivity(orderIntent);

                // Creating intent for name :
//                Intent orderIntent = new Intent(Intent.ACTION_SENDTO);


                hasChocolate = hasChocolateChk.isChecked();
                hasWhippedCream = hasWhippedCreamChk.isChecked();

                Intent getter = getIntent();
                String username = getter.getStringExtra("UserName");
                int orderCount = getter.getIntExtra("OrderCount",0);
                int TotalCost = getter.getIntExtra("TotalCost",0);
                String OrderDetails = getter.getStringExtra("OrderDetails");
                TextView textview = findViewById(R.id.txtview1);
                String message = "Customer: " + username + "\nAmount: " + orderCount + " Cups\nAdditions: " + OrderDetails + "\nCost: " + TotalCost;

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "moaazmahmoud108@gmail.com" });
                intent.putExtra(Intent.EXTRA_SUBJECT, "Order Confirmation");
                intent.putExtra(Intent.EXTRA_TEXT, MessageBuilder.buildMessage(counterOrders, hasChocolate, hasWhippedCream));
                startActivity(Intent.createChooser(intent, "Send email"));

            }
        });
    }

}
