package com.example.demo;

import com.example.demo.modules.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication(scanBasePackages = "com.example.demo")
public class App {
	private static List<Module> modules;

	@Autowired
	public App(List<Module> modules){
		App.modules = modules;
	}
	
//C:\Projects\JAVA2\JavaTech82\Files\image.jpg

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		Scanner scanner = new Scanner(System.in);
		System.out.println( "Enter file : ");
		String file = scanner.nextLine();
		File x = new File(file);


		var allowedModules = new ArrayList<Module>();
		for (var module : modules)
			if (module.isSupported(file))
				allowedModules.add(module);

		if(allowedModules.size() == 0){
			System.out.println("File not supported");
		}
		else {
			for (int i = 0; i < allowedModules.size(); i++) {
				System.out.println(Integer.valueOf(i).toString() + " " + allowedModules.get(i).getDescription());
			}

			System.out.print("Enter needed function:");
			allowedModules.get(scanner.nextInt()).Execute(file);
		}
	}


}
