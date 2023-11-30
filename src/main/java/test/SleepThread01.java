package test;

public class SleepThread01 implements Runnable {

    private Service01 service01;

    public SleepThread01(Service01 service01) {
        this.service01 = service01;
    }

    public void run() {
        service01.mSleep();
    }
}