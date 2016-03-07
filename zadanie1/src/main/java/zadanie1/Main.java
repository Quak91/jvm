package zadanie1;

public class Main {
	
	private static final int MEGABYTE = 1024*1024;
	
	public static void main(String[] args) {
		int i = 0;
		while(true) {
			byte[] bytes = new byte[i*MEGABYTE];
			i+=50;
			System.out.println(i + "MB");
		}
	}

}
