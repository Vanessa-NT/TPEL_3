package junitTests;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.junit.Assert;
import org.junit.Test;

import personenidentity.Member;

public class MemberTest {

	@Test
	public void isTheSameNachname() {
		boolean expected = true;
		Member mem1 = new Member(1, "Maria", "Geist", 2);
		Member mem2 = new Member(2, "Caro", "Schmidt", 3);
		Assert.assertNotEquals(expected, mem1.isTheSameNachname(mem2));
	}

	@Test
	public void isTheSameVorname() {
		boolean expected = false;
		Member mem1 = new Member(3, "David", "Müller", 2);
		Member mem2 = new Member(4, "David", "Müller", 2);
		Assert.assertNotEquals(expected, mem1.isTheSameVorname(mem2));

	}

	@Test
	public void hasSameMitgliedsJahre() {
		boolean expected = false;
		Member mem1 = new Member(5, "Sofia", "Piesch", 2);
		Member mem2 = new Member(6, "Katharina", "Damm", 3);
		Assert.assertEquals(expected, mem1.hasSameMitgliedsJahre(mem2));

	}

	@Test(expected = InvalidParameterException.class)
	public void IllegalArguments(){

		Member mem1 = new Member(7, "Hans Christian", "Andersen", 53);
		Member mem2 = new Member(7, "Hans Christian", "Andersen", 50);

	}

}