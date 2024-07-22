package com.minwoo.nunutalk.controller;

import java.util.List;
import java.util.UUID;

public record CreateRoomDto(String title, List<UUID> members) {
}
