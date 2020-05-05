package com.chhatrola.microservices.currencyconversionservice.controller;

import com.chhatrola.microservices.currencyconversionservice.model.CurrencyConversionBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Created by niv214 on 5/5/20.
 */
@RestController
public class CurrencyConversionController {

    @GetMapping("/currency-convertor/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable("from") String from, @PathVariable("to") String to, @PathVariable("quantity") BigDecimal quantity){
        return new CurrencyConversionBean(1l, from, to , BigDecimal.valueOf(64), BigDecimal.valueOf(1000), BigDecimal.valueOf(64000),"8100");
    }
}
