package by.alex.task04.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Account extends AbstractBaseEntity {

    private final String number;

    private AccountStatus status;

    private BigDecimal balance;

    public Account(String number) {
        this.number = number;
        this.balance = new BigDecimal(0);
        this.status = AccountStatus.ACTIVE;
    }

    public Account(String number, AccountStatus status, BigDecimal balance) {
        this.number = number;
        this.status = status;
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Account account = (Account) o;
        return Objects.equals(number, account.number) && status == account.status && Objects.equals(balance, account.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), number, status, balance);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + getId() + "\'" +
                "number='" + number + '\'' +
                ", status=" + status +
                ", balance=" + balance +
                '}';
    }

}
