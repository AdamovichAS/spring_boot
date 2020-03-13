package com.andersenlab.adamovichjr.dao.repository;


import com.andersenlab.adamovichjr.dao.entity.UserAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccountEntity,Long> {
    @Query(value = "from UserAccountEntity u where u.userName= :userName")
    UserAccountEntity findByUserName(@Param("userName") String userName);

//    @Query(value = "from UserAccountEntity u where u.id= :id")
    Optional<UserAccountEntity> findById(@Param("id") Long id);
}
