package com.budgeting.Backend.Controller;

import com.budgeting.Backend.Model.Expense;
import com.budgeting.Backend.Service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (value = "/expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public List<Expense> getAll() {
        return  expenseService.getAll();
    }

    @PostMapping
    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense) {
        Expense addedExpense = expenseService.addExpense(expense);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedExpense);
    }

    @PutMapping (value = "/item/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable Long id, @RequestBody Expense expense) {
        Optional<Expense> optionalExpense = expenseService.getById(id);
        if (optionalExpense.isPresent()) {
            Expense existingExpense = optionalExpense.get();

            // Step 3: Update the existing Expense with values from the request body
            // You can update specific fields as needed
            existingExpense.setExpenseTitle(expense.getExpenseTitle());
            existingExpense.setExpenseAmount(expense.getExpenseAmount());
            existingExpense.setExpenseDate(expense.getExpenseDate());
            existingExpense.setCategories(expense.getCategories());

            // Step 4: Save the updated Expense and return it in ResponseEntity
            Expense updatedExpense = expenseService.updateExpense(existingExpense);
            return ResponseEntity.ok(updatedExpense);
        } else {
            // Handle the case where Expense with given id is not found
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping (value = "/item/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpenseById(id);
        return ResponseEntity.noContent().build();
    }
}
