package serializationBenchmark;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.google.gson.Gson;

public class GsonSerializer {
	
	private Gson gson = new Gson();
	private Class<?> _class;
	
	public GsonSerializer(Class<?> _class) {
		this._class=_class;
	}
	
	public Object test(Object object) throws IOException {
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		out.write(gson.toJson(object).getBytes());
		Object result = gson.fromJson(out.toString(), _class);
		out.close();
		
		return result;
	}

}
