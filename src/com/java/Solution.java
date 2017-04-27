package com.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	//path to file which is attached with zip file
	private static final String FILENAME = "/home/sameer/inputFile";

	public Map<String, List<String>> mainTask() {
		// List to store data
		List<String> words = new ArrayList<>();
		List<String> phrases = new ArrayList<>();
		Map<String, List<String>> merged = new HashMap<>();
		BufferedReader br = null;
		FileReader fr = null;

		try {

			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String sCurrentLine;

			br = new BufferedReader(new FileReader(FILENAME));

			while ((sCurrentLine = br.readLine()) != null) {

				String[] strArr = sCurrentLine.trim().split(" ");
				if (strArr.length > 1) {
					phrases.add(sCurrentLine.trim());
				} else {
					words.add(sCurrentLine.trim());
				}

				// System.out.println(sCurrentLine);
			}
			doSorting(words);
			doSorting(phrases);
			merged.put("words", words);
			merged.put("phrases", phrases);
			/*System.out.println("-- Words----");

			words.forEach(System.out::println);
			System.out.println("-- Phrases----");
			phrases.forEach(System.out::println);*/
		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
		return merged;
	}

	//sorting the list according to length and alphabets
	private static void doSorting(List<String> words) {
		words.sort((a, b) -> {

			if (a.length() == b.length()) {
				return a.compareTo(b);

			} else {
				return a.length() - b.length();
			}
		});
	}

	public static void main(String[] args) {
		new Solution().mainTask();
	}

}
