package javaguide.java.basic.ch07Unsafe;

import lombok.Getter;

@Getter
class ChangeThread implements Runnable {
    /**
     * no volatile
     **/
    boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("subThread change flag to:" + flag);
        flag = true;
    }
}