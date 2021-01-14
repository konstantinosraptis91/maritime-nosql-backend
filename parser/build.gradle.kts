plugins {
    id("maritime.java-library-conventions")
}

dependencies {
    implementation(project(":codelists"))
    implementation("javax.validation:validation-api:2.0.1.Final")
    implementation("org.hibernate.validator:hibernate-validator:6.1.6.Final")
    // implementation("com.opencsv:opencsv:5.3")
}
