package nail.lynxmsk.test.presentation.view.detailArticle;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import nail.lynxmsk.test.models.Articles;
import nail.lynxmsk.test.models.Detail;

public interface DetailArticleView extends MvpView {
    void showProgress();
    void hideProgress();
    void setDataToTextViews(Detail detail);
    void onResponseFaiture(Throwable t);
}
