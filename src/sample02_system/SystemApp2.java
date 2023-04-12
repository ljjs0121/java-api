package sample02_system;

import java.util.Arrays;

public class SystemApp2 {

	public static void main(String[] args) {
		
		// 배열 복사하기
		// void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
		//		src		: 원본배열
		//		srcPos	: 원본배열에서의 복사 시작위치
		//		dest	: 목적지배열
		//		destPos	: 목적지배열의 저장 시작위치
		//		length	: 복사할 갯수
		
		// src배열에 저장된 모든 값을 dest배열에 복사하기
		int[] src = {10, 20, 30, 40, 50};
		int[] dest = new int[10];
		System.arraycopy(src, 0, dest, 0, src.length);
//		System.arraycopy(src, 0, dest, 2, src.length); 인덱스 2부터 10, 20, 30, 40, 50 저장
		
		// 배열복사결과 확인하기
		System.out.println(Arrays.toString(dest));
		
		
	}
}
