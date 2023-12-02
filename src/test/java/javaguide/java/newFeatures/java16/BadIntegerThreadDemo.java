//package javaguide.java.newFeatures.java16;
//
//public class BadIntegerThreadDemo {
//    public void inc(Integer count) {
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                synchronized (count) { //Variable used in lambda expression should be final or effectively final
//                    count++; //Variable used in lambda expression should be final or effectively final
//                }
//            }).start();
//        }
//    }
//}