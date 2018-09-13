package nail.lynxmsk.test.presentation.presenter.detailArticle;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import nail.lynxmsk.test.models.Detail;
import nail.lynxmsk.test.presentation.model.detailArticle.IDetailModel;
import nail.lynxmsk.test.presentation.model.detailArticle.DetailModelImpl;
import nail.lynxmsk.test.presentation.view.detailArticle.DetailArticleView;

@InjectViewState
public class DetailArticlePresenter extends MvpPresenter<DetailArticleView> implements IDetailModel.OnFinishedListener  {

    private DetailModelImpl model;

    @Override
    public void attachView(DetailArticleView view) {
        super.attachView(view);
        model = new DetailModelImpl();
    }

    public void getData(String article){
        getViewState().showProgress();
        model.getDeatil(this, article);
    }


    @Override
    public void onFinished(Detail detail) {
        getViewState().setDataToTextViews(detail);
        getViewState().hideProgress();
    }


    @Override
    public void onFailure(Throwable t) {
        getViewState().onResponseFaiture(t);
        getViewState().hideProgress();
    }
}
