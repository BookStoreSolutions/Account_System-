package za.ac.nwu.ac.domain.persistance;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ACCOUNT_TRANSACTION")
public class AccountTransaction implements Serializable {
    
    @Id
    @Column(name = "TRANSACTIONID")
    public long getTransactionID() {
        return transactionID;
    }
    @Column(name = "MEMBERSHIP_ID")
    public int getMembership_ID() {
        return membership_ID;
    }
    @Column(name = "AMOUNT")
    public long getAmount() {
        return amount;
    }
    @Column(name = "TRANSACTIONDATE")
        public LocalDate getTransactionDate() {
            return transactionDate;
        }
    @Column(name = "ACCOUNT_TYPE_NAME")
        public AccountType getAccountType() {
            return accountType;
        }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_TYPE_ID")
        public long getAccountTypeId() {
            return accountTypeId;
        }

    @OneToOne(targetEntity = Membership_Details.class, fetch = FetchType.LAZY, mappedBy = "accountTransaction", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Membership_Details getMembership() {

        return details;
    }

    public AccountTransaction(Long transactionID, Long accountTypeId, Integer membership_ID, Long amount, LocalDate transactionDate, AccountType accountType) {
        this.transactionID = transactionID;
        this.accountTypeId = accountTypeId;
        this.membership_ID = membership_ID;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.accountType = accountType;
    }

    public void setTransactionID(Long transactionID) {
        this.transactionID = transactionID;
    }

    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public void setMembership_ID(Integer membership_ID) {
        this.membership_ID = membership_ID;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @OneToOne
    @JoinColumn(name = "details_membership_id")
    private Membership_Details details;

    Long transactionID;
    Long accountTypeId;
    Integer membership_ID;
    Long amount;
    LocalDate transactionDate;
    AccountType accountType;

    public Membership_Details getDetails() {
        return details;
    }

    public long calAddMiles(Long amount)
    {
        amount =+ getAmount();

        return amount;
    }

    public long calMinusMiles(long amount)
    {
        amount =- getAmount();

        return amount;
    }
}
