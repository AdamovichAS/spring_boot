package com.github.adamovichas.hes.dao.repository;


import com.github.adamovichas.hes.dao.entity.UserAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccountEntity,Long> {
    UserAccountEntity findByUserName(String userName);
    boolean existsByUserName(String userName);
}
