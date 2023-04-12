package sample08_list;

import java.util.ArrayList;
/* 배열과 ArrayList<E> 비교 */
public class ArrayListApp1 {

	public static void main(String[] args) {
		
		// 문자열을 저장할 수 있는 배열객체와 ArrayList객체 생성하기
		String[] arr = new String[5];
		ArrayList<String> list = new ArrayList<>();
		
		// 배열객체에 문자열 저장하기 - 배열객체에 값을 저장하기 위해서는 항상 인덱스를 알고 있어야 한다.
		arr[0] = "John";
		arr[1] = "Jane";
		arr[2] = "Alex";
		arr[3] = "Julia";
		arr[4] = "David";
//		arr[5] = "Eddy";	// 배열의 크기보다 많은 값을 넣을 수 없어서 오류
//		arr[6] = "Liz";
		
		// ArrayList객체에 문자열 저장하기 - 인덱스를 사용하지 않고 ArrayList객체에 값을 저장할 수 있다.
		list.add("John");
		list.add("Jane");
		list.add("Alex");
		list.add("Julia");
		list.add("David");
		list.add("Eddy");
		list.add("Liz");
		
		// 배열에 저장된 값 출력하기
		// enhanced-for문의 배열의 처음부터 끝까지 모든 요소를 반복처리한다.
		System.out.println("### 배열객체에 저장된 값 출력하기");
		for (String value : arr) {
			if(value == null) {
				break;		// null 값이면 탈출하게 되서 toUpperCase가 실행이 된다.
			}
			System.out.println(value + " -> " + value.toUpperCase()); // 마지막 인덱스가 null값이여서 오류 
		}
		
		// ArrayList객체에 저장된 값 출력하기
		// enhanced-for문의 ArrayList에 저장된 요소의 갯수만큼만 반복처리한다.
		System.out.println("### ArrayList객체에 저장된 값 출력하기");
		for (String value : list) {
			System.out.println(value + " -> " + value.toUpperCase());
		}
		
	}
}