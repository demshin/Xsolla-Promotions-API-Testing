
package io.github.demshin.models;

import java.util.ArrayList;
import java.util.HashMap;

public class Periods {

    private ArrayList<HashMap<String, String>> periods;

    public ArrayList<HashMap<String, String>> getPeriods() {
        return periods;
    }

    public void setPeriods(ArrayList<HashMap<String, String>> periods) {
        this.periods = periods;
    }

    public static Periods getRandomPeriods() {
        Periods periods = new Periods();
        HashMap<String, String> mapOfPeriods = new HashMap<>();
        mapOfPeriods.put("from", "2018-06-09T00:00:00+04:00");
        mapOfPeriods.put("to", "2018-06-15T00:00:00+04:00");
        ArrayList<HashMap<String,String>> listOfPeriods = new ArrayList<>();
        listOfPeriods.add(mapOfPeriods);
        periods.setPeriods(listOfPeriods);

        return periods;
    }
}
