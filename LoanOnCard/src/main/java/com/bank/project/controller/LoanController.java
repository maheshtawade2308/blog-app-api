package com.bank.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.project.model.LoanEligibility;
import com.bank.project.service.LoanEligibilityService;


@RestController
public class LoanController {

    @Autowired
    private LoanEligibilityService loanEligibilityService;

    @GetMapping("/check-loan-eligibility")
    public LoanEligibility checkLoanEligibility(@RequestParam String panNumber) {
        return loanEligibilityService.checkEligibility(panNumber);
    }
}

