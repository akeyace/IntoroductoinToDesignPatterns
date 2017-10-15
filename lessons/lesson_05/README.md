# デザインパターン入門 第五回 Decorator パターン

前回の勉強会では、第四回 『デザインパターン Proxy パターン』を学び、
またハンズオンで Singleton パターンの実装を行いました。
今回は、Decorator パターンを学んで参ります！

## 事前準備
- 前回分までのソースコードを用意します
  - git 環境がある場合
    - 既に clone してある場合
      ```
      git checkout lesson_03_05
      ```
    - clone していない場合
      ```
      # git 環境を作成するディレクトリに移動する
      # 下記は一例
      mkdir ~/git
      cd ~/git

      git clone https://github.com/akeyace/IntoroductoinToDesignPatterns.git
      cd IntoroductoinToDesignPatterns
      git checkout lesson_03_05
      ```     
  - git 環境を作成する場合
    - 下記を参考に git 環境を構築する
      - https://git-scm.com/book/ja/v2/使い始める-Gitのインストール
  - git を使わない場合
    - 下記ファイルをダウンロードする
      - https://github.com/akeyace/IntoroductoinToDesignPatterns/archive/lesson_03_05.zip
- Eclipse で開く


# Eclipse で開く
  1. Eclipse で 『ファイル』→ 『新規』 → 『Java プロジェクト』を実行
  1. プロジェクト名に『IntroductionToDesignPatterns』 を指定
  1. ロケーションにclone (もしくはダウロード) したディレクトリ  (IntoroductoinToDesignPatterns/lessons/lesson_03/java/) を指定
  1. プロジェクトを開いたら、『実行』 → 『Java アプリケーション』 を実行
  1. コンソール ウィンドウに色々と表示されたら成功

## Decorator パターン概要
- 目的
  - オブジェクトに責任(responsibility)を動的に追加する。Decorator パターンは、サブクラス化よりも柔軟な機能拡張方法を提供する
- 別名
  - wrapper
- 動機(意訳)
  - あるクラス全体にではなく、部分的に機能を追加、修正したい
    - 例えば肥大化したクラスの部分的な追加・修正を行ないたいが影響範囲を抑えたい
  - 単純に継承を行いサブクラスを作る方法もあるが、不要にサブクラスが量産される事を回避したい
    - 例えばよくある方法は……   
      ```java
      // 通常の処理
      class Process() {
        public function doAction() {
          // 何らかの処理
        }
      }
      
      // 特定状況下で処理を変えたい
      class ProcessOtherCase extends Process {
        @override
        public function doAction() {
          // 処理内容が異なる
        }
      }
      ```
- 適用可能性
  - 個々のオブジェクトに処理を動的、かつ影響範囲を小さく処理を追加する場合
  - 処理の取り外しがある場合
  - サブクラスの肥大化等により、サブクラスによる拡張が困難な場合
- クラス図  
  ![960px-decorator_uml_class_diagram svg](https://user-images.githubusercontent.com/1944039/29361022-9a72b7f0-82c0-11e7-9b04-1860b4f703ac.png)
  - wikipedia より
- 構成要素
  - Component クラス
    - 処理の動的追加が出来るようにインタフェースを定義する
  - ConcreteComponent クラス
    - 処理追加が行われるの実態オブジェクト。Component インタフェースを実現する
  - Decorator クラス
    - 実態オブジェクト(ConcereteComponent) への参照を保持する。Component インタフェースを実現する
  - ConcreteDecorator クラス
    - Component クラスに処理を追加するオブジェクト
- 結果
  - 2つのメリット、2つのデメリットを持つ
    - メリット
      - サブクラスによる実装よりも、柔軟な実装が可能
      - 実装する際の影響範囲を小さくすることが出来る
    - デメリット
      - ConcreteDecorater オブジェクト、Component オブジェクトの同一性がない
        - 実装時に注意が必要
      - エンジニアが Decorator パターンを理解していないと混乱が生じる可能性がある

### Decorator パターンを適用する

それでは、Decorator パターンを適用してみましょう。
今回適用出来そうな場所はどこでしょう？

今回は適用可能な箇所が複数あるやも。

今回は、案件情報(WorkInformation) に適用してみましょう！

#### クラス図修正
それでは、案件情報(WorkInformation) クラスを修正していきましょう。
- 修正内容
  - 案件情報クラスを拡張しやすくするため、操作: getOptions, setOptions を追加 
  - 案件情報 クラスのステレオタイプにインタフェースを追加
  - 案件情報(実態) クラスを追加し、案件情報インタフェースを実現する
  - 案件情報(Decorator)を追加し、抽象クラスとして案件情報インタフェースを実現する
  - 案件情報(メモ)を追加し、案件情報(Decorator)を継承する
  - 案件情報(単価)を追加し、案件情報(Decorator)を継承する
  - 案件情報(永田)を追加し、案件情報(Decorator)を継承する
    - 操作に getDetail, upPrice を追加

修正後のクラス図はこちらになります。
[PE-BANK UML図 Decorator パターンを適用](https://github.com/akeyace/IntoroductoinToDesignPatterns/tree/lesson_03_06/lessons/lesson_03)

#### ソースコード修正
- 修正内容
  - WorkInformation クラスの名前を ConcreteWorkInformation に変更し、WorkInformation インタフェースをimplements する
    - メンバ変数に options, メソッドにgetOptions, setOptions を追加する
      ```diff
        String detail;
      + HashMap<String, String> options = new HashMap<>();
     
         public void setDetail(String detail) {
           this.detail = detail;
          }
      
      + public HashMap<String, String> getOptions() {
      +   return options;
      + }
      
      + public void setOptions(String key, String value) {
      +   options.put(key, value);
      + }
      ```
  - WorkInformation インタフェースを追加
    - インタフェースなのでメソッドを 「void setWorkInformation(String workName, String detail)」のように記述すること
  - WorkInformationDecorator クラスを追加
    ```java
    package introductiontodesignpatterns.workinformation;
    
    import java.util.HashMap;
    
    abstract class WorkInformationDecorator implements WorkInformation {
      protected WorkInformation workInformation;
    
      public void setWorkInformation(String workName, String detail) {
        workInformation.setWorkInformation(workName, detail);
      }
    
      public String getWorkName() {
        return workInformation.getWorkName();
      }
    
      public void setWorkName(String workName) {
        workInformation.setWorkName(workName);
      }
    
      public String getDetail() {
        return workInformation.getDetail();
      }
    
      public void setDetail(String detail) {
        workInformation.setDetail(detail);
      }
    
      public HashMap<String, String> getOptions() {
        return workInformation.getOptions();
      }
    
      public void setOptions(String key, String value) {
        workInformation.setOptions(key, value);
      }
    }
    ````
  - WorkInformationWithMemo クラスを追加
    ```java
    package introductiontodesignpatterns.workinformation;
    
    public class WorkInformationWithMemo extends WorkInformationDecorator {
      public WorkInformationWithMemo(WorkInformation workInformation, String memo) {
        this.workInformation = workInformation;
        setOptions("memo", memo);
    
      }
    }
    ```
  - WorkInformationWithPrice クラスを追加
    ```java
    package introductiontodesignpatterns.workinformation;
    
    public class WorkInformationWithPrice extends WorkInformationDecorator {
      public WorkInformationWithPrice(WorkInformation workInformation, Number price) {
        this.workInformation = workInformation;
        setOptions("単価", price.toString());
      }
    
      public String getDetail() {
        if (Integer.parseInt(workInformation.getOptions().get("単価")) >= 600000) {
          return workInformation.getDetail() + " 高単価案件です";
        } else {
          return workInformation.getDetail();
        }
      }
    }
    ```
  - WorkInformationNagata クラスを追加
    ```java
    package introductiontodesignpatterns.workinformation;
      
    public class WorkInformationNagata extends WorkInformationDecorator {
      
      public WorkInformationNagata(WorkInformation workInformation) {
        this.workInformation = workInformation;
        this.workInformation.setWorkName(workInformation.getWorkName() + "[永田案件]");
      }
    
      public WorkInformation priceUp(Double priceUpRate) {
        this.workInformation.setOptions("単価", String
            .valueOf(Math.round(Integer.parseInt(this.workInformation.getOptions().get("単価")) * priceUpRate)));
        return this;
      }
    
      public String getDetail() {
        return workInformation.getDetail() + " オススメの案件です！";
      }
    }
    ```

   - PEEmployee クラスを修正
     ```diff
     
     public void setWorkInformation(Number id, String workName, String detail) {
     -  workInformations.put(id, new WorkInformation(workName, detail));
     +  workInformations.put(id, new ConcreteWorkInformation(workName, detail));
     }

     public ArrayList<String> getWorkInfo(Number id) {
        WorkInformation workInformation = workInformations.get(id);
     -  return new ArrayList<String>(Arrays.asList(workInformation.getWorkName(), workInformation.getDetail()));
     +  return new ArrayList<String>(Arrays.asList(workInformation.getWorkName(), workInformation.getDetail(),
        workInformation.getOptions().toString()));
      }
     ```

これで実行してみると……
ログにの案件情報に「{}」が追加されたのが解ります。
Decorator パターンは影響範囲を限定出来るのがメリット。
それでは、Decorator パターンの威力を見てみましょう

- 永田クラスでsetWorkInformationをオーバーライド
  ```java
  public void setWorkInformation(Number id, String workName, String detail, String memo, Number price) {
     workInformations.put(id,
       new WorkInformationWithPrice(
          new WorkInformationWithMemo(new ConcreteWorkInformation(workName, detail), memo), price));
  }
  ```
- Main.java の次の行を修正
  ```diff
  - Nagata.call().setWorkInformation(1, "java案件", "Spring フレームワーク");
  + Nagata.call().setWorkInformation(1, "java案件", "Spring フレームワーク", "働き易い案件", 600000);
  ```

実行してみると……。
ログの案件情報に、options の項目が追加され、しかもdetail 欄に「高単価案件」と表示されるようになりました。
さらに永田クラスを修正すると……

- 永田クラスのsetWorkInformation を書き換え
  ```java
  public void setWorkInformation(Number id, String workName, String detail, String memo, Number price) {
    workInformations.put(id,
      new WorkInformationNagata(new WorkInformationWithPrice(
        new WorkInformationWithMemo(new ConcreteWorkInformation(workName, detail), memo), price))
          .priceUp(1.2));
  }
  ```

上記、実行結果は是非ともお試しあれ。

### Decorator パターン まとめ
この様にインスタンス生成時に ConcreteDecorator を使い分ける事で処理内容が変更される事がわかりました。
これで修正時に元のクラスへの変更せず、新規クラスの追加による処理変更が行われるようになりました。

修正後のソースコードはこちらになります。
[PE-BANK ソースコード Decorator パターンを適用](https://github.com/akeyace/IntoroductoinToDesignPatterns/tree/lesson_03_07/lessons/lesson_03/java/src/introductiontodesignpatterns)

## 第五回まとめ
今回は、オブジェクトの処理をより効果的に修正するパターンを学びました。
デザインパターンはスパゲッティになりがちな設計、ソースコードをより解りやすく、より透明にします。
一見すると難しいですが、何回も繰り返し実装し、不明な点は検索して探し出す事でより深い理解へと辿り着くことが可能です。
是非ともデザインパターンを習得していきましょう！
