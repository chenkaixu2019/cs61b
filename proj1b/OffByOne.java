
public class OffByOne implements CharacterComparator {
	@Override
	public boolean equalChars(char a, char b) {
		int res = Math.abs(a - b);
		if (res == 1) {
			return true;
		}
		return false;
	}

}
