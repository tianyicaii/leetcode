## leetcode

https://leetcode.com/u/apf1743/


## MODULE.bazel

```
# Hedron's Compile Commands Extractor for Bazel
# https://github.com/hedronvision/bazel-compile-commands-extractor
bazel_dep(name = "hedron_compile_commands", dev_dependency = True)
git_override(
    module_name = "hedron_compile_commands",
    remote = "https://github.com/hedronvision/bazel-compile-commands-extractor.git",
    commit = "0e990032f3c5a866e72615cf67e5ce22186dcb97",
    # Replace the commit hash (above) with the latest (https://github.com/hedronvision/bazel-compile-commands-extractor/commits/main).
    # Even better, set up Renovate and let it do the work for you (see "Suggestion: Updates" in the README).
)

```


## build

```
bazel build leetcode/cpp:main
bazel run @hedron_compile_commands//:refresh_all

```
