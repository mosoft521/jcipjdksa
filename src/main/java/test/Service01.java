package test;

public class Service01 {

    public void mSleep() {
        synchronized (this) {
            try {
                System.out.println("Sleep 。当前时间：" + System.currentTimeMillis());
                Thread.sleep(3 * 1000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void mWait() {
        synchronized (this) {
            System.out.println("Wait 。结束时间：" + System.currentTimeMillis());
        }
    }
}