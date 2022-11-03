package com.company.controller;

import com.company.model.Country;
import com.company.model.Currency;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CountryController {

    static List<Country> countryList = new ArrayList<>();
    static {
        Country country1 = new Country();
        country1.setId(1);
        country1.setName("Poland");
        country1.setCapital("Warsaw");
        country1.setCurrency(Currency.PLN);
        country1.setPopulation(38_000_000);

        Country country2 = new Country();
        country2.setId(2);
        country2.setName("Spain");
        country2.setCapital("Madrid");
        country2.setCurrency(Currency.EUR);
        country2.setPopulation(47_000_000);

        Country country3 = new Country();
        country3.setId(3);
        country3.setName("Japan");
        country3.setCapital("Tokio");
        country3.setCurrency(Currency.JPY);
        country3.setPopulation(328_000_000);

        Country country4 = new Country();
        country4.setId(4);
        country4.setName("United States");
        country4.setCapital("Washington");
        country4.setCurrency(Currency.USD);
        country4.setPopulation(126_000_000);

        countryList.add(country1);
        countryList.add(country2);
        countryList.add(country3);
        countryList.add(country4);
    }

    //TODO http://localhost:8282/healtCheck
    //TODO 192.168.33.1 - router
    //TODO 192.168.33:8282/healthCheck

    @GetMapping("/healtCheck")
    public String healtCheck(){
        return "Serwer działa i wszystko git :DDD";
    }

@   RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<Country>> getAll(){
        return ResponseEntity.ok(countryList);
    }
    @GetMapping("/getByName/{name}")
    public ResponseEntity<Country> getByName(@PathVariable String name){
        for ( Country country : countryList )
            if (country.getName().equals(name)){
                return  ResponseEntity.ok(country);
            }
        Country notfound = new Country();
        notfound.setName("Country with name"+name+"not found");
        return ResponseEntity.ok(notfound);
    }
    @GetMapping("/getByCapitalCity")
    public ResponseEntity<Country> getByCaptalCity(@RequestParam(required = false) String capitalCity){
        if (capitalCity != null){
            for (Country country : countryList){
                if (country.getCapital().equals(capitalCity)){
                    return  ResponseEntity.ok(country);
                }
            }
        }
        Country notfound = new Country();
        notfound.setCapital("Country with capital city"+capitalCity+"not Found");
        return ResponseEntity.ok(notfound);
    }
}
