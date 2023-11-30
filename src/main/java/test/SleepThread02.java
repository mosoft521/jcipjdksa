package test;

public class SleepThread02 implements Runnable {

    private Service02 service02;

    public SleepThread02(Service02 service02) {
        this.service02 = service02;
    }

    public void run() {
        service02.mSleep();
    }
}