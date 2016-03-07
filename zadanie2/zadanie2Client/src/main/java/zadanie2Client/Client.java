package zadanie2Client;

public class Client {

	public static void main(String[] args) throws Exception {
		MyClassLoader myClassLoader = new MyClassLoader();

		Class<?> classDef = myClassLoader.findClass("zadanie2Server.MyInterfaceImpl");
        
		Object o = classDef.newInstance();
        o.getClass().getMethod("printMsg").invoke(o);
		
        //	ClassCastException... - nie wiem jak to zrobiæ, wiêc jest bez rzutowania
        //	RemoteInterface o = (RemoteInterface) aClass.newInstance();
        //	o.printMessage();
        
	}

}
