package pranjal.realm.Database;

import io.realm.RealmObject;

/**
 * Created by royalpranjal on 5/22/2016.
 */
public class User extends RealmObject {

    private String id;

    private int followers;

    private String name;

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public int getFollowers(){
        return followers;
    }

    public void setFollowers(int followers){
        this.followers = followers;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

}
