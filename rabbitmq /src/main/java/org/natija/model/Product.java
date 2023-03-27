package org.natija.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity


@NoArgsConstructor
public class Product {
    @Id
    private String name;

    private Integer count;
    private Double price;
    private String brand;

    @ManyToOne
    private Warehouse warehouse;

    @Column(name = "id")
    private Integer warehouseId;

    public Product(String productName, Integer countPro, String brand, Double price, Integer id)  {
        this.brand = brand;
        this.count = countPro;
        this.price = price;
        this.name = productName;
        this.warehouseId = id;
    }

    public String toString() {
        return String.format("\n name: %s \n brand : %s \n count: %d \n price : %f ",
                name, brand, count, price);
    }

}
