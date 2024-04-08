package com.yevhenkim.communityskillshare.controller;

import com.yevhenkim.communityskillshare.model.SkillSession;
import com.yevhenkim.communityskillshare.service.SkillSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/skill-sessions")
public class SkillSessionController {

    private final SkillSessionService skillSessionService;

    @Autowired
    public SkillSessionController(SkillSessionService skillSessionService) {
        this.skillSessionService = skillSessionService;
    }

    @PostMapping
    public ResponseEntity<SkillSession> createSkillSession(@RequestBody SkillSession skillSession) {
        SkillSession newSkillSession = skillSessionService.createSkillSession(skillSession);
        return ResponseEntity.ok(newSkillSession);
    }

    @GetMapping
    public ResponseEntity<List<SkillSession>> getAllSkillSessions() {
        List<SkillSession> skillSessions = skillSessionService.getAllSkillSessions();
        return ResponseEntity.ok(skillSessions);
    }

    @GetMapping("/status")
    public ResponseEntity<List<SkillSession>> getSkillSessionsByStatus(@RequestParam String status) {
        List<SkillSession> skillSessions = skillSessionService.getSkillSessionsByStatus(status);
        return ResponseEntity.ok(skillSessions);
    }
}

