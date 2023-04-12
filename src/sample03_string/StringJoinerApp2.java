package sample03_string;

import java.util.StringJoiner;

import javax.print.attribute.standard.JobName;

public class StringJoinerApp2 {

	public static void main(String[] args) {
		String[] names = {"김유신", "강감찬", "이순신"};
		
		StringJoiner joiner = new StringJoiner(",");
		for (String x : names) {
			joiner.add(x);
		}
		String text = joiner.toString();
		System.out.println(text);
		
		// Joiner가 없었을 때 코드
//		String text = "";
//		for (String x : names) {
//			text += x;
//			text += ",";
//		}
//		text = text.substring(0, text.length() -1);
//		System.out.println(text);
	}
}

