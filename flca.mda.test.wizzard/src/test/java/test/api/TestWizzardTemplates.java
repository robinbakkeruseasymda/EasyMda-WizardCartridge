package test.api;

import org.junit.BeforeClass;
import org.junit.Test;

import test.data.TestConstants;
import test.data.WizzardData;
import test.model.MyWizzard;
import test.model.Page1;
import test.model.Page2;
import wizzard.TidWizzard;
import wizzard.WizzardConstants;
import flca.test.base.AbstractTestTemplates;


public class TestWizzardTemplates extends AbstractTestTemplates implements TestConstants
{
	@BeforeClass
	public static void beforeOnce() {
		AbstractTestTemplates.beforeOnceBase(new WizzardData());
	}
	
	@Test
	public void test01() {
		generate(MyWizzard.class, WizzardConstants.getTemplate(TidWizzard.WIZZARD_MAIN));
	}
	
	@Test 
	public void test02() {
		generate(MyWizzard.class, WizzardConstants.getTemplate(TidWizzard.WIZZARD_DIALOG));
	}
	
	@Test 
	public void test03() {
		generate(Page1.class, WizzardConstants.getTemplate(TidWizzard.WIZZARD_PAGE));
		generate(Page2.class, WizzardConstants.getTemplate(TidWizzard.WIZZARD_PAGE));
	}
	
	@Test 
	public void test04() {
		generate(MyWizzard.class, WizzardConstants.getTemplate(TidWizzard.WIZZARD_TEST));
	}
}