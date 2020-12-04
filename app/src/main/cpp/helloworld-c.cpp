//
// Created by fijar on 05/12/20.
//

#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jint  JNICALL
Java_id_ac_ui_cs_mobileprogramming_fijar_tktpl_lab_external_Age_addAge(
        JNIEnv* pEnv,
        jobject pThis,
        jint pAge
        ) {
    return pAge+1;
}

extern "C"
JNIEXPORT jint JNICALL
Java_id_ac_ui_cs_mobileprogramming_fijar_tktpl_lab_14_external_Age_addAge(JNIEnv *env, jobject thiz,
                                                                          jint age) {
    return age+1;
}