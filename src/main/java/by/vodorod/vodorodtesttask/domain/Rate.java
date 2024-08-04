package by.vodorod.vodorodtesttask.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tb_rate", uniqueConstraints = @UniqueConstraint(columnNames = {"currId", "date", "abbreviation"}))
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "curr_id")
    private int currId;

    @Column(name = "date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @Column(name = "abbreviation")
    private String abbreviation;

    @Column(name = "scale")
    private int scale;

    @Column(name = "name")
    private String name;

    @Column(name = "official_rate")
    private double officialRate;
}
