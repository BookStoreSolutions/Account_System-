package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistance.AccountTransaction;
import za.ac.nwu.ac.domain.persistance.AccountType;

import java.util.List;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {

    List<AccountTransaction> findAll();

    //AccountType save(AccountType accountType);

    @Query(value = "SELECT" +
            "   at" +
            "   FROM " +
            "   AccountTransaction at" +
            "   WHERE at.amount = :amount")
    AccountTransaction getAmount(long amount);



}
