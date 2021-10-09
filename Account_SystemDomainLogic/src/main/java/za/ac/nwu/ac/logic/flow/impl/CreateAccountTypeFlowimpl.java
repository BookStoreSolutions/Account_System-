package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.ac.translator.flow.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("createAccountTypeFlowName")

public class CreateAccountTypeFlowimpl implements CreateAccountTypeFlow {

    private final AccountTypeTranslator accountTypeTranslator;

    public CreateAccountTypeFlowimpl(AccountTypeTranslator accountTypeTranslator) {
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public AccountTypeDto create(AccountTypeDto accountType){
        if(null == accountType.getCreationDate()){
            accountType.setCreationDate(LocalDate.now());
        }
        return accountTypeTranslator.create(accountType);
    }
}
