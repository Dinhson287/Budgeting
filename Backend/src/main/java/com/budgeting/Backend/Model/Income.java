package com.budgeting.Backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Income {

    private Long incomeId;
    private String incomeTitle;
    private Double incomeAmount;
    private LocalDate incomeDate;

    public Income() {

    }

    @Id
    @GeneratedValue
    public Long getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(Long incomeId) {
        this.incomeId = incomeId;
    }

    public String getIncomeTitle() {
        return incomeTitle;
    }

    public void setIncomeTitle(String incomeTitle) {
        this.incomeTitle = incomeTitle;
    }

    public Double getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(Double incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public LocalDate getIncomeDate() {
        return incomeDate;
    }

    public void setIncomeDate(LocalDate incomeDate) {
        this.incomeDate = incomeDate;
    }

    public Income(Long incomeId, String incomeTitle, Double incomeAmount, LocalDate incomeDate) {
        this.incomeId = incomeId;
        this.incomeTitle = incomeTitle;
        this.incomeAmount = incomeAmount;
        this.incomeDate = incomeDate;
    }
}
