package com.example.interstellarmission.service;

import com.example.interstellarmission.exception.ResourceNotFoundException;
import com.example.interstellarmission.model.dto.MissionLogDto;
import com.example.interstellarmission.model.entity.MissionLog;
import com.example.interstellarmission.repository.MissionLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionLogServiceImpl implements MissionLogService {

    private final MissionLogRepository repository;

    @Override
    public List<MissionLog> getAllLogs() {
        return repository.findAll();
    }

    @Override
    public MissionLog getLogById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Log not found with id: " + id));
    }

    @Override
    public MissionLog createLog(MissionLogDto dto) {
        MissionLog log = MissionLog.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .status(dto.getStatus())
                .build();
        return repository.save(log);
    }

    @Override
    public MissionLog updateLog(Long id, MissionLogDto dto) {
        MissionLog log = getLogById(id);
        log.setTitle(dto.getTitle());
        log.setContent(dto.getContent());
        log.setStatus(dto.getStatus());
        return repository.save(log);
    }

    @Override
    public void deleteLog(Long id) {
        MissionLog log = getLogById(id);
        repository.delete(log);
    }

    @Override
    public MissionLog getLogByIdAndTitle(Long id, String title) {
        return repository.findByIdAndTitle(id, title)
                .orElseThrow(() -> new ResourceNotFoundException("Log not found with id and title"));
    }

    @Override
    public List<MissionLog> getLogsByTitle(String title) {
        return repository.findByTitle(title);
    }
}
