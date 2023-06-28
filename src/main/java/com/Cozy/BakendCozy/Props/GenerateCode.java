package com.Cozy.BakendCozy.Props;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GenerateCode {
	
	   private static final String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	    private static final int LONGITUD_CODIGO = 8;
	    private static final int MAX_INTENTOS = 10000;

	    private static Set<String> codigosGenerados = new HashSet<>();

	    public static String main(String[] args) {
	        String codigo = generarCodigoUnico();
	        return codigo;
	    }

	    public static String generarCodigoUnico() {
	        String codigo = generarCodigoAleatorio();

	        int intentos = 0;
	        while (codigosGenerados.contains(codigo) && intentos < MAX_INTENTOS) {
	            codigo = generarCodigoAleatorio();
	            intentos++;
	        }

	        if (intentos == MAX_INTENTOS) {
	            throw new IllegalStateException("No se pudo generar un código único después de " + MAX_INTENTOS + " intentos.");
	        }

	        codigosGenerados.add(codigo);
	        return codigo;
	    }

	    private static String generarCodigoAleatorio() {
	        StringBuilder sb = new StringBuilder();
	        Random random = new Random();
	        for (int i = 0; i < LONGITUD_CODIGO; i++) {
	            int index = random.nextInt(CARACTERES.length());
	            sb.append(CARACTERES.charAt(index));
	        }
	        return sb.toString();
	    }

}
