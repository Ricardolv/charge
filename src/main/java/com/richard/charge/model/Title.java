package com.richard.charge.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Data
@EqualsAndHashCode(of = "code")
@Entity
public class Title {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    @NotBlank
    private String description;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date dateExpiration;

    @NotNull
    @NumberFormat(pattern = "#,##0.00")
    private BigDecimal value;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusTitle status;

    /** Business **/

    public boolean isPending() {
        return StatusTitle.PENDING.equals(this.status);
    }

}
