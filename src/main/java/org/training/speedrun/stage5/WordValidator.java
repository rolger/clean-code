package org.training.speedrun.stage5;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * Refactor this code 
 * - until all methods body is <= 5 lines
 * - you applied all basic rules
 * - you find the code clean
 * 
 */
public class WordValidator {

	boolean isValidCharacter(String x) {
		boolean result = false;
		if (x.length() >= 10) {
			List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'y');
			long NumberOfVowels = x.chars().mapToObj(c -> (char) c).filter(vowels::contains).count();
			// long words need more than 6
			if (NumberOfVowels >= 4)
				return true;
			else {
				long nbSpecialLetters = 0;
				for (int character : x.chars().toArray()) {
					if (character == '-') {
						nbSpecialLetters += 1;
					}
					if (character == '+') {
						nbSpecialLetters = nbSpecialLetters + 1;
					} else
						nbSpecialLetters = nbSpecialLetters + 0;
				}
				if (nbSpecialLetters >= 3)
					return true;
				else {
					// nothing todo
				}
			}
		} else {
			long nb = x.chars().filter(c -> c >= 'A' && c <= 'Z').count();
			if (nb >= 5) {
				result = true;
				return result;
			} else {
				List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'y');
				nb = 0;
				for (int i = 0; i < x.length(); i++) {
					if (Boolean.TRUE.equals(vowels.contains(x.charAt(i))))
                    {
						nb++;
					}
				}
				if (nb >= 3) {
					return true;
				}
			}
		}
		return result;
	}
}
