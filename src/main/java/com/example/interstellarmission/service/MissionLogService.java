package com.example.interstellarmission.service;

import com.example.interstellarmission.model.dto.MissionLogDto;
import com.example.interstellarmission.model.entity.MissionLog;

import java.util.List;

public interface MissionLogService {
    List<MissionLog> getAllLogs();
    MissionLog getLogById(Long id);
    MissionLog createLog(MissionLogDto dto);
    MissionLog updateLog(Long id, MissionLogDto dto);
    void deleteLog(Long id);
    MissionLog getLogByIdAndTitle(Long id, String title);
    List<MissionLog> getLogsByTitle(String title);
}
