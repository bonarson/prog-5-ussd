package com.yasussd;

import java.util.TimerTask;

public class TimerTaskHandler extends TimerTask {
    private final UssdSession session;

    public TimerTaskHandler(UssdSession session) {
        this.session = session;
    }

    @Override
    public void run() {
        System.out.println("\nTemps écoulé. Session expirée.");
        System.exit(0);
    }
}
