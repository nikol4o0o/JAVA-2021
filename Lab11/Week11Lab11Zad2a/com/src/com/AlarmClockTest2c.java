package com;

import events.AlarmActionEventHandler;
import events.AlarmEvent;

public class AlarmClockTest2c {
    private AlarmClock alarmClock;

    public AlarmClockTest2c() {
        alarmClock = new AlarmClock(new AlarmActionEventHandler() {
            @Override
            public void alarmActionPerformed(AlarmEvent args) {
                System.out.printf("Leftover rings: %d\n", args.getNrings());
            }
        }, 10);
    }

    public static void main(String[] args) {
        AlarmClockTest2c alarmClockTest = new AlarmClockTest2c();
        alarmClockTest.alarmClock.start();
    }
}


