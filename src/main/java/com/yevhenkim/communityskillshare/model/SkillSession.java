package com.yevhenkim.communityskillshare.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "skill_sessions")
public class SkillSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "offer_id", nullable = false)
    private SkillOffer skillOffer;

    @Column(nullable = false)
    private LocalDateTime sessionDate;

    @Enumerated(EnumType.STRING)
    private SessionStatus status;

    public SkillSession() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SkillOffer getSkillOffer() {
        return skillOffer;
    }

    public void setSkillOffer(SkillOffer skillOffer) {
        this.skillOffer = skillOffer;
    }

    public LocalDateTime getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(LocalDateTime sessionDate) {
        this.sessionDate = sessionDate;
    }

    public SessionStatus getStatus() {
        return status;
    }

    public void setStatus(SessionStatus status) {
        this.status = status;
    }

    public enum SessionStatus {
        PLANNED, COMPLETED, CANCELLED
    }
}
