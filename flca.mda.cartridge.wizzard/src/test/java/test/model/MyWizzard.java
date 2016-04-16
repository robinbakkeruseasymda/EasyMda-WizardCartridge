package test.model;

import java.util.ArrayList;
import java.util.List;

import mda.type.IWizzard;
import mda.type.IWizzardPage;

public class MyWizzard implements IWizzard
{

	@Override
	public String getTitle()
	{
		return "Demo Wizzard !!";
	}

	@Override
	public String getImage()
	{
		return "C:/mydocs/robin/Project/flca/projects/com.flca.mda/FlcaMdaCodegen/src-test/icons/hotel.gif";
	}

	@Override
	public List<IWizzardPage> getPages()
	{
		List<IWizzardPage> result = new ArrayList<IWizzardPage>();
		
		result.add(new Page1());
		result.add(new Page2());
		
		return result;
	}


}
