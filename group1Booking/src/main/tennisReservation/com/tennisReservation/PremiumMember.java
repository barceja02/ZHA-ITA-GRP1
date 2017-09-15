package com.tennisReservation;

public class PremiumMember {
	int memberId;
	String recurringDay;
	String recurringSlot;
	String isActive;
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getRecurringDay() {
		return recurringDay;
	}
	public void setRecurringDay(String recurringDay) {
		this.recurringDay = recurringDay;
	}
	public String getRecurringSlot() {
		return recurringSlot;
	}
	public void setRecurringSlot(String recurringSlot) {
		this.recurringSlot = recurringSlot;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
}
