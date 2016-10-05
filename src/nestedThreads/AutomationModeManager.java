package nestedThreads;

public class AutomationModeManager implements Runnable{

	Thread managerThread;
	AutomationModeManagerEventHandler ammeh;
	String name;
	
	public AutomationModeManager(String name){
		ammeh = new AutomationModeManagerEventHandler(this);
		this.name = name;
		startManagerThread();
	}
	
	public void startManagerThread(){
		managerThread = new ManagerThread(this, name);
		managerThread.start();
	}
	
	
	@Override
	public void run() {
	while(true){
		System.out.println("Current Thread Name is " + Thread.currentThread().getName() + " managerThreadId is " + managerThread.getId() + " managerThread is " + managerThread.isInterrupted());
		try {
			managerThread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	}
	
	
	public void killImmediately(){
		System.out.println("killImmediately");
		System.out.println("Current Thread Name is " + Thread.currentThread().getName() + " managerThreadId is " + managerThread.getId() + " managerThread is " + managerThread.isInterrupted());
		managerThread.interrupt();
		System.out.println("Current Thread Name is " + Thread.currentThread().getName() + " managerThreadId is " + managerThread.getId() + " managerThread is " + managerThread.isInterrupted());
	}

}
