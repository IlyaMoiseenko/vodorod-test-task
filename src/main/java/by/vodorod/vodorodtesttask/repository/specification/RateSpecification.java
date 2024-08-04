package by.vodorod.vodorodtesttask.repository.specification;

import by.vodorod.vodorodtesttask.domain.Rate;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class RateSpecification {

    public static Specification<Rate> withCurrId(int currId) {
        return (root, query, cb) -> cb.equal(root.get("currId"), currId);
    }

    public static Specification<Rate> withDate(LocalDate date) {
        return (root, query, cb) -> cb.equal(root.get("date"), date);
    }
}
