package frontend.wizzard;

import java.util.*;
import java.lang.reflect.*;
import java.lang.annotation.*;
import flca.mda.api.util.*;
import mda.type.*;
import mda.annotation.wizzard.*;
import wizzard.*;

public class WizzardPage
{
  protected static String nl;
  public static synchronized WizzardPage create(String lineSeparator)
  {
    nl = lineSeparator;
    WizzardPage result = new WizzardPage();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "package ";
  protected final String TEXT_2 = ";" + NL + " ";
  protected final String TEXT_3 = NL + "\t" + NL + "class ";
  protected final String TEXT_4 = " extends WizardPage {";
  protected final String TEXT_5 = NL + "\tprivate Text ";
  protected final String TEXT_6 = ";";
  protected final String TEXT_7 = NL + NL + NL + "\tpublic ";
  protected final String TEXT_8 = "() {" + NL + "\t\tsuper(\"";
  protected final String TEXT_9 = "\");" + NL + "\t\tsetTitle(\"";
  protected final String TEXT_10 = "\");" + NL + "\t}" + NL + "" + NL + "\t/*" + NL + "\t * (non-Javadoc)" + NL + "\t * " + NL + "\t * @see" + NL + "\t * org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets" + NL + "\t * .Composite)" + NL + "\t */" + NL + "\tpublic void createControl(Composite parent) {" + NL + "\t\tComposite composite = new Composite(parent, SWT.NULL);" + NL + "\t\tcomposite.setLayout(new GridLayout(2, false));" + NL;
  protected final String TEXT_11 = NL + "\t\tnew Label(composite, SWT.NULL).setText(\"";
  protected final String TEXT_12 = ": \");" + NL + "\t\t";
  protected final String TEXT_13 = " = new Text(composite, SWT.SINGLE | SWT.BORDER);" + NL + "\t\t";
  protected final String TEXT_14 = ".setLayoutData(new GridData(GridData.FILL_HORIZONTAL));" + NL + "\t\t";
  protected final String TEXT_15 = ".addListener(SWT.Modify, new ";
  protected final String TEXT_16 = "());" + NL + "\t\t";
  protected final String TEXT_17 = NL + NL + "\t\tif (getDialogSettings() != null && validDialogSettings()) {" + NL + "\t\t\t//TODO populate\t" + NL + "\t\t}" + NL + "" + NL + "\t\tsetControl(composite);" + NL + "\t}" + NL + "" + NL + "\tprivate boolean validDialogSettings() {" + NL + "\t\t//TODO" + NL + "\t\treturn true;" + NL + "\t}" + NL + "\t" + NL + "\t@Override" + NL + "\tpublic boolean canFlipToNextPage() {" + NL + "\t\t//TODO " + NL + "\t\treturn true;" + NL + "\t}" + NL + "" + NL + "\t//--- Listener on input fields";
  protected final String TEXT_18 = NL + "\tclass ";
  protected final String TEXT_19 = " implements Listener {" + NL + "\t\tpublic void handleEvent(Event event) {" + NL + "\t\t\t//TODO " + NL + "\t\t}" + NL + "\t};\t" + NL + "\t";
  protected final String TEXT_20 = NL + "\t\t" + NL + "}" + NL + " ";

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
     IWizzardPage wizpage = (IWizzardPage) element; 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(pck);
    stringBuffer.append(TEXT_2);
     ImportUtils impu = new ImportUtils();
     impu.addImport("org.eclipse.jface.wizard.WizardPage");
     impu.addImport("org.eclipse.swt.SWT");
     impu.addImport("org.eclipse.swt.widgets.Listener");
     impu.addImport("org.eclipse.swt.widgets.Text");
     impu.addImport("org.eclipse.swt.widgets.Event");
     impu.addImport("org.eclipse.swt.widgets.Label");
     impu.addImport("org.eclipse.swt.widgets.Composite");
     impu.addImport("org.eclipse.swt.layout.GridData");
     impu.addImport("org.eclipse.swt.layout.GridLayout");
    
 StringBuffer importStringBuffer = stringBuffer;
 int importInsertionPoint = stringBuffer.length();
 impu.addCompilationUnitImports(stringBuffer.toString());

    stringBuffer.append(TEXT_3);
    stringBuffer.append(classname);
    stringBuffer.append(TEXT_4);
     for (Fw fw : tu.getAllFields(element.getClass())) { 
     String fldname = nu.uncapName(fw); 
    stringBuffer.append(TEXT_5);
    stringBuffer.append(fldname);
    stringBuffer.append(TEXT_6);
     } //for loop 
    stringBuffer.append(TEXT_7);
    stringBuffer.append(classname);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(wizpage.getName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(wizpage.getTitle());
    stringBuffer.append(TEXT_10);
     for (Fw fw : tu.getAllFields(element.getClass())) { 
     String fldname = nu.uncapName(fw); 
     String listener = nu.capName(fw) + "Listener"; 
     PageField anno = (PageField) tu.getAnnotation(fw, PageField.class); 
     String prompt = anno != null ? anno.label() : fldname; 
    stringBuffer.append(TEXT_11);
    stringBuffer.append(prompt);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(fldname);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(fldname);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(fldname);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(listener);
    stringBuffer.append(TEXT_16);
     } //for loop 
    stringBuffer.append(TEXT_17);
     for (Fw fw : tu.getAllFields(element.getClass())) { 
     String fldname = nu.uncapName(fw); 
     String listener = nu.capName(fw) + "Listener"; 
    stringBuffer.append(TEXT_18);
    stringBuffer.append(listener);
    stringBuffer.append(TEXT_19);
     } //for loop 
    stringBuffer.append(TEXT_20);
     importStringBuffer.insert(importInsertionPoint,  impu.computeSortedImports());
    return stringBuffer.toString();
  }
}
