package com.yevhenkim.communityskillshare.service;

import com.yevhenkim.communityskillshare.model.SkillOffer;
import com.yevhenkim.communityskillshare.repository.SkillOfferRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillOfferService {
    private final SkillOfferRepository skillOfferRepository;

    @Autowired
    public SkillOfferService(SkillOfferRepository skillOfferRepository) {
        this.skillOfferRepository = skillOfferRepository;
    }

    public SkillOffer createSkillOffer(SkillOffer skillOffer) {
        return skillOfferRepository.save(skillOffer);
    }

    public List<SkillOffer> getAllSkillOffers() {
        return skillOfferRepository.findAll();
    }
    public SkillOffer getSkillOfferById(Long id) {
        return skillOfferRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("SkillOffer not found with id: " + id));
    }
}

