import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {

	public static void main(String[] args) {
		ExecutorService pool = Executors.newCachedThreadPool();

		pool.execute(new MyRunnable());
		pool.submit(new MyRunnable());
		pool.submit(new MyRunnable());
		pool.shutdown();
	}

}
