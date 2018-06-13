# NotificationCompatTutorial


This is an example program made primarily to highlight the basic aspects of NotificationCompat for Android development. 

Steps to Use: 
1) Run program through emulator on Android. 
2) Click "TOGGLE NOTIFICATION" to receive default notification. Clicking on said notification will lead you to a blank test Activity. 
3) If you did click into said notification in previous step (2), Click on the "JUST KIDDING" button to return back to the main Activity. 
   Click on "TOGGLE NOTIFICATION (HEADS UP) to receive highest priority notification (popup). Clicking on said notification will lead you    to a blank test Activity.
4) If you clicked on "TOGGLE NOTIFICATION (HEADS UP)" notification, you will see the notification message replace the title in the            notification popup. Click on the message to reach the blank test Activity (click on "JUST KIDDING 2" to go back to the main screen). 


Steps to Replicate: 
1) Open Android Studio. Start a new project. You can use any Activity as your starting MainActivity. In this tutorial I went with a generic Blank Activity. 

2) Create 2 new Activities that the notifications will redirect to. You can do this by navigating to the ```java``` folder. Right click on the parent folder of your ```MainActivity``` and  select ```New``` -> ```Activity``` -> ```Gallery...```. Again, I went with the Blank Activity template but any type of Activity will work.

3) For ease of testing, I created Buttons on my 2 Activities that redirected me back to the Main Activity. You can do this by simply:     

   a) Declaring the buttons (in both of the 2 Activities)
      ```java
      private Button returnToMain;
      ```
   b) Creating the button in the corresponding Activity XML file (under ```res``` -> ```layout```)
   c) Defining the buttons with their respective ID (found in the same Activity XML file) in your ```onCreate``` method
   
      ```java
      returnToMain = findViewById(R.id.<buttonID>);
      ```
      
   d) Declare an ```Intent``` to redirect back to ```MainActivity```
   
      ```java
      Intent intent = new Intent(<redirectedActivity>.this, MainActivity.class);
      ```
      
   e) Set the ```onClick``` listeners for these buttons to redirect back to your ```MainActivity```
   
      ```java
      returnToMain.setOnClickListener(new View.OnClickListener(){
         @Override
         public void onClick(View v) {
             startActivity(intent);
         }
      });
      ```
      
 4) Back in your MainActivity, set 2 Buttons to trigger your notifications as well as 2 Intents to go from MainActivity to your             redirected Activities (follow step (3) to create Buttons and set up Intents).These will be used to trigger both your default and         priority notifications respectively. I will refer to these Buttons as ```toggle``` and ```toggleHeadsUp``` for the default and           priority notifications respectively. 
 
 5) Now it's time to declare your NotificationCompat Elements.
 
    a) <i>Start by declaring the notification manager.</i>
 
    <b>**If at any point you see any red-colored text, hover over it and press Alt + Enter and select "Import class"</b>
 
    ```java
    final NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
    ```
    b) <i>Declare the 2 notifications (default and priority) after.</i>
    
    ```java
    final NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
    final NotificationCompat.Builder mBuilder2 = new NotificationCompat.Builder(this);
    ``` 
    
    c) <i>Set Attributes of the declared notifications. This step is up to mainly up to preference and highlights multiple aspects of             the notification such as Title, content Text, icons, intent to perform on click, as well as priority level. The two primary             focuses will be ``setContentIntent``, which sets the intent to be performed on clicking the activity as well as                         ``setPriority``,        which handles the priority level of the notification.</i>
    
        
       ```java
       //Settings for default notification
        mBuilder
                .setSmallIcon(R.drawable.ic_action_name)
                .setLargeIcon(BitmapFactory.decodeResource(this.getResources(),
                        R.drawable.skull))
                .setContentTitle("EMERGENCY: MISSILE INBOUND")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Our sensors have detected an incoming missile. Seek shelter immediately. This is NOT  a drill."))
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        //Settings for popup notification
        mBuilder2
                .setSmallIcon(R.drawable.ic_action_name)
                .setLargeIcon(BitmapFactory.decodeResource(this.getResources(),
                        R.drawable.skull))
                .setContentTitle("EMERGENCY: MISSILE INBOUND")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Our sensors have detected an incoming missile. Seek shelter immediately. This is NOT  a drill."))
                .setContentIntent(pendingIntent2)
                .setDefaults(Notification.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_MAX);
        
        
  6) Set toggle buttons to push notifications onClick
      
     <i>Using the notification manager, you can push individual notifications whenever an event is fired, such as the click of a              button</i>
     
     ```java
        //OnclickListener for default notification handling button
        toggle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){


                notificationManager.notify(1, mBuilder.build());
            }
        });

        //OnClickListener for popup notification handling button
        toggleHeadsUp.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                notificationManager.notify(1, mBuilder2.build());
            }
        });
     ```
     
  7) You're all done! You can additionally customize your notification by adding custom icons! Small icons will appear in the taskbar as      well as the very left-top corner of the notification bar, and Large icons will appear on right side.
  
     <i>Import new images by right clicking on ```res``` subfolder and selecting ```New``` -> ```Image Asset```. Change ```Icon Type:``` to ```Action Bar and Tab Icons``` and set preferred name. Change ```Asset Type:``` to "Image" and enter the path to your image on your local machine. Progress through the rest of the helper to finish.</i>
  

     <i>To import the image as an icon, declare it in your notification settings with your image name (under ```Drawable```). </i>
      
     <b>For Small Icons:</b>
     
     ```java
        .setSmallIcon(R.drawable.<image name>)
     ```
     
     <b>For Large Icons:</b>
     
     ```java
        .setLargeIcon(BitmapFactory.decodeResource(this.getResources(),
                        <image name>))
     ```

![stack Overflow](https://images.pexels.com/photos/104827/cat-pet-animal-domestic-104827.jpeg)
