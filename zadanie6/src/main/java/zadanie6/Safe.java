package zadanie6;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Safe {
	ExecutorService executorService = Executors.newFixedThreadPool(8);
	ThreadLocal<SimpleDateFormat> safeSimpleDateFormat = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd");
			
		};
	};
	List<Callable<Date>> callableDates = new ArrayList<Callable<Date>>();
	List<Future<Date>> results = new ArrayList<Future<Date>>();

	public void test() {

		System.out.println("=========================== Safe.test() ===========================");
		for (int i = 0; i < 10; i++) {
			callableDates.add(new Callable<Date>() {

				public Date call() throws Exception {
					return safeSimpleDateFormat.get().parse("2016-01-01");
				}

			});
		}
		try {
			results = executorService.invokeAll(callableDates);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		executorService.shutdown();

		for (Future<Date> result : results) {
			try {
				System.out.println(result.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}

	}
}
