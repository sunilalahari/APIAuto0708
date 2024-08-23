
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;

import groovyjarjarantlr4.v4.runtime.atn.SemanticContext.Predicate;

public class LamdaExpressions {
	
	public List<Book> getBooks() {
		List<Book> lb = new ArrayList<LamdaExpressions.Book>();
		lb.add(new Book("JavaBook", 190923.23f, "Alahari Zera"));
		lb.add(new Book("C# Book", 8923.23f, "Sirisha Alahari"));	
		lb.add(new Book(".net", 78783.30f, "Bala Chandra Alahari"));
		lb.add(new Book("Python", 128773.293f, "Yuvan Teja"));
		return lb;
	}
	public List<Book> getBooksSort(){
		List<Book> ls= new LamdaExpressions().getBooks();
		//Collections.sort(ls,(o1,o2)->o1.getAuthorName().compareTo(o2.getAuthorName()));
		//ls.stream().sorted((b1,b2)->b2.getAuthorName().compareTo(b1.getAuthorName())).forEach(System.out::println);
		ls.stream().sorted(Comparator.comparing(Book::getName).reversed()).forEach(ob->System.out.println(ob.getName()));
		return ls;
	}
	
	public static void main(String[] args) {
		FunctionalInter inter = new FunctionalInter() {			
			@Override
			public void m1() {
				//System.out.println("Implementation of Functional Interf:   ");
			}
		};
		/*inter.m1();
		FunctionalInter i = ()-> System.out.println("Ananymous Implimentation...");
		i.m1();
		java.util.function.Predicate<String> p = s->s.length()>0;
		System.out.println(p.test("A"));*/
		LamdaExpressions lbs = new LamdaExpressions();
		List<Book> boo= lbs.getBooksSort();
		
		Function<String, String> fn = (str)->str.toUpperCase().concat(" Ongole");

		
		
		
	}
	
	class Book{
		String name;
		float price;
		String authorName;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public float getPrice() {
			return price;
		}
		public void setPrice(float price) {
			this.price = price;
		}
		public String getAuthorName() {
			return authorName;
		}
		public void setAuthorName(String authorName) {
			this.authorName = authorName;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + Objects.hash(authorName, name, price);
			return result;
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
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			return Objects.equals(authorName, other.authorName) && Objects.equals(name, other.name)
					&& Float.floatToIntBits(price) == Float.floatToIntBits(other.price);
		}
		private LamdaExpressions getEnclosingInstance() {
			return LamdaExpressions.this;
		}
		@Override
		public String toString() {
			return "Book [name=" + name + ", price=" + price + ", authorName=" + authorName + "]";
		}
		public Book(String name, float price, String authorName) {
			super();
			this.name = name;
			this.price = price;
			this.authorName = authorName;
		}
		
	}
}
