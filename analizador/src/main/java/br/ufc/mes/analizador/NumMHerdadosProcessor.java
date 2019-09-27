package br.ufc.mes.analizador;

import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtClass;

public class NumMHerdadosProcessor extends AbstractProcessor<CtClass>{

	public void process(CtClass element) {
		int num_methods = element.getAllMethods().size();
		int num_dec = element.getMethods().size();
		System.out.println("Elemento: "+element.getQualifiedName());
		System.out.println("NoDMH: "+ (num_methods - num_dec));	
		
	}

}
