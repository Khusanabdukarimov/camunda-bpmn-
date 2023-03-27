package org.natija.service;

import org.natija.model.Warehouse;
import org.natija.repository.WarehouseRep;
import org.springframework.stereotype.*;

import java.util.Optional;

@Service

public class WarehouseService {
    private final WarehouseRep warehouseRep;
    private Integer i = 0;

    public WarehouseService(WarehouseRep warehouseRep) {
        this.warehouseRep = warehouseRep;
    }

    public Warehouse create(Warehouse warehouse) {
        Warehouse warehouse1 = new Warehouse();
        warehouse1.setId(++i);
        warehouse1.setName(warehouse.getName());
        warehouse1.setSize(warehouse.getSize());
        warehouseRep.save(warehouse1);

        return warehouseRep.findByName(warehouse.getName()).get();
    }

    public Warehouse get(Integer id) {
        Optional<Warehouse> optional = warehouseRep.findById(id);

        if(optional.isEmpty())
            throw new IllegalArgumentException("number");

        return optional.get();
    }

    public int getId(String name) {
        Optional<Warehouse> optional = warehouseRep.findByName(name);

        if(optional.isEmpty()) {
            return 0;
        }

        return optional.get().getId();
    }



}
