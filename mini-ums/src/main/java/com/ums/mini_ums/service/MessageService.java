package com.ums.mini_ums.service;

import com.ums.mini_ums.entity.Message;
import com.ums.mini_ums.entity.User;
import com.ums.mini_ums.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;
    private final UserService userService;
    private final ChannelService channelService;

    public Message sendMessage(Long userId, Long channelId, String content) {
        Message message = new Message();
        message.setUser(userService.getUserById(userId));
        message.setChannel(channelService.getChannelById(channelId));
        message.setContent(content);
        message.setStatus(Message.MessageStatus.PENDING);
        return messageRepository.save(message);
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public List<Message> getMessagesByUser(Long userId) {
        User user = userService.getUserById(userId);
        return messageRepository.findByUser(user);
    }

    public Message updateStatus(Long id, Message.MessageStatus status) {
        Message message = messageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Message not found with id: " + id));
        message.setStatus(status);
        return messageRepository.save(message);
    }
}