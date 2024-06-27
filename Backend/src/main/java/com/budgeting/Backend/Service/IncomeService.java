package com.budgeting.Backend.Service;

import com.budgeting.Backend.Model.Income;
import com.budgeting.Backend.Repository.IncomeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncomeService {

    private final IncomeRepo incomeRepo;

    @Autowired
    public IncomeService(IncomeRepo incomeRepo) {
        this.incomeRepo = incomeRepo;
    }

    public List<Income> getAll() {
        return incomeRepo.findAll();
    }

    public Income addIncome(Income income) {
        return incomeRepo.save(income);
    }

    public Income updateIncome(Income income) {
        return incomeRepo.save(income);
    }

    public Optional<Income> getById(Long id) {
        return incomeRepo.findById(id);
    }

    public void deleteById(Long id) {
        incomeRepo.deleteById(id);
    }
}
