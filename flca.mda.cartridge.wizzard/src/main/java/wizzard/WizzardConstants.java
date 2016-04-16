package wizzard;

import java.util.ArrayList;
import java.util.List;

import mda.type.IWizzard;
import mda.type.IWizzardPage;
import flca.mda.codegen.CodegenConstants;
import flca.mda.codegen.data.ITemplate;
import flca.mda.codegen.data.Template;
import flca.mda.codegen.data.TemplateMergeStrategy;
import frontend.wizzard.WizzardDialog;
import frontend.wizzard.WizzardMain;
import frontend.wizzard.WizzardPage;
import frontend.wizzard.WizzardTest;

public class WizzardConstants {

	public static final String CARTRIDGE_NAME = "wizzard";
	public static final String BACKEND = "Backend";
	public static final String SRC_GEN = "src-gen";

	public static final String Classname = "<%=" + CodegenConstants.CLASSNAME + "%>";
	public static final String Backend = "<%=" + BACKEND + "%>" + "/" + "<%=" + SRC_GEN + "%>";
	public static final String SrcGen = "<%=" + SRC_GEN + "%>";
	private static final String PCK = "<%=" + CodegenConstants.PACKAGE + "%>";
	
	private static List<ITemplate> allTemplates;

	public WizzardConstants() {
		super();
		if (allTemplates == null) {
			allTemplates = makeTemplates();
		}
	}

	public List<ITemplate> getAllTemplates() {
		return allTemplates;
	}
	
	public static ITemplate getTemplate(TidWizzard aTid) {
		for (ITemplate t : allTemplates) {
			if (t.getName().equals(aTid.name())) {
				return t;
			}
		}
		return null;
	}
	
	private List<ITemplate> makeTemplates() {
		List<ITemplate> result = new ArrayList<ITemplate>();
		
		result.add(makeTemplate_WIZZARD_MAIN());
		result.add(makeTemplate_WIZZARD_DIALOG());
		result.add(makeTemplate_WIZZARD_PAGE());
		result.add(makeTemplate_WIZZARD_TEST());
				
		return result;
	}
	
	private ITemplate makeTemplate_WIZZARD_MAIN() {
		Template r = new Template();
		r.setName(TidWizzard.WIZZARD_MAIN.name());
		r.setPackage(PCK);
		r.setClassname(Classname + "Dialog");
		r.setTargetDir(Backend);
		r.setFileExtension(".java");
		r.setGeneratorFqn(WizzardMain.class.getName());
		r.setJetPath("/wizzard/WizzardMain.jet");
		r.setMergeStrategy(TemplateMergeStrategy.MERGE);
		r.setCartridgeName(CARTRIDGE_NAME);
		r.setApplyToClasses(new Class<?> [] {IWizzard.class,});
		r.setRank(5);
		return r;
	}

	private ITemplate makeTemplate_WIZZARD_DIALOG() {
		Template r = new Template();
		r.setName(TidWizzard.WIZZARD_DIALOG.name());
		r.setPackage(PCK);
		r.setClassname(Classname);
		r.setTargetDir(Backend);
		r.setFileExtension(".java");
		r.setGeneratorFqn(WizzardDialog.class.getName());
		r.setJetPath("/wizzard/WizzardDialog.jet");
		r.setMergeStrategy(TemplateMergeStrategy.MERGE);
		r.setCartridgeName(CARTRIDGE_NAME);
		r.setApplyToClasses(new Class<?> [] {IWizzard.class,});
		r.setRank(5);
		return r;
	}

	private ITemplate makeTemplate_WIZZARD_PAGE() {
		Template r = new Template();
		r.setName(TidWizzard.WIZZARD_PAGE.name());
		r.setPackage(PCK);
		r.setClassname(Classname);
		r.setTargetDir(Backend);
		r.setFileExtension(".java");
		r.setGeneratorFqn(WizzardPage.class.getName());
		r.setJetPath("/wizzard/WizzardPage.jet");
		r.setMergeStrategy(TemplateMergeStrategy.MERGE);
		r.setCartridgeName(CARTRIDGE_NAME);
		r.setApplyToClasses(new Class<?> [] {IWizzardPage.class,});
		r.setRank(5);
		return r;
	}

	private ITemplate makeTemplate_WIZZARD_TEST() {
		Template r = new Template();
		r.setName(TidWizzard.WIZZARD_TEST.name());
		r.setPackage(PCK + ".test");
		r.setClassname("Test" + Classname);
		r.setTargetDir(Backend);
		r.setFileExtension(".java");
		r.setGeneratorFqn(WizzardTest.class.getName());
		r.setJetPath("/wizzard/WizzardTest.jet");
		r.setMergeStrategy(TemplateMergeStrategy.MERGE);
		r.setCartridgeName(CARTRIDGE_NAME);
		r.setApplyToClasses(new Class<?> [] {IWizzard.class,});
		r.setRank(5);
		return r;
	}

}
