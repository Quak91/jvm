package serializationBenchmark;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JaxbSerializer {
	
	private Marshaller marshaller;
	private Unmarshaller unmarshaller;
	
	public JaxbSerializer(Class<?> _class) throws JAXBException {
		marshaller = JAXBContext.newInstance(_class).createMarshaller();
		unmarshaller = JAXBContext.newInstance(_class).createUnmarshaller();
	}
	
	public Object test(Object object) throws JAXBException, IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		marshaller.marshal(object, out);
		
		Object result = unmarshaller.unmarshal(new StringReader(out.toString()));
		out.close();
		
		return result;
	}

}
