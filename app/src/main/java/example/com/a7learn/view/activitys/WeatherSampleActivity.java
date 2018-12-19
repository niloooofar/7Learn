package example.com.a7learn.view.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import example.com.a7learn.ApiService;
import example.com.a7learn.R;
import example.com.a7learn.models.WeatherInfo;

public class WeatherSampleActivity extends AppCompatActivity implements ApiService.OnWeatherInfoRecieved {

    private static final String TAG = "WeatherSampleActivity";
    private Button btnSendRequest;
    private ApiService apiService;
    private TextView txtWeatherName, txtWeatherDescription, txtTemp, txtHumidity, txtPressure, txtMinTemp, txtMaxTemp, txtWindSpeed, txtWindDegree;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_sample);
        apiService = new ApiService(this);

        initViews();

        btnSendRequest = findViewById(R.id.btn_send_request);
        btnSendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apiService.getCurrentWeather(WeatherSampleActivity.this, "Tehran");
                progressBar.setVisibility(View.VISIBLE);
            }
        });
    }

    private void initViews(){
        progressBar = findViewById(R.id.progress_bar);
        txtWeatherName = findViewById(R.id.txt_weather_name);
        txtWeatherDescription = findViewById(R.id.txt_weather_description);
        txtTemp = findViewById(R.id.txt_temprature);
        txtHumidity = findViewById(R.id.txt_humidity);
        txtPressure = findViewById(R.id.txt_pressure);
        txtMinTemp = findViewById(R.id.txt_min_temp);
        txtMaxTemp = findViewById(R.id.txt_max_temp);
        txtWindSpeed = findViewById(R.id.txt_wind_speed);
        txtWindDegree = findViewById(R.id.txt_wind_degree);
    }


    @Override
    public void onRecieved(WeatherInfo weatherInfo) {
        if (weatherInfo != null) {
            txtWeatherName.setText("آب‌و‌هوای فعلی" +weatherInfo.getWeatherName());
            txtWeatherDescription.setText("توضیحات" +weatherInfo.getWeatherDescription());
            txtTemp.setText("دمای فعلی" +weatherInfo.getWeatherTemprature());
            txtHumidity.setText("رطوبت هوا:" +weatherInfo.getHumidity());
            txtPressure.setText("میزان فشار هوا:" +weatherInfo.getPressure());
            txtMinTemp.setText("کم‌ترین دما:" +weatherInfo.getMinTemprature());
            txtMaxTemp.setText("بیشترین دما:" +weatherInfo.getMaxTemprature());
            txtWindSpeed.setText("سرعت باد:" +weatherInfo.getWindSpeed());
            txtWindDegree.setText("درجه باد:" +weatherInfo.getWindDegree());

        } else {
            Toast.makeText(this, "خطا در ارتباط با سرور", Toast.LENGTH_LONG).show();
        }
        progressBar.setVisibility(View.INVISIBLE);
    }
}
