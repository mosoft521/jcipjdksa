package dp.templateMethod.java8;

import org.apache.commons.lang3.RandomUtils;

import java.math.BigDecimal;
import java.util.function.Consumer;

public class BankBusinessHandler {

    private void execute(Consumer<BigDecimal> consumer) {
        getNumber();
        consumer.accept(null);
        judge();
    }

    private void getNumber() {
        System.out.println("number-00" + RandomUtils.nextInt());
    }

    private void judge() {
        System.out.println("give a praised");
    }

    public void save(BigDecimal amount) {
        execute(a -> System.out.println("save " + amount));
    }

    public void draw(BigDecimal amount) {
        execute(a -> System.out.println("draw " + amount));
    }

    public void moneyManage(BigDecimal amount) {
        execute(a -> System.out.println("money manage " + amount));
    }
}