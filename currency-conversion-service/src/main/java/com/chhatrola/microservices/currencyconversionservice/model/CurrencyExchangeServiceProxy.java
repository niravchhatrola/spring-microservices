package com.chhatrola.microservices.currencyconversionservice.model;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by niv214 on 6/5/20.
 */
//@FeignClient(name = "currency-exchange-service", url = "localhost:8000")    URL is not necessery once we configure ribbon client as it(load balancing) will be taken care by ribbon
@FeignClient(name = "currency-exchange-service")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to );

}
