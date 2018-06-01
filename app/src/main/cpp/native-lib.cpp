#include <jni.h>
#include <string>
#include <android/log.h>
// 宏定义类似java 层的定义,不同级别的Log LOGI, LOGD, LOGW, LOGE, LOGF。 对就Java中的 Log.i log.d
#define LOG_TAG    "hpc -- JNILOG" // 这个是自定义的LOG的标识
//#undef LOG // 取消默认的LOG
#define LOGI(...)  __android_log_print(ANDROID_LOG_INFO,LOG_TAG, __VA_ARGS__)
#define LOGD(...)  __android_log_print(ANDROID_LOG_DEBUG,LOG_TAG, __VA_ARGS__)
#define LOGW(...)  __android_log_print(ANDROID_LOG_WARN,LOG_TAG, __VA_ARGS__)
#define LOGE(...)  __android_log_print(ANDROID_LOG_ERROR,LOG_TAG, __VA_ARGS__)
#define LOGF(...)  __android_log_print(ANDROID_LOG_FATAL,LOG_TAG, __VA_ARGS__)
extern "C"
JNIEXPORT jstring JNICALL
Java_com_panjq_opencv_opencvdemo_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    LOGE("stringFromJNI: called JNI start...");
    std::string hello = "Hello from C++";
    LOGE("stringFromJNI: called JNI end...");
    return env->NewStringUTF(hello.c_str());
}
