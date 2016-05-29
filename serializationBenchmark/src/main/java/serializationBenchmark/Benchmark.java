package serializationBenchmark;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.RandomStringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;

@SuppressWarnings("all")
public class Benchmark {

	public static void run() throws ClassNotFoundException, IOException, JAXBException {

		Boolean warmupEnded = false;
		
		for (int i = 0; i < 110; i++) {
			
			if(i==100) warmupEnded = true;
			
			Login[] loginArray10 = new Login[10];
			Login[] loginArray10000 = new Login[10000];
			for (int j = 0; j < 10; j++) {
				loginArray10[j] = getRandomLogin();
			}
			for (int j = 0; j < 10000; j++) {
				loginArray10000[j] = getRandomLogin();
			}
			JaxbArray jaxbArray10 = new JaxbArray(loginArray10);
			JaxbArray jaxbArray10000 = new JaxbArray(loginArray10000);
			
			if(warmupEnded) System.out.println("======== 1 object ========");
			testSerializer(getRandomLogin(), warmupEnded);
			testGsonSerializer(getRandomLogin(), warmupEnded);
			testJacksonSerializer(getRandomLogin(), warmupEnded);
			testJaxbSerializer(getRandomLogin(), warmupEnded);
			
			if(warmupEnded) System.out.println("======== 10 objects ========");
			testSerializer(loginArray10, warmupEnded);
			testGsonSerializer(loginArray10, warmupEnded);
			testJacksonSerializer(loginArray10, warmupEnded);
			testJaxbSerializer(jaxbArray10, warmupEnded);
			
			if(warmupEnded) System.out.println("======== 10000 objects ========");
			testSerializer(loginArray10000, warmupEnded);
			testGsonSerializer(loginArray10000, warmupEnded);
			testJacksonSerializer(loginArray10000, warmupEnded);
			testJaxbSerializer(jaxbArray10000, warmupEnded);
			
		}

	}

	private static Login getRandomLogin() {
		return new Login(RandomStringUtils.randomAlphanumeric(20), RandomStringUtils.randomAlphanumeric(20));
	}

	private static <T> void testSerializer(T object, Boolean warmupEnded) throws ClassNotFoundException, IOException {
		T result;
		Serializer serializer = new Serializer();
		long start = System.nanoTime();
		result = (T) serializer.test(object);
		if(warmupEnded) { System.out.print(System.nanoTime() - start); System.out.println(" Serialize"); }
	}

	private static <T> void testGsonSerializer(T object, Boolean warmupEnded) throws IOException {
		T result;
		GsonSerializer gsonSerializer = new GsonSerializer(object.getClass());
		long start = System.nanoTime();
		result = (T) gsonSerializer.test(object);
		if(warmupEnded) { System.out.print(System.nanoTime() - start); System.out.println(" Gson"); }
	}

	private static <T> void testJacksonSerializer(T object, Boolean warmupEnded) throws JsonProcessingException, IOException {
		T result;
		JacksonSerializer jacksonSerializer = new JacksonSerializer(object.getClass());
		long start = System.nanoTime();
		result = (T) jacksonSerializer.test(object);
		if(warmupEnded) { System.out.print(System.nanoTime() - start); System.out.println(" Jackson"); }
	}

	private static <T> void testJaxbSerializer(T object, Boolean warmupEnded) throws JAXBException, IOException {
		T result;
		JaxbSerializer jaxbSerializer = new JaxbSerializer(object.getClass());
		long start = System.nanoTime();
		result = (T) jaxbSerializer.test(object);
		if(warmupEnded) { System.out.print(System.nanoTime() - start); System.out.println(" Jaxb"); }

		// System.out.println(result);
		// JaxbArray jaxbArray = (JaxbArray)result;
		// Login[] list = jaxbArray.getList();
		// for (Login login : list) {
		// System.out.println(login);
		// }

	}

}
