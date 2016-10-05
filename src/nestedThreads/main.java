package nestedThreads;

public class main {

	public static void main(String[] args) {
		AutomationModeManager amm = new AutomationModeManager("AutomationModeManager");
		amm.startManagerThread();
		
		Thread thread2 = new Thread(new OtherThread("AutomationModeManager"));
		thread2.start();
		
		

	}

}
