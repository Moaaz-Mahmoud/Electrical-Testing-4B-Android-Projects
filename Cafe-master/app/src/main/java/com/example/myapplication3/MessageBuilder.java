package com.example.myapplication3;

public class MessageBuilder {
    public static String buildMessage(int counterOrders, boolean hasChocolate, boolean hasWhippedCream){
        StringBuilder body = new StringBuilder();
        int cost = 6;
        body.append("ORDER CONFIRMATION\n------\n");
        body.append("You ordered " + counterOrders + "drinks\n");
        body.append("Toppings:\n");
        if(hasChocolate) {
            body.append(" - Chocolate\n");
            cost++;
        }
        if(hasWhippedCream) {
            body.append(" - Whipped Cream\n");
            cost++;
        }
        cost *= counterOrders;
        body.append("Total cost: " + cost);
        return new String(body);
    }
}
