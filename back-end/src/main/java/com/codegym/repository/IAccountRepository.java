package com.codegym.repository;

import com.codegym.entity.about_account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IAccountRepository extends JpaRepository<Account, Integer> {
    @Query(value = "INSERT into account (accountUsername,accountPassword,) values (?1,?2) ", nativeQuery = true)
    void saveQuery(String accountUsername, String accountPassword);
}
