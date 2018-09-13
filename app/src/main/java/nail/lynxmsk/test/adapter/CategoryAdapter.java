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
import nail.lynxmsk.test.models.Category;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {
    public interface RecyclerViewClickListener {
        public void recyclerViewListClicked(View v, int position);
    }
    private static RecyclerViewClickListener itemListener;
    private Context mContext;
    private List<Category> categoryList;

    public CategoryAdapter(Context mContext, List<Category> categoryList,RecyclerViewClickListener myClickListener) {
        this.mContext = mContext;
        this.categoryList = categoryList;
        this.itemListener = myClickListener;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_category, viewGroup,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        Category category = categoryList.get(i);
        myViewHolder.tvCategoryName.setText(category.getName());
        myViewHolder.tvCategoryUrl.setText(category.getUrl_name());
    }



    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tvCategoryName;
        public TextView tvCategoryUrl;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCategoryName = itemView.findViewById(R.id.tvCategoryName);
            tvCategoryUrl = itemView.findViewById(R.id.tvCategoryUrl);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemListener.recyclerViewListClicked(v, this.getPosition());

        }
    }
}
