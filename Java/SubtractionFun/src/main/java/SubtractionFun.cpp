#include <jni.h>
#include "SubtractionFun.h"

JNIEXPORT jint JNICALL Java_SubtractionFun_subtractValues
  (JNIEnv *, jobject thisObj, jdouble x, jdouble y) {
    int difference = x - y;
    return difference;
  }
