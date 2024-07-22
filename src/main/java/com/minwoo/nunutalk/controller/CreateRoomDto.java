package com.minwoo.nunutalk.controller;

import java.util.UUID;

public record CreateRoomDto(String title, UUID ownerId, UUID friendId) {
}
