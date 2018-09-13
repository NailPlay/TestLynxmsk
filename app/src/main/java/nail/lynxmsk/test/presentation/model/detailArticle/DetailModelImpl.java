package nail.lynxmsk.test.presentation.model.detailArticle;


import android.util.Log;

import nail.lynxmsk.test.models.Detail;
import nail.lynxmsk.test.network.ApiClient;
import nail.lynxmsk.test.network.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailModelImpl implements IDetailModel {

    @Override
    public void getDeatil(final OnFinishedListener onFinishedListener, String article) {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Detail> call = apiInterface.getArticleDetail(article);
        call.enqueue(new Callback<Detail>() {
            @Override
            public void onResponse(Call<Detail> call, Response<Detail> response) {
                Log.d("NAIL","Url: " + response.raw().request().url());
                Log.d("NAIL","Url: " + response.body().getTeam1());
                Detail detail = response.body();
                onFinishedListener.onFinished(detail);
            }

            @Override
            public void onFailure(Call<Detail> call, Throwable t) {
                Log.d("NAIL",t.toString());
                onFinishedListener.onFailure(t);

            }
        });
    }
}
