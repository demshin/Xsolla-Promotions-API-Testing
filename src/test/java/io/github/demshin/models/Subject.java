
package io.github.demshin.models;

import java.util.ArrayList;
import java.util.HashMap;

import static io.github.demshin.utils.Generators.getRandomName;
import static io.github.demshin.utils.Generators.getRandomNumber;

public class Subject {

    private Boolean purchase;
    private ArrayList<HashMap<String, String>> items;
    private ArrayList<Float> packages;
    private HashMap<String, ArrayList<Object>> subscriptions;
    private ArrayList<HashMap<String, Object>> digital_contents;

    public Boolean getPurchase() {
        return purchase;
    }

    public void setPurchase(Boolean purchase) {
        this.purchase = purchase;
    }

    public ArrayList<HashMap<String, String>> getItems() {
        return items;
    }

    public void setItems(ArrayList<HashMap<String, String>> items) {
        this.items = items;
    }

    public ArrayList<Float> getPackages() {
        return packages;
    }

    public void setPackages(ArrayList<Float> packages) {
        this.packages = packages;
    }

    public HashMap<String, ArrayList<Object>> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(HashMap<String, ArrayList<Object>> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public ArrayList<HashMap<String, Object>> getDigital_contents() {
        return digital_contents;
    }

    public void setDigital_contents(ArrayList<HashMap<String, Object>> digital_contents) {
        this.digital_contents = digital_contents;
    }

    public static Subject getRandomSubject() {
        Subject subject = new Subject();

        ArrayList<HashMap<String, String>> listOfItems = new ArrayList<>();
        HashMap<String, String> sku = new HashMap<>();
        sku.put("sku", "t-" + getRandomNumber(10, 99) + "-" + getRandomNumber(0, 9) + "-unique-id");
        listOfItems.add(sku);

        HashMap<String, ArrayList<Object>> subscriptions = new HashMap<>();
        ArrayList<Object> plans = new ArrayList<>();
        HashMap<String, Integer> hashMapId = new HashMap<>();
        hashMapId.put("id", getRandomNumber(1, 999999));
        plans.add(hashMapId);
        ArrayList<Object> arrayListOfProducts = new ArrayList<>();
        arrayListOfProducts.add(getRandomNumber(1, 999999));
        subscriptions.put("plans", plans);
        subscriptions.put("products", arrayListOfProducts);
        subscriptions.put("max_charges_count", null);

        ArrayList<HashMap<String, Object>> listOfDigitalContents = new ArrayList<>();
        HashMap<String, Object> digitalContents = new HashMap<>();
        digitalContents.put("id", 1);
        digitalContents.put("localized_name", getRandomName());
        ArrayList<HashMap<String, Object>> drm = new ArrayList<>();
        HashMap<String, Object> drms1 = new HashMap<>();
        drms1.put("id", 1);
        drms1.put("name", "Steam");
        HashMap<String, Object> drms2 = new HashMap<>();
        drms2.put("id", 2);
        drms2.put("name", "Playstation");
        drm.add(drms1);
        drm.add(drms2);
        digitalContents.put("drm", drm);
        listOfDigitalContents.add(digitalContents);

        subject.setPurchase(false);
        subject.setItems(listOfItems);
        subject.setPackages(null);
        subject.setSubscriptions(subscriptions);
        subject.setDigital_contents(listOfDigitalContents);

        System.out.println(subject.toString());

        return subject;
    }

    @Override
    public String toString() {
        return "{" +
                "purchase=" + purchase +
                ", items=" + items +
                ", packages=" + packages +
                ", subscriptions=" + subscriptions +
                ", digital_contents=" + digital_contents +
                '}';
    }
}
