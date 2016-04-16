package frontend.wizzard;

import java.util.*;
import java.lang.reflect.*;
import flca.mda.api.util.*;
import flca.mda.codegen.data.*;
import wizzard.*;
import mda.type.*;

public class WizzardDialog
{
  protected static String nl;
  public static synchronized WizzardDialog create(String lineSeparator)
  {
    nl = lineSeparator;
    WizzardDialog result = new WizzardDialog();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + " ";
  protected final String TEXT_3 = " ";
  protected final String TEXT_4 = NL + "\t" + NL + "class ";
  protected final String TEXT_5 = " extends Wizard {" + NL + "" + NL + "\t// the model object." + NL + "" + NL + "\tpublic ";
  protected final String TEXT_6 = "() {" + NL + "\t\tsetWindowTitle(\"";
  protected final String TEXT_7 = "\");" + NL + "\t\tsetNeedsProgressMonitor(true);" + NL + "\t\tsetDefaultPageImageDescriptor(ImageDescriptor.createFromFile(null, \"";
  protected final String TEXT_8 = "\"));" + NL + "" + NL + "\t\tDialogSettings dialogSettings = new DialogSettings(\"userInfo\");" + NL + "" + NL + "\t\tsetDialogSettings(dialogSettings);" + NL + "" + NL + "\t}" + NL + "" + NL + "\t/*" + NL + "\t * (non-Javadoc)" + NL + "\t * " + NL + "\t * @see org.eclipse.jface.wizard.IWizard#addPages()" + NL + "\t */" + NL + "\tpublic void addPages() {";
  protected final String TEXT_9 = NL + "\t\taddPage(new ";
  protected final String TEXT_10 = "());";
  protected final String TEXT_11 = NL + "\t}" + NL + "" + NL + "\t/*" + NL + "\t * (non-Javadoc)" + NL + "\t * " + NL + "\t * @see org.eclipse.jface.wizard.IWizard#performFinish()" + NL + "\t */" + NL + "\tpublic boolean performFinish() {" + NL + "\t\tif (getDialogSettings() != null) {" + NL + "\t\t\t//TODO" + NL + "\t\t}" + NL + "" + NL + "\t\ttry {" + NL + "\t\t\t// puts the data into a database ..." + NL + "\t\t\tgetContainer().run(true, true, new IRunnableWithProgress()" + NL + "\t\t\t{" + NL + "\t\t\t\tpublic void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\tmonitor.beginTask(\"Store data\", 100);" + NL + "\t\t\t\t\tmonitor.worked(40);" + NL + "" + NL + "\t\t\t\t\t// TODO store data here ..." + NL + "//\t\t\t\t\tSystem.out.println(data);" + NL + "" + NL + "\t\t\t\t\tThread.sleep(2000);" + NL + "\t\t\t\t\tmonitor.done();" + NL + "\t\t\t\t}" + NL + "\t\t\t});" + NL + "\t\t} catch (InvocationTargetException e) {" + NL + "\t\t\te.printStackTrace();" + NL + "\t\t} catch (InterruptedException e) {" + NL + "\t\t\te.printStackTrace();" + NL + "\t\t}" + NL + "" + NL + "\t\treturn true;" + NL + "\t}" + NL + "" + NL + "\t/*" + NL + "\t * (non-Javadoc)" + NL + "\t * " + NL + "\t * @see org.eclipse.jface.wizard.IWizard#performCancel()" + NL + "\t */" + NL + "\tpublic boolean performCancel() \t{" + NL + "\t\tboolean ans = MessageDialog.openConfirm(getShell(), \"Confirmation\", \"Are you sure to cancel the task?\");" + NL + "\t\tif (ans)" + NL + "\t\t\treturn true;" + NL + "\t\telse" + NL + "\t\t\treturn false;" + NL + "\t}" + NL + "}" + NL + " ";

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

     TypeUtils tu = new TypeUtils();
     NameUtils nu = new NameUtils();
     Object element = arg.getElement(); 
     String classname = nu.getCurrentClassname();
     String pck = nu.getCurrentPackage();
     TemplateUtils tplu = new TemplateUtils();
     IWizzard iwiz = (IWizzard) element; 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(pck);
    stringBuffer.append(TEXT_2);
     ImportUtils impu = new ImportUtils();
    stringBuffer.append(TEXT_3);
     impu.addImport("org.eclipse.jface.dialogs.DialogSettings");
     impu.addImport("org.eclipse.jface.resource.ImageDescriptor");
     impu.addImport("org.eclipse.jface.operation.IRunnableWithProgress");
     impu.addImport("org.eclipse.core.runtime.IProgressMonitor");
     impu.addImport("java.lang.reflect.InvocationTargetException");
     impu.addImport("org.eclipse.jface.dialogs.MessageDialog");
     impu.addImport("org.eclipse.jface.wizard.Wizard");
    
 StringBuffer importStringBuffer = stringBuffer;
 int importInsertionPoint = stringBuffer.length();
 impu.addCompilationUnitImports(stringBuffer.toString());

    stringBuffer.append(TEXT_4);
    stringBuffer.append(classname);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(classname);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(iwiz.getTitle());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(iwiz.getImage());
    stringBuffer.append(TEXT_8);
     ITemplate pageTemplate = tplu.getTemplate(TidWizzard.WIZZARD_PAGE.name()); 
     for (IWizzardPage wizpage : iwiz.getPages()) { 
    stringBuffer.append(TEXT_9);
    stringBuffer.append(tplu.getClassName(wizpage.getClass(), pageTemplate));
    stringBuffer.append(TEXT_10);
     } 
    stringBuffer.append(TEXT_11);
     importStringBuffer.insert(importInsertionPoint,  impu.computeSortedImports());
    return stringBuffer.toString();
  }
}
