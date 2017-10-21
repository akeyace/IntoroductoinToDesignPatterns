
# ｎさわさんのやってみようのコーナー


以下のCOBOL エンジニアがあったとき、

ファイル名:Engineer.java
```java
package decoratordemo;

public class Engineer {

	public void saySkill(){
	}

	public void exec(){
		saySkill();
	}

}
```

ファイル名:CobolEngineer.java
```java
package decoratordemo;

public class CobolEngineer extends Engineer{

	public void saySkill(){
		System.out.println("私はCOBOLのエンジニアです。");
	}

}
```

これが、Java エンジニアになるためには、

ファイル名:JavaEngineer.java
```java
package decoratordemo;

public class JavaEngineer extends CobolEngineer{

	public void saySkill(){
		super.saySkill();	// CobolEngineer の saySkill を呼び出す
		System.out.println("そしてJavaもできるようになりました。");
	}

}
```

のように、COBOL エンジニアを継承するという方法があるけれど、
Decorator を使えば、

ファイル名:DecoratedJavaEngineer.java
```java
package decoratordemo;

public class DecoratedJavaEngineer extends Engineer{

	private Engineer enginner = null;	// もともとのエンジニア

	public DecoratedJavaEngineer(Engineer inner){	// コンストラクタで渡す
		this.enginner = inner;
	}

	public void saySkill(){
		this.enginner.saySkill();
		System.out.println("ですが、Java のスキルも手に入れました。");
	}

}
```

もともとのエンジニアを内包した（継承せずに）Java エンジニアになれる。

【利点】
-この構成だと、CobolEngineer じゃないと JavaEngineer になれないが、DecoratedJavaEngineer ならどのエンジニアも JavaEngineer になれる。

## ★課題

1. 新規プロジェクトを作成して、上記のクラスを作成しましょう。
main クラスは以下のクラスを使用してください。

ファイル名:Main.java
```java
package decoratordemo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args){

		Scanner scanner = new Scanner(System.in);
		System.out.println("e か d を入力してください。");
		String input = scanner.next();
		scanner.close();

		Engineer engineer = null;
		if ( "e".equals(input) ){
			engineer = new JavaEngineer();
		} else if ( "d".equals(input ) ) {
			engineer = new DecoratedJavaEngineer(new CobolEngineer());
		}

		engineer.exec();

	}

}
```

2. 起動してください。
e を入力すると
> 私はCOBOLのエンジニアです。
> そしてJavaもできるようになりました。

d を入力すると
> 私はCOBOLができます。
> ですが、Java もできるようになりました。

となることを確かめてください。


3. Engineer クラスを継承した VBEngineer クラスを作成してください。
そして、DecoratatedJavaEngineer にて、VBEngineer を JavaEngineer にしてあげてください。
Main クラスで 'v' と入力すれば、上記のふるまいが確認できるようにしてください。

4. （任意）
任意の Engineer からの、DecoratedDotNetEngineer を作成してみましょう。


5. Decorator の利用シーンを考えてみましょう

(1) 一般的には...

・無用な継承を避けたいとき
・なにかの処理を行うクラスを拡張したいとき（継承を用いずに）

(2) 泥臭い実装面の観点からだと...

・すでにスパゲッティなプログラムがあるときにそのプログラムの動作を間借りする形で
　動作を拡張したいとき
（COBOL だと基本的にコピペしなければならないが、Java だともとのプログラムはそのままで
　利用することができますね。）

(3) 設計面からは...

・業務実装クラスを拡張するために、スーパークラスを変更したいが、スーパークラスが
パッケージだったり、他社が作ったものであるために、その変更ができないとき
・または、業務実装クラス固有の動作のために、いちいちスーパークラスの変更など
やってられないとき→Decorator でやって、とお願いする。

など



