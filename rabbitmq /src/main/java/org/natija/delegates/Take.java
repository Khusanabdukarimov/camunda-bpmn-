package org.natija.delegates;

import lombok.AllArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.natija.model.Warehouse;
import org.natija.service.ProductService;
import org.natija.service.WarehouseService;
import org.springframework.stereotype.*;

import javax.inject.Named;
import java.util.Objects;

@Component
@AllArgsConstructor
public class Take implements JavaDelegate {
    private final WarehouseService warehouseService;
    private final ProductService productService;
    @Override
    public void execute(DelegateExecution de) throws Exception {
        boolean is = false;

        String name = (String) de.getVariable("take_ware");
        String p_name = (String) de.getVariable("nameof");
        Integer count = (Integer) de.getVariable("count_pro");

        int n = warehouseService.getId(name);

         if(n != 0 && !Objects.isNull( productService.get(p_name))) {
            is = true;
         }

         de.setVariable("is_that", is);
    }
}
