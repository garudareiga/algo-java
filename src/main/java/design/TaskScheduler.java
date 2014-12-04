package design;

import java.util.concurrent.*;

public class TaskScheduler {
//	private final ScheduledExecutorService service = 
//			Executors.newScheduledThreadPool(2);
//	
//	public void schedule(Callable f, int delay) {
//		service.schedule(f, delay, TimeUnit.SECONDS);
//	}
//	
//	static class TaskCallable implements Callable {
//		private int taskId;
//		
//		TaskCallable(int taskId) { this.taskId = taskId; }
//		
//		public Object call() throws Exception {
//			System.out.println(String.format("Call task %d!", taskId));
//			return null;
//		}
//	}
	
	public static void main() {
		System.out.println("Start scheduling ...");
//		TaskScheduler scheduler = new TaskScheduler();
//		scheduler.schedule(new TaskCallable(1), 3);
//		scheduler.schedule(new TaskCallable(2), 3);
//		scheduler.schedule(new TaskCallable(3), 3);
	}
}
