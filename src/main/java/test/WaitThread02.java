package test;

public class WaitThread02 implements Runnable {

    private Service02 service02;

    public WaitThread02(Service02 service02) {
        this.service02 = service02;
    }

    public void run() {
        service02.mWait();
    }
}