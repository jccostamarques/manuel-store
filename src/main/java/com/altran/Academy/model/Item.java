package com.altran.Academy.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name= "Item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private Integer quantidade;

    @Column
    private double precoVendido;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private  Pedido pedido;

    @OneToOne
    private Product product;


}
