package sample07_generic;

public class GenericBox<T> { // <T> 타입파라미터

	private T item;
	public T getItem() {
		return item;
	}
	public void setItem(T item) {
		this.item = item;
	}
	
}
