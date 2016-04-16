package test.model;

import java.util.Date;

import mda.type.IWizzardPage;

public class Page2 implements IWizzardPage
{

	@Override
	public String getName()
	{
		return "Personal";
	}

	@Override
	public String getTitle()
	{
		return "Pagina 2";
	}
	
	Date dob;
	boolean married;
	
	
}
