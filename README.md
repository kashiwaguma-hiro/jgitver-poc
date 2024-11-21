# jgitver-poc

https://jgitver.github.io/ を利用したモジュールバージョンの自動化をためす


# usage

mainブランチのバージョン
```
% git branch
* main

% ./gradlew version

> Task :version
Version: 0.0.0-SNAPSHOT

BUILD SUCCESSFUL in 365ms
```

feature branchの場合のバージョン
```
% git switch -c feature/hogehoge
Switched to a new branch 'feature/hogehoge'

% ./gradlew version             

> Task :version
Version: 0.0.0-feature_hogehoge-SNAPSHOT

BUILD SUCCESSFUL in 622ms
```

適当な修正を加えてPullRequestだして、マージ後
```
% git pull
remote: Enumerating objects: 1, done.
remote: Counting objects: 100% (1/1), done.
remote: Total 1 (delta 0), reused 0 (delta 0), pack-reused 0 (from 0)
Unpacking objects: 100% (1/1), 901 bytes | 901.00 KiB/s, done.
From https://github.com/kashiwaguma-hiro/jgitver-poc
   fcb56ba..a9914f7  main       -> origin/main
Updating fcb56ba..a9914f7
Fast-forward
 README.md | 31 ++++++++++++++++++++++++++++++-
 1 file changed, 30 insertions(+), 1 deletion(-)

 % ./gradlew version

> Task :version
Version: 0.0.0-SNAPSHOT #snapshotのまま

BUILD SUCCESSFUL in 314ms
1 actionable task: 1 executed
```

タグを作成したらどうなる
```
% git tag -a 0.0.1 -m "increment"
% git push origin 0.0.1
Enumerating objects: 1, done.
Counting objects: 100% (1/1), done.
Writing objects: 100% (1/1), 170 bytes | 170.00 KiB/s, done.
Total 1 (delta 0), reused 0 (delta 0), pack-reused 0
To https://github.com/kashiwaguma-hiro/jgitver-poc.git
 * [new tag]         0.0.1 -> 0.0.1
% git tag  
0.0.1

% ./gradlew version    

> Task :version
Version: 0.0.1
```

そのあと、改修いれてみる
```
% git switch -c feature/modify_readme

% ./gradlew version #featureブランチでの確認

> Task :version
Version: 0.0.2-feature_modify_readme-SNAPSHOT

BUILD SUCCESSFUL in 331ms
1 actionable task: 1 executed
```

上記featureをマージし、その後のバージョンどうなるのっと
```
% git switch main
Switched to branch 'main'
Your branch is behind 'origin/main' by 2 commits, and can be fast-forwarded.
  (use "git pull" to update your local branch)
kashiwaguma-hiro@QCXL4279VX jgitver-poc % git pull
Updating a9914f7..5d118b3
Fast-forward
 README.md | 47 +++++++++++++++++++++++++++++++++++++++++++++++
 1 file changed, 47 insertions(+)

 % ./gradlew version

> Task :version
Version: 0.0.2-SNAPSHOT # tagのバージョンにインクリメントした値になってる

BUILD SUCCESSFUL in 311ms
1 actionable task: 1 executed
kashiwaguma-hiro@QCXL4279VX jgitver-poc % git tag 
0.0.1
```