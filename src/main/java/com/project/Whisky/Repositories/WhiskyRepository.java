package com.project.Whisky.Repositories;

import com.project.Whisky.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {

    List<Whisky> findByYear(Integer year);
    List<Whisky> findDistilleryByAge(Integer age);
    List<Whisky> findByDistilleryName(String distilleryName);
    List<Whisky> findByDistilleryRegion(String distilleryRegion);

}
