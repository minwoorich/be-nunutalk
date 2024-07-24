package com.minwoo.nunutalk.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.NonNull;

import java.util.List;
import java.util.UUID;

@Builder
public record CreateRoomReq(
        @Schema(description = "채팅방 제목", example = "독서 스터디 모임") @Size(min = 1, max = 30) String title,
        @Schema(description = "채팅방에 참여하는 모든 인원의 ID", example = "[\"0190d945-4424-7bee-af99-3a83d52985cb\", \"0190d945-440c-7ccf-a688-0eb70ad426a5\"]") @NonNull List<UUID> memberIds) {
}

