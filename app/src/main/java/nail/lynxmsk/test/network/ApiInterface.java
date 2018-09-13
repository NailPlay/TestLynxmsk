package nail.lynxmsk.test.network;


import nail.lynxmsk.test.models.Articles;
import nail.lynxmsk.test.models.Detail;
import nail.lynxmsk.test.models.Items;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("list.php")
    Call<Items> getArticles(@Query("category") String category);

    @GET("post.php")
    Call<Detail> getArticleDetail(@Query("article") String article);


}
