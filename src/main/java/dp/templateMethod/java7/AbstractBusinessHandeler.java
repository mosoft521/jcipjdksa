package dp.templateMethod.java7;

import org.apache.commons.lang3.RandomUtils;

/**
 * 用Java8改造后的模板方法模式真的是yyds!
 * 模板方法设计模式的抽象类
 */
public abstract class AbstractBusinessHandeler {
    /**
     * 模板方法
     */
    public final void execute() {
        getRowNumber();
        handle();
        judge();
    }

    /**
     * 取号
     *
     * @return
     */
    private void getRowNumber() {
        System.out.println("rowNumber-00" + RandomUtils.nextInt());
    }

    /**
     * 办理业务
     */
    public abstract void handle(); //抽象的办理业务方法，由子类实现

    /**
     * 评价
     */
    private void judge() {
        System.out.println("give a praised");
    }
}