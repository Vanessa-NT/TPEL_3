package junitTests;

import java.security.InvalidParameterException;

import org.junit.Assert;
import org.junit.Test;

import personenidentity.Member;
import personenidentity.MembershipList;

public class ClubTest {
	MembershipList list = new MembershipList();

	@Test
	public void testSetVorname() {
		boolean expected = true;

		String test = "Test";
		list.put(new Member(1, "Muster", "Frau", 7));
		list.setVorname(1, test);
		String actual = list.get(1).getVorname();
		Assert.assertEquals(expected, test == actual);
	}

	@Test
	public void testSetNachname() {
		boolean expected = true;
		String test = "Test";
		list.put(new Member(2, "Muster", "Frau", 7));
		list.setNachname(2, test);
		String actual = list.get(2).getNachname();
		Assert.assertEquals(expected, test == actual);
	}

	@Test
	public void testSetMitgliederJahre() {
		boolean expected = true;
		int test = 10;
		list.put(new Member(3, "Muster", "Frau", 7));
		list.setMitgliederJahre(3, test);
		int actual = list.get(3).getMitgliedsJahre();
		Assert.assertEquals(expected, test == actual);
	}

	@Test
	public void testPutMember() {
		boolean expected = true;

		Member myMember = new Member(4, "Muster", "Man", 5);

		list.put(myMember);
		Member actual = list.get(4);
		Assert.assertEquals(expected, myMember.equals(actual));
	}

	@Test(expected = InvalidParameterException.class)
	public void testPutKeyDifferentToID() {
		list.put(10, new Member(1, "Muster", "Man", 5));
	}

}