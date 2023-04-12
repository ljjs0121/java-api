package sample09_set;

import java.util.TreeSet;

public class TreeSetApp1 {
/* TreeSet 사용 예제 */
	public static void main(String[] args) {
		
		TreeSet<String> names = new TreeSet<>();
		
		names.add("김기리");
		names.add("강하나");
		names.add("이규민");
		names.add("유산슬");
		names.add("안창호");
		
		for	 (String name : names) {
			System.out.println(name); // TreeSet은 오름차순으로 정렬되어서 값을 저장한다.
		}
		
	}
}
