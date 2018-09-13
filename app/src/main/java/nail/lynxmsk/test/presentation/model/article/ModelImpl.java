package nail.lynxmsk.test.presentation.model.article;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import nail.lynxmsk.test.models.Articles;
import nail.lynxmsk.test.models.Items;
import nail.lynxmsk.test.network.ApiClient;
import nail.lynxmsk.test.network.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelImpl implements IModel {
    @Override
    public void getArticlesList(final OnFinishedListener onFinishedListener, String category) {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Items> call = apiInterface.getArticles(category);
        call.enqueue(new Callback<Items>() {
            @Override
            public void onResponse(Call<Items> call, Response<Items> response) {
                Log.d("NAIL","Url: " + response.raw().request().url());
                ArrayList<Articles> items = response.body().events;
                Log.d("NAIL","Number: " + items.size());
                onFinishedListener.onFinished(items);
            }

            @Override
            public void onFailure(Call<Items> call, Throwable t) {
                Log.d("NAIL",t.toString());
                onFinishedListener.onFailure(t);
            }
        });
    }
}
