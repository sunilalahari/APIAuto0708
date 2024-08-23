package POJOs;

public class Contacts {

	private String type;
	private String value;
	@Override
	public String toString() {
		return "Contacts [type=" + type + ", value=" + value + "]";
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
