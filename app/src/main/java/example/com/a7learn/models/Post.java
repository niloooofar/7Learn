package example.com.a7learn.models;

import android.graphics.drawable.Drawable;

public class Post {

    private int id;
    private Drawable postImage;
    private String postImageUrl;
    private String title;
    private String content;
    private String date;
    private int isVisited = 0;
//    private boolean isVisited = false;

//    public boolean isVisited() {
//        return isVisited;
//    }
//
//    public void setVisited(boolean visited) {
//        isVisited = visited;
//    }


    public int getIsVisited() {
        return isVisited;
    }

    public void setIsVisited(int isVisited) {
        this.isVisited = isVisited;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPostImageUrl() {
        return postImageUrl;
    }

    public void setPostImageUrl(String postImageUrl) {
        this.postImageUrl = postImageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

//    public String getPostImageUrl() {
//        return postImageUrl;
//    }
//
//    public void setPostImageUrl(String postImageUrl) {
//        this.postImageUrl = postImageUrl;
//    }

        public Drawable getPostImage() {
        return postImage;
    }

    public void setPostImage(Drawable postImage) {
        this.postImage = postImage;
    }
}
