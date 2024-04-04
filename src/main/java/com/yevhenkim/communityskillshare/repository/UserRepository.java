package com.yevhenkim.communityskillshare.repository;

import com.yevhenkim.communityskillshare.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // методы для поиска по email и др.
}

