package io.github.demshin.models;

import io.github.demshin.configuration.TestsConfig;

import java.util.HashMap;

import static io.github.demshin.utils.Generators.getRandomDiscount;
import static io.github.demshin.utils.Generators.getRandomName;

public class Promotion {

    public static void main(String[] args) {
        System.out.println(getRandomPromotion().toString());
    }

    private String technicalName;
    private HashMap<String, Object> label;
    private HashMap<String, Object> name;
    private HashMap<String, Object> description;
    private String projectId;

    public String getTechnicalName() {
        return technicalName;
    }

    public void setTechnicalName(String technicalName) {
        this.technicalName = technicalName;
    }

    public HashMap<String, Object> getLabel() {
        return label;
    }

    public void setLabel(HashMap<String, Object> label) {
        this.label = label;
    }

    public HashMap<String, Object> getName() {
        return name;
    }

    public void setName(HashMap<String, Object> name) {
        this.name = name;
    }

    public HashMap<String, Object> getDescription() {
        return description;
    }

    public void setDescription(HashMap<String, Object> description) {
        this.description = description;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }


    public static Promotion getRandomPromotion() {
        String name = getRandomName();
        final String DISCOUNT = getRandomDiscount();
        String id = TestsConfig.getConfig().getProjectId();

        Promotion promotion = new Promotion();
        promotion.setTechnicalName(name);
        promotion.setLabel(new HashMap<String, Object>() {{
            put("en", DISCOUNT + "% save");
        }});
        promotion.setName(new HashMap<String, Object>() {{
            put("en", DISCOUNT + "% PayPal Discount");
        }});
        promotion.setDescription(new HashMap<String, Object>() {{
            put("en", DISCOUNT + "% PayPal Discount Sample");
        }});
        promotion.setProjectId(id);

        return promotion;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "technicalName='" + technicalName + '\'' +
                ", label=" + label +
                ", name=" + name +
                ", description=" + description +
                ", projectId=" + projectId +
                '}';
    }
}
