package by.vodorod.vodorodtesttask.service;

import by.vodorod.vodorodtesttask.domain.Rate;
import by.vodorod.vodorodtesttask.exception.DomainNotFoundException;
import by.vodorod.vodorodtesttask.repository.RateRepository;
import by.vodorod.vodorodtesttask.repository.specification.RateSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RateService {

    private final RateRepository rateRepository;

    public void save(List<Rate> rates) {
        rateRepository.saveAll(rates);
    }

    public Rate findByCurrIdAndDate(int currId, LocalDate date) {
        return rateRepository.findOne(RateSpecification.withCurrId(currId).and(RateSpecification.withDate(date)))
                .orElseThrow(() -> new DomainNotFoundException(
                        Rate.class, Map.of("Curr id", String.valueOf(currId), "Date", String.valueOf(date))
                ));
    }
}
