package com.bank.project.model;

public class LoanEligibility {

    private int cibilScore;
    private boolean isEligible;
    private int loanAmount;
	/**
	 * @return the cibilScore
	 */
	public int getCibilScore() {
		return cibilScore;
	}
	/**
	 * @param cibilScore the cibilScore to set
	 */
	public void setCibilScore(int cibilScore) {
		this.cibilScore = cibilScore;
	}
	/**
	 * @return the isEligible
	 */
	public boolean isEligible() {
		return isEligible;
	}
	/**
	 * @param isEligible the isEligible to set
	 */
	public void setEligible(boolean isEligible) {
		this.isEligible = isEligible;
	}
	/**
	 * @return the loanAmount
	 */
	public int getLoanAmount() {
		return loanAmount;
	}
	/**
	 * @param loanAmount the loanAmount to set
	 */
	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}
    
    
}
