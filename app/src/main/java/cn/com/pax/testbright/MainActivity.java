package cn.com.pax.testbright;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentResolver;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editText =  findViewById(R.id.brightvalue);
        Button button = findViewById(R.id.setbright);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String brightStr = editText.getText().toString();
                if(brightStr.trim().length() > 0) {
                    setBrightness(MainActivity.this, Integer.parseInt(brightStr));
                }
            }
        });
    }

    public static void setBrightness(Activity activity, int brightness) {
        // Settings.System.putInt(activity.getContentResolver(),

        // Settings.System.SCREEN_BRIGHTNESS_MODE,

        // Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);

        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();

        lp.screenBrightness = Float.valueOf(brightness) * (1f / 255f);
        Log.d("lxy", "set  lp.screenBrightness == " + lp.screenBrightness);

        activity.getWindow().setAttributes(lp);
    }

//    public static boolean isAutoBrightness(ContentResolver aContentResolver) {
//        boolean automicBrightness = false;
//        try {
//            automicBrightness = Settings.System.getInt(aContentResolver,
//                    Settings.System.SCREEN_BRIGHTNESS_MODE) == Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC;
//        } catch (Settings.SettingNotFoundException e) {
//            e.printStackTrace();
//        }
//        return automicBrightness;
//    }
//
//    public static void stopAutoBrightness(Activity activity) {
//
//        Settings.System.putInt(activity.getContentResolver(),
//
//                Settings.System.SCREEN_BRIGHTNESS_MODE,
//
//                Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);
//    }

}
