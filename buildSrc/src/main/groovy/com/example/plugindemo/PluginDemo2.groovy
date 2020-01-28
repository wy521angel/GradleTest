package com.example.plugindemo

import com.android.build.gradle.BaseExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class PluginDemo2 implements Plugin<Project> {
    @Override
    void apply(Project target) {
        def extension = target.extensions.create('wy2', ExtensionDemo)
        target.afterEvaluate {
            println "Hello ${extension.name}!"
        }
        //需要插入代码的 transform
        def transform = new TransFormDemo()
        //这是约定俗成的
        //配置的类是 BaseExtension
        //在 module 中的 build.gradle 里配置的标签是 android
        //下面代码就是拿到对应配置类
        def baseExtension = target.extensions.getByType(BaseExtension)

        println "bootClassPath: ${baseExtension.bootClasspath}"
        baseExtension.registerTransform(transform)
    }
}