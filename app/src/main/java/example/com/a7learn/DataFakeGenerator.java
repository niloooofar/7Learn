package example.com.a7learn;

import android.content.Context;
import android.support.v4.content.res.ResourcesCompat;

import java.util.ArrayList;
import java.util.List;

import example.com.a7learn.models.AppFeature;
import example.com.a7learn.models.Cloth;
import example.com.a7learn.models.Post;
import example.com.a7learn.view.activitys.ProfileActivity;
import example.com.a7learn.view.activitys.PostsActivity;

public class DataFakeGenerator {

    public static List<Post> getData(Context context){
        /*
        List<Post> posts=new ArrayList<>();
        for(int i=1;i<=6;i++){
            Post post=new Post();
            post.setId(i);
            post.setTitle("لورم ایپسوم متن ساختگی");
            post.setContent("لورم ایپسوم متن ساختگی با تولید سادگی نامفهوم از صنعت چاپ و با استفاده از طراحان گرافیک است. چاپگرها و متون بلکه روزنامه و مجله در ستون و سطرآنچنان که لازم است و برای شرایط فعلی تکنولوژی مورد نیاز و کاربردهای متنوع با هدف بهبود ابزارهای کاربردی می باشد. لورم ایپسوم متن ساختگی با تولید سادگی نامفهوم از صنعت چاپ و با استفاده از طراحان گرافیک است.");
            post.setDate("2 ساعت پیش");

            switch (i){
                case 1:
                    post.setPostImageUrl(ResourcesCompat.getDrawable(context.getResources(),R.drawable.pic1,null));
                    break;
                case 2:
                    post.setPostImageUrl(ResourcesCompat.getDrawable(context.getResources(),R.drawable.pic2,null));
                    break;
                case 3:
                    post.setPostImageUrl(ResourcesCompat.getDrawable(context.getResources(),R.drawable.pic3,null));
                    break;
                case 4:
                    post.setPostImageUrl(ResourcesCompat.getDrawable(context.getResources(),R.drawable.pic4,null));
                    break;
                case 5:
                    post.setPostImageUrl(ResourcesCompat.getDrawable(context.getResources(),R.drawable.pic5,null));
                    break;
                case 6:
                    post.setPostImageUrl(ResourcesCompat.getDrawable(context.getResources(),R.drawable.pic6,null));
                    break;
            }
            posts.add(post);
        }
         */

        return null;
    }

    public static List<Cloth> getClothes(Context context){

        List<Cloth> cloths=new ArrayList<>();
        for (int i=1;i<=8;i++){
            Cloth cloth=new Cloth();
            cloth.setId(i);
            cloth.setTitle("لورم ایپسوم متن ساختگی");
            cloth.setViewCount(700);
            switch (i){
                case 1:
                    cloth.setImage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.pic6,null));
                    break;
                case 2:
                    cloth.setImage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.pic4,null));
                    break;
                case 3:
                    cloth.setImage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.pic3,null));
                    break;
                case 4:
                    cloth.setImage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.pic1,null));
                    break;
                case 5:
                    cloth.setImage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.pic2,null));
                    break;
                case 6:
                    cloth.setImage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.pic7,null));
                    break;
                case 7:
                    cloth.setImage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.pic9,null));
                    break;
                case 8:
                    cloth.setImage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.pic8,null));
                    break;

            }
            cloths.add(cloth);
        }
        return cloths;
    }

    public static List<AppFeature> getAppFeatures(Context context){
        List<AppFeature> appFeatures=new ArrayList<>();

        AppFeature appFeature=new AppFeature();
        appFeature.setId(AppFeature.ID_POSTS_ACTIVITY);
        appFeature.setTitle(context.getString(R.string.app_feature_latest_posts));
        appFeature.setFeatureImage(R.drawable.posts);
        appFeature.setDestinationActivity(PostsActivity.class);
        appFeatures.add(appFeature);

        appFeature=new AppFeature();
        appFeature.setId(AppFeature.ID_USER_PROFILE);
        appFeature.setTitle(context.getString(R.string.app_feature_user_profile));
        appFeature.setFeatureImage(R.drawable.user_profile);
//        appFeature.setDestinationActivity(ProfileActivity.class);
        appFeature.setDestinationActivity(ProfileActivity.class);
        appFeatures.add(appFeature);

        appFeature=new AppFeature();
        appFeature.setId(AppFeature.ID_FASHION);
        appFeature.setTitle(context.getString(R.string.app_feature_fashion));
        appFeature.setFeatureImage(R.drawable.fashion);
//        appFeature.setDestinationActivity(BotickActivity.class);
        appFeature.setDestinationActivity(PostsActivity.class);
        appFeatures.add(appFeature);

        appFeature=new AppFeature();
        appFeature.setId(AppFeature.ID_MUSIC);
        appFeature.setTitle(context.getString(R.string.app_feature_music_player));
        appFeature.setFeatureImage(R.drawable.music_player);
        appFeature.setDestinationActivity(ProfileActivity.class);
        appFeatures.add(appFeature);

        appFeature=new AppFeature();
        appFeature.setId(AppFeature.ID_VIDEO);
        appFeature.setTitle(context.getString(R.string.app_feature_video_player));
        appFeature.setFeatureImage(R.drawable.video_player);
        appFeature.setDestinationActivity(ProfileActivity.class);
        appFeatures.add(appFeature);

        appFeature=new AppFeature();
        appFeature.setId(AppFeature.ID_LOGIN);
        appFeature.setTitle(context.getString(R.string.app_feature_login));
        appFeature.setFeatureImage(R.drawable.login);
        appFeature.setDestinationActivity(ProfileActivity.class);
        appFeatures.add(appFeature);


        return appFeatures;
    }


//
//    public static List<Post> getData(Context context) {
//
//        List<Post> posts = new ArrayList<Post>();
//
//        for (int i = 1; i <= 6; i++) {
//            Post post = new Post();
//            post.setId(i);
//            post.setDate("۲ ساعت پیش");
//            post.setTitle("لورم ایپسوم چیست؟");
//            post.setContent(" لورم ایپسوم یا طرح‌نما (به انگلیسی: Lorem ipsum) به متنی آزمایشی و بی‌معنی در صنعت چاپ، صفحه‌آرایی و طراحی گرافیک گفته می‌شود. طراح گرافیک از این متن به عنوان عنصری از ترکیب بندی برای پر کردن صفحه و ارایه اولیه شکل ظاهری و کلی طرح سفارش گرفته شده استفاده می نماید، تا از نظر گرافیکی نشانگر چگونگی نوع و اندازه فونت و ظاهر متن باشد.");
//
//            switch (i) {
//                case 1:
//                    post.setPostImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic1, null));
//                    break;
//
//                case 2:
//                    post.setPostImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic8, null));
//                    break;
//
//                case 3:
//                    post.setPostImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic2, null));
//                    break;
//
//                case 4:
//                    post.setPostImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic7, null));
//                    break;
//
//                case 5:
//                    post.setPostImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic5, null));
//                    break;
//
//                case 6:
//                    post.setPostImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic6, null));
//                    break;
//            }
//            posts.add(post);
//        }
//        return posts;
//    }
//
//    public static List<Cloth> getClothes(Context context) {
//        List<Cloth> cloths = new ArrayList<>();
//        for (int i = 0; i <= 8; i++) {
//            Cloth cloth = new Cloth();
//            cloth.setId(i);
//            cloth.setTitle("لوازم ایپسوم متن ساختگی");
//            cloth.setViewCount(700);
//            switch (i) {
//                case 1:
//                    cloth.setImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic1, null));
//                    break;
//                case 2:
//                    cloth.setImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic2, null));
//                    break;
//                case 3:
//                    cloth.setImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic3, null));
//                    break;
//                case 4:
//                    cloth.setImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic4, null));
//                    break;
//                case 5:
//                    cloth.setImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic5, null));
//                    break;
//                case 6:
//                    cloth.setImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic6, null));
//                    break;
//                case 7:
//                    cloth.setImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic7, null));
//                    break;
//                case 8:
//                    cloth.setImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.pic8, null));
//                    break;
//            }
//            cloths.add(cloth);
//        }
//        return cloths;
//    }
}
