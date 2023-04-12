package sample09_set;

import java.util.HashSet;

public class HashSetApp1 {
/* HashSet 사용 예제 */
	public static void main(String[] args) {
		
		//HashSet의 주요 API
		HashSet<String> names = new HashSet<>();
		
		// 객체 저장하기
		names.add("김기남");
		names.add("강개리");
		names.add("이기제");
		names.add("유시민");
		names.add("안창호");

		// 저장된 객체의 갯수를 조회하기
		int count = names.size();
		System.out.println("저장된 객체의 갯수 -> " + count);
		
		// 저장된 객체 삭제하기
		names.remove("이기제");

		// HashSet객체에 지정된 객체가 존재하는지 조회하기
		boolean isExist = names.contains("안창호");
		System.out.println("안창호가 존재하는가? -> " + isExist);
		
		// 향상된 for문으로 저장된 객체를 반복처리하기
		System.out.println("### 삭제 후 저장된 이름 확인하기");
		for (String name : names) {
			System.out.println("이름 -> " + name); // HashSet은 저장했던 순서대로 출력되지 않는다.
		}
		
	}
}
