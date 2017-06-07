
package io.github.demshin.models;

import java.util.ArrayList;
import java.util.HashMap;

public class Periods {

    private ArrayList<HashMap<String, String>> Periods;

    public ArrayList<HashMap<String, String>> getPeriods() {
        return Periods;
    }

    public void setPeriods(ArrayList<HashMap<String, String>> periods) {
        Periods = periods;
    }

    public static Periods getRandomPeriods() {
        Periods periods = new Periods();
        HashMap<String, String> mapOfPeriods = new HashMap<>();
        mapOfPeriods.put("from", "2017-06-07T00:00:00+04:00");
        mapOfPeriods.put("to", "2017-06-10T00:00:00+04:00");
        ArrayList<HashMap<String,String>> listOfPeriods = new ArrayList<>();
        listOfPeriods.add(mapOfPeriods);
        periods.setPeriods(listOfPeriods);

        return periods;
    }
}
