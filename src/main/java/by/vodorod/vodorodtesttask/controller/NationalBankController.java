package by.vodorod.vodorodtesttask.controller;

import by.vodorod.vodorodtesttask.domain.Rate;
import by.vodorod.vodorodtesttask.feign.NationalBankApiService;
import by.vodorod.vodorodtesttask.mapper.RateMapper;
import by.vodorod.vodorodtesttask.response.RateResponse;
import by.vodorod.vodorodtesttask.service.RateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bank")
public class NationalBankController {

    private final NationalBankApiService nationalBankApiService;
    private final RateService rateService;
    private final RateMapper rateMapper;

    @PostMapping("/rates")
    public ResponseEntity<String> loadAndSaveRatesByDate(@RequestParam(name = "date") LocalDate date,
                                                         @RequestParam(name = "periodicity", required = false, defaultValue = "0") int periodicity)
    {
        List<RateResponse> allRatesByDate = nationalBankApiService.getAllRatesByDate(date, periodicity);
        List<Rate> rates = allRatesByDate
                .stream()
                .map(rateMapper::toDomain)
                .toList();

        rateService.save(rates);

        return ResponseEntity.ok("Saved " + allRatesByDate.size() + " rates by date " + date);
    }
}
