package com.ust.stateService.controller;


import com.ust.stateService.dto.Responsedto;
import com.ust.stateService.model.State;
import com.ust.stateService.service.StateService;
import com.ust.stateService.service.StateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/states")
public class StateController {

    @Autowired
    private StateServiceImpl service;

    @PostMapping("/addState")
    public ResponseEntity<State> addState(@RequestBody State state){
        return ResponseEntity.ok(service.saveState(state));
    }

    @GetMapping("/getAllStates")
    public ResponseEntity<List<State>> getAllStates() {
        return ResponseEntity.ok(service.getAllStates());
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<State> getStateById(@PathVariable String id) {
        return ResponseEntity.ok(service.getStateById(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Responsedto> getResponsedtoById(@PathVariable String id) {
        Responsedto responseDto = service.getStateWithDistricts(id);
        return ResponseEntity.ok(responseDto);
    }



}
