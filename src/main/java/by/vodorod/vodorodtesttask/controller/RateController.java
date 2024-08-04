package by.vodorod.vodorodtesttask.controller;

import by.vodorod.vodorodtesttask.domain.Rate;
import by.vodorod.vodorodtesttask.mapper.RateMapper;
import by.vodorod.vodorodtesttask.repository.RateRepository;
import by.vodorod.vodorodtesttask.response.RateResponse;
import by.vodorod.vodorodtesttask.service.RateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rate")
public class RateController {

    private final RateService rateService;
    private final RateMapper rateMapper;
    private final RateRepository rateRepository;

    @GetMapping("/{curr-code}")
    public ResponseEntity<RateResponse> getRateByCodeAndDate(@PathVariable(name = "curr-code") int currCode,
                                                             @RequestParam(name = "date") LocalDate date)
    {
        Rate byCurrIdAndDate = rateService.findByCurrIdAndDate(currCode, date);

        return ResponseEntity.ok(rateMapper.toResponse(byCurrIdAndDate));
    }

    @GetMapping
    public List<Rate> getAll() {
        return rateRepository.findAll();
    }
}
