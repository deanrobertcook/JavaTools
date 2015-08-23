package org.theronin.javatools.testutility;

import com.sun.javafx.application.PlatformImpl;
import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;

import java.util.concurrent.CountDownLatch;

public class JavaFXRunner {

    private final Thread thread;
    private CountDownLatch countDownLatch = new CountDownLatch(1);

    private PlatformImpl.FinishListener listener = new PlatformImpl.FinishListener() {
        @Override
        public void idle(boolean implicitExit) {
            countDownLatch.countDown();
        }

        @Override
        public void exitCalled() {
        }
    };

    public JavaFXRunner(Application javaFXApplication) {
        thread = new Thread(() -> {
            new JFXPanel(); // Initializes the JavaFx Platform
            PlatformImpl.addListener(listener);
            PlatformImpl.runLater(() -> {
                try {
                    javaFXApplication.start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        });
    }

    public void showGraph() {
        thread.start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}