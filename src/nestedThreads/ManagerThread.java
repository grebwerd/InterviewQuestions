package nestedThreads;

public class ManagerThread extends Thread {

	
	public ManagerThread(AutomationModeManager automationModeManager, String name) {
		super(automationModeManager, name);
	}

	public static boolean interrupted(){
		System.out.println("!!!!!!!!!!!!!!!" + Thread.currentThread().getName() + "calling interrupted");
		Thread.currentThread().dumpStack();
		
		
		return Thread.currentThread().interrupted();
		
	}
	
}
