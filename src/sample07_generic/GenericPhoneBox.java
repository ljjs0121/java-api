package sample07_generic;
// 제네릭 타입 제한
public class GenericPhoneBox<T extends Phone> {

	private T item;
	public T getItem() {
		return item;
	}
	public void setItem(T item) {
		this.item = item;
	}
	
}
