package test;

public class Service02 {

    public void mSleep() {
        synchronized (this) {
            try {
                Thread.sleep(3 * 1000);
                this.notifyAll();
                System.out.println("唤醒等待 。 结束时间：" + System.currentTimeMillis());
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void mWait() {
        synchronized (this) {
            try {
                System.out.println("等待开始 。 当前时间：" + System.currentTimeMillis());
                this.wait();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}