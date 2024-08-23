package POJOs;

import java.util.List;

public class NestedJson {
	private String name;
	private String age;
	private Address address;
	private List<Contacts> contacts;
	
	@Override
	public String toString() {
		return "NestedJson [name=" + name + ", age=" + age + ", address=" + address + ", contacts=" + contacts + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Contacts> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contacts> contacts) {
		this.contacts = contacts;
	}
	

}
