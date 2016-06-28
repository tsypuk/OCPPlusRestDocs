/**
 * Created by roman.tsypuk on 6/24/16.
 */
class A {
    void teach(String student) {
        System.out.println("A teach");

    }
}
public class B extends A{

    protected void teach(String s) {
        System.out.println("B teach");
    }
}
