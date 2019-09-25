package br.ufc.mes.analizador;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import spoon.Launcher;
import spoon.MavenLauncher;
import spoon.SpoonAPI;
import spoon.reflect.code.CtIf;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtField;
import spoon.reflect.visitor.filter.TypeFilter;

public class App 
{
    public static void main( String[] args )
    {
    	String path = "/home/362953/Documentos/spoon-java/analizador/sua/bank-sys-master/src";
        SpoonAPI api = new Launcher();
        api.addInputResource(path);
        api.buildModel();
        //api.addProcessor("br.ufc.mes.analizador.AdjacentListProcessor");
        //api.process();
        HashMap adj = new HashMap<String,Set<String>>();
        for (CtClass<?> element: api.getModel().getElements(new TypeFilter<CtClass>(CtClass.class))) {
        	List l = element.getFields();
        	HashSet set = new HashSet();
        	Iterator<CtField> it = l.iterator();
        	//System.out.println("Class: "+ element.getQualifiedName());
        	while(it.hasNext()) {
        		CtField next = it.next();
        		//System.out.println("Field Type: "+next.getType().getQualifiedName());
        		set.add(next.getType().getQualifiedName());
        	}
        	adj.put(element.getQualifiedName(), set);
        }
        Set mapkeys = adj.keySet();
        Iterator<String> it2 = mapkeys.iterator();
        while(it2.hasNext()) {
        	String chave = it2.next();
        	if(chave != null) {
        		System.out.println("Class: "+ chave);
				System.out.println("Field: " + adj.get(chave));
        	}
        }
        HashMap adj2 = new HashMap<String,Set<String>>();
        for(CtClass<?> element: api.getModel().getElements(new TypeFilter<CtClass>(CtClass.class))) {
        	HashSet set = new HashSet();
        	CtElement l = element.getParent();
        	System.out.println(l.toString());
        }
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
