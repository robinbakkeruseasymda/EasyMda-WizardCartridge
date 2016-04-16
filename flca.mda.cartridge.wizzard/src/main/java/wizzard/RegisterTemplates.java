package wizzard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import mda.type.IRegisterTemplates;
import flca.mda.codegen.data.ITemplate;
import flca.mda.codegen.data.SubsValue;
import flca.mda.codegen.data.SubsValueType;
import flca.mda.codegen.data.TemplatesBranch;
import flca.mda.common.api.helpers.RegisterTemplatesHelper;

public class RegisterTemplates implements IRegisterTemplates {
	@Override
	public String getName() {
		return "wizzard";
	}

	@Override
	public String getDescription() {
		return "jface wizzard";
	}

	@Override
	public List<TemplatesBranch> getTemplateBranches() {
		List<TemplatesBranch> result = new ArrayList<TemplatesBranch>();

		result.add(makeWizzardBranch());

		return result;
	}

	private TemplatesBranch makeWizzardBranch() {
		TemplatesBranch result = new TemplatesBranch();
		result.setName("wizzard");
		result.setDescription("jface wizzard");

		for (ITemplate template : new WizzardConstants().getAllTemplates()) {
			result.addTemplate(template);
		}
		
		return result;
	}

	private final static SubsValueType text = SubsValueType.TEXTINPUT;
	private final static SubsValueType folder = SubsValueType.FOLDER;
	private final static String[] ALL_WIZZARD_CARTRIDGES = new String[] {WizzardConstants.CARTRIDGE_NAME};
	private final static String WIZZARD = WizzardConstants.CARTRIDGE_NAME;

	@Override
	public Collection<SubsValue> getSubstituteValues() {
		Collection<SubsValue> result = RegisterTemplatesHelper.getCommomSubsValues(ALL_WIZZARD_CARTRIDGES);
		
		result.add(makeSubsValue(WizzardConstants.BACKEND, folder, "backend", "target directory for backend code", 2, null));
		result.add(makeSubsValue(WizzardConstants.SRC_GEN, text, "scr-gen", "sub directory for generated sources", 3, "src/main/mda-gen"));
		
		return result;
	}



	@Override
	public String getVersion() {
		return "2.0";
	}

	private SubsValue makeSubsValue(String name, SubsValueType type, String label, String help, 
			int rank, String aDefaultValue) {
		return RegisterTemplatesHelper.makeSubsValue(name, type, label, help, rank, aDefaultValue, ALL_WIZZARD_CARTRIDGES);
	}

	@Override
	public void doBefore() {
		// TODO Auto-generated method stub		
	}

	@Override
	public void doAfter() {
		// TODO Auto-generated method stub
	}

}
