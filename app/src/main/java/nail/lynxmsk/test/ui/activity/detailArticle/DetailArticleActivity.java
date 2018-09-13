package nail.lynxmsk.test.ui.activity.detailArticle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import nail.lynxmsk.test.R;
import nail.lynxmsk.test.adapter.CategoryAdapter;
import nail.lynxmsk.test.models.Category;
import nail.lynxmsk.test.models.Detail;
import nail.lynxmsk.test.presentation.view.detailArticle.DetailArticleView;
import nail.lynxmsk.test.presentation.presenter.detailArticle.DetailArticlePresenter;



import com.arellomobile.mvp.MvpActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

public class DetailArticleActivity extends MvpActivity implements DetailArticleView {
    public static final String TAG = "DetailArticleActivity";
    @InjectPresenter
    DetailArticlePresenter mDetailArticlePresenter;

    private List<Detail> detailList;

    @BindView(R.id.tvTeam1)TextView tvTeam1;

    @BindView(R.id.tvTeam2)TextView tvTeam2;

    @BindView(R.id.tvTime)TextView tvTime;

    @BindView(R.id.tvTournament)TextView tvTournament;

    @BindView(R.id.tvPlace)TextView tvPlace;

    @BindView(R.id.progressBar1)ProgressBar pb;

    public static Intent getIntent(final Context context) {
        Intent intent = new Intent(context, DetailArticleActivity.class);
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_article);
        ButterKnife.bind(this);
        getMvpDelegate().onAttach();
        Intent intent = getIntent();
        String article = intent.getStringExtra("article");
        mDetailArticlePresenter.getData(article);
    }


    @SuppressLint("WrongConstant")
    @Override
    public void showProgress() {
        pb.setVisibility(0);
    }

    @Override
    public void hideProgress() {
        pb.setVisibility(4);
    }

    @Override
    public void setDataToTextViews(Detail detail){
        tvTeam1.setText(detail.getTeam1());
        tvTeam2.setText(detail.getTeam2());
        tvPlace.setText(detail.getPlace());
        tvTime.setText(detail.getTime());
        tvTournament.setText(detail.getTournament());
    }

    @Override
    public void onResponseFaiture(Throwable t) {

    }
}
