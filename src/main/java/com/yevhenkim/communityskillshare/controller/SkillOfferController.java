package com.yevhenkim.communityskillshare.controller;

import com.yevhenkim.communityskillshare.model.SkillOffer;
import com.yevhenkim.communityskillshare.service.SkillOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/skill-offers")
public class SkillOfferController {

    private final SkillOfferService skillOfferService;

    @Autowired
    public SkillOfferController(SkillOfferService skillOfferService) {
        this.skillOfferService = skillOfferService;
    }

    @PostMapping
    public ResponseEntity<SkillOffer> createSkillOffer(@RequestBody SkillOffer skillOffer) {
        SkillOffer newSkillOffer = skillOfferService.createSkillOffer(skillOffer);
        return ResponseEntity.ok(newSkillOffer);
    }

    @GetMapping
    public ResponseEntity<List<SkillOffer>> getAllSkillOffers() {
        List<SkillOffer> skillOffers = skillOfferService.getAllSkillOffers();
        return ResponseEntity.ok(skillOffers);
    }

}

