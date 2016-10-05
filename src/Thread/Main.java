package Thread;

public class Main {

	public static void main(String[] args) {
		
		//Each thread shares a common drop object.
		Drop drop = new Drop();
		(new Thread(new Producer(drop))).start();
		(new Thread(new Consumer(drop))).start();
	}

}
