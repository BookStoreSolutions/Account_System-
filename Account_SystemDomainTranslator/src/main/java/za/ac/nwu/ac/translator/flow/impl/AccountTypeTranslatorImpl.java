package za.ac.nwu.ac.translator.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistance.AccountType;
import za.ac.nwu.ac.repo.persistence.AccountTypeRepository;
import za.ac.nwu.ac.translator.flow.AccountTypeTranslator;

import java.lang.Override;
import java.util.ArrayList;
import java.util.List;

@Component

public class AccountTypeTranslatorImpl implements AccountTypeTranslator {

    private final AccountTypeRepository accountTypeRepository;

    @Autowired
    public AccountTypeTranslatorImpl(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }

    @Override
    public List<AccountTypeDto> getAllAccountTypes(){

            List<AccountTypeDto> accountTypeDtos = new ArrayList<>();

        try {
            for (AccountType accountType : accountTypeRepository.findAll()) {
                accountTypeDtos.add(new AccountTypeDto(accountType));
            }
        }catch(Exception e){
            throw new RuntimeException("Unable to read from the DB", e);
        }

        return accountTypeDtos;
    }

    @Override
    public AccountTypeDto getAccountTypeMnemonic(String mnemonic) {
        return null;
    }

    @Override
    public AccountTypeDto create(AccountTypeDto accountTypeDto) {
        try{
            AccountType accountType = accountTypeRepository.save(accountTypeDto.getAccountType());
            return new AccountTypeDto(accountType);
        } catch(Exception E){
            throw new RuntimeException("Unable to save to the DB",E);
        }
    }
}
