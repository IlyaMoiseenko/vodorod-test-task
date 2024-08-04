package by.vodorod.vodorodtesttask.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RateResponse {

    private String message;
    private int size;
}
