package by.vodorod.vodorodtesttask.mapper;

import by.vodorod.vodorodtesttask.domain.Rate;
import by.vodorod.vodorodtesttask.response.RateResponse;
import org.springframework.stereotype.Component;

@Component
public class RateMapper {

    public Rate toDomain(RateResponse from) {
        return Rate
                .builder()
                .currId(from.getCurID())
                .date(from.getDate())
                .abbreviation(from.getCurAbbreviation())
                .scale(from.getCurScale())
                .name(from.getCurName())
                .officialRate(from.getCurOfficialRate())
                .build();
    }

    public RateResponse toResponse(Rate from) {
        return RateResponse
                .builder()
                .curID(from.getCurrId())
                .date(from.getDate())
                .curAbbreviation(from.getAbbreviation())
                .curScale(from.getScale())
                .curName(from.getName())
                .curOfficialRate(from.getOfficialRate())
                .build();
    }
}
