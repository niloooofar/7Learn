package example.com.a7learn.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import example.com.a7learn.R;
import example.com.a7learn.SevenLearnDatabaseOpenHelper;
import example.com.a7learn.models.Post;
import example.com.a7learn.view.activitys.PostsActivity;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.NewsViewHolder> {

    private Context context;
    private List<Post> posts;

    public PostsAdapter(Context context, List<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_news, parent, false);

        Typeface iranSans = Typeface.createFromAsset(context.getAssets(), "fonts/iran_sans.ttf");

        return new NewsViewHolder(view, iranSans);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, final int position) {
        final Post post = posts.get(position);

        holder.postImage.setImageDrawable(post.getPostImage());

//        Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(holder.postImage);

        holder.postTitle.setText(post.getTitle());
        holder.postContent.setText(post.getContent());
        holder.postDate.setText(post.getDate());

        if (post.getIsVisited() == 1) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.color_visited_post));
        } else {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.color_not_visited_post));
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PostsActivity.class);
                intent.putExtra(SevenLearnDatabaseOpenHelper.COL_ID, post.getId());
                intent.putExtra(SevenLearnDatabaseOpenHelper.COL_TITLE, post.getTitle());
                intent.putExtra(SevenLearnDatabaseOpenHelper.COL_CONTENT, post.getContent());
                intent.putExtra(SevenLearnDatabaseOpenHelper.COL_DATE, post.getDate());
                intent.putExtra(SevenLearnDatabaseOpenHelper.COL_IS_VISITED, post.getIsVisited());
                intent.putExtra(SevenLearnDatabaseOpenHelper.COL_POST_IMAGE_URL, post.getPostImageUrl());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {

        private ImageView postImage;
        private TextView postTitle;
        private TextView postContent;
        private TextView postDate;

        public NewsViewHolder(View itemView, Typeface iranSansTypeface) {
            super(itemView);

            postImage = itemView.findViewById(R.id.post_img);

            postTitle = itemView.findViewById(R.id.post_title);
            postTitle.setTypeface(iranSansTypeface);

            postContent = itemView.findViewById(R.id.post_content);
            postContent.setTypeface(iranSansTypeface);

            postDate = itemView.findViewById(R.id.post_date);
            postDate.setTypeface(iranSansTypeface);
        }
    }
}
