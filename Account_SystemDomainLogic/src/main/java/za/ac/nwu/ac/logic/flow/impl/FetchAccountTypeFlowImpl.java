package za.ac.nwu.ac.logic.flow.impl;

import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.translator.flow.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class FetchAccountTypeFlowImpl implements FetchAccountTypeFlow {

    private final AccountTypeTranslator accountTypeTranslator;

    @Autowired
    public FetchAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator) {
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public List<AccountTypeDto> getAllAccountTypes() {
        List<AccountTypeDto> accountTypeDtos = new ArrayList<>();
        accountTypeDtos.add(new AccountTypeDto("MILES", "Miles", LocalDate.now()));
        return accountTypeTranslator.getAllAccountTypes();
    }

    @Override
    public AccountTypeDto getAccountTypeMnemonic(String mnemonic){
        return accountTypeTranslator.getAccountTypeMnemonic(mnemonic);
    }

    @Override
    public AccountTypeDto getAllAccountTypesByMnemonic(String mnemonic) {
        return null;
    }

    public boolean methodToTest(){
        return true;
    }
}
