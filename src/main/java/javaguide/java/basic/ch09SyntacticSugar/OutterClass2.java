package javaguide.java.basic.ch09SyntacticSugar;

public class OutterClass2 {
    class InnerClass2 {

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private String name;
        final OutterClass2 this$0;

        InnerClass2() {
            super(); // Call to 'super()' must be first statement in constructor body
            this.this$0 = OutterClass2.this;
        }
    }


    public OutterClass2() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static void main(String args1[]) {
    }

    private String userName;
}