package serializationBenchmark;

import java.io.IOException;

import javax.xml.bind.JAXBException;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, IOException, JAXBException {
		Benchmark.run();
	}

}
