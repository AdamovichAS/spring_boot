package com.github.adamovichas.hes.dao.repository;


import com.github.adamovichas.hes.dao.entity.UserAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserAccountRepository extends JpaRepository<UserAccountEntity,Long> {
    @Query(value = "from UserAccountEntity u where u.userName= :userName")
    UserAccountEntity findByUserName(@Param("userName") String userName);
}
