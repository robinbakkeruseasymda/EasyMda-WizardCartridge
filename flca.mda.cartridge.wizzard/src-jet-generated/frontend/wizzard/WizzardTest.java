package frontend.wizzard;

import java.util.*;
import java.lang.reflect.*;
import flca.mda.api.util.*;
import mda.type.*;
import wizzard.*;

public class WizzardTest
{
  protected static String nl;
  public static synchronized WizzardTest create(String lineSeparator)
  {
    nl = lineSeparator;
    WizzardTest result = new WizzardTest();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "package ";
  protected final String TEXT_2 = ";";
  protected final String TEXT_3 = NL + "\t " + NL + "public class ";
  protected final String TEXT_4 = " " + NL + "{" + NL + "\t@Test" + NL + "\tpublic void testWizzard() {" + NL + "\t\t";
  protected final String TEXT_5 = " wizzard = new ";
  protected final String TEXT_6 = "(null);" + NL + "\t\twizzard.setBlockOnOpen(true);" + NL + "\t\twizzard.open();" + NL + "\t}" + NL + "}";

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
     String classname = nu.getCurrentClassname();
     String pck = nu.getCurrentPackage();
     TemplateUtils tplu = new TemplateUtils();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(pck);
    stringBuffer.append(TEXT_2);
     ImportUtils impu = new ImportUtils();
    
 StringBuffer importStringBuffer = stringBuffer;
 int importInsertionPoint = stringBuffer.length();
 impu.addCompilationUnitImports(stringBuffer.toString());

    String wizzard = tplu.getClassName(TidWizzard.WIZZARD_MAIN.name());
     impu.addImport("org.junit.Test");
    stringBuffer.append(TEXT_3);
    stringBuffer.append(classname);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(wizzard);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(wizzard);
    stringBuffer.append(TEXT_6);
     importStringBuffer.insert(importInsertionPoint,  impu.computeSortedImports());
    return stringBuffer.toString();
  }
}
