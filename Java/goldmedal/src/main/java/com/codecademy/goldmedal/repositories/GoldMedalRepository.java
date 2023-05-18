package com.codecademy.goldmedal.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codecademy.goldmedal.model.GoldMedal;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoldMedalRepository extends CrudRepository<GoldMedal, Integer>  {
    List<GoldMedal> findByCountryOrderByYearAsc(String country);
    List<GoldMedal> findByCountryOrderByYearDesc(String country);
    List<GoldMedal> findByCountryOrderBySeasonAsc(String country);
    List<GoldMedal> findByCountryOrderBySeasonDesc(String country);
    List<GoldMedal> findByCountryOrderByCityAsc(String country);
    List<GoldMedal> findByCountryOrderByCityDesc(String country);
    List<GoldMedal> findByCountryOrderByNameAsc(String country);
    List<GoldMedal> findByCountryOrderByNameDesc(String country);
    List<GoldMedal> findByCountryOrderByEventAsc(String country);
    List<GoldMedal> findByCountryOrderByEventDesc(String country);

    List<GoldMedal> findByCountryAndSeasonOrderByYearAsc(String country, String season);

    int countByCountry(String country);
    int countBySeason(String season);
    int countByCountryAndGender(String country, String gender);

}
