package javaguide.java.basic.javaBasicQuestions02;

import cn.hutool.core.util.ObjectUtil;

public class AddressAndPersonWithLombokAndHutoolTest {
    public static void main(String[] args) {
        PersonWithLombok personWithLombok1 = new PersonWithLombok(new AddressWithLombok("武汉"));
        PersonWithLombok personWithLombok1Copy = ObjectUtil.cloneByStream(personWithLombok1);//借助Hutool实现深Copy【深克隆】
        System.out.println(personWithLombok1.getAddress() == personWithLombok1Copy.getAddress());// false
    }
}