package com.luxstech.repository;

import com.luxstech.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {

    Country findByCountryCode(String code);

    @Transactional
    void deleteByCountryCode(String code);

    boolean existsByCountryCode(String code);

}
