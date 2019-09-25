package br.ufc.mes.analizador;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtType;

public class AdjacentListProcessor extends AbstractProcessor<CtType<?>>{
	HashMap adj = new HashMap<String,Set<String>>();
	public void process(CtType<?> element) {
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
		Set mapkeys = adj.keySet();
		Iterator<String> it2 = mapkeys.iterator();
		while(it2.hasNext()) {
			String chave = it2.next();
			if(chave != null) {
				System.out.println("Class: "+ chave);
				System.out.println("Field: " + adj.get(chave));
			}
		}
	}

}
