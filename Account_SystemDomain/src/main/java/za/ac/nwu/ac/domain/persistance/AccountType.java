package za.ac.nwu.ac.domain.persistance;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ACCOUNT_TYPE")
public class AccountType implements Serializable {

    @Id
    @Column(name = "ACCOUNT_TYPE_ID")
    public Long getAccountTypeId() {
        return accountTypeId;
    }
    @Column(name = "MNEMONIC")
    public String getMnemonic() {
        return mnemonic;
    }
    @Column(name = "ACCOUNT_TYPE_NAME")
    public String getAccountTypeName() {
        return accountTypeName;
    }
    @Column(name = "CREATION_DATE")
    public LocalDate getCreationDate() {
        return creationDate;
    }

    Set<AccountTransaction> accountTransaction;
    @OneToMany(targetEntity = Membership_Details.class, fetch = FetchType.LAZY, mappedBy = "accountType", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<AccountTransaction> getMembership(){
        return accountTransaction;
    }

    public void setAccountTransaction(Set<AccountTransaction> accountTransaction)
    {
        this.accountTransaction = accountTransaction;
    }

    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public AccountType(Long accountTypeId, String mnemonic, String accountTypeName, LocalDate creationDate) {
        this.accountTypeId = accountTypeId;
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.creationDate = creationDate;
    }

    Long accountTypeId;
    String mnemonic;
    String accountTypeName;
    LocalDate creationDate;
}
