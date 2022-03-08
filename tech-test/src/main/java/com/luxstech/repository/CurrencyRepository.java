package com.luxstech.repository;

import com.luxstech.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {

    Currency findByCode(String code);

    @Transactional
    void deleteByCountryCode(String countrycode);

    boolean existsByCode(String code);

}
