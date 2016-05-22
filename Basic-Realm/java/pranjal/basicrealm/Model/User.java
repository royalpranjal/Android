package pranjal.basicrealm.Model;

import io.realm.RealmObject;

/**
 * Created by royalpranjal on 5/22/2016.
 */
// creating a model for the user...annotations can be used
public class User extends RealmObject {

    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
