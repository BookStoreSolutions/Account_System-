package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistance.AccountType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "AccountType", description = "A DTO represents the AccountType")
public class AccountTypeDto implements Serializable {

    public AccountTypeDto() {
    }

    public AccountTypeDto(String mnemonic, String accountTypeName, LocalDate creationDate) {
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.creationDate = creationDate;
    }

    public AccountTypeDto(AccountType accountType) {
        this.setMnemonic(accountType.getMnemonic());
        this.setAccountTypeName(accountType.getAccountTypeName());
        this.setCreationDate(accountType.getCreationDate());
    }



    @ApiModelProperty(position = 1,
        value = "Account Type Mnemonic",
        name = "Mnemonic",
        notes = "Uniquely identifies the account type",
        dataType = "java.lang.String",
        example = "MILES",
        required = true)

    public Long getAccountTypeId() {
        return accountTypeId;
    }
    public String getMnemonic() {
        return mnemonic;
    }

    public String getAccountTypeName() {
        return accountTypeName;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    @ApiModelProperty(position = 2,
            value = "AccountType Name",
            name = "Name",
            notes = "Account Type Name:",
            dataType = "java.lang.String",
            example = "MILES",
            required = true)

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

    @ApiModelProperty(position = 3,
            value = "AccountType Creation Date",
            name = "CreationDate",
            notes = "Creation Date of the Account type",
            dataType = "java.lang.String",
            example = "2021-09-01",
            allowableValues = "true")

    @JsonIgnore
    public AccountType getAccountType() {
        return new AccountType(getAccountTypeId(),getMnemonic(), getAccountTypeName(), getCreationDate());
    }

    private Long accountTypeId;
    private String mnemonic;
    private String accountTypeName;
    private LocalDate creationDate;

}
