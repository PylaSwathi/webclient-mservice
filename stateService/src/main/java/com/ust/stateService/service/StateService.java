package com.ust.stateService.service;

import com.ust.stateService.dto.Responsedto;
import com.ust.stateService.dto.Statedto;
import com.ust.stateService.model.State;

import java.util.List;
import java.util.Optional;

public interface StateService {

   Optional<State> getState(String id);

   List<State> getAllStates();

   State getStateById(String id);

   State saveState(State state);

//   State updateState(String id, State state);

   Responsedto getStateWithDistricts(String id);


}
