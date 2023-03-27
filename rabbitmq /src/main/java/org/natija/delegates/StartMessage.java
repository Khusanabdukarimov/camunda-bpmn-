package org.natija.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.natija.service.ProcessService;
import org.springframework.stereotype.*;

@Component
public class StartMessage  implements JavaDelegate {
    private final ProcessService processService;

    public StartMessage(ProcessService processService) {
        this.processService = processService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        processService.startMessageProcess();
    }
}
