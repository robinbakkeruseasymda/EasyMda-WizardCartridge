package frontend.wizzard;

import java.util.*;
import java.lang.reflect.*;
import flca.mda.api.util.*;
import flca.mda.api.util.*;
import wizzard.*;

public class WizzardMain
{
  protected static String nl;
  public static synchronized WizzardMain create(String lineSeparator)
  {
    nl = lineSeparator;
    WizzardMain result = new WizzardMain();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "package ";
  protected final String TEXT_2 = ";" + NL + " ";
  protected final String TEXT_3 = NL + "\t" + NL + "public class ";
  protected final String TEXT_4 = " extends ApplicationWindow" + NL + "{" + NL + "\t/**" + NL + "\t * @param parentShell" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_5 = "(Shell parentShell) {" + NL + "\t\tsuper(parentShell);" + NL + "\t}" + NL + "" + NL + "\t/*" + NL + "\t * (non-Javadoc)" + NL + "\t * @see" + NL + "\t * org.eclipse.jface.window.Window#createContents(org.eclipse.swt.widgets.Composite)" + NL + "\t */" + NL + "\tprotected Control createContents(Composite parent) {" + NL + "\t\tButton button = new Button(parent, SWT.PUSH);" + NL + "\t\tbutton.setText(\"Test Wizzard\");" + NL + "\t\tbutton.addListener(SWT.Selection, new Listener() {" + NL + "\t\t\tpublic void handleEvent(Event event) {" + NL + "\t\t\t\t";
  protected final String TEXT_6 = " wizard = new ";
  protected final String TEXT_7 = "();" + NL + "" + NL + "\t\t\t\tWizardDialog dialog = new WizardDialog(getShell(), wizard);" + NL + "\t\t\t\tdialog.setBlockOnOpen(true);" + NL + "\t\t\t\tint returnCode = dialog.open();" + NL + "\t\t\t\tif (returnCode == Dialog.OK)" + NL + "\t\t\t\t\tSystem.out.println(\"Ok\");" + NL + "\t\t\t\telse" + NL + "\t\t\t\t\tSystem.out.println(\"Cancelled\");" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t\treturn button;" + NL + "\t}" + NL + "}" + NL + " ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     	// here we parse the input argument(s) and create the object JetArgument:arg and Object[]:args
	JetArgument arg = null;
	Object args[] = null;
	 
	if (argument != null) { 
		if (argument instanceof JetArgument) {
			arg = (JetArgument) argument;
		} else if (argument.getClass().isArray()) { 
			args = (Object[]) argument;
			if (args[0] instanceof JetArgument) {
				arg = (JetArgument) args[0];
			}
		}
	} 

     NameUtils nu = new NameUtils();
     Object element = arg.getElement(); 
     String classname = nu.getCurrentClassname();
     TemplateUtils tplu = new TemplateUtils();
     String pck = nu.getCurrentPackage();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(pck);
    stringBuffer.append(TEXT_2);
     ImportUtils impu = new ImportUtils();
    String wizzardDlg = tplu.getClassName(TidWizzard.WIZZARD_DIALOG.name());
     impu.addImport("org.eclipse.jface.window.ApplicationWindow");
     impu.addImport("org.eclipse.jface.wizard.WizardDialog");
     impu.addImport("org.eclipse.jface.dialogs.Dialog");
     impu.addImport("org.eclipse.swt.SWT");
     impu.addImport("org.eclipse.swt.widgets.Button");
     impu.addImport("org.eclipse.swt.widgets.Composite");
     impu.addImport("org.eclipse.swt.widgets.Control");
     impu.addImport("org.eclipse.swt.widgets.Event");
     impu.addImport("org.eclipse.swt.widgets.Listener");
     impu.addImport("org.eclipse.swt.widgets.Shell");
    
 StringBuffer importStringBuffer = stringBuffer;
 int importInsertionPoint = stringBuffer.length();
 impu.addCompilationUnitImports(stringBuffer.toString());

    stringBuffer.append(TEXT_3);
    stringBuffer.append(classname);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(classname);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(wizzardDlg);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(wizzardDlg);
    stringBuffer.append(TEXT_7);
     importStringBuffer.insert(importInsertionPoint,  impu.computeSortedImports());
    return stringBuffer.toString();
  }
}
