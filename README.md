# bazel-kt-hilt-demo
Bazel/Kotlin/Android/Hilt not working nicely together

## Reproducing the Issue

On `main`, build:

```
$ bazel build app
INFO: Analyzed target //app:app (36 packages loaded, 1085 targets configured).
INFO: Found 1 target...
...
ERROR: /Users/p/Code/bazel-kt-hilt-demo/app/BUILD.bazel:16:19: KotlinKapt //app:lib_kt { kt: 2, java: 0, srcjars: 0 } for armeabi-v7a failed: (Exit 1): build failed: error executing command (from target //app:lib_kt) bazel-out/darwin_arm64-opt-exec-2B5CBBC6/bin/external/io_bazel_rules_kotlin/src/main/kotlin/build '--flagfile=bazel-out/android-armeabi-v7a-fastbuild/bin/app/lib_kt-kapt-gensrc.jar-0.params'
warning: language version 1.5 is deprecated and its support will be removed in a future version of Kotlin
error: /var/folders/71/0r_ylvb13vv2my1_676sx1gm0000gn/T/pwd14073656098635999496/_kotlinc/app-lib_kt_jvm/temp/stubs/com/example/demo/MainActivity.java:5: error: [Hilt] @AndroidEntryPoint class expected to extend Hilt_MainActivity. Found: Object
public final class MainActivity {
             ^
  [Hilt] Processing did not complete. See error above for details.
error: /var/folders/71/0r_ylvb13vv2my1_676sx1gm0000gn/T/pwd14073656098635999496/_kotlinc/app-lib_kt_jvm/temp/stubs/com/example/demo/DemoApplication.java:5: error: [Hilt] @HiltAndroidApp class expected to extend Hilt_DemoApplication. Found: Object
public final class DemoApplication {
             ^
  [Hilt] Processing did not complete. See error above for details.
app/DemoApplication.kt:7:25: error: unresolved reference: Hilt_DemoApplication
class DemoApplication : Hilt_DemoApplication()
                        ^
app/MainActivity.kt:8:22: error: unresolved reference: Hilt_MainActivity
class MainActivity : Hilt_MainActivity() {
                     ^
Sep 20, 2023 9:23:38 AM worker request 0
SEVERE: Compilation failure: compile phase failed:Target //app:app failed to build
Use --verbose_failures to see the command lines of failed build steps.
INFO: Elapsed time: 80.979s, Critical Path: 26.85s
INFO: 587 processes: 47 internal, 479 darwin-sandbox, 61 worker.
FAILED: Build did NOT complete successfully
```
