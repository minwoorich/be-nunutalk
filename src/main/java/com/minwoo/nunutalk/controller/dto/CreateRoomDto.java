package com.minwoo.nunutalk.controller.dto;

import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record CreateRoomDto(String title, List<UUID> memberIds) {
}
