package com.example.interstellarmission.repository;

import com.example.interstellarmission.model.entity.MissionLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MissionLogRepository extends JpaRepository<MissionLog, Long> {
    Optional<MissionLog> findByIdAndTitle(Long id, String title);
    List<MissionLog> findByTitle(String title);
}
