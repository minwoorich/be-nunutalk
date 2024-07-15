package com.minwoo.nunutalk.controller;

import java.util.UUID;

public record CreateRoomRecord(UUID ownerId, UUID friendId) {
}
