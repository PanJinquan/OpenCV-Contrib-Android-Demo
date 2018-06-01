# OpencvDemo说明
## 一：OpenCV-android-sdk说明

#由于Github不支持超过100M的大文件上传，因此原Demo的OpenCV-android-sdk的部分大文件已经被删除了
#可能导致其他意想不到的问题，请到官网下载对应的OpenCV-3.1.0-android-sdk或者其他版本，并代替原文件即可：
OpenCV-android-sdk下载地址：
https://opencv.org/releases.html

- 请在app/CMakeLists.txt中设置好OpenCV-android-sdk的路径
- Demo的OpenCV版本是OpenCV-3.1.0-android-sdk，CMakeLists已经设置为：
> set(OpenCV_DIR ${CMAKE_SOURCE_DIR}/../OpenCV-android-sdk/sdk/native/jni) 
> find_package(OpenCV REQUIRED)   
> include_directories( ${CMAKE_SOURCE_DIR}/../OpenCV-android-sdk/sdk/native/jni/include) 

## 二：文件说明
- 由于Github不支持超过100M的大文件上传，因此原Demo的OpenCV-android-sdk的部分大文件已经被删除了
- 可以导致其他意想不到的问题，请到官网下载对应的OpenCV-3.1.0-android-sdk或者其他版本，并代替原文件即可：
> OpenCV-android-sdk下载地址：https://opencv.org/releases.html

