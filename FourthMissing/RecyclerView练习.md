# RecyclerView练习
RecyclerView是一个强大的滚动控件，算是一个增强版的ListView。本次实验将使用RecyclerView来显示各种水果的图片和名字。

## 图片
将准备好的水果图片放入项目的main/res/drawable-xhdip中。

## 布局
自定义一个布局，放入ImageView和TextView用来显示图片和文字。在layout目录中创建了fruit_item.xml:
```
	<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_margin="5dp">

    <ImageView
        android:id="@+id/fruit_image"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center_horizontal"/>

    <TextView
        android:id="@+id/fruit_name"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="left"
        android:layout_marginTop="10dp"/>

</LinearLayout>
```
在布局中添加RecyclerView，让它充满整个界面，之后再把自定义的布局放入。
在活动的onCreate方法中，启动瀑布流布局，将水果呈3列显示。
```
	 RecyclerView recyclerView = (RecyclerView) 
		findViewById(R.id.recycler_view);
     StaggeredGridLayoutManager layoutManager = new
     	StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
     recyclerView.setLayoutManager(layoutManager);
```
显示效果：
<br/>
![main](/FourthMissing/img/main.png)

## RecyclerView的点击事件
在适配器的onCreateViewHolder方法中，注册图片和文字的点击事件。
```
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fruit_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.fruitView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(v.getContext(),"你点击了" + fruit.getName() + "的文字",
                        Toast.LENGTH_SHORT).show();
            }
        });
        holder.fruitImage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(v.getContext(),"你点击了" + fruit.getName() + "的图片",
                        Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }
```
使用了toast方式显示信息：
<br/>
![image](/FourthMissing/img/image.png)
![text](/FourthMissing/img/text.png)

## 小结
相对于ListView，RecyclerView要强大，能实现瀑布布局，能比较简单地实现每个子项中的内容的点击事件。未来将有更多的程序从ListView转换成RecyclerView。