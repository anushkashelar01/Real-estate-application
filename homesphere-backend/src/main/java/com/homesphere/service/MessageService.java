package com.homesphere.service;

import com.homesphere.model.Message;

import java.util.List;

public interface MessageService {

    Message sendMessage(Message message);

    List<Message> getMessages(Long userId);
}