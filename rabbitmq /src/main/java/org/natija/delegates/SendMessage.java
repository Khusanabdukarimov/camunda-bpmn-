package org.natija.delegates;

import lombok.AllArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.natija.model.Product;
import org.natija.mq.Producer;
import org.natija.service.ProductService;
import org.springframework.stereotype.*;
@Component
@AllArgsConstructor
public class SendMessage implements JavaDelegate {
    private final Producer producer;
    private ProductService productService;
    @Override
    public void execute(DelegateExecution de) throws Exception {
         Product product =  productService.get((String) de.getVariable("pro_name"));
         producer.sendJsonMessage(product);

    }
}
