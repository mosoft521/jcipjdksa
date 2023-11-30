package javaguide.java.concurrent;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NamedInternalThreadFactoryTest {

    @Test
    void newThread() throws Exception {
        NamedInternalThreadFactory namedInternalThreadFactory = new NamedInternalThreadFactory();
        Thread t = namedInternalThreadFactory.newThread(() -> {});

        Assertions.assertEquals(t.getClass(), InternalThread.class, "thread is not InternalThread");
    }
}