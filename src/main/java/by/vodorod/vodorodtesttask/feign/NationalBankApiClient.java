package by.vodorod.vodorodtesttask.feign;

import by.vodorod.vodorodtesttask.domain.Rate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Component
@FeignClient(name = "nationalBankClient", url = "https://api.nbrb.by")
public interface NationalBankApiClient {

    @GetMapping("/exrates/rates")
    List<Rate> getRatesByDate(@RequestParam(name = "ondate") LocalDate date,
                              @RequestParam(name = "periodicity") int periodicity);

    @GetMapping("/exrates/rates/{curr-id}")
    Rate getRateByIdAndDate(@PathVariable(name = "curr-id") int id,
                                      @RequestParam(name = "ondate") LocalDate date);
}
