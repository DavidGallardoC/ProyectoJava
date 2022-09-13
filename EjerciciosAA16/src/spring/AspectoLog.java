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

	@Before("execution(* generaArchivo())") // * cualquier generarTxt
	public void log1()
	{
		
		System.out.println("Estas por ejecutar un TXT");
	}
	
	@Before("execution(* isTxt())") // * cualquier generarTxt
	public void log2()
	{
		
		System.out.println("Validando que el archivo sea un .txt");
	}
	
	@After("execution(* generaArchivo())") // * cualquier generarTxt
	public void log3()
	{
		
		System.out.println("Archivo generado");
	}
	
	
	
}
//aspectos: El concepto de aspecto es el elemento fundamental  del 
//paradigma, se emplea una funcionalidad transversal al software
//punto de corte
//consejo o advince