package dp.templateMethod.java7;

//取钱业务的实现类
public class DrawMoneyHandler extends AbstractBusinessHandeler {

    @Override
    public void handle() {
        System.out.println("draw 1000");
    }
}