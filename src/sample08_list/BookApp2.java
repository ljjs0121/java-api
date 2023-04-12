package sample08_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* 정렬하기 Collection.sort() 와 람다식 정렬법 */
public class BookApp2 {

	public static void main(String[] args) {
		List<Book> books = new ArrayList<>();
		
		books.add(new Book(100, "자바의 정석", "남궁성", 35000));
		books.add(new Book(102, "세이노의 가르침", "세이노", 7800));
		books.add(new Book(105, "스프링입문을 위한 자바 객체지향의 원리와 이해", "김종민", 24000));
		books.add(new Book(103, "CleanCode", "로버트 c.마틴", 28000));
		books.add(new Book(101, "인생은 소설이다", "기욤 뮈소 ", 35000));
		books.add(new Book(104, "함께 자라기", "김창준", 35000));
		
		// List객체에 저장된 책정보 정렬시키기
		Collections.sort(books);
		// List객체에 저장된 책정보를 가격을 기준으로 정렬시키기
		Collections.sort(books, (b1, b2) -> b1.getPrice() - b2.getPrice());
		// List객체에 저장된 책정보를 저자명을 기준으로 정렬키기
		Collections.sort(books, (b1, b2) -> b1.getWriter().compareTo(b2.getWriter()));
		// List객체에 저자오딘 책정보를 가격순을 기준으로 정렬시키고, 가격이 동일하면 제목순으로 정렬시키기
		Collections.sort(books, (b1, b2) -> {
			int gap = b1.getPrice() - b2.getPrice();
			if (gap == 0) {
				return b1.getTitle().compareTo(b2.getTitle());
			}
			return gap;
		});

		for (Book book : books) {
			System.out.println(book.getNo());
			System.out.println(book.getTitle());
			System.out.println(book.getWriter());
			System.out.println(book.getPrice());
			System.out.println();
		}
		
		
	}
}
