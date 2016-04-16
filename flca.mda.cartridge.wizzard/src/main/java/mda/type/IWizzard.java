package mda.type;

import java.util.List;

public interface IWizzard extends IBaseType
{
	String getTitle();
	
	/**
	 * get resource of tge image
	 * @return
	 */
	String getImage();
	
	List<IWizzardPage> getPages();
}
