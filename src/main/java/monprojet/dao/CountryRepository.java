package monprojet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import monprojet.entity.City;
import monprojet.entity.Country;

// This will be AUTO IMPLEMENTED by Spring 

public interface CountryRepository extends JpaRepository<Country, Integer> {
    @Query(value = "SELECT SUM(city.population)" +
            "FROM City" +
            "WHERE City.country_id = :id_pays", nativeQuery = true)
    public Integer populationPays(int id_pays);


    @Query(value = "SELECT country.name AS \"Pays\" , SUM(city.population) as \"Population\" "+
            "FROM city INNER JOIN country ON city.country_id = country.id"+
            "GROUP BY country.name;"
            ,nativeQuery = true )

    public List<PopulationParPays> populationParPays();
}
