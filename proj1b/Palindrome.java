
public class Palindrome {

	public Deque<Character> wordToDeque(String word) {
		Deque<Character> res = new LinkedListDeque();
		if (word == null) {
			return null;
		}

		for (int i = 0; i < word.length(); i++) {
			res.addLast(word.charAt(i));
		}
		return res;
	}

	public boolean isPalindrome(String word) {
		boolean dummyOne = false;
		if (word == null) {
			return false;
		}
		if (word.length() <= 1) {
			return true;
		}
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
				dummyOne = false;
			}
		}
		return false;
	}
	
	public boolean isPalindrome(String word, CharacterComparator cc) {
		boolean res = true;
		if (word == null) {
			return false;
		}
		if (word.length() <= 1) {
			return true;
		}
		for (int i = 0; i < word.length(); i++) {
			if (word.length() %2 != 0) {
				if(i != word.length() / 2) {
					res = res && cc.equalChars(word.charAt(i), word.charAt(word.length() - i - 1));
				}
			}else {
				res = res && cc.equalChars(word.charAt(i), word.charAt(word.length() - i - 1));
			}
		}
		return res;
	}

}
