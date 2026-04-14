package com.homesphere.repository;

import com.homesphere.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    // get messages where user is sender or receiver
    List<Message> findBySenderIdOrReceiverId(Long senderId, Long receiverId);
}