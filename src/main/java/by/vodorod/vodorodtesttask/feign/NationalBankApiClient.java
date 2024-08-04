package by.vodorod.vodorodtesttask.feign;

import by.vodorod.vodorodtesttask.response.RateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Component
@FeignClient(name = "nationalBankClient", url = "https://api.nbrb.by")
public interface NationalBankApiClient {

    @GetMapping("/exrates/rates")
    List<RateResponse> loadRatesByDate(@RequestParam(name = "ondate") LocalDate date,
                                       @RequestParam(name = "periodicity") int periodicity);
}
