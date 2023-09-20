load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

RULES_JVM_EXTERNAL_TAG = "5.3"


http_archive(
    name = "rules_jvm_external",
    sha256 = "d31e369b854322ca5098ea12c69d7175ded971435e55c18dd9dd5f29cc5249ac",
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    url = "https://github.com/bazelbuild/rules_jvm_external/releases/download/%s/rules_jvm_external-%s.tar.gz" % (RULES_JVM_EXTERNAL_TAG, RULES_JVM_EXTERNAL_TAG),
)


http_archive(
    name = "io_bazel_rules_kotlin",
    sha256 = "a630cda9fdb4f56cf2dc20a4bf873765c41cf00e9379e8d59cd07b24730f4fde",
    urls = ["https://github.com/bazelbuild/rules_kotlin/releases/download/v1.8.1/rules_kotlin_release.tgz"],
)

android_sdk_repository(
    name = "androidsdk",
    api_level = 31,
    build_tools_version = "33.0.0",
)

_DAGGER_TAG = "2.48"

http_archive(
    name = "dagger",
    sha256 = "5f9d43b9a7d940a44ca9d5f4e08758b6141e7cb57ac0a2b8bbab02c9ba554c0e",
    strip_prefix = "dagger-dagger-%s" % _DAGGER_TAG,
    urls = ["https://github.com/google/dagger/archive/refs/tags/dagger-%s.zip" % _DAGGER_TAG],
)

load(
    "@dagger//:workspace_defs.bzl",
    "HILT_ANDROID_ARTIFACTS",
    "HILT_ANDROID_REPOSITORIES",
)

load("@rules_jvm_external//:defs.bzl", "maven_install")

KOTLIN_VERSION = "1.9.0"

maven_install(
    artifacts = [
        "androidx.activity:activity-ktx:1.7.1",
        "androidx.appcompat:appcompat:1.6.1",
        "androidx.core:core-ktx:1.9.0",
        "androidx.lifecycle:lifecycle-runtime:2.6.1",
        "org.jetbrains.kotlin:kotlin-stdlib:{}".format(KOTLIN_VERSION),
    ] + HILT_ANDROID_ARTIFACTS,
    fetch_sources = True,
    repositories = HILT_ANDROID_REPOSITORIES,
    version_conflict_policy = "pinned",
)

load(
    "@io_bazel_rules_kotlin//kotlin:repositories.bzl",
    "kotlin_repositories",
    "kotlinc_version",
)

# Get from https://github.com/JetBrains/kotlin/releases/
KOTLINC_RELEASE_SHA = "1fc50d805f9809e92de43e91f089cc8618567c1a350faebdabf8a40c5048bee8"

kotlin_repositories(
    compiler_release = kotlinc_version(
        release = KOTLIN_VERSION,
        sha256 = KOTLINC_RELEASE_SHA,
    ),
)

register_toolchains("//:kotlin_toolchain")
