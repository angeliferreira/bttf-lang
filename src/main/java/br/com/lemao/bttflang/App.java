package br.com.lemao.bttflang;

import java.io.IOException;

import javax.lang.model.element.Modifier;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

public class App {

	public static void main(String[] args) throws IOException {
		// Source file
		StringBuilder source = new StringBuilder();
		source.append("YEAH, WELL, HISTORY IS GONNA CHANGE"); // Begin Main
		source.append("DOC, YOU GOTTA LISTEN TO ME Hello World"); // Print
		source.append("GUESS YOU GUYS AREN’T READY FOR THAT YET"); // End Main
		
		// Parse the file
		
		// Create the main method with the statements from the parsed file
		MethodSpec main = MethodSpec.methodBuilder("main")
				.addModifiers(Modifier.PUBLIC, Modifier.STATIC)
				.returns(void.class)
				.addParameter(String[].class, "args")
				.addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
				.build();

		// Create the main executable class
		TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
				.addModifiers(Modifier.PUBLIC, Modifier.FINAL)
				.addMethod(main).build();

		// Create the final Java file
		JavaFile javaFile = JavaFile.builder("com.example.helloworld", helloWorld).build();

		// Compile
		// Execute
		
		// This only for testing the output of the file
		javaFile.writeTo(System.out);
	}

}
