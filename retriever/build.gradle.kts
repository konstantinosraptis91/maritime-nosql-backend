plugins {
    id("maritime.java-library-conventions")
}

dependencies {
    implementation(project(":model"))
    implementation("jakarta.validation:jakarta.validation-api:3.0.0")
}
