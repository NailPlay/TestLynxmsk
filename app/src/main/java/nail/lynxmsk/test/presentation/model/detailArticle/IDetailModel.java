package nail.lynxmsk.test.presentation.model.detailArticle;

import java.util.List;

import nail.lynxmsk.test.models.Articles;
import nail.lynxmsk.test.models.Detail;

public interface IDetailModel {
    interface OnFinishedListener{
        void onFinished(Detail detail);
        void onFailure(Throwable t);
    }
    void getDeatil(OnFinishedListener onFinishedListener, String article);

}
