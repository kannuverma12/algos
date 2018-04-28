package com.my.algos;

import java.util.HashMap;
import java.util.Map;

public class MakeSentenceFromALongWord {
	private static Map<String, Integer> dictionary = new HashMap<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String longWord = "ramisagoodboy";
		
		
		
		dictionary.put("ram", 0);
		dictionary.put("is", 0);
		dictionary.put("a", 0);
		dictionary.put("good", 0);
		dictionary.put("boy", 0);
		
		
		makeSentenceFromLongWord(longWord);

	}

	private static boolean makeSentenceFromLongWord(String longWord) {
		int size = longWord.length();
		int start = 0;
		int end = size;
		for(int i=0;i<size;i++) {
			if(dictionary.get(longWord.substring(start, i)) != null && makeSentenceFromLongWord(longWord.substring(i, end-1))) {
				System.out.println(longWord.substring(start, i));
				return true;
				
			}else {
				//makeSentenceFromLongWord(longWord.substring(start, i));
			}
			
		}
		return false;
		
	}

}
