package com.yevhenkim.communityskillshare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yevhenkim.communityskillshare.model.SkillSession;

public interface SkillSessionRepository extends JpaRepository<SkillSession, Long> {
    //методы поиска по статусу сессии, участникам
}

