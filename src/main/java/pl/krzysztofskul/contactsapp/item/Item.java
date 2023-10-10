package pl.krzysztofskul.contactsapp.item;

public abstract class Item<T> {

	private String name;
	
	private T data;

	/**
	 * 
	 */
	public Item() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param data
	 */
	public Item(String name, T data) {
		this.name = name;
		this.data = data;
	}
	
	
	
}
