package dev.macrobug.asmodeo.util;

import java.util.ArrayList;
public class WatchDog implements Runnable {
  private final ArrayList<TimeoutObserver> observers = new ArrayList<>(1);
  private long timeout = -1;
  private boolean stopped = false;
  
  public WatchDog(long timeout) {
    if (timeout < 1) {
      throw new IllegalArgumentException("timeout lesser than 1.");
    }
    this.timeout = timeout;
  }

  public void addTimeoutObserver(TimeoutObserver to) {
    observers.add(to);
  }

  public void removeTimeoutObserver(TimeoutObserver to) {
    observers.remove(to);
  }

  protected final void fireTimeoutOccured() {
    for(TimeoutObserver e: observers){
      e.timeoutOccured(this);
    }
  }

  public synchronized void start() {
    stopped = false;
    Thread t = new Thread(this, "WATCHDOG");
    t.setDaemon(true);
    t.start();
  }

  public synchronized void stop() {
    stopped = true;
    notifyAll();
  }

  @Override
  public synchronized void run() {
    final long until = System.currentTimeMillis() + timeout;
    long now;
    while (!stopped && until > (now = System.currentTimeMillis())) {
      try {
        wait(until - now);
      } catch (InterruptedException e) {}
    }
    if (!stopped) {
    	fireTimeoutOccured();
    }
  }
}
