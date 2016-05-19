package pranjal.githubapiusingretrofit.API;

import pranjal.githubapiusingretrofit.Model.GithubModel;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by royalpranjal on 5/19/2016.
 */
public interface GithubAPI {

    // user is the string retrieved from edittext

    @GET("/users/{user}")
    void getFeed(@Path("user")
            String user, Callback<GithubModel> response);


    /*
    // callback is used for async response
    // String user is for passing values from edittext
    // response is from the server which is POJO

    @Path("/users/{username}")
    In this kind of example, a user is prompted to type his or her name. Then the web service
    responds to this URI
     */
}
