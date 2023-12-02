package javaguide.java.newFeatures.modern;

interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}