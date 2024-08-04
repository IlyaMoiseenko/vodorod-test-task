package by.vodorod.vodorodtesttask.controller;

import by.vodorod.vodorodtesttask.domain.Rate;
import by.vodorod.vodorodtesttask.response.RateResponse;
import by.vodorod.vodorodtesttask.service.RateService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rate")
public class RateController {

    private final RateService rateService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping
    public ResponseEntity<RateResponse> loadRatesByDate(@RequestParam(name = "date") LocalDate date,
                                                        @RequestParam(name = "periodicity", required = false, defaultValue = "0") int periodicity) {
        List<Rate> rates = rateService.loadRatesByDate(date, periodicity);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(RateResponse
                        .builder()
                        .message("Rates loaded successfully for date: " + date)
                        .size(rates.size())
                        .build()
                );
    }

    @GetMapping("/{curr-id}")
    public ResponseEntity<Rate> getRateByIdAndDate(@PathVariable(name = "curr-id") int id,
                                                   @RequestParam(name = "date") LocalDate date) {

        return ResponseEntity.ok(rateService.loadRateByIdAndDate(id, date));
    }
}
