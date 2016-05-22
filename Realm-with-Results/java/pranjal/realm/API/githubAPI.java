package pranjal.realm.API;

import pranjal.realm.Model.githubModel;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by royalpranjal on 5/22/2016.
 */
public interface githubAPI {
    @GET("/users/{user}")
    public void getFeed(@Path("user")
                        String user, Callback<githubModel> response);
}
