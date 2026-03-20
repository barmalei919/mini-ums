package com.ums.mini_ums.controller;

import com.ums.mini_ums.entity.Message;
import com.ums.mini_ums.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping("/send")
    public ResponseEntity<Message> sendMessage(
            @RequestParam Long userId,
            @RequestParam Long channelId,
            @RequestParam String content) {
        return ResponseEntity.ok(messageService.sendMessage(userId, channelId, content));
    }

    @GetMapping
    public ResponseEntity<List<Message>> getAllMessages() {
        return ResponseEntity.ok(messageService.getAllMessages());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Message>> getMessagesByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(messageService.getMessagesByUser(userId));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Message> updateStatus(
            @PathVariable Long id,
            @RequestParam Message.MessageStatus status) {
        return ResponseEntity.ok(messageService.updateStatus(id, status));
    }
}