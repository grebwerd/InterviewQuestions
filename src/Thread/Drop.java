package Thread;

public class Drop {
    // Message sent from producer
    // to consumer.
    private String message;
    
    
    // True if consumer should wait
    // for producer to send message. 
    //There is nothing in the Message. The message is empty, the consumer waits for the producer to set the message.
    
    
    // false if producer should wait for
    // consumer to retrieve message.
    // This is because the message hasn't been consumed yet.
    //The message contains data that the consumer needs to get. 
    //The producer needs to wait until the message is empty again.
    private boolean empty = true;

    public synchronized String take() {
        // Wait until message is
        // available.
    	System.out.println("Take(): empty value before the while loop: " + empty);
        while (empty) {
            try {
            	System.out.println("Take(): " + Thread.currentThread().getName() + " waits");
                wait();
                System.out.println("Take(): " + Thread.currentThread().getName() + " done waiting");
            } catch (InterruptedException e) {}
        }
        // Toggle status.
        empty = true;
        // Notify producer that
        // status has changed.
        notifyAll();
        return message;
    }

    public synchronized void put(String message) {
        // Wait until message has
        // been retrieved.
    	System.out.println("Put(): empty value before the while loop: " + empty);
        while (!empty) {
            try { 
            	System.out.println("Put() " + Thread.currentThread().getName() + " waits");
                wait();
                System.out.println("Put(): " + Thread.currentThread().getName() + " done waiting");
            } catch (InterruptedException e) {}
        }
        // Toggle status.
        empty = false;
        // Store message.
        System.out.println("Put(): The message is " + message);
        this.message = message;
        // Notify consumer that status
        // has changed.
        notifyAll();
    }
}