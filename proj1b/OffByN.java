public class OffByN implements CharacterComparator {

	private int difference;

	public OffByN(int item) {
		difference = item;
	}

	@Override
	public boolean equalChars(char a, char b) {
		int res = Math.abs(a - b);
		if (res == difference) {
			return true;
		}
		return false;

	}
}
