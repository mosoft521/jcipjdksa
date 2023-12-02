package javaguide.java.newFeatures.java14;

/**
 * 这个类具有两个特征
 * 1. 所有成员属性都是final
 * 2. 全部方法由构造方法，和两个成员属性访问器组成（共三个）
 * 那么这种类就很适合使用record来声明
 */
public final class RectangleClass {
    final double length;
    final double width;

    public RectangleClass(double length, double width) {
        this.length = length;
        this.width = width;
    }

    double length() {
        return length;
    }

    double width() {
        return width;
    }
}