package com.muy.dubbo.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

public class DubboHolderListener implements ApplicationListener<ApplicationEvent> {
  private static final Logger LOGGER = LoggerFactory.getLogger(DubboHolderListener.class);

  private static Thread holdThread;
  private static Boolean running = false;

  @Override
  public void onApplicationEvent(ApplicationEvent event) {
    if (event instanceof ApplicationPreparedEvent) {
      if (running == false){
        running = true;
      }
      if (holdThread == null) {
        holdThread = new Thread(new Runnable() {
          @Override
          public void run() {
            if (LOGGER.isTraceEnabled()) {
              LOGGER.trace(Thread.currentThread().getName());
            }
            while (running && !Thread.currentThread().isInterrupted()) {
              try {
                Thread.sleep(2000);
              } catch (InterruptedException e) {
              }
            }
          }
        }, "Dubbo-Holder");
        holdThread.setDaemon(false);
        holdThread.start();
      }
    }
    if (event instanceof ContextClosedEvent) {
      running = Boolean.FALSE;
      if (null != holdThread) {
        holdThread.interrupt();
        holdThread = null;
      }
    }
  }

  public static void stopApplicationContext(Boolean stop) {
    running = stop.booleanValue();
    if (null != holdThread) {
      holdThread.interrupt();
      holdThread = null;
    }
  }
}
