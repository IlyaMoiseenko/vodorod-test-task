package by.vodorod.vodorodtesttask.feign;

import by.vodorod.vodorodtesttask.response.RateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NationalBankApiService {

    private final NationalBankApiClient client;

    public List<RateResponse> getAllRatesByDate(LocalDate date, int periodicity) {
        return client.loadRatesByDate(date, periodicity);
    }
}
