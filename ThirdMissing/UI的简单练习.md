# UI的简单练习
本次实验对android界面中的TextView、EditText、Button、ImageView等控件进行了简单的使用和布局。
<br/>

## 布局
布局最外层采用垂直布局，一共四个区域，1放置了TextView，2是一个水平布局，里面放置了EditText和Button，3是ImageView和4的切换图片的Button。
整体效果如下：
<br/>
![整体效果图](/ThirdMissing/img/all.png)
<br/>
布局中需要注意，如果全局布局是垂直布局，那么在放置其它布局或控件时应该注意在其layout_height的设置中不能采用match_parent，否则在其以下的其它布局或者控件会被挤出屏幕,用户将无法看到和操作。
<br/>

## TextView
它用于在界面上显示文本，通常来说文本是默认居左上角对齐的，图中对文本进行了如下设置使其居中显示,同时设置文字大小为20sp，也可以设置其他文字样式。
<br/>
```
	android:gravity="center"
	android:textSize="20sp" 
```
<br/>
![区域1](/ThirdMissing/img/1.png)

## EditText
它用来接收用户输入的文本内容，这里和按钮控件联系，点击按钮使用Toast方法使EditText中的内容显示出来。
<br/>
![区域2](/ThirdMissing/img/2.png)

## ImageView
它用来在界面上显示图片，通常图片放在以”drawable“开头的目录下，项目中一般有一个空的drawable目录，不过这个目录没有指定具体的分辨率，所以我们在res目录下创建了drawable-xhdpi目录，将图片放入。（实验过程中发现图片不能单纯数字，提示以某个character开头命名）
<br/>
这里与按钮控件联系，点击换一张按钮可以反复切换图片。
<br/>
![区域3、4](/ThirdMissing/img/3.png)
![区域3、4](/ThirdMissing/img/4.png)

## AlertDialog
AlertDialog可以在当前界面弹出一个对话框，这个对话框是置顶于所有界面元素之上的，能屏蔽掉其它控件的交互能力，因此它一般都是用于提示一些非常重要的信息。实验中将其与退出程序联系起来，在界面按下back键会弹出对话框，按是退出程序，否则只关闭对话框。
<br/>
![对话框](/ThirdMissing/img/alertDialog.png)
