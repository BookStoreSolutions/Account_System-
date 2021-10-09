package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistance.AccountType;

import java.util.List;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {
    List<AccountType> findAll();

    AccountType save(AccountType accountType);

    @Query(value = "SELECT" +
            "   at" +
            "   FROM " +
            "   AccountType at" +
            "   WHERE at.mnemonic = :mnemonic")
    AccountType getAccountTypeByMnemonic(String mnemonic);
}
