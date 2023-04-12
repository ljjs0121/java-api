package sample03_string;

import java.util.StringJoiner;

public class StringJoinerApp {

	public static void main(String[] args) {
		// StringJoiner - 구분문자로 문자열을 나열해준다.
		StringJoiner joiner = new StringJoiner(",");
		joiner.add("홍유빈");
		joiner.add("강개리");
		joiner.add("김유빈");
		joiner.add("이상호");
		joiner.add("문동은");
		joiner.add("강혜정");
		joiner.add("안창호");
		
		String text = joiner.toString();
		System.out.println(text);
	}
}
