package com.yevhenkim.communityskillshare.repository;

import com.yevhenkim.communityskillshare.model.SkillOffer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillOfferRepository extends JpaRepository<SkillOffer, Long> {
    // методы поиска по пользователю, навыку
}
