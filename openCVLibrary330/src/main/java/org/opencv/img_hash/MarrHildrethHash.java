
//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.img_hash;



// C++: class MarrHildrethHash
//javadoc: MarrHildrethHash
public class MarrHildrethHash extends ImgHashBase {

    protected MarrHildrethHash(long addr) { super(addr); }


    //
    // C++: static Ptr_MarrHildrethHash create(float alpha = 2.0f, float scale = 1.0f)
    //

    //javadoc: MarrHildrethHash::create(alpha, scale)
    public static MarrHildrethHash create(float alpha, float scale)
    {
        
        MarrHildrethHash retVal = new MarrHildrethHash(create_0(alpha, scale));
        
        return retVal;
    }

    //javadoc: MarrHildrethHash::create()
    public static MarrHildrethHash create()
    {
        
        MarrHildrethHash retVal = new MarrHildrethHash(create_1());
        
        return retVal;
    }


    //
    // C++:  float getAlpha()
    //

    //javadoc: MarrHildrethHash::getAlpha()
    public  float getAlpha()
    {
        
        float retVal = getAlpha_0(nativeObj);
        
        return retVal;
    }


    //
    // C++:  float getScale()
    //

    //javadoc: MarrHildrethHash::getScale()
    public  float getScale()
    {
        
        float retVal = getScale_0(nativeObj);
        
        return retVal;
    }


    //
    // C++:  void setKernelParam(float alpha, float scale)
    //

    //javadoc: MarrHildrethHash::setKernelParam(alpha, scale)
    public  void setKernelParam(float alpha, float scale)
    {
        
        setKernelParam_0(nativeObj, alpha, scale);
        
        return;
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++: static Ptr_MarrHildrethHash create(float alpha = 2.0f, float scale = 1.0f)
    private static native long create_0(float alpha, float scale);
    private static native long create_1();

    // C++:  float getAlpha()
    private static native float getAlpha_0(long nativeObj);

    // C++:  float getScale()
    private static native float getScale_0(long nativeObj);

    // C++:  void setKernelParam(float alpha, float scale)
    private static native void setKernelParam_0(long nativeObj, float alpha, float scale);

    // native support for java finalize()
    private static native void delete(long nativeObj);

}
