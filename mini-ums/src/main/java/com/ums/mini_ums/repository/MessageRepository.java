package com.ums.mini_ums.repository;

import com.ums.mini_ums.entity.Message;
import com.ums.mini_ums.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByUser(User user);
    List<Message> findByStatus(Message.MessageStatus status);
}