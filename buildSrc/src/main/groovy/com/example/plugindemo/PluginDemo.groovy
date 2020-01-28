package com.example.plugindemo

import org.gradle.api.Plugin
import org.gradle.api.Project

class PluginDemo implements Plugin<Project> {
    @Override
    void apply(Project target) {
        def extension = target.extensions.create('wy', ExtensionDemo)
//        def extension = target.extensions.create('wy', JavaExtensionDemo)
        target.afterEvaluate {
            println "Hello ${extension.name}!"
        }
    }
}