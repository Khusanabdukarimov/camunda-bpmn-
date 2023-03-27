package org.natija.service;

import lombok.AllArgsConstructor;
import org.camunda.bpm.engine.RuntimeService;
import org.natija.model.Warehouse;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProcessService {
    private final String MESSAGE_NAME = "name1";
    private final String MESSAGE_NAME_1 = "sendMessage";
    private final RuntimeService runtimeService;
    public void startThroughAPI(Warehouse warehouse) {
        runtimeService.createMessageCorrelation(MESSAGE_NAME)
                .setVariable("name", warehouse.getName())
                .setVariable("size", warehouse.getSize())
                .correlate();
    }

    public void startMessageProcess() {
        runtimeService
                .createMessageCorrelation(MESSAGE_NAME_1)
                .processInstanceBusinessKey("1")
                .correlate();
    }
}
