package serializationBenchmark;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonSerializer {

	private ObjectMapper objectMapper = new ObjectMapper();
	private Class<?> _class;
	
	public JacksonSerializer(Class<?> _class) {
		this._class=_class;
	}
	
	public Object test(Object object) throws JsonProcessingException, IOException {
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		out.write(objectMapper.writeValueAsBytes(object));
		
		Object result = objectMapper.readValue(out.toByteArray(), _class);
		out.close();
		
		return result;
		
	}
	
}
