# [Notes](https://hackmd.io/@Q4x1OboORY-yKLhWsxCdQg/SylcS64Xv)

App Development
===

## Table of Contents
* [App Development](#App-Development)
  * [Table of Contents](#Table-of-Contents)
  * [1.Intents (Explicit)](#1-intents-explicit "Goto Intents")
  * [2.Handler](#2-Handler "Goto Handler")
  * [3.AsynTask](#3-AsynTask "Goto AsynTask")
  * [4.TCP Communication](#4-TCP-Communication "Goto TCP Communication")
  * [5.Others](#5-others "Goto Others")

## 1. Intents (Explicit)
Link: [Javapoint Android Explicit Intents](https://www.javatpoint.com/android-explicit-intent-example)

* Simple Intent
```js
Intent i = new Intent(getApplicationContext(), ActivityTwo.class);  
startActivity(i);  
```
* Adding Extras to intent
    *Code in Main Activity*
```js
public void callSecondActivity(View view){  
    Intent i = new Intent(getApplicationContext(), SecondActivity.class);  
    i.putExtra("Value1", "Android By Javatpoint");  
    i.putExtra("Value2", "Simple Tutorial");   
    startActivity(i);  
}   
```

*Code in Second Activity*
```js
@Override  
protected void onCreate(Bundle savedInstanceState) {  
    super.onCreate(savedInstanceState);  
    setContentView(R.layout.activity_second);  
    Intent intent = getIntent();  
    String value1 = intent.getStringExtra("Value1");  
    String value2 = intent.getStringExtra("Value2");  
    Toast.makeText(getApplicationContext(),"Values are:\n First value: "+value1+  
            "\n Second Value: "+value2, Toast.LENGTH_LONG).show();  
}  
```
* Intent Activity for result


*There are two variants of startActivityForResult() method.*
```js
public void startActivityForResult (Intent intent, int requestCode)  
public void startActivityForResult (Intent intent, int requestCode, Bundle options)  
```

 *Code in Main Activity*
```js
@Override  
protected void onCreate(Bundle savedInstanceState) {  
    super.onCreate(savedInstanceState);  
    setContentView(R.layout.activity_main);  
    textView1=(TextView)findViewById(R.id.textView1);  
    button1=(Button)findViewById(R.id.button1);  
    button1.setOnClickListener(new OnClickListener() {  
        @Override  
        public void onClick(View arg0) {  
            Intent intent=new Intent(MainActivity.this,SecondActivity.class);  
            startActivityForResult(intent, 2);// Activity is started with requestCode 2  
        }  
    });  
}  
// Call Back method  to get the Message form other Activity  
@Override  
   protected void onActivityResult(int requestCode, int resultCode, Intent data)  
   {  
             super.onActivityResult(requestCode, resultCode, data);  
              // check if the request code is same as what is passed  here it is 2  
               if(requestCode==2)  
                     {  
                        String message=data.getStringExtra("MESSAGE");   
                        textView1.setText(message);  
                     }  
 }  
```

*Code in Second Activity*
```js
@Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_second);  
        editText1=(EditText)findViewById(R.id.editText1);  
            button1=(Button)findViewById(R.id.button1);  
            button1.setOnClickListener(new OnClickListener() {  
                @Override  
                public void onClick(View arg0) {  
                    String message=editText1.getText().toString();  
                    Intent intent=new Intent();  
                    intent.putExtra("MESSAGE",message);  
                    setResult(2,intent);  
                    finish();//finishing activity  
                }  
            });  
    }  
```

## 2. Handler
Link: [Android Developer Handler Class](https://developer.android.com/reference/android/os/Handler)
There are two main uses for a Handler: (1) to schedule messages and runnables to be executed at some point in the future; and (2) to enqueue an action to be performed on a different thread than your own.


* `postDelayed(Runnable r, long delayMillis)`

    Causes the Runnable r to be added to the message queue, to be run after the specified amount of time elapses.

## 3. AsynTask
Link: [Android Developer AsyncTask Class](https://developer.android.com/reference/android/os/AsyncTask)
Link: [Stackoverflow AsyncTask Example](https://stackoverflow.com/questions/9671546/asynctask-android-example)
Android AsyncTask going to do background operation on background thread and update on main thread.

## 4. TCP Communication
Link: [Tutorialspoint sending and recieving using Sockets in Android](https://www.tutorialspoint.com/sending-and-receiving-data-with-sockets-in-android)

## 5. Others
* #### Making TextView Scrollable
    ```xml
    <TextView
    android:scrollbars=”vertical” />
    ```
    ```js
    textView.setMovementMethod(newScrollingMovementMethod());
    ```
    
###### tags: `App Development` `Notes` `Documentation`  `Templates` 

---
[Back to Top](#Notes)
