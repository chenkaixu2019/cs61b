import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
	// You must use this palindrome, and not instantiate
	// new Palindromes, or the autograder might be upset.
	static Palindrome palindrome = new Palindrome();
	static OffByOne OFFBYONE = new OffByOne();

	@Test
	public void testWordToDeque() {
		Deque d = palindrome.wordToDeque("persiflage");
		String actual = "";
		for (int i = 0; i < "persiflage".length(); i++) {
			actual += d.removeFirst();
		}
		assertEquals("persiflage", actual);
	}

	@Test
	public void testIsPalindrome() {
		assertTrue(palindrome.isPalindrome("cac"));
		assertFalse(palindrome.isPalindrome("cafjksg"));

	}

	@Test
	public void testIsPalindrome1() {
		assertFalse(palindrome.isPalindrome("shjksd", OFFBYONE));
		assertTrue(palindrome.isPalindrome("flake", OFFBYONE));

	}
}
