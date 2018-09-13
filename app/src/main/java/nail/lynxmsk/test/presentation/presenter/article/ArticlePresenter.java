package nail.lynxmsk.test.presentation.presenter.article;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.List;

import nail.lynxmsk.test.models.Articles;
import nail.lynxmsk.test.presentation.model.article.IModel;
import nail.lynxmsk.test.presentation.model.article.ModelImpl;
import nail.lynxmsk.test.presentation.view.article.ArticleView;

@InjectViewState
public class ArticlePresenter extends MvpPresenter<ArticleView> implements IModel.OnFinishedListener {

    private ModelImpl model;

    @Override
    public void attachView(ArticleView view) {
        super.attachView(view);
        model = new ModelImpl();
    }

    public void getMoreData(String category){
        getViewState().showProgress();
        model.getArticlesList(this, category);
    }


    @Override
    public void onFinished(List<Articles> articlesArrayList) {
        getViewState().setDataToReyclerView(articlesArrayList);
        getViewState().hideProgress();
    }

    @Override
    public void onFailure(Throwable t) {
        getViewState().onResponseFaiture(t);
        getViewState().hideProgress();
    }
}
