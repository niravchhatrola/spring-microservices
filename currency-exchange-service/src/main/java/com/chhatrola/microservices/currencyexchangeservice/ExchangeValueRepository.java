package com.chhatrola.microservices.currencyexchangeservice;

import com.chhatrola.microservices.currencyexchangeservice.model.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by niv214 on 5/5/20.
 */
@Repository
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

    public ExchangeValue findByFromAndTo(String from, String to);


}
