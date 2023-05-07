package org.natija.service;

import lombok.AllArgsConstructor;
import org.camunda.bpm.engine.RuntimeService;
import org.natija.model.Warehouse;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProcessService {
    private final RuntimeService runtimeService;
    public void startThroughAPI(Warehouse warehouse) {
        String MESSAGE_NAME = "name1";
        runtimeService.createMessageCorrelation(MESSAGE_NAME)
                .setVariable("name", warehouse.getName())
                .setVariable("size", warehouse.getSize())
                .correlate();
    }

    public void startMessageProcess() {
        String MESSAGE_NAME_1 = "sendMessage";
        runtimeService
                .createMessageCorrelation(MESSAGE_NAME_1)
                .processInstanceBusinessKey("1")
                .correlate();
    }
}
