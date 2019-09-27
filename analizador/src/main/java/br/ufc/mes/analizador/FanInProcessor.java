package br.ufc.mes.analizador;

import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtElement;

public class FanInProcessor extends AbstractProcessor<CtClass>{

	public void process(CtClass element) {
		// TODO Auto-generated method stub
		int num_tipos = element.getDirectChildren().size();
		System.out.println("Elemento: "+element.getQualifiedName());
		System.out.println("Fan In: " + num_tipos);
		System.out.println("///////////////////////////////");
	}

}
