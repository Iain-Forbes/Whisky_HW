package com.project.Whisky.Controllers;

import com.project.Whisky.Repositories.DistilleryRepository;

import com.project.Whisky.models.Distillery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping("/distillery")
    public ResponseEntity<List<Distillery>> getAllDistillery() {
        return new ResponseEntity<>(distilleryRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/distillery/{region}")
    public ResponseEntity<List<Distillery>> getRegion(@PathVariable String region) {
        return new ResponseEntity<>(distilleryRepository.findByRegionIgnoreCase(region), HttpStatus.OK);
    }

}
