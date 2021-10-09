package za.ac.nwu.ac.domain.persistance;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "MEMBERSHIP_DETAILS")

public class Membership_Details implements Serializable {
    @Id
    @Column(name = "MEMBERSHIP_ID")
    public Long getMembership_ID() {
        return membership_ID;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TRANSACTION_ID")
    public AccountTransaction getAccountTransaction() {
        return accountTransaction;
    }

    @Column(name = "INSURANCE_PLAN")
    public String getInsurance_Plan() {
        return Insurance_Plan;
    }

    @Column(name = "ITEMS_COUNT")
    public Long getItems_Count() {
        return items_Count;
    }

    public Membership_Details(Long membership_ID, AccountTransaction accountTransaction, String insurance_Plan, Long items_Count) {
        this.membership_ID = membership_ID;
        this.accountTransaction = accountTransaction;
        Insurance_Plan = insurance_Plan;
        this.items_Count = items_Count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Membership_Details)) return false;
        Membership_Details that = (Membership_Details) o;
        return Objects.equals(getMembership_ID(), that.getMembership_ID()) && Objects.equals(getAccountTransaction(), that.getAccountTransaction()) && Objects.equals(getInsurance_Plan(), that.getInsurance_Plan()) && Objects.equals(getItems_Count(), that.getItems_Count());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMembership_ID(), getAccountTransaction(), getInsurance_Plan(), getItems_Count());
    }

    @Override
    public String toString() {
        return "Membership_Details{" +
                "membership_ID=" + membership_ID +
                ", accountTransaction=" + accountTransaction +
                ", Insurance_Plan='" + Insurance_Plan + '\'' +
                ", items_Count=" + items_Count +
                '}';
    }

    Long membership_ID;
    AccountTransaction accountTransaction;
    String Insurance_Plan;
    Long items_Count;

}
