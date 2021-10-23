package com.codegym.repository;

import com.codegym.entity.about_account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IAccountRepository extends JpaRepository<Account, Integer> {
    @Query(value = "select * from account a where a.account_username= ?1", nativeQuery = true)
    Account findAccountByUsername(String username);

}
