package org.natija.delegates;

import lombok.AllArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.natija.model.Product;
import org.natija.model.Warehouse;
import org.natija.service.ProductService;
import org.natija.service.WarehouseService;
import org.springframework.stereotype.*;

import javax.inject.Named;



@Component
@AllArgsConstructor
public class SaveDelegate implements JavaDelegate {

    private final WarehouseService warehouseService;
    private final ProductService productService;

    @Override
    public void execute(DelegateExecution de) throws Exception {
            String name_warehouse = (String) de.getVariable("name_ware");
            Integer size = (Integer) de.getVariable("size");
            String product_name = (String) de.getVariable("pro_name");
            Integer count_pro = (Integer) de.getVariable("count");
            String brand = (String) de.getVariable("brand");
            String warehouse_p_n = (String) de.getVariable("warehouse");
             Double price = Double.valueOf((String) de.getVariable("price"));
            Warehouse warehouse = warehouseService.create(new Warehouse(name_warehouse, size));
            productService.create(new Product(product_name, count_pro, brand, price, warehouse.getId()), warehouse_p_n);

    }
}
