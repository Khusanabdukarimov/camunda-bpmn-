package org.natija.controller;

import lombok.AllArgsConstructor;
import org.natija.model.Warehouse;
import org.natija.service.ProcessService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

@RestController
@RequestMapping("/api/v1/start/process")
@AllArgsConstructor
public class ProcessController {

     private ProcessService processService;
    @PostMapping
    public ResponseEntity<?> start(Warehouse warehouse) {
        processService.startThroughAPI(warehouse);

        return ResponseEntity.ok(warehouse);
    }

}
