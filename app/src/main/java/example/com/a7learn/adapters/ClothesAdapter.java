package example.com.a7learn.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import example.com.a7learn.R;
import example.com.a7learn.models.Cloth;

public class ClothesAdapter extends RecyclerView.Adapter<ClothesAdapter.ClothesViewHolder> {

    private final List<Cloth> cloths;
    private final Context context;

    public ClothesAdapter(Context context, List<Cloth> cloths) {
        this.cloths = cloths;
        this.context = context;
    }

    @Override
    public ClothesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.lauout_clothing_item, parent, false);
        return new ClothesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ClothesViewHolder holder, int position) {
        Cloth cloth = cloths.get(position);
        holder.clothesTitle.setText(cloth.getTitle());
        holder.clothesViewCount.setText(String.valueOf(cloth.getViewCount()));
        holder.clothesImage.setImageDrawable(cloth.getImage());
    }

    @Override
    public int getItemCount() {
        return cloths.size();
    }

    public class ClothesViewHolder extends RecyclerView.ViewHolder {
        private ImageView clothesImage;
        private TextView clothesTitle;
        private TextView clothesViewCount;

        public ClothesViewHolder(View itemView) {
            super(itemView);
            clothesImage = itemView.findViewById(R.id.clothing_image);
            clothesTitle = itemView.findViewById(R.id.clothing_title);
            clothesViewCount = itemView.findViewById(R.id.view_count_text);
        }
    }
}
