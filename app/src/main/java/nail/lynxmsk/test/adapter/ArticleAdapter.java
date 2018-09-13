package nail.lynxmsk.test.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import nail.lynxmsk.test.R;
import nail.lynxmsk.test.models.Articles;
import nail.lynxmsk.test.models.Category;
import nail.lynxmsk.test.models.Items;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {
    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_articles, viewGroup,false);
        return new ArticleAdapter.ArticleViewHolder(itemView);
    }

    public ArticleAdapter(Context mContext, List<Articles> articlesList,CategoryAdapter.RecyclerViewClickListener myClickListener) {
        this.mContext = mContext;
        this.articlesList = articlesList;
        this.itemListener = myClickListener;
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder articleViewHolder, int i) {
        Articles articles = articlesList.get(i);
        articleViewHolder.tvArticleTitle.setText(articles.getTitle());
        articleViewHolder.tvArticleArticle.setText(articles.getArticle());
        articleViewHolder.tvArticlePreview.setText(articles.getPreview());
        articleViewHolder.tvArticlePlace.setText(articles.getPlace());
        articleViewHolder.tvArticleTime.setText(articles.getTitle());
        articleViewHolder.tvArticleCoefficient.setText(articles.getCoefficient());
    }

    @Override
    public int getItemCount() {
        return articlesList.size();
    }

    public interface RecyclerViewClickListener {
        public void recyclerViewListClicked(View v, int position);
    }
    private static CategoryAdapter.RecyclerViewClickListener itemListener;
    private Context mContext;
    private List<Articles> articlesList;


    class ArticleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tvArticleTitle;
        public TextView tvArticleCoefficient;
        public TextView tvArticleTime;
        public TextView tvArticlePlace;
        public TextView tvArticlePreview;
        public TextView tvArticleArticle;



        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);
            tvArticleTitle = itemView.findViewById(R.id.tvArticleTitle);
            tvArticleCoefficient = itemView.findViewById(R.id.tvArticleCoefficient);
            tvArticleTime = itemView.findViewById(R.id.tvArticleTime);
            tvArticlePlace = itemView.findViewById(R.id.tvArticlePlace);
            tvArticlePreview = itemView.findViewById(R.id.tvArticlePreview);
            tvArticleArticle = itemView.findViewById(R.id.tvArticleArticle);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemListener.recyclerViewListClicked(v, this.getPosition());

        }
    }
}
