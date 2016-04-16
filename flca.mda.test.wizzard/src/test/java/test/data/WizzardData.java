package test.data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.flca.frw.util.FileUtils;

import flca.mda.codegen.CodegenConstants;
import flca.mda.codegen.data.SubsValue;
import flca.test.base.AbstractTestTemplatesData;

public class WizzardData extends AbstractTestTemplatesData implements TestConstants 
{
	@Override
	public File getPluginDir() {
		return new File(getProjectDir() + "/" + PLUGIN_DIR);
	}

	@Override
	public File getModelDir() {
		return new File(getProjectDir() + "/" + WEBAPP_MODEL_DIR);
	}

	@Override
	public File getTemplateDir() {
		return new File(getProjectDir() + "/" + WIZARD_CARTRIDGE);
	}
	
	private final static String BACKEND_SRC_GEN = 
			FileUtils.getTempDir() + "/src-wizard-generated";
	
	@Override
	public List<SubsValue> getSubsvalues() {
		List<SubsValue> r = new ArrayList<SubsValue>();
		r.add(new SubsValue(CodegenConstants.APP_NAME, "Demo"));
		r.add(new SubsValue(CodegenConstants.APP_PACKAGE, "flca.demo"));
		r.add(new SubsValue("Backend", BACKEND_SRC_GEN));
		return r;
	}
}

