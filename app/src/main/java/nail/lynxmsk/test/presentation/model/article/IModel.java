package nail.lynxmsk.test.presentation.model.article;

import java.util.List;

import nail.lynxmsk.test.models.Articles;

public interface IModel {
    interface OnFinishedListener{
        void onFinished(List<Articles> articlesArrayList);
        void onFailure(Throwable t);
    }
    void getArticlesList(OnFinishedListener onFinishedListener, String category);

}
