package mk.ukim.finki.emt_lab.service.impl;

import mk.ukim.finki.emt_lab.model.Country;
import mk.ukim.finki.emt_lab.model.dto.CountryDto;
import mk.ukim.finki.emt_lab.repository.CountryRepository;
import mk.ukim.finki.emt_lab.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country findById(Long id) {
        return this.countryRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Country> listAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Country create(CountryDto country) {
        Country c = new Country();

        country.setName(c.getName());

        return countryRepository.save(c);
    }

    @Override
    public Country update(Long id, CountryDto country) {
        Country c = countryRepository.findById(id).orElse(null);

        if (c == null) {
            return null;
        }

        c.setName(country.getName());

        return countryRepository.save(c);
    }

    @Override
    public Country delete(Long id) {
        Country country= this.findById(id);
        this.countryRepository.delete(country);
        return country;
    }
}
