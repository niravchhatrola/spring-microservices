package com.chhatrola.microservices.limitsservice.model;

import org.springframework.stereotype.Component;

/**
 * Created by niv214 on 3/5/20.
 */
@Component
public class LimitConfiguration {

    protected LimitConfiguration(){
    }

    public LimitConfiguration(String minimum, String maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    private String minimum;
    private String maximum;

    public String getMinimum() {
        return minimum;
    }

    public void setMinimum(String minimum) {
        this.minimum = minimum;
    }

    public String getMaximum() {
        return maximum;
    }

    public void setMaximum(String maximum) {
        this.maximum = maximum;
    }
}
