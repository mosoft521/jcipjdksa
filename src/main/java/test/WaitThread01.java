package test;

public class WaitThread01 implements Runnable {

    private Service01 service01;

    public WaitThread01(Service01 service01) {
        this.service01 = service01;
    }

    public void run() {
        service01.mWait();
    }
}