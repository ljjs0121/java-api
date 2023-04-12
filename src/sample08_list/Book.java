package sample08_list;

import java.util.Objects;
// List 와 Set 재정의
public class Book implements Comparable<Book>{ // 정렬 구현 Comparable

	private int no;
	private String title;
	private String writer;
	private int price;

	public Book(int no, String title, String writer, int price) {
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.price = price;
	}

	public int getNo() {
		return no;
	}
	public String getTitle() {
		return title;
	}
	public String getWriter() {
		return writer;
	}
	public int getPrice() {
		return price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(no);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return no == other.no;
	}

	// 책번호를 기준으로 오름차순 정렬시킨다.
//	@Override
//	public int compareTo(Book other) {
//		return no - other.no;
	
	// 책이름을 기준으로 오름차순 정렬시킨다.
		@Override
		public int compareTo(Book o) {
			return title.compareTo(o.title);
	}
}

