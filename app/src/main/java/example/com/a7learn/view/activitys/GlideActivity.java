package example.com.a7learn.view.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import example.com.a7learn.R;

public class GlideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);

        ImageView img = findViewById(R.id.img);
        Picasso.get().load("http://via.placeholder.com/300.png").into(img);

    }
}
