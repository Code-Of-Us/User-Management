plugins {
    kotlin("jvm") version "1.7.22"
    kotlin("plugin.allopen") version "1.7.22"
    id("io.quarkus")
}

repositories {
    mavenCentral()
    mavenLocal()
}

var lombokVersion = "1.18.22"
var mapstructVersion = "1.3.1."

val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project

dependencies {
    implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
    implementation("io.quarkus:quarkus-hibernate-orm-rest-data-panache")
    implementation("io.quarkus:quarkus-resteasy-jackson")
    implementation("io.quarkus:quarkus-rest-client")
    implementation("io.quarkus:quarkus-kotlin")
    implementation("io.quarkus:quarkus-jdbc-postgresql")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.quarkus:quarkus-arc")
    implementation("org.projectlombok:lombok:$lombokVersion")
    implementation("org.mapstruct:mapstruct:${mapstructVersion}Final")
    implementation("org.mapstruct:mapstruct-processor:${mapstructVersion}Final")
    implementation("io.quarkus:quarkus-smallrye-health")
    implementation("com.github.fmcejudo:quarkus-eureka:0.0.14")
    testImplementation("io.quarkus:quarkus-junit5")
    testImplementation("io.rest-assured:rest-assured")

    annotationProcessor("org.projectlombok:lombok:${lombokVersion}")
    annotationProcessor("org.mapstruct:mapstruct-processor:${mapstructVersion}Final")
}

group = "com.example"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<Test> {
    systemProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager")
}
allOpen {
    annotation("javax.ws.rs.Path")
    annotation("javax.enterprise.context.ApplicationScoped")
    annotation("io.quarkus.test.junit.QuarkusTest")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_17.toString()
    kotlinOptions.javaParameters = true
}
