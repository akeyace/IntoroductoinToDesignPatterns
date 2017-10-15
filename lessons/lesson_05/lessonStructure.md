# 第五回勉強会構成

今回の勉強会では下記の担当で行う(敬称略)
- 導入部分: 藤井担当
- クラス図修正: 藤井担当
- ソースコード修正: ｎさわ担当
- まとめ: 藤井担当

## ソースコード修正 ポイント
- WorkInformation をコピーしてConcreateWorkInformation を作る時は普段通りでOK
- WorkInformation をインタフェース化する時に便利な方法があれば、それを伝授してやって下さいまし
- WorkInformation 及び、ConcreateWorkInformation に HashMap を追加する時にエラーが出ますが保存すれば自動的に import されます
- PEEmployee クラスの WorkInformation を ConcreteWorkInformation に変更する時に 自動的に import されないかもしれません
  - その時はエラー箇所を右クリックで ConcreteWorkInformation を import すればOK
- PEEmployee クラスの options 反映の時に手入力で workinformation.getOptions().toString() を書くとエラーが出るかもしれません
  - その時はコードをコピーしてペーストすると上手くいきます

## 話し方 ポイント
- Decorator パターンは既存処理への影響が少ないのがメリットなので、『main.java を実行してみましょう』の辺りで既存への影響が少ない事をアピール
- 早く終るようなら、実際に WorkInformationDecorator を継承した Decorator クラスを自分で作ってみるコーナーを入れても面白そうです
- 不明な点があれば藤井に話を振って下さい

## その他
- 藤井はｎさわさんの話している間、他参加者のフォローに入ります
