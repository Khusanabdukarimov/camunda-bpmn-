package org.natija.service;

import lombok.AllArgsConstructor;
import org.natija.model.Product;
import org.natija.model.Warehouse;
import org.natija.repository.ProductRep;
import org.natija.repository.WarehouseRep;
import org.springframework.stereotype.*;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRep productRep;
    private final WarehouseRep warehouseRep;


    public void create(Product product, String name) {
        Warehouse warehouse = warehouseRep.findByName(name).get();
        warehouse.setSize(warehouse.getSize()-1);
        warehouseRep.save(warehouse);
        productRep.save(product);
    }

    public Product  get(String name) {
        System.out.println(name);
        Optional<Product> optionalProduct = productRep.findById(name);
        ;
        if(optionalProduct.isEmpty())
            throw new IllegalArgumentException("there is no product start with " + name);

        return optionalProduct.get();
    }

}
