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
        HashMap<String, String> mapOfPaymentSystems1 = new HashMap<>();
        HashMap<String, String> mapOfPaymentSystems2 = new HashMap<>();
        mapOfPaymentSystems1.put("id", "24");
        mapOfPaymentSystems2.put("id", "26");
        listOfPaymentSystems.add(mapOfPaymentSystems1);
        listOfPaymentSystems.add(mapOfPaymentSystems2);
        paymentSystems.setPayment_systems(listOfPaymentSystems);

        return paymentSystems;
    }
}
