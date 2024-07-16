package com.minwoo.nunutalk.controller;

import com.minwoo.nunutalk.domain.enums.MessageType;

import java.util.UUID;

public record SubsMessageDto(UUID senderId, MessageType type) {
}