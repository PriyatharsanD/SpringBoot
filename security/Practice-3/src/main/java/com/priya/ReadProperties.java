package com.priya;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	public static void main(String[] args) throws IOException {
		Properties p  = new Properties();
		FileInputStream input = new FileInputStream("src/main/resources/application.properties");
		p.load(input);
		System.out.println(p.getProperty("spring.datasource.url"));
		System.out.println(p.getProperty("server.port"));
	}

}
