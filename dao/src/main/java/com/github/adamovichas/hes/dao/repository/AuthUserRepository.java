package com.github.adamovichas.hes.dao.repository;

import com.github.adamovichas.hes.dao.entity.AuthUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthUserRepository extends JpaRepository<AuthUserEntity,Long> {
}
