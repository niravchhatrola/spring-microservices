package com.chhatrola.microservices.currencyconversionservice.controller;

import com.chhatrola.microservices.currencyconversionservice.model.CurrencyConversionBean;
import com.chhatrola.microservices.currencyconversionservice.model.CurrencyExchangeServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Created by niv214 on 5/5/20.
 */
@RestController
public class CurrencyConversionController {

    @Autowired
    CurrencyExchangeServiceProxy proxy;

    @GetMapping("/currency-convertor/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable("from") String from, @PathVariable("to") String to, @PathVariable("quantity") BigDecimal quantity){
        CurrencyConversionBean currencyConversionBean = proxy.retrieveExchangeValue(from, to);
        currencyConversionBean.setQuantity(quantity);
        currencyConversionBean.setTotalCalculatedAmount(currencyConversionBean.getConversionMultiple().multiply(quantity));
        return currencyConversionBean;
    }
}
