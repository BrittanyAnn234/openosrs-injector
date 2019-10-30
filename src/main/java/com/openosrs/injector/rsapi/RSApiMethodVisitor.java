package com.openosrs.injector.rsapi;

import net.runelite.asm.Type;
import net.runelite.asm.attributes.annotation.Annotation;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class RSApiMethodVisitor extends MethodVisitor
{
	private final RSApiMethod method;

	RSApiMethodVisitor(RSApiMethod method)
	{
		super(Opcodes.ASM5);
		this.method = method;
	}

	public AnnotationVisitor visitAnnotation(String descriptor, boolean visible)
	{
		Annotation annotation = new Annotation(new Type(descriptor));
		this.method.getAnnotations().addAnnotation(annotation);
		return new RSApiMethodAnnotationVisitor(annotation);
	}
}
