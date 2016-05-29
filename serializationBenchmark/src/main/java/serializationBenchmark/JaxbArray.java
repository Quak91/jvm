package serializationBenchmark;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="root")
public class JaxbArray implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="array")
	private Login[] list;
	
	public JaxbArray() {}
	public JaxbArray(Login[] list) {
		this.list = list;
	}
	
	public Login[] getList() {
		return list;
	}
	
}
