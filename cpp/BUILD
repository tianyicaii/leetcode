# bazel build //leetcode/cpp:all
# ./bazel-bin/main
# bazel run @hedron_compile_commands//:refresh_all

cc_binary(
    name = "main",
    srcs = ["main.cpp"],
    deps = [
        "//leetcode/cpp/selected:0001-two-sum",
    ],
)

# ./bazel-bin/leetcode/cpp/scratch
cc_binary(
    name = "scratch",
    srcs = ["scratch/scratch.cpp"],
    deps = [],
)
