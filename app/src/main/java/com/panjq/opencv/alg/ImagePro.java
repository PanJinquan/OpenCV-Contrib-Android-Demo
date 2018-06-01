package com.panjq.opencv.alg;

import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.opencv.core.Mat;
import org.opencv.android.Utils;

/**
 * Created by panjq1 on 2017/10/22.
 */

public class ImagePro {
    private static final String    TAG = "ImagePro:";
    static {
       // System.loadLibrary("imagePro-lib");
        //System.loadLibrary("opencv_java3");
    }
    public native int[] jniImagePro1(int[] pixels, int w, int h);
    public native ImageData jniImagePro2(ImageData image_data);
    public native void jniImagePro3(long matAddrSrcImage, long matAddrDestImage);
    /**
     *
     */
    public Bitmap ImageProcess1(Bitmap origImage) {
        int w = origImage.getWidth();
        int h = origImage.getHeight();
        int[] pixels = new int[w * h];
        origImage.getPixels(pixels, 0, w, 0, 0, w, h);
        int[] image= jniImagePro1(pixels,w,h);
        Log.i(TAG, "jniImagePro1 called successfully");
        //最后将返回的int数组转为bitmap类型。
        Bitmap desImage=Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
        //faceall为返回的int数组
        desImage.setPixels(image,0,w,0,0,w,h);
        return desImage;
    }

    /**
     *
     */
    public Bitmap ImageProcess2(Bitmap origImage) {
       ImageData imageData=new ImageData(origImage);
//        ImageData imageData=new ImageData();
//        imageData.getImageData(origImage);
        Log.i(TAG, "input image size:"+imageData.w+","+imageData.h);
        ImageData out_image= jniImagePro2(imageData);
        Log.i(TAG, "return image size:"+out_image.w+","+out_image.h);
        Bitmap desImage=out_image.getBitmap();
        //saveImage(desImage,"desImage.jpg");
        Log.i(TAG, "jniImagePro2 called successfully");
        return desImage;
    }



    /**
     *
     */
    public Bitmap ImageProcess3(Bitmap origImage) {
        Log.i(TAG, "called JNI:jniImagePro3 ");
        int w=origImage.getWidth();
        int h=origImage.getHeight();
        Mat origMat = new Mat();
        Mat destMat = new Mat();
        Utils.bitmapToMat(origImage, origMat);
        jniImagePro3(origMat.getNativeObjAddr(), destMat.getNativeObjAddr());
        Bitmap bitImage = Bitmap.createBitmap(destMat.width(), destMat.height(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(destMat, bitImage);
        Log.i(TAG, "jniImagePro3 called successfully");
        return bitImage;
    }



    public static void saveImage(Bitmap bmp,String name) {
        File appDir = new File(Environment.getExternalStorageDirectory(), "OpencvDemo");
        if (!appDir.exists()) {
            appDir.mkdir();
        }
        String fileName = name;
        File file = new File(appDir, fileName);
//        if (file.exists()) {
//            file.delete();
//        }
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
            Log.e(TAG, "图片保存成功...");
        } catch (FileNotFoundException e) {
            Log.e(TAG, "图片保存失败...");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
