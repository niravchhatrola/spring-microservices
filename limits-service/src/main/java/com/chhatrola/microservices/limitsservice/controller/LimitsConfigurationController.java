package com.chhatrola.microservices.limitsservice.controller;

import com.chhatrola.microservices.limitsservice.config.PropertiesConfig;
import com.chhatrola.microservices.limitsservice.model.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by niv214 on 3/5/20.
 */
@RestController
public class LimitsConfigurationController {

    @Autowired
    PropertiesConfig propertiesConfig;

    @GetMapping("/limits")
    public LimitConfiguration retriveLimitsFromConfiguration(){
        return new LimitConfiguration(propertiesConfig.getMinimum(), propertiesConfig.getMaximum());
    }
}
