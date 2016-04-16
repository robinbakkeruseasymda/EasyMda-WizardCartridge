package test.model;

import mda.type.IWizzardPage;

public class Page1 implements IWizzardPage
{

	@Override
	public String getName()
	{
		return "Page1";
	}

	@Override
	public String getTitle()
	{
		return "Pagina 1";
	}
	

	@mda.annotation.wizzard.PageField(label = "Naam")
	String name;
	
	@mda.annotation.wizzard.PageField(label = "Aantal")
	int count;

	String abc;
	int aapNootMies;
	
}
