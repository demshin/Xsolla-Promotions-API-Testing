package io.github.demshin.models;

import io.github.demshin.configuration.TestsConfig;

import java.util.HashMap;

import static io.github.demshin.utils.Generators.getRandomDiscount;
import static io.github.demshin.utils.Generators.getRandomName;

public class Promotion {

    private String id;
    private String technical_name;
    private HashMap<String, String> label;
    private HashMap<String, String> name;
    private HashMap<String, String> description;
    private String project_id;
    private Boolean read_only;
    private Boolean enabled;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTechnical_name() {
        return technical_name;
    }

    public void setTechnical_name(String technical_name) {
        this.technical_name = technical_name;
    }

    public HashMap<String, String> getLabel() {
        return label;
    }

    public void setLabel(HashMap<String, String> label) {
        this.label = label;
    }

    public HashMap<String, String> getName() {
        return name;
    }

    public void setName(HashMap<String, String> name) {
        this.name = name;
    }

    public HashMap<String, String> getDescription() {
        return description;
    }

    public void setDescription(HashMap<String, String> description) {
        this.description = description;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public Boolean getRead_only() {
        return read_only;
    }

    public void setRead_only(Boolean read_only) {
        this.read_only = read_only;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public static Promotion getRandomPromotion() {
        String name = getRandomName();
        final String DISCOUNT = getRandomDiscount();
        String id = TestsConfig.getConfig().getProjectId();

        Promotion promotion = new Promotion();
        promotion.setTechnical_name(name);
        promotion.setLabel(new HashMap<String, String>() {{
            put("en", DISCOUNT + "% save");
        }});
        promotion.setName(new HashMap<String, String>() {{
            put("en", DISCOUNT + "% PayPal Discount");
        }});
        promotion.setDescription(new HashMap<String, String>() {{
            put("en", DISCOUNT + "% PayPal Discount Sample");
        }});
        promotion.setProject_id(id);

        return promotion;
    }
}
