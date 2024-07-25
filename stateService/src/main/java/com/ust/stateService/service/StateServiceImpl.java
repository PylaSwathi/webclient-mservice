package com.ust.stateService.service;


import com.ust.stateService.dto.Districtdto;
import com.ust.stateService.dto.Responsedto;
import com.ust.stateService.dto.Statedto;
import com.ust.stateService.model.State;
import com.ust.stateService.repo.StateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Service
public class StateServiceImpl implements StateService {

    @Autowired
    private StateRepo repo;

    @Autowired
    private WebClient webClient;

    @Override
    public Optional<State> getState(String zipCode) {
        // Implement logic to fetch state from zip code
        return repo.findById(zipCode);
    }

    @Override
    public List<State> getAllStates(){
        return repo.findAll();
    }

    @Override
    public State getStateById(String id){
        return repo.findById(id).orElse(null);
    }

    @Override
    public State saveState(State state){
        return repo.save(state);
    }

//    @Override
//    public State updateState(String id, State state){
//       Optional<State> st = repo.findById(id);
//       if(st.isPresent()){
//           return repo.save(state);
//       }
//    }

    @Override
    public Responsedto getStateWithDistricts(String id){
        State state = repo.findById(id).orElseThrow(()->new RuntimeException("No state found"));
        Responsedto res = new Responsedto();
        Statedto st = mapToStateDto(state);
        List<Districtdto> dist = webClient.get()
                .uri("http://localhost:9097/districts/" +state.getStateCode())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Districtdto>>() {}).block();

        res.setState(st);
        res.setDistricts(dist);
        return res;





    }


    private Statedto mapToStateDto(State state){
        Statedto nst = new Statedto();
        nst.setStateCode(state.getStateCode());
        nst.setStateName(state.getStateName());
        return nst;
    }





}
