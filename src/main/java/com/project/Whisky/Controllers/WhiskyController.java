package com.project.Whisky.Controllers;

import com.project.Whisky.Repositories.WhiskyRepository;
import com.project.Whisky.models.Whisky;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping("/whiskys")
    public ResponseEntity<List<Whisky>> getAllWhisky() {
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/whiskys/{year}")
    public ResponseEntity<List<Whisky>> getWhiskyByYear(@PathVariable Integer year) {
        return new ResponseEntity<>(whiskyRepository.findByYear(year), HttpStatus.OK);
    }
}
