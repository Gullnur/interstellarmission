package com.example.interstellarmission.controller;

import com.example.interstellarmission.model.dto.MissionLogDto;
import com.example.interstellarmission.model.entity.MissionLog;
import com.example.interstellarmission.service.MissionLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
@RequiredArgsConstructor
public class MissionLogController {

    private final MissionLogService service;

    @GetMapping("/getAll")
    public ResponseEntity<List<MissionLog>> getAllLogs() {
        List<MissionLog> logs = service.getAllLogs();
        return ResponseEntity.ok(logs);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<MissionLog> getLogById(@PathVariable Long id) {
        MissionLog log = service.getLogById(id);
        return ResponseEntity.ok(log);
    }

    @PostMapping("/create")
    public ResponseEntity<MissionLog> createLog(@RequestBody MissionLogDto dto) {
        MissionLog createdLog = service.createLog(dto);
        return new ResponseEntity<>(createdLog, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MissionLog> updateLog(@PathVariable Long id, @RequestBody MissionLogDto dto) {
        MissionLog updatedLog = service.updateLog(id, dto);
        return ResponseEntity.ok(updatedLog);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteLog(@PathVariable Long id) {
        service.deleteLog(id);
        return ResponseEntity.noContent().build();
    }

    // Əlavə olaraq id və title ilə axtarış
    @GetMapping("/getByIdAndTitle")
    public ResponseEntity<MissionLog> getLogByIdAndTitle(@RequestParam Long id, @RequestParam String title) {
        MissionLog log = service.getLogByIdAndTitle(id, title);
        return ResponseEntity.ok(log);
    }

    // Title-ə görə siyahı
    @GetMapping("/getByTitle")
    public ResponseEntity<List<MissionLog>> getLogsByTitle(@RequestParam String title) {
        List<MissionLog> logs = service.getLogsByTitle(title);
        return ResponseEntity.ok(logs);
    }
}
