package chapter7_1;

public enum Suit {
	
	CLUB(0), DIAMOND(1), HEART(2), SPADE(3);
	private int value;
	private Suit(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	
	public Suit getSuitFromValue(int value) {
		
	}
}
