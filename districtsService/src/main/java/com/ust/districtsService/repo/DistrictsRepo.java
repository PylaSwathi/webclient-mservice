package com.ust.districtsService.repo;

import com.ust.districtsService.model.Districts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistrictsRepo extends JpaRepository<Districts,String> {
    List<Districts> findByStateId(String stateCode);
}
