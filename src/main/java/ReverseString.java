
public class ReverseString {
public static String str ="Sunil Kumar";
public static void main(String[] args) {
 char[] ch = str.toCharArray();
	for(int i=0;i<str.length();i++) {
		char ch1 = str.charAt(i);
		int a=0;
		int b=str.length()-1;
		while(a<b) {
			char temp = ch[a];
			ch[a]=ch[b];
			ch[b]=ch[a];
		a++;
		b--;
		}
		
		
	}
	System.out.println(ch);
}
}
