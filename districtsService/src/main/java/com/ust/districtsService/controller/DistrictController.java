package com.ust.districtsService.controller;

import com.ust.districtsService.model.Districts;
import com.ust.districtsService.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/districts")
public class DistrictController {
    @Autowired
    DistrictService districtService;

    @GetMapping("/getDistricts")
    public List<Districts> getDistricts() {
        return  districtService.getDistricts();
    }

    @GetMapping("/getDistrictbyid/{id}")
    public Districts getDistById(@PathVariable String id) {
        return districtService.getDistrictById(id);
    }

    @PostMapping("/addDistrict")
    public Districts addDistrict(@RequestBody Districts district) {
        return districtService.saveDistrict(district);
    }

    @GetMapping("/{stateCode}")
    public List<Districts> getDistrictsByState(@PathVariable String stateCode){
        return districtService.getDistrictsByState(stateCode);
    }
}
