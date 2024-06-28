package com.budgeting.Backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table (name = "expense")
public class Expense {

    private Long expenseID;
    private String expenseTitle;
    private Double expenseAmount;
    private LocalDate expenseDate;

    public Expense() {

    }


    @Id
    @GeneratedValue
    public Long getExpenseID() {
        return expenseID;
    }

    public void setExpenseID(Long expenseID) {
        this.expenseID = expenseID;
    }

    public String getExpenseTitle() {
        return expenseTitle;
    }

    public void setExpenseTitle(String expenseTitle) {
        this.expenseTitle = expenseTitle;
    }

    public Double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(Double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public LocalDate getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDate expenseDate) {
        this.expenseDate = expenseDate;
    }

    public Expense(LocalDate expenseDate, Double expenseAmount, String expenseTitle, Long expenseID) {
        this.expenseDate = expenseDate;
        this.expenseAmount = expenseAmount;
        this.expenseTitle = expenseTitle;
        this.expenseID = expenseID;
    }
}
