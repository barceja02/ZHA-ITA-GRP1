package com.tennisReservation.test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.tennisReservation.PremiumMember;
import com.tennisReservation.PremiumMemberIMPL;

public class PremiumMemberTest {

	PremiumMember premiumMember = new PremiumMember();

	@Test
	public void testGetPremiumMember() {
		premiumMember.setMemberId(12345);
		Assert.assertEquals(premiumMember.getMemberId(), 12345);		
	}
	@Test
	public void testHibernateConnection() {
		Assert.assertNotEquals(new PremiumMemberIMPL().setHibernateOpenSession(), null);
	}
	@Test
	public void getPremiumMembers() {
		ArrayList<PremiumMember> premiumMember;
		Assert.assertEquals(new PremiumMemberIMPL().getAllPremiumMember().size(), 2);
		
		
	}
	@Test
	public void testAddPremiumMemberRecurringSchedule() {
		premiumMember.setRecurringDay("MONDAY");
		premiumMember.setRecurringSlot("9:00-11:00");
		premiumMember.setIsActive(1);
		
		Assert.assertEquals(new PremiumMemberIMPL().CreatePremiumMember(premiumMember), "true");	
	}
}
