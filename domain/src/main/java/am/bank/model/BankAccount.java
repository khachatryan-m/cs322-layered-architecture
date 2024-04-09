package am.bank;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "\"bank_account\"")

public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private double balance;
    @Column(unique = true)
    private long userID;

    public BankAccount(){}

    public BankAccount(double balance, long userID){
        this.balance = balance;
        this.userID = userID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount account = (BankAccount) o;
        return Objects.equals(userID, account.userID)
                && Objects.equals(balance, account.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, balance);
    }

    public Long getId(){return id;}

    public double getBalance() {
        return balance;
    }

    public long getUserID() {
        return userID;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

