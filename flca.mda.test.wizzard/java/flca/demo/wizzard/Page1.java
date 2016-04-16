package flca.demo.wizzard;

import mda.type.IWizzardPage;

public class Page1 implements IWizzardPage
{

	String firstName;
	int age;
	
	@Override
	public String getName()
	{
		return "page1";
	}

	@Override
	public String getTitle()
	{
		return "Wizzard page 1";
	}

}
