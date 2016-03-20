package zadanie3;

import java.lang.reflect.InvocationTargetException;

import com.google.caliper.BeforeExperiment;
import com.google.caliper.Benchmark;
import com.google.caliper.api.VmOptions;

@VmOptions("-XX:-TieredCompilation")
public class ReflectionBenchmark {

	private MyClass myClass;

	@BeforeExperiment
	void setUp() {
		myClass = new MyClass();
		myClass.integer = 4444;
		myClass.string = "string";
	}

	@Benchmark
	void runMyMethod(long reps) {
		for (long i = 0; i < reps; i++) {
			myClass.myMethod(4444);
		}
	}
	
	@Benchmark
	void runMyMethodReflection(long reps) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		for (long i = 0; i < reps; i++) {
			MyClass.class.getMethod("myMethod", int.class).invoke(myClass, 4444);
		}
	}
	
	@Benchmark
	void setIntField(long reps) {
		for (long i = 0; i < reps; i++) {
			myClass.integer = 4444;
		}
	}
	
	@Benchmark
	void setIntFieldReflection(long reps) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		for (long i = 0; i < reps; i++) {
			MyClass.class.getField("integer").set(myClass, 4444);
		}
	}
	
	@Benchmark
	void setStringField(long reps) {
		for (long i = 0; i < reps; i++) {
			myClass.string = "string";
		}
	}
	
	@Benchmark
	void setStringFieldReflection(long reps) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		for (long i = 0; i < reps; i++) {
			MyClass.class.getField("string").set(myClass, "string");
		}
	}
	
	@Benchmark
	int getIntField(long reps) {
		int j = 0;
		for(long i = 0; i < reps; i++) {
			j = myClass.integer;
		}
		return j;
	}
	
	@Benchmark
	int getIntFieldReflection(long reps) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		int j = 0;
		for(long i = 0; i < reps; i++) {
			j = MyClass.class.getField("integer").getInt(myClass);
		}
		return j;
	}
	
	@Benchmark
	String getStringField(long reps) {
		String s = "";
		for(long i = 0; i < reps; i++) {
			s = myClass.string;
		}
		return s;
	}
	
	@Benchmark
	String getStringFieldReflection(long reps) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		String s = "";
		for(long i = 0; i < reps; i++) {
			s = (String) MyClass.class.getField("string").get(myClass);
		}
		return s;
	}

}
