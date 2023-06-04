package ru.nsu.seleznev.a.parser;

import com.sun.tools.javac.Main;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.util.DelegatingScript;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import org.codehaus.groovy.control.CompilerConfiguration;

public class Parser {
  public static Object parseConfiguration(File file, Class<?> ourClass) {
    try {
      CompilerConfiguration cc = new CompilerConfiguration();
      cc.setScriptBaseClass(DelegatingScript.class.getName());
      GroovyShell gs = new GroovyShell(Main.class.getClassLoader(), new Binding(), cc);
      DelegatingScript script = (DelegatingScript) gs.parse(file);
      Object obj = ourClass.getDeclaredConstructor().newInstance();
      script.setDelegate(obj);
      script.run();
      return obj;
    } catch (IOException | InvocationTargetException | InstantiationException | IllegalAccessException |
             NoSuchMethodException e) {
      throw new RuntimeException(e);
    }
  }
}
