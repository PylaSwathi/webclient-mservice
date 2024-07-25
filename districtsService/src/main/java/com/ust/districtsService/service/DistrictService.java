package com.ust.districtsService.service;

import com.ust.districtsService.model.Districts;
import com.ust.districtsService.repo.DistrictsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {

    @Autowired
    private DistrictsRepo repo;

    public List<Districts> getDistricts() {
        return repo.findAll();
    }

    public Districts getDistrictById(String id) {
        return repo.findById(id).orElse(null);
    }

    public Districts saveDistrict(Districts district) {
        return repo.save(district);
    }

    public List<Districts> getDistrictsByState(String stateCode) {
        return repo.findByStateId(stateCode);
    }
}
