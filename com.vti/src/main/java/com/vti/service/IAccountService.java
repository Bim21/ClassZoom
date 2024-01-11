package com.vti.service;

import com.vti.dto.AccountDTO;
import com.vti.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.security.auth.login.AccountNotFoundException;

public interface IAccountService {
    Page<AccountDTO> getAllAccounts(Pageable pageable);
    AccountDTO getAccountById(int id) throws AccountNotFoundException;

    Account createAccount(Account account);

    Account updateAccount(Account account, int id) throws AccountNotFoundException;

    void deteleAccountById(int id) throws AccountNotFoundException;
}
