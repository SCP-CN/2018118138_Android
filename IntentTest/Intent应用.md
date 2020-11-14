# Intent的应用
一个程序一般不只有一个主活动，还有各种各样的其它活动，我们可以利用Intent从主活动中跳转到其它活动中去。<br/>
接下来程序将展示多种Intent启动活动的应用。主活动如下所示：<br/>
![主活动](/IntentTest/img/主活动.png)

## 显式Intent
Intent有多个构造函数的重载，其中一个是Intent(Context packageContext,Class<?>cls)。第一个参数Context要求提供一个启动活动的上下文，第二个参数Class则是指定想要启动的目标活动，通过这个构造函数就可以构建出Intent的“意图”。<br/>
那么如何使用Intent呢？Activity类中提供了startActivity()方法，它接收Intent参数来启动活动。<br/>
设置好主活动中按钮显示Intent的点击事件：
```
	Intent intent1 = new Intent(MainActivity.this, IntentActivity1.class);
    startActivity(intent1);
```
点击显式Intent按钮启动活动：<br/>
![主活动](/IntentTest/img/显式.png)
<br/>
这种指定好启动活动的方式意图十分明显，因此被称为显式Intent。<br/>

## 隐式Intent
隐式Intent不明确指定要启动的活动，而是指定了一系列更为抽象的action和category等信息，然后交由系统分析这个Intent，找出合适的活动启动，而所谓的合适，即能响应这个Intent的活动。<br/>
打开AndroidManifest.xml文件，其中的<activity>标签下的<intent-filter>中即可设置action和category。<br/>
我们进行如下设置：<br/>
```
	<activity android:name=".IntentActivity2">
    	<intent-filter>
        	<action android:name="com.example.intenttest.ACTION_START" />
            <category android:name="android.intent.category.DEFAULT" />
            <category android:name="com.example.intenttest.MY_CATEGORY" />
     	</intent-filter>
     </activity>
```
设置好主活动中按钮隐式Intent的点击事件：
```
	Intent intent2 = new Intent("com.example.intenttest.ACTION_START");
    intent2.addCategory("com.example.intenttest.MY_CATEGORY");//添加自定义的category
    startActivity(intent2);
```
我们使用了Intent的另一个构造函数，直接将action的字符串传了进去，表明我们要启动能响应com.example.intenttest.ACTION_START这个action的活动，那么action就指定好了，而android.intent.category.DEFAULT是一种默认的category，在调用startActivity()时会自动将其添加到Intent中。<br/>
此外，我们还可以自定义category，调用Intent中的addCategory()方法添加自定义category，并记得在AndroidManifest.xml文件的<category>标签添加进这个category。<br/>

点击隐式Intent按钮启动活动：<br/>
![主活动](/IntentTest/img/隐式.png)
<br/>

## 其它隐式Intent的用法
使用隐式Intent不仅可以启动自己程序内的活动，还可以启动其它程序的活动。例如调用手机浏览器访问百度。<br/>
设置好主活动中按钮的点击事件：

```
	Intent intent3 = new Intent(Intent.ACTION_VIEW);
    intent3.setData(Uri.parse("http://www.baidu.com"));
    startActivity(intent3);
```
点击按钮：<br/>
![主活动](/IntentTest/img/打开百度.png)
<br/>

## 使用Intent在活动间传递数据
Intent中提供了putExtra()方法的重载，我们可以将想传递的数据暂存在Intent中，然后在另一个活动中将在Intent中的数据取出来。<br/>
存入data：
```
	String data = "你好，下一个活动~";
    Intent intent4 = new Intent(MainActivity.this,IntentActivity3.class);
    intent4.putExtra("extra_data",data);//第一个参数是取值时的key值
```
取出data：
```
	Intent intent = getIntent();
    String data = intent.getStringExtra("extra_data");
```
![主活动](/IntentTest/img/下一个活动.png)
![主活动](/IntentTest/img/log.png)