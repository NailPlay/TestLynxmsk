package nail.lynxmsk.test.ui.activity.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import nail.lynxmsk.test.R;
import nail.lynxmsk.test.adapter.CategoryAdapter;
import nail.lynxmsk.test.models.Category;
import nail.lynxmsk.test.presentation.view.main.MainView;
import nail.lynxmsk.test.presentation.presenter.main.MainPresenter;
import nail.lynxmsk.test.ui.activity.article.ArticleActivity;


import com.arellomobile.mvp.MvpActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends MvpActivity implements MainView, CategoryAdapter.RecyclerViewClickListener {
    public static final String TAG = "MainActivity";
    @InjectPresenter
    MainPresenter mMainPresenter;

    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;
    private List<Category> categoryList;
    private GridLayoutManager mLayoutManager;

    public static Intent getIntent(final Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    private void initIU(){
        categoryRecyclerView = findViewById(R.id.categoryRecyclerView);
        categoryList = new ArrayList<>();
        String[] nameCategory = getResources().getStringArray(R.array.array_category_name);
        String[] urlCategory = getResources().getStringArray(R.array.array_category_url);
        for (int i=0; i<=nameCategory.length-1;i++){
           categoryList.add(new Category(nameCategory[i],urlCategory[i]));
        }
        mLayoutManager = new GridLayoutManager(this, 2);
        categoryAdapter = new CategoryAdapter(this, categoryList, this);
        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        categoryRecyclerView.setItemAnimator(new DefaultItemAnimator());
        categoryRecyclerView.setAdapter( categoryAdapter);
    }

    @Override
    public void recyclerViewListClicked(View v, int position){
        Intent intent = new Intent(MainActivity.this, ArticleActivity.class);
        intent.putExtra("category",categoryList.get(position).getUrl_name());
        startActivityForResult(intent,0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initIU();
    }


}
