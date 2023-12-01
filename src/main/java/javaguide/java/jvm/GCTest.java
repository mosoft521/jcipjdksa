package javaguide.java.jvm;

public class GCTest {
    public static void main(String[] args) {
        byte[] allocation1, allocation2;
        allocation1 = new byte[30900*1024];
//        allocation2 = new byte[900 * 1024];
    }
}
/*
-XX:+PrintGCDetails
Heap
 PSYoungGen      total 76288K, used 36143K [0x000000076ae00000, 0x0000000770300000, 0x00000007c0000000)
  eden space 65536K, 55% used [0x000000076ae00000,0x000000076d14bd58,0x000000076ee00000)
  from space 10752K, 0% used [0x000000076f880000,0x000000076f880000,0x0000000770300000)
  to   space 10752K, 0% used [0x000000076ee00000,0x000000076ee00000,0x000000076f880000)
 ParOldGen       total 175104K, used 0K [0x00000006c0a00000, 0x00000006cb500000, 0x000000076ae00000)
  object space 175104K, 0% used [0x00000006c0a00000,0x00000006c0a00000,0x00000006cb500000)
 Metaspace       used 3392K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 370K, capacity 388K, committed 512K, reserved 1048576K
加allocation2 = new byte[900 * 1024];后
Heap
 PSYoungGen      total 76288K, used 38354K [0x000000076ae00000, 0x0000000770300000, 0x00000007c0000000)
  eden space 65536K, 58% used [0x000000076ae00000,0x000000076d374860,0x000000076ee00000)
  from space 10752K, 0% used [0x000000076f880000,0x000000076f880000,0x0000000770300000)
  to   space 10752K, 0% used [0x000000076ee00000,0x000000076ee00000,0x000000076f880000)
 ParOldGen       total 175104K, used 0K [0x00000006c0a00000, 0x00000006cb500000, 0x000000076ae00000)
  object space 175104K, 0% used [0x00000006c0a00000,0x00000006c0a00000,0x00000006cb500000)
 Metaspace       used 3527K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 381K, capacity 388K, committed 512K, reserved 1048576K
改为：-XX:+PrintGCDetails -Xms128M -Xmx128M -XX:TargetSurvivorRatio=100
Heap
 PSYoungGen      total 38400K, used 3335K [0x00000000fd580000, 0x0000000100000000, 0x0000000100000000)
  eden space 33280K, 10% used [0x00000000fd580000,0x00000000fd8c1c20,0x00000000ff600000)
  from space 5120K, 0% used [0x00000000ffb00000,0x00000000ffb00000,0x0000000100000000)
  to   space 5120K, 0% used [0x00000000ff600000,0x00000000ff600000,0x00000000ffb00000)
 ParOldGen       total 87552K, used 30900K [0x00000000f8000000, 0x00000000fd580000, 0x00000000fd580000)
  object space 87552K, 35% used [0x00000000f8000000,0x00000000f9e2d010,0x00000000fd580000)
 Metaspace       used 3392K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 370K, capacity 388K, committed 512K, reserved 1048576K
 */