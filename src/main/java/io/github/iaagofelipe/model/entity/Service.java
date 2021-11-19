package io.github.iaagofelipe.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;

    @Column(nullable = false)
    private BigDecimal value;
}
