package com.budgeting.Backend.Config;

import com.budgeting.Backend.Model.Expense;
import com.budgeting.Backend.Repository.ExpenseRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class ExpenseConfig {

    @Bean
    CommandLineRunner commandLineRunner(ExpenseRepo expenseRepo) {
        return args -> {
            Expense rent = new Expense(
                    LocalDate.now(), 500.0, "Rent", 1L
            );

            expenseRepo.saveAll(
                    List.of(rent)
            );
        };
    }
}
