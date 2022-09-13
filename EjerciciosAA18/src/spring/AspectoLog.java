package spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component


public class AspectoLog 
{

	
	@After("execution(* generartxt())") // * cualquier generarTxt
	public void log1()
	{
		
		System.out.println("Ejecutaste un TXT");
	}
	
	
}
//aspectos: El concepto de aspecto es el elemento fundamental  del 
//paradigma, se emplea una funcionalidad transversal al software
//punto de corte
//consejo o advince