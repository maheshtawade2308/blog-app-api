package com.bank.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.project.model.LoanEligibility;

@Service
public class LoanEligibilityService {

    @Autowired
    private CibilService cibilService;

    public LoanEligibility checkEligibility(String panNumber) {
        int cibilScore = cibilService.getCibilScore(panNumber);
        LoanEligibility eligibility = new LoanEligibility();
        eligibility.setCibilScore(cibilScore);

        if (cibilScore > 750) {
            eligibility.setEligible(true);
            eligibility.setLoanAmount(500000); // example loan amount
        } else {
            eligibility.setEligible(false);
            eligibility.setLoanAmount(0);
        }
        return eligibility;
    }
}
