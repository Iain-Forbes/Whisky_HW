package com.project.Whisky.Repositories;

import com.project.Whisky.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {
}
