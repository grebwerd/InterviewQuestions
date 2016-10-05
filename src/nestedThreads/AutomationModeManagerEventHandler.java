package nestedThreads;

public class AutomationModeManagerEventHandler {
	AutomationModeManager automationModeManager;
	
	public AutomationModeManagerEventHandler(AutomationModeManager amm){
		this.automationModeManager = amm;
	}
	
	
	public void killManagerThread(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		automationModeManager.killImmediately();
	}

}
