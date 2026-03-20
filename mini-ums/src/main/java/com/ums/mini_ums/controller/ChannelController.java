package com.ums.mini_ums.controller;

import com.ums.mini_ums.entity.Channel;
import com.ums.mini_ums.service.ChannelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/channels")
@RequiredArgsConstructor
public class ChannelController {

    private final ChannelService channelService;

    @PostMapping
    public ResponseEntity<Channel> createChannel(@RequestBody Channel channel) {
        return ResponseEntity.ok(channelService.createChannel(channel));
    }

    @GetMapping
    public ResponseEntity<List<Channel>> getAllChannels() {
        return ResponseEntity.ok(channelService.getAllChannels());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Channel> getChannelById(@PathVariable Long id) {
        return ResponseEntity.ok(channelService.getChannelById(id));
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<Channel>> getChannelsByType(@PathVariable Channel.ChannelType type) {
        return ResponseEntity.ok(channelService.getChannelsByType(type));
    }
}