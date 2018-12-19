package example.com.a7learn;

import android.content.Context;
import android.content.SharedPreferences;

import javax.crypto.KeyGenerator;

import example.com.a7learn.models.User;

public class UserSharedPrefManager {

    private static final String USER_SHARED_PREF_NAME = "user_shared_pref";
    private SharedPreferences sharedPreferences;
    private static final String KEY_FIRST_NAME = "first_name";
    private static final String KEY_LAST_NAME = "last_name";
    private static final String KEY_HTML = "is_html_expert";
    private static final String KEY_CSS = "is_css_expert";
    private static final String KEY_JAVA = "is_java_expert";
    private static final String KEY_GENDER = "gender";

    public UserSharedPrefManager(Context context) {
        sharedPreferences = context.getSharedPreferences(USER_SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }

    public void saveUser(User user){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_FIRST_NAME, user.getFirstName());
        editor.putString(KEY_LAST_NAME, user.getLastName());
        editor.putBoolean(KEY_HTML, user.isHtmlExpert());
        editor.putBoolean(KEY_CSS, user.isCssExpert());
        editor.putBoolean(KEY_JAVA, user.isJavaExpert());
        editor.putInt(KEY_GENDER, user.getGender());
        editor.apply();
    }

    public User getUser(){
        User user = new User();
        user.setFirstName(sharedPreferences.getString(KEY_FIRST_NAME, ""));
        user.setLastName(sharedPreferences.getString(KEY_LAST_NAME, ""));
        user.setHtmlExpert(sharedPreferences.getBoolean(KEY_HTML,false));
        user.setCssExpert(sharedPreferences.getBoolean(KEY_CSS, false));
        user.setJavaExpert(sharedPreferences.getBoolean(KEY_JAVA, false));
        user.setGender((byte) sharedPreferences.getInt(KEY_GENDER, User.MALE));
        return user;
    }
}
