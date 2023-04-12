package sample08_list;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
// stream 사용 예제
public class ArrayListApp2 {

	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<>();
		names.add("김순섭");
		names.add("이순실");
		names.add("박태준");
		names.add("유재석");
		
		System.out.println("### 콜렉션객체(ArrayList객체)에 저장된 값을 외부반복으로 처리");
		for (String name : names) {
			System.out.println(name);
		}
		
		// 변형, 수집
		List<Character> values = new ArrayList<>();
		for (String name : names) {
			values.add(name.charAt(0));
		}
		//소비
		for (char c : values) {
			System.out.println(c);
		}
		
		System.out.println("### 콜렉션객체(ArrayList객체)에 저장된 값을 내부반복으로 처리");
		names.stream().forEach(name -> System.out.println(name)); // forEach는 반복작업 메소드
		
		names.stream()
			.map(name -> name.charAt(0))						// 변형
			.collect(Collectors.toList())						// 수집
			.forEach(value -> System.out.println(value));		// 소비
	}
}
