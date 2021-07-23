package com;

import events.AlarmActionEventHandler;
import events.AlarmEvent;

public class AlarmClockTest2b {
    private AlarmClock alarmClock;

    public AlarmClockTest2b() {
        alarmClock = new AlarmClock(new AlarmActionEventHandlerImpl(), 10);
    }

    public static void main(String[] args) {
        AlarmClockTest2b alarmClockTest = new AlarmClockTest2b();
        alarmClockTest.alarmClock.start();
    }

    private class AlarmActionEventHandlerImpl implements AlarmActionEventHandler {

        @Override
        public void alarmActionPerformed(AlarmEvent args) {
            System.out.printf("Leftover rings: %d\n", args.getNrings());
        }
    }
}

