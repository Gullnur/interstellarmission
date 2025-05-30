package com.example.interstellarmission.model.dto;

import com.example.interstellarmission.model.entity.MissionLog.Status;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MissionLogDto {
    private String title;
    private String content;
    private Status status;
}
