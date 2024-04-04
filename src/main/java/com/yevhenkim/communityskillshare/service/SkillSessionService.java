package com.yevhenkim.communityskillshare.service;

import com.yevhenkim.communityskillshare.model.SkillSession;
import com.yevhenkim.communityskillshare.repository.SkillSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SkillSessionService {
    private final SkillSessionRepository skillSessionRepository;

    @Autowired
    public SkillSessionService(SkillSessionRepository skillSessionRepository) {
        this.skillSessionRepository = skillSessionRepository;
    }

    public SkillSession createSkillSession(SkillSession skillSession) {
        return skillSessionRepository.save(skillSession);
    }

    public List<SkillSession> getAllSkillSessions() {
        return skillSessionRepository.findAll();
    }

}

