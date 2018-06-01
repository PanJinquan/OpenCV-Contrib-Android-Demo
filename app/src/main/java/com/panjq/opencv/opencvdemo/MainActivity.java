package com.panjq.opencv.opencvdemo;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.panjq.opencv.alg.ImagePro;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private static final String    TAG = "MainActivity";
    static{
        Log.i(TAG, "opencv_java3 loading...");
        System.loadLibrary("opencv_java3");
        Log.i(TAG, "opencv_java3 loaded successfully");
        Log.i(TAG, "imagePro-lib loading...");
        System.loadLibrary("imagePro-lib");
        Log.i(TAG, "imagePro-lib loaded successfully");
    }

    private ImageView imageview;
    private Bitmap bmp, bitmap;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
    static {
        File appDir = new File(Environment.getExternalStorageDirectory(), "OpencvDemo");
        if (!appDir.exists()) {
            appDir.mkdir();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        verifyStoragePermissions(MainActivity.this);
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());
        imageview = (ImageView) findViewById(R.id.image_view);
        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.girl);
        imageview.setImageBitmap(bmp);
        TextView tv2 = (TextView) findViewById(R.id.tv2);
        Button buttonLoadImage = (Button) findViewById(R.id.buttonLoadPicture);
        buttonLoadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Log.i(TAG, "onClick...");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ImagePro img=new ImagePro();
                        long T0 = System.currentTimeMillis();
                        Bitmap bitImage1 =img.ImageProcess1(bmp);//通过整型数组传递图像数据
                        long T1 = System.currentTimeMillis();
                        Bitmap bitImage2 =img.ImageProcess2(bmp);//通过自定义图像对象传递图像数据
                        long T2 = System.currentTimeMillis();
                        Bitmap bitImage3 =img.ImageProcess3(bmp);//通过OpenCV的getNativeObjAddr()把地址传递给底层JNI
                        long T3 = System.currentTimeMillis();
                        Log.e(TAG, "Run time,ImageProcess1="+(T1-T0)+"ms");
                        Log.e(TAG, "Run time,ImageProcess2="+(T2-T1)+"ms");
                        Log.e(TAG, "Run time,ImageProcess3="+(T3-T2)+"ms");
                        bitmap =bitImage3;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                imageview.setImageBitmap(bitmap);
                            }
                        });

                    }
                }).start();
            }
        });
    }

    /**
     * 添加文件读写权限
     */
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};

    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE);
        }
    }
    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
