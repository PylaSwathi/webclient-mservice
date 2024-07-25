package com.ust.stateService.repo;

import com.ust.stateService.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepo extends JpaRepository<State,String> {
}
