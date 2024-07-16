package com.minwoo.nunutalk.controller;

import java.util.UUID;

public record CreateRoomDto(UUID ownerId, UUID friendId) {
}
