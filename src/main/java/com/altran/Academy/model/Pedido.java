package com.altran.Academy.model;


import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name= "Pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pedido_id")
    private Integer codigopedido;

    @Column
    private LocalDate dataPedido;

    @Column
    private String nomeComprador;

    @Column
    private Estado estado;

    @Column
    private double valorFrete;

    @OneToMany(mappedBy = "pedido",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Item> items;


}
