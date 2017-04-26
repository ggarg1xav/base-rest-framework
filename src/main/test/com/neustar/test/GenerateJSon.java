package com.neustar.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GenerateJSon {
	private static final String FILENAME = "src\\test\\resources\\testdata\\SampleJson.json";

	public static void main(String[] args) throws IOException {

		GenerateJSon GJ = new GenerateJSon();
		String content = GJ.readJsonFile(FILENAME);
		content = GJ.replaceJsonVariable(content, "age", 20);
		content = GJ.replaceJsonVariable(content, "name", "ABCDEF");
		System.out.println(content);
		
	}

	public String readJsonFile(String file) {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append("\n");
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

	public String replaceJsonVariable(String str, String replaceVariable, Object value) {
		return str.replaceAll("\\$\\{" + replaceVariable + "\\}", value.toString());
	}

}