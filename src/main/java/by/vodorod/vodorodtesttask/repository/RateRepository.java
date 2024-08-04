package by.vodorod.vodorodtesttask.repository;

import by.vodorod.vodorodtesttask.domain.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {
}
