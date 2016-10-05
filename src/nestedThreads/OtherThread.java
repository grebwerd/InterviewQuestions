package nestedThreads;

public class OtherThread implements Runnable{

	public AutomationModeManagerEventHandler ammeh;
	String name;
	public OtherThread(String name){
		this.name = name;
	}
	
	@Override
	public void run() {
		AutomationModeManager amm = new AutomationModeManager(name);
		amm.startManagerThread();
		ammeh = new AutomationModeManagerEventHandler(amm);
		ammeh.killManagerThread();
	}

}
