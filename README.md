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