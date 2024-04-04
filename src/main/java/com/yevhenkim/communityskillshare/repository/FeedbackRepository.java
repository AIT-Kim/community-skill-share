package com.yevhenkim.communityskillshare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yevhenkim.communityskillshare.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    // поиск по сессии, пользователю
}

