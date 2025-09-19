plugins {
    // أضف الـ plugin الخاص بـ Google Services كـ dependency على مستوى المشروع
    id("com.google.gms.google-services") version "4.4.3" apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

// إعدادات تغيير مجلد الـ build حسب ما عندك
val newBuildDir: Directory = rootProject.layout.buildDirectory.dir("../../build").get()
rootProject.layout.buildDirectory.value(newBuildDir)

subprojects {
    val newSubprojectBuildDir: Directory = newBuildDir.dir(project.name)
    project.layout.buildDirectory.value(newSubprojectBuildDir)
}

subprojects {
    project.evaluationDependsOn(":app")
}

// تعريف مهمة clean
tasks.register<Delete>("clean") {
    delete(rootProject.layout.buildDirectory)
}
