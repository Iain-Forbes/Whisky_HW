package com.project.Whisky.Controllers;

import com.project.Whisky.Repositories.WhiskyRepository;
import com.project.Whisky.models.Whisky;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping("/whiskys")
    public ResponseEntity<List<Whisky>> getAllWhisky(
            @RequestParam(name="year", required = false) Integer year,
            @RequestParam(name="distilleryName", required = false) String distilleryName,
            @RequestParam(name="age", required = false) Integer age,
            @RequestParam(name="region", required = false) String region
    ) {
            if(distilleryName != null){
                return new ResponseEntity<>(whiskyRepository.findByDistilleryName(distilleryName), HttpStatus.OK);
            }
        {
            if(age != null){
                return new ResponseEntity<>(whiskyRepository.findDistilleryByAge(age), HttpStatus.OK);
            }
        }
            if(year !=null){
                return new ResponseEntity<>(whiskyRepository.findByYear(year), HttpStatus.OK);
        }
            if(region != null) {
                return new ResponseEntity<>(whiskyRepository.findByDistilleryRegion(region), HttpStatus.OK);
            }
            return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/whiskys/year/{year}")
    public ResponseEntity<List<Whisky>> getWhiskyByYear(@PathVariable Integer year) {
        return new ResponseEntity<>(whiskyRepository.findByYear(year), HttpStatus.OK);
    }

    @GetMapping("/whiskys/age/{age}")
    public ResponseEntity<List<Whisky>> getWhiskyByAge(@PathVariable Integer age) {
        return new ResponseEntity<>(whiskyRepository.findDistilleryByAge(age), HttpStatus.OK);
    }

}
