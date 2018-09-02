package com.prevail.utilgeneric;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Test3 {

/*	@Test
	public void Sample()
	{
		System.out.println("1");
		Assert.assertTrue(true);
		System.out.println("2");
		Assert.assertTrue(false);
		System.out.println("3");
		Assert.assertTrue(true);
	}*/
	
	@Test
	public void aa()
	{
		SoftAssert sa=new SoftAssert();
		System.out.println("1");
		sa.assertTrue(true);
		System.out.println("2");
		sa.assertTrue(false,"this is shashi");
		System.out.println("3");
		sa.assertTrue(false,"this is lanka");
		sa.assertEquals("hello", "hi");
		sa.assertAll();
	}
	
}
