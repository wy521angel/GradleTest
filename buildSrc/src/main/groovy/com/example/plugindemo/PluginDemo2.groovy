package com.example.plugindemo

import org.gradle.api.Plugin
import org.gradle.api.Project

class PluginDemo2 implements Plugin<Project> {
    @Override
    void apply(Project target) {
        def extension = target.extensions.create('wy2', ExtensionDemo)
        target.afterEvaluate {
            println "Hello ${extension.name}!"
        }
    }
}