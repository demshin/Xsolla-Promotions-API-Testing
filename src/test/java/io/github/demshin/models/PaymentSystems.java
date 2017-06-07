package io.github.demshin.models;

import java.util.ArrayList;
import java.util.HashMap;

public class PaymentSystems {
    private ArrayList<HashMap<String, String>> payment_systems;

    public ArrayList<HashMap<String, String>> getPayment_systems() {
        return payment_systems;
    }

    public void setPayment_systems(ArrayList<HashMap<String, String>> payment_systems) {
        this.payment_systems = payment_systems;
    }

    public static PaymentSystems getRandomPaymentSystems() {
        PaymentSystems paymentSystems = new PaymentSystems();


        ArrayList<HashMap<String, String>> listOfPaymentSystems = new ArrayList<>();
        HashMap<String, String> mapOfPaymentSystems = new HashMap<>();
        mapOfPaymentSystems.put("id", "24");
        mapOfPaymentSystems.put("id", "26");
        listOfPaymentSystems.add(mapOfPaymentSystems);
        paymentSystems.setPayment_systems(listOfPaymentSystems);

        return paymentSystems;
    }
}
