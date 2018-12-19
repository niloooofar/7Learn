package example.com.a7learn.view.activitys;

import android.content.DialogInterface;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import example.com.a7learn.R;
import example.com.a7learn.view.fragments.SampleFragment;
import example.com.a7learn.view.fragments.SampleFragment2;

public class FragmentSampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_sample);

        final SampleFragment2 sampleFragment = new SampleFragment2();

        final FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fragment_container, new SampleFragment() );
        transaction.commit();

        Button btnReplace = findViewById(R.id.replace_fragment);
        btnReplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction replaceTransaction = fragmentManager.beginTransaction();
                replaceTransaction.replace(R.id.fragment_container, sampleFragment);
                replaceTransaction.commit();

            }
        });

        final Button removeFragment = findViewById(R.id.remove_fragment);
        removeFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction removeTransaction = fragmentManager.beginTransaction();
                removeTransaction.remove(sampleFragment);
                removeTransaction.commit();
            }
        });

        Button btnShowDialog = findViewById(R.id.btn_show_dialog);
        btnShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(FragmentSampleActivity.this);

                builder.setTitle("hiiii")
                        .setMessage("Are u show u want to cancle?")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(FragmentSampleActivity.this, "yes", Toast.LENGTH_SHORT).show();
                            }
                        }).setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setCancelable(false);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

    }
}
