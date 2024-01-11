package com.vti.service.impl;

import com.vti.dto.AccountDTO;
import com.vti.entity.Account;
import com.vti.exception.ClassNotFoundException;
import com.vti.repository.IAccountRepository;
import com.vti.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;

@Service
@RequiredArgsConstructor
public class AccountService implements IAccountService {

    private final IAccountRepository accountRepository;

    private final ModelMapper mapper;
    @Override
    public Page<AccountDTO> getAllAccounts(Pageable pageable) {
        Page<Account> accountPage = accountRepository.findAll(pageable);
        return accountPage.map(account -> mapper.map(account, AccountDTO.class));
    }

    @Override
    public AccountDTO getAccountById(int id) throws AccountNotFoundException {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException());
        return mapper.map(account, AccountDTO.class);
    }

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account updateAccount(Account account, int id) throws AccountNotFoundException {
        Account existingAccount = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException());
        return accountRepository.save(existingAccount);
    }

    @Override
    public void deteleAccountById(int id) throws AccountNotFoundException {
        if(!accountRepository.existsById(id)) {
            throw new AccountNotFoundException();
        }
        accountRepository.deleteById(id);
    }
}
