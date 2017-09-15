package com.tennisReservation.test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tennisReservation.PremiumMember;
import com.tennisReservation.PremiumMemberIMPL;

public class PremiumMemberTest {

	PremiumMember premiumMember = new PremiumMember();
	PremiumMemberIMPL premiumImpl = new PremiumMemberIMPL();
	@Before
	public void init() {
		premiumMember = new PremiumMember();
		premiumImpl = new PremiumMemberIMPL();
	}
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
		Assert.assertEquals(premiumImpl.getAllPremiumMember().size(), 15);
		
	}
//	@Test
//	public void testAddPremiumMemberRecurringSchedule() {
//		premiumMember.setRecurringDay("MONDAY");
//		premiumMember.setRecurringSlot("9:00-11:00");
//		premiumMember.setIsActive("1");
//		Assert.assertEquals(new PremiumMemberIMPL().AddPremiumMemberSchedule(premiumMember), "true");	
//	}
	
	@Test
	public void test1AddPremiumMember() {
		//add premium member and day is not taken and slot is not taken
		premiumMember.setRecurringDay("THURSDAY");
		premiumMember.setRecurringSlot("15:00-18:00");
		premiumMember.setIsActive("1");
		Assert.assertEquals(new PremiumMemberIMPL().AddPremiumMemberSchedule(premiumMember), "true");
	}
	@Test
	public void test2AddPremiumMember() {
		//add premium member and day is taken and slot is not taken

		premiumMember.setRecurringDay("Monday");
		premiumMember.setRecurringSlot("15:00-18:00");
		premiumMember.setIsActive("1");
		Assert.assertEquals(new PremiumMemberIMPL().AddPremiumMemberSchedule(premiumMember), "false");
	}
	@Test
	public void test3AddPremiumMember() {
		//add premium member and day is taken and slot is not taken

		premiumMember.setRecurringDay("Monday");
		premiumMember.setRecurringSlot("15:00-18:00");
		premiumMember.setIsActive("1");
		Assert.assertEquals(new PremiumMemberIMPL().AddPremiumMemberSchedule(premiumMember), "false");
	}
	

	@Test//initial test
	public void testUpdatePremiumMemberRecurringSchedule() {
		premiumMember.setMemberId(10001);
		premiumMember.setRecurringDay("MONDAY");
		premiumMember.setRecurringSlot("15:00-18:00");
		premiumMember.setIsActive("1");
		
		Assert.assertEquals(premiumImpl.updateMemberSchedule(premiumMember),"true");
	}
	@Test
	public void test1UpdatePremiumMember() {
		//Update the PremiumMemberSchedule but day and slot is taken by someone
		premiumMember.setMemberId(10001);
		premiumMember.setRecurringDay("MONDAY");
		premiumMember.setRecurringSlot("9:00-11:00");
		premiumMember.setIsActive("1");
		
		Assert.assertEquals(premiumImpl.updateMemberSchedule(premiumMember),"false");
		
	}
	@Test
	public void test3UpdatePremiumMember() {
		//Update the PremiumMemberSchedule and slot and day is not taken
		premiumMember.setMemberId(10001);
		premiumMember.setRecurringDay("TUESDAY");
		premiumMember.setRecurringSlot("9:00-11:00");
		premiumMember.setIsActive("1");
		
		Assert.assertEquals(premiumImpl.updateMemberSchedule(premiumMember),"true");
	}
	
	
}
