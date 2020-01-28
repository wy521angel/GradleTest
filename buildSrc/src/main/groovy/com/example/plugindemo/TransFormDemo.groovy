package com.example.plugindemo

import com.android.build.api.transform.Format
import com.android.build.api.transform.QualifiedContent
import com.android.build.api.transform.Transform
import com.android.build.api.transform.TransformException
import com.android.build.api.transform.TransformInvocation
import com.android.build.gradle.internal.pipeline.TransformManager
import com.android.utils.FileUtils

public class TransFormDemo extends Transform {

    // 对应的 task 名
    @Override
    String getName() {
        return "wyTransform"
    }

    // 要对哪些类型的结果进行转换(是字节码还是资源⽂文件)
    @Override
    Set<QualifiedContent.ContentType> getInputTypes() {
        return TransformManager.CONTENT_CLASS
    }

    // 适用范包括什么(整个 project 还是别的),
    @Override
    Set<? super QualifiedContent.Scope> getScopes() {
        return TransformManager.SCOPE_FULL_PROJECT
    }

    @Override
    boolean isIncremental() {
        return false
    }

    @Override
    void transform(TransformInvocation transformInvocation) throws TransformException, InterruptedException, IOException {
        def inputs = transformInvocation.inputs
        def outputProvider = transformInvocation.outputProvider

        inputs.each {
            it.jarInputs.each {
                println "file:${it.file}"
                File dest = outputProvider.getContentLocation(it.name, it.contentTypes, it.scopes, Format.JAR)
                FileUtils.copyFile(it.file, dest)
            }

            it.directoryInputs.each {
                println "file:${it.file}"
                File dest = outputProvider.getContentLocation(it.name, it.contentTypes, it.scopes, Format.DIRECTORY)
                println "Dest: ${it.file}"
                FileUtils.copyDirectory(it.file, dest)
            }
        }
    }
}
