package xyz.klmn.model;

import java.util.List;

/**
 * Created by mart on 16/01/2017.
 */
public class Step {

    //        @JsonIgnore
    Step nextStep;
    String label;
    String paramName;
    List<String> values;

    public Step() {
    }

    public Step(String label, String paramName, List<String> values) {
        this.label = label;
        this.paramName = paramName;
        this.values = values;
    }

    public Step getNextStep() {
        return nextStep;
    }

    public void setNextStep(Step nextStep) {
        this.nextStep = nextStep;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
}
