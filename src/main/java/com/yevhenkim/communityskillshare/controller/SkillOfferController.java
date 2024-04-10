package com.yevhenkim.communityskillshare.controller;


import com.yevhenkim.communityskillshare.model.SkillOffer;
import com.yevhenkim.communityskillshare.service.SkillOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    public ResponseEntity<List<Map<String, Object>>> getAllSkillOffers() {
        List<SkillOffer> skillOffers = skillOfferService.getAllSkillOffers();
        List<Map<String, Object>> response = skillOffers.stream().map(offer -> {
            Map<String, Object> map = new HashMap<>();
            map.put("id", offer.getId());
            map.put("skill", offer.getSkill().getName());
            map.put("user", offer.getUser().getName());
            map.put("user_id", offer.getUser().getId());
            map.put("skill_id", offer.getSkill().getId());
            map.put("description", offer.getDescription());
            return map;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getSkillOfferById(@PathVariable Long id) {
        SkillOffer skillOffer = skillOfferService.getSkillOfferById(id);
        Map<String, Object> response = new HashMap<>();
        response.put("id", skillOffer.getId());
        response.put("skill", skillOffer.getSkill().getName());
        response.put("user", skillOffer.getUser().getName());
        response.put("user_id", skillOffer.getUser().getId());
        response.put("skill_id", skillOffer.getSkill().getId());
        response.put("description", skillOffer.getDescription());
        return ResponseEntity.ok(response);
    }

}

