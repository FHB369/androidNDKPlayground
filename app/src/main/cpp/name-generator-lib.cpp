//
// Created by fhb36 on 06-Sep-20.
//

#include "name-generator-lib.h"
#include <jni.h>
#include <string>

using namespace std;

extern "C" JNIEXPORT jstring JNICALL
Java_com_spectrum_androidndkplayground_MainActivity_generateRandomName(
        JNIEnv *env,
        jobject /* this */,
        jint age) {
    string epic_names[10] = {"Arthur", "Beowulf", "Castor", "Davy", "Griffin", "Leander",
                             "Odysseus", "Pollux", "Thor", "Zeus"};
    int index = age % 10;
    string name = epic_names[index] ;
    return env->NewStringUTF(name.c_str());
}