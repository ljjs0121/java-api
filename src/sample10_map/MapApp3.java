package sample10_map;

import java.util.HashMap;
import java.util.Map;

public class MapApp3 {
// Map 활용
	public static void main(String[] args) {
		// Map을 이용해서 학생들의 성씨를 조사해서 성씨별 학생수를 집계하기
		String[] names = {"홍유빈", "김상구", "이준영", "김병구", "박상영", "강산에", "황창영", "이순재",
						"안창호", "김유빈", "이성수", "김병길", "차두리", "황인범", "손흥민"};
		
		// key는 성씨, value는 학생수
		Map<String, Integer> map = new HashMap<>();
		
		for (String name : names) {
			String familyName = name.substring(0, 1);
			if (map.containsKey(familyName)) { // containsKey 존재유무
				int currentCount = map.get(familyName); // 씨를 빼서 currentCount에 담는다.
				map.put(familyName, currentCount + 1); // currentCount 1 증가
			} else {
				map.put(familyName, 1);
			}
		}
		System.out.println(map);
	}
}
