package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistance.AccountTransaction;
import za.ac.nwu.ac.domain.persistance.Membership_Details;

import java.io.Serializable;

@ApiModel(value = "Membership", description = "A DTO represents the Membership")
public class MembershipDto implements Serializable {

    public MembershipDto() {
    }

    public MembershipDto(Long membership_ID, AccountTransaction accountTransaction, String insurance_Plan, Long items_Count) {
        this.membership_ID = membership_ID;
        this.accountTransaction = accountTransaction;
        Insurance_Plan = insurance_Plan;
        this.items_Count = items_Count;
    }

    public void setMembership_ID(Long membership_ID) {
        this.membership_ID = membership_ID;
    }

    public void setAccountTransaction(AccountTransaction accountTransaction) {
        this.accountTransaction = accountTransaction;
    }

    public void setInsurance_Plan(String insurance_Plan) {
        Insurance_Plan = insurance_Plan;
    }

    public void setItems_Count(Long items_Count) {
        this.items_Count = items_Count;
    }


    @ApiModelProperty(position = 1,
            value = "Account Type Mnemonic",
            name = "Mnemonic",
            notes = "Uniquely identifies the account type",
            dataType = "java.lang.String",
            example = "MILES",
            required = true)

    public Long getMembership_ID() {
        return membership_ID;
    }

    @ApiModelProperty(position = 2,
            value = "AccountType Name",
            name = "Name",
            notes = "Account Type Name:",
            dataType = "java.lang.String",
            example = "MILES",
            required = true)

    public AccountTransaction getAccountTransaction() {
        return accountTransaction;
    }

    @ApiModelProperty (position = 3,
            value = "AccountType Creation Date",
            name = "CreationDate",
            notes = "Creation Date of the Account type",
            dataType = "java.lang.String",
            example = "2021-09-01",
            allowableValues = "true")

    public String getInsurance_Plan() {
        return Insurance_Plan;
    }

    @ApiModelProperty (position = 4,
            value = "AccountType Creation Date",
            name = "CreationDate",
            notes = "Creation Date of the Account type",
            dataType = "java.lang.String",
            example = "2021-09-01",
            allowableValues = "true")

    public Long getItems_Count() {
        return items_Count;
    }

    @JsonIgnore
    public Membership_Details getDiscovery_Miles() {
        return new Membership_Details(getMembership_ID(),getAccountTransaction(),getInsurance_Plan(),getItems_Count());
    }

    Long membership_ID;
    AccountTransaction accountTransaction;
    String Insurance_Plan;
    Long items_Count;

}

