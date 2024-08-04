package by.vodorod.vodorodtesttask.service;

import by.vodorod.vodorodtesttask.domain.Rate;
import by.vodorod.vodorodtesttask.feign.NationalBankApiClient;
import by.vodorod.vodorodtesttask.repository.RateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RateService {

    private final RateRepository rateRepository;
    private final NationalBankApiClient nationalBankApiClient;

    public List<Rate> loadRatesByDate(LocalDate date, int periodicity) {

        List<Rate> ratesByDate = nationalBankApiClient.getRatesByDate(date, periodicity);

        return rateRepository.saveAll(ratesByDate);
    }
}
