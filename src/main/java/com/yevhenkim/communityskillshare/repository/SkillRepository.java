package com.yevhenkim.communityskillshare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yevhenkim.communityskillshare.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    // методы поиска
}
