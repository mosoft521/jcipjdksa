//package javaguide.java.newFeatures.java18;
//
//import jdk.incubator.vector.FloatVector;
//import jdk.incubator.vector.VectorSpecies;
//
//import java.util.Arrays;
//
//public class FloatVectorDemo {
//    private static void scalarComputation(float[] a, float[] b, float[] c) {
//        for (int i = 0; i < a.length; i++) {
//            c[i] = (a[i] * a[i] + b[i] * b[i]) * -1.0f;
//        }
//    }
//
//    static final VectorSpecies<Float> SPECIES = FloatVector.SPECIES_PREFERRED;
//
//    private static void vectorComputation(float[] a, float[] b, float[] c) {
//        int i = 0;
//        int upperBound = SPECIES.loopBound(a.length);
//        for (; i < upperBound; i += SPECIES.length()) {
//            // FloatVector va, vb, vc;
//            var va = FloatVector.fromArray(SPECIES, a, i);
//            var vb = FloatVector.fromArray(SPECIES, b, i);
//            var vc = va.mul(va)
//                    .add(vb.mul(vb))
//                    .neg();
//            vc.intoArray(c, i);
//        }
//        for (; i < a.length; i++) {
//            c[i] = (a[i] * a[i] + b[i] * b[i]) * -1.0f;
//        }
//    }
//
//    public static void main(String[] args) {
//        float[] a = {1.0f, 2.0f, 3.0f};
//        float[] b = {1.0f, 2.0f, 3.0f};
//        float[] c = {1.0f, 2.0f, 3.0f};
//        scalarComputation(a, b, c);
//        System.out.println(Arrays.toString(c));//[-2.0, -8.0, -18.0]
//        float[] d = {1.0f, 2.0f, 3.0f};
//        float[] e = {1.0f, 2.0f, 3.0f};
//        float[] f = {1.0f, 2.0f, 3.0f};
//        vectorComputation(d, e, f);
//        System.out.println(Arrays.toString(f));//[-2.0, -8.0, -18.0]
//    }
//}
///*
//todo:程序包 jdk.incubator.vector 已在模块 jdk.incubator.vector 中声明, 但该模块不在模块图中
//add VM options:
//--add-opens jdk.incubator.vector/jdk.incubator.vector=ALL-UNNAMED
//不行
// */