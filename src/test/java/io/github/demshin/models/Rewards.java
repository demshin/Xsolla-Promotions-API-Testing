package io.github.demshin.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;

public class Rewards {
    private HashMap<String, String> purchase;
    @JsonProperty("package")
    private HashMap<String, String> Package;
    private HashMap<String, ArrayList<HashMap<String, String>>> item;
    private HashMap<String, String> subscription;

    public HashMap<String, String> getPurchase() {
        return purchase;
    }

    public void setPurchase(HashMap<String, String> purchase) {
        this.purchase = purchase;
    }

    public HashMap<String, String> getPackage() {
        return Package;
    }

    public void setPackage(HashMap<String, String> aPackage) {
        Package = aPackage;
    }

    public HashMap<String, ArrayList<HashMap<String, String>>> getItem() {
        return item;
    }

    public void setItem(HashMap<String, ArrayList<HashMap<String, String>>> item) {
        this.item = item;
    }

    public void setSubscription(HashMap<String, String> subscription) {
        this.subscription = subscription;
    }

    public HashMap<String, String> getSubscription() {
        return subscription;
    }


    public static Rewards getRandomRewards() {
        Rewards rewards = new Rewards();

        HashMap<String, String> mapOfPurchase = new HashMap<>();
        mapOfPurchase.put("discount_percent", "10");
        rewards.setPurchase(mapOfPurchase);

        HashMap<String, String> mapOfPackage = new HashMap<>();
        mapOfPackage.put("bonus_percent", "5");
        mapOfPackage.put("bonus_amount", "5");
        rewards.setPackage(mapOfPackage);

        HashMap<String,String> mapOfDiscount = new HashMap<>();
        mapOfDiscount.put("sku", "t-43-3-unique-id");
        mapOfDiscount.put("name", "T-34-3");
        mapOfDiscount.put("max_amount", "10");
        mapOfDiscount.put("discount_percent", "5");
        HashMap<String,String> mapOfBonus = new HashMap<>();
        mapOfBonus.put("sku", "t-43-3-unique-id");
        mapOfBonus.put("name", "T-34-3");
        mapOfBonus.put("amount", "2");
        ArrayList<HashMap<String, String>> listOfDiscount = new ArrayList<>();
        listOfDiscount.add(mapOfDiscount);
        ArrayList<HashMap<String, String>> listOfBonus = new ArrayList<>();
        listOfBonus.add(mapOfBonus);
        HashMap<String, ArrayList<HashMap<String, String>>> mapOfItem = new HashMap<>();
        mapOfItem.put("discount", listOfDiscount);
        mapOfItem.put("bonus", listOfBonus);
        rewards.setItem(mapOfItem);

        HashMap<String, String> mapOfSubscription = new HashMap<>();
        mapOfSubscription.put("trial_days", "30");
        rewards.setSubscription(mapOfSubscription);

        return rewards;
    }
}
