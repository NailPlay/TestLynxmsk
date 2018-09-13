package nail.lynxmsk.test.presentation.view.article;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import nail.lynxmsk.test.models.Articles;

public interface ArticleView extends MvpView {
    void showProgress();
    void hideProgress();
    void setDataToReyclerView(List<Articles> articlesList);
    void onResponseFaiture(Throwable t);
}
