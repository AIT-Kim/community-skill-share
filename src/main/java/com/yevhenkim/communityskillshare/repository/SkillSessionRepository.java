package com.yevhenkim.communityskillshare.repository;

import com.yevhenkim.communityskillshare.model.SkillSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillSessionRepository extends JpaRepository<SkillSession, Long> {
    List<SkillSession> findByStatus(String status);
}

