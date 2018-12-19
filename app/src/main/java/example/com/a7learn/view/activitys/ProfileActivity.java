package example.com.a7learn.view.activitys;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import example.com.a7learn.R;
import example.com.a7learn.UserSharedPrefManager;
import example.com.a7learn.models.User;

public class ProfileActivity extends AppCompatActivity {

    private UserSharedPrefManager prefManager;
    private User user = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        prefManager = new UserSharedPrefManager(this);
        user = prefManager.getUser();

        Button btnEditAvator = findViewById(R.id.edit_avator);
        btnEditAvator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProfileActivity.this, "edit avator", Toast.LENGTH_LONG).show();
            }
        });

        ImageView btnBack = findViewById(R.id.back_button);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/iran_sans.ttf");

        EditText firstNameEditText = findViewById(R.id.edittext_firstName);
        firstNameEditText.setTypeface(typeface);
        firstNameEditText.setText(user.getFirstName());

        EditText lastNameEditText = findViewById(R.id.edittext_lastName);
        lastNameEditText.setTypeface(typeface);
        lastNameEditText.setText(user.getLastName());

        firstNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //Toast.makeText(ProfileActivity.this, s, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //Toast.makeText(ProfileActivity.this, s, Toast.LENGTH_SHORT).show();
                user.setFirstName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
//                Toast.makeText(ProfileActivity.this, String.valueOf(s), Toast.LENGTH_SHORT).show();
            }
        });

        lastNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                user.setLastName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        CheckBox javaCheckbox = findViewById(R.id.java_checkbox);
        CheckBox htmlCheckbox = findViewById(R.id.html_checkbox);
        CheckBox cssCheckbox = findViewById(R.id.css_checkbox);

        javaCheckbox.setChecked(user.isJavaExpert());
        htmlCheckbox.setChecked(user.isHtmlExpert());
        cssCheckbox.setChecked(user.isCssExpert());

        javaCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(ProfileActivity.this, String.valueOf(isChecked), Toast.LENGTH_SHORT).show();
                user.setJavaExpert(isChecked);
            }
        });

        htmlCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                user.setHtmlExpert(isChecked);
            }
        });

        cssCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                user.setCssExpert(isChecked);
            }
        });


        RadioButton maleRadio = findViewById(R.id.male_radio);
        RadioButton femaleRadio = findViewById(R.id.female_radio);

        if(user.getGender() == User.MALE){
            maleRadio.setChecked(true);
        }else {
            femaleRadio.setChecked(true );
        }

        maleRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(ProfileActivity.this, String.valueOf(isChecked), Toast.LENGTH_SHORT).show();

                if (isChecked) {
                    user.setGender(User.MALE);
                } else {
                    user.setGender(User.FEMALE);
                }

            }
        });

        Button btnSave = findViewById(R.id.save_form);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(ProfileActivity.this, "save form is clicked!",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ProfileActivity.this, FirstActivitySt.class));
                prefManager.saveUser(user);
            }
        });
    }
}
