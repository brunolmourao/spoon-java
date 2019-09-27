package br.ufc.mes.analizador;

import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtClass;

public class NumMethodsProcessor extends AbstractProcessor<CtClass>{

	public void process(CtClass element) {
		int num_methods = element.getMethods().size();
		System.out.println("Elemento: "+element.getQualifiedName());
		System.out.println("NoDM: "+num_methods);
		
	}

}
