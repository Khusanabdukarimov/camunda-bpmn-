package org.natija.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Getter
@Setter

public class Warehouse {
    @Id
    private Integer id;

    private Integer size;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Product> products;

    public Warehouse(String name, Integer size) {
        this.name = name;
        this.size = size;
    }

    public Warehouse() {

    }
}
