
//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.text;

import java.lang.String;
import org.opencv.core.Mat;

// C++: class OCRTesseract
//javadoc: OCRTesseract
public class OCRTesseract extends BaseOCR {

    protected OCRTesseract(long addr) { super(addr); }


    //
    // C++: static Ptr_OCRTesseract create(c_string datapath = 0, c_string language = 0, c_string char_whitelist = 0, int oem = OEM_DEFAULT, int psmode = PSM_AUTO)
    //

    //javadoc: OCRTesseract::create(datapath, language, char_whitelist, oem, psmode)
    public static OCRTesseract create(String datapath, String language, String char_whitelist, int oem, int psmode)
    {
        
        OCRTesseract retVal = new OCRTesseract(create_0(datapath, language, char_whitelist, oem, psmode));
        
        return retVal;
    }

    //javadoc: OCRTesseract::create()
    public static OCRTesseract create()
    {
        
        OCRTesseract retVal = new OCRTesseract(create_1());
        
        return retVal;
    }


    //
    // C++:  String run(Mat image, Mat mask, int min_confidence, int component_level = 0)
    //

    //javadoc: OCRTesseract::run(image, mask, min_confidence, component_level)
    public  String run(Mat image, Mat mask, int min_confidence, int component_level)
    {
        
        String retVal = run_0(nativeObj, image.nativeObj, mask.nativeObj, min_confidence, component_level);
        
        return retVal;
    }

    //javadoc: OCRTesseract::run(image, mask, min_confidence)
    public  String run(Mat image, Mat mask, int min_confidence)
    {
        
        String retVal = run_1(nativeObj, image.nativeObj, mask.nativeObj, min_confidence);
        
        return retVal;
    }


    //
    // C++:  String run(Mat image, int min_confidence, int component_level = 0)
    //

    //javadoc: OCRTesseract::run(image, min_confidence, component_level)
    public  String run(Mat image, int min_confidence, int component_level)
    {
        
        String retVal = run_2(nativeObj, image.nativeObj, min_confidence, component_level);
        
        return retVal;
    }

    //javadoc: OCRTesseract::run(image, min_confidence)
    public  String run(Mat image, int min_confidence)
    {
        
        String retVal = run_3(nativeObj, image.nativeObj, min_confidence);
        
        return retVal;
    }


    //
    // C++:  void setWhiteList(String char_whitelist)
    //

    //javadoc: OCRTesseract::setWhiteList(char_whitelist)
    public  void setWhiteList(String char_whitelist)
    {
        
        setWhiteList_0(nativeObj, char_whitelist);
        
        return;
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++: static Ptr_OCRTesseract create(c_string datapath = 0, c_string language = 0, c_string char_whitelist = 0, int oem = OEM_DEFAULT, int psmode = PSM_AUTO)
    private static native long create_0(String datapath, String language, String char_whitelist, int oem, int psmode);
    private static native long create_1();

    // C++:  String run(Mat image, Mat mask, int min_confidence, int component_level = 0)
    private static native String run_0(long nativeObj, long image_nativeObj, long mask_nativeObj, int min_confidence, int component_level);
    private static native String run_1(long nativeObj, long image_nativeObj, long mask_nativeObj, int min_confidence);

    // C++:  String run(Mat image, int min_confidence, int component_level = 0)
    private static native String run_2(long nativeObj, long image_nativeObj, int min_confidence, int component_level);
    private static native String run_3(long nativeObj, long image_nativeObj, int min_confidence);

    // C++:  void setWhiteList(String char_whitelist)
    private static native void setWhiteList_0(long nativeObj, String char_whitelist);

    // native support for java finalize()
    private static native void delete(long nativeObj);

}
