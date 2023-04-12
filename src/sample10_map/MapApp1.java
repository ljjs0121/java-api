package sample10_map;

import java.util.HashMap;

public class MapApp1 {

	public static void main(String[] args) {
		
		// HashMap객체로 정보 저장하기
		// key:사용자아이디, value : 사용자이름
		HashMap<String, String> map = new HashMap<>();
		
		// HashMap객체에 key, value 저장하기
		map.put("kim", "김유신");
		map.put("park", "박재범");
		map.put("lee", "이순재");
		map.put("yu", "유산슬");
		map.put("ahn", "안창호");
		
		// HashMap객체에 저장된 정보를 key를 이용해서 조회하기
		String value1 = map.get("kim");
		System.out.println("조회된 값 -> " + value1);
		// 존재하지 않는 key로 값을 조회하면 null로 반환된다.
		String value2 = map.get("hong");
		System.out.println("조회된 값 -> " + value2);
		
		// HashMap객체에 저장된 정보를 key를 이용해서 삭제하기
		map.remove("park");
		// 존재하지 않는 key로 정보를 삭제하면 아무일도 일어나지 않는다.
		map.remove("hong");	
		
	}
}
