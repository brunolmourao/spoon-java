package br.ufc.mes.analizador;

import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtElement;

public class LocProcessor extends AbstractProcessor<CtClass<?>> {

	public void process(CtClass<?> element) {
		int startlin = element.getPosition().getLine();
		int endlin = element.getPosition().getEndLine();
		int loc = endlin - startlin;
		
		System.out.print("Classe :" + element.getQualifiedName() + "loc " + loc);
		System.out.println("\n");

	}

}
