package com.budgeting.Backend.Controller;

import com.budgeting.Backend.Model.Expense;
import com.budgeting.Backend.Model.Income;
import com.budgeting.Backend.Service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (value = "/income")
public class IncomeController {

    private final IncomeService incomeService;

    @Autowired
    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @GetMapping
    public List<Income> getAll() {
        return incomeService.getAll();
    }

    @PostMapping
    public ResponseEntity<Income> addIncome(@RequestBody Income income) {
        Income addedIncome = incomeService.addIncome(income);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedIncome);
    }

    @PutMapping(value = "/item/{id}")
    public ResponseEntity<Income> updateIncome(@PathVariable Long id, @RequestBody Income income) {
        Optional<Income> optionalIncome = incomeService.getById(id);
        if (optionalIncome.isPresent()) {
            Income existingIncome = optionalIncome.get();

            existingIncome.setIncomeTitle(income.getIncomeTitle());
            existingIncome.setIncomeAmount(income.getIncomeAmount());
            existingIncome.setIncomeDate(income.getIncomeDate());

            Income updatedIncome = incomeService.updateIncome(existingIncome);
            return ResponseEntity.ok(updatedIncome);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/item/{id}")
    public ResponseEntity<Void> deleteIncomeById(@PathVariable Long id) {
        incomeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
