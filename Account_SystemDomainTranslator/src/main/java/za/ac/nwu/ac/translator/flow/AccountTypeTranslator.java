package za.ac.nwu.ac.translator.flow;

import za.ac.nwu.ac.domain.dto.AccountTypeDto;

import java.util.List;

public interface AccountTypeTranslator {
    AccountTypeDto getAccountTypeMnemonic(String mnemonic);

    AccountTypeDto create(AccountTypeDto accountType);

    List<AccountTypeDto> getAllAccountTypes();
}
