package dp.templateMethod.java8v2;

import org.apache.commons.lang3.RandomUtils;

import java.math.BigDecimal;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class BankBusinessHandler {
    /**
     * 模板方法
     */
    protected void execute(Supplier<String> supplier, Consumer<BigDecimal> consumer) {
        String number = supplier.get();
        System.out.println(number);
        if (number.startsWith("vip")) {
            //Vip号分配到VIP柜台
            System.out.println("Assign To Vip Counter");
        } else if (number.startsWith("reservation")) {
            //预约号分配到专属客户经理
            System.out.println("Assign To Exclusive Customer Manager");
        } else {
            //默认分配到普通柜台
            System.out.println("Assign To Usual Manager");
        }
        consumer.accept(null);
        judge();
    }

    private void judge() {
        System.out.println("give a praised");
    }

    public void saveVip(BigDecimal amount) {
        execute(() -> "vipNumber-00" + RandomUtils.nextInt(), a -> System.out.println("save " + amount));
    }

    public void saveReservation(BigDecimal amount) {
        execute(() -> "reservationNumber-00" + RandomUtils.nextInt(), a -> System.out.println("save " + amount));
    }

    public void save(BigDecimal amount) {
        execute(() -> "number-00" + RandomUtils.nextInt(), a -> System.out.println("save " + amount));
    }
}