package nail.lynxmsk.test.ui.activity.article;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;


import butterknife.BindView;
import butterknife.ButterKnife;
import nail.lynxmsk.test.adapter.ArticleAdapter;
import nail.lynxmsk.test.adapter.CategoryAdapter;
import nail.lynxmsk.test.models.Articles;
import nail.lynxmsk.test.models.Category;
import nail.lynxmsk.test.presentation.view.article.ArticleView;
import nail.lynxmsk.test.presentation.presenter.article.ArticlePresenter;



import nail.lynxmsk.test.R;
import nail.lynxmsk.test.ui.activity.detailArticle.DetailArticleActivity;
import nail.lynxmsk.test.ui.activity.main.MainActivity;

import com.arellomobile.mvp.MvpActivity;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.ArrayList;
import java.util.List;

public class ArticleActivity extends MvpAppCompatActivity implements ArticleView, CategoryAdapter.RecyclerViewClickListener  {
    public static final String TAG = "ArticleActivity";
    @InjectPresenter
    ArticlePresenter mArticlePresenter;

    private RecyclerView articleRecyclerView;
    private ArticleAdapter articleAdapter;
    private List<Articles> articlesList;
    private GridLayoutManager mLayoutManager;
    @BindView(R.id.progressBar0) ProgressBar pb1;
    public static Intent getIntent(final Context context) {
        Intent intent = new Intent(context, ArticleActivity.class);
        return intent;
    }

    private void initIU(){
        articleRecyclerView = findViewById(R.id.articleRecyclerView);
        articlesList = new ArrayList<>();
        mLayoutManager = new GridLayoutManager(this, 2);
        articleAdapter = new ArticleAdapter(this, articlesList, this);
        articleRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        articleRecyclerView.setItemAnimator(new DefaultItemAnimator());
        articleRecyclerView.setNestedScrollingEnabled(false);
        articleRecyclerView.addItemDecoration(new DividerItemDecoration(articleRecyclerView.getContext(), DividerItemDecoration.VERTICAL));
        articleRecyclerView.setAdapter(articleAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        ButterKnife.bind(this);
        getMvpDelegate().onAttach();
        Intent intent = getIntent();
        String category = intent.getStringExtra("category");
        initIU();
        mArticlePresenter.getMoreData(category);
    }

    @SuppressLint("WrongConstant")
    @Override
    public void showProgress() {
        pb1.setVisibility(0);
    }

    @SuppressLint("WrongConstant")
    @Override
    public void hideProgress() {
        pb1.setVisibility(4);
    }

    @Override
    public void setDataToReyclerView(List<Articles> articlesList) {
        this.articlesList.addAll(articlesList);
        articleAdapter.notifyDataSetChanged();
    }

    @Override
    public void onResponseFaiture(Throwable t) {
        Toast.makeText(this,"Error: " + t.getMessage(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void recyclerViewListClicked(View v, int position) {
        // click detaling
        Intent intent = new Intent(ArticleActivity.this, DetailArticleActivity.class);
        intent.putExtra("article", articlesList.get(position).getArticle());
        startActivityForResult(intent,1);
    }
}
