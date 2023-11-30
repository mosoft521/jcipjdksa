package javaguide.java.concurrent;

public class SingletonErr {
    private volatile static SingletonErr uniqueInstance;

    private SingletonErr() {
    }

    public static SingletonErr getUniqueInstance() {
        //先判断对象是否已经实例过，没有实例化过才进入加锁代码
        if (uniqueInstance == null) {
            //类对象加锁
            synchronized (SingletonErr.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new SingletonErr();
                }
            }
        }
        return uniqueInstance;
    }
}