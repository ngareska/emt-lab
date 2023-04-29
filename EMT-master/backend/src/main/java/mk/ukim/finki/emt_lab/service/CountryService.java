package mk.ukim.finki.emt_lab.service;

import mk.ukim.finki.emt_lab.model.Country;
import mk.ukim.finki.emt_lab.model.dto.CountryDto;

import java.util.List;

public interface CountryService {

    Country findById(Long id);

    List<Country> listAll();

    Country create(CountryDto country);

    Country update(Long id, CountryDto country);

    Country delete(Long id);

}
