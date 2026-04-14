package com.homesphere.service;

import com.homesphere.model.Message;
import com.homesphere.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    // ✅ SEND MESSAGE
    @Override
    public Message sendMessage(Message message) {
        message.setTimestamp(LocalDateTime.now());
        return messageRepository.save(message);
    }

    // ✅ GET USER MESSAGES
    @Override
    public List<Message> getMessages(Long userId) {
        return messageRepository.findBySenderIdOrReceiverId(userId, userId);
    }
}