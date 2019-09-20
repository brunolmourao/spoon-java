package br.ufc.mes.analizador;

import java.util.List;

import spoon.Launcher;
import spoon.MavenLauncher;
import spoon.SpoonAPI;
import spoon.reflect.code.CtIf;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.visitor.filter.TypeFilter;

public class App 
{
    public static void main( String[] args )
    {
    	String path = "/home/362953/Downloads/bank-sys-master/src";
        SpoonAPI api = new Launcher();
        api.addInputResource(path);
        api.buildModel();
        api.addProcessor("br.ufc.mes.analizador.LocProcessor");
        api.process();
        
        /*for(CtClass<?> element: api.getModel().getElements(new TypeFilter<CtClass>(CtClass.class))) {
        	System.out.println("Class" + element.getQualifiedName());
        	System.out.println("Metodos"+ element.getDeclaredExecutables().size());
        	System.out.println("Atributos"+ element.getDeclaredFields().size());
        	List<CtIf> ifs = element.getElements(new TypeFilter<CtIf>(CtIf.class));
        	for(CtIf oneIf : ifs) {
        		int lin = oneIf.getPosition().getLine();
        		int col = oneIf.getPosition().getColumn();
        		System.out.println("If's condition : " + oneIf.getCondition() + " line: " + lin + " column: " + col);
        	}
        	System.out.println("\n");
        }*/
    }
}
