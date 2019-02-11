# peAk

```
Code Fellows; seattle-java-401d2
Project manager: Jason Burns
Android frontend contributors: Pablo Rosales, Kevin Rosales, Darrin Howell, Nick Crain
Python backend contributors: Fangyuan Huang, Scott Currie, Roger Huba
```

### Target Demographic:
Snowboarders and skiers who want to consolidate their trip planning and intra group communication to one place.

### Overview:
peAK is an Android application developed to facilitate snowboard  / ski meetups at alpine resorts on 
the West Coast of the United States. Within peAk, users can browse through a small collection of 
resorts served by our custom python API. Within each resort page, app users can also browse meetups 
posted to that specific resort. Trip details can be viewed after clicking on meetups stored in the 
recycler view of each resort detail page. peAk users can also establish their own meetups by filling 
out a form and creating a new meetup at a specific resort. <br/>

To date, our team was only able to develop the aforementioned features. In subsequent iterations of 
our project, we envision users having the essential capabilities to 1) signup and login, 2) to post 
new meetups to any resort stored in our database (currently, we have only established the logic to 
post meetups to Badger Mountain via form submission), 3) to join groups created by other app users, 
4) to post messages to a group message board to coordinate trip logistics, and 5) to view one's 
collection of future trips in our app's "My Groups" page. 

### Libraries and Dependencies:
##### Android Dependencies
* implementation fileTree(dir: 'libs', include: \['*.jar'])
* implementation 'androidx.lifecycle:lifecycle-extensions:2.0.0-beta01'
* implementation 'androidx.appcompat:appcompat:1.1.0-alpha01'
* implementation 'androidx.constraintlayout:constraintlayout:1.1.3'
* implementation 'androidx.legacy:legacy-support-v4:1.0.0'
* implementation 'com.google.android.material:material:1.1.0-alpha03'
* implementation 'androidx.recyclerview:recyclerview:1.0.0'
* implementation 'com.google.android.gms:play-services-maps:16.0.0'
* implementation 'com.squareup.okhttp3:okhttp:3.12.1'
* implementation 'com.google.code.gson:gson:2.8.5'
* testImplementation 'junit:junit:4.12'
* androidTestImplementation 'androidx.test:<zero-width space>runner:1.1.2-alpha01'
* androidTestImplementation 'androidx.test.espresso:espresso-core:3.1.2-alpha01'
* androidTestImplementation 'androidx.test.espresso:espresso-contrib:3.1.2-alpha01'
* androidTestImplementation 'androidx.test:core:1.1.0'
* androidTestImplementation 'androidx.test:rules:1.1.1'
* androidTestImplementation 'androidx.test.espresso:espresso-intents:3.1.1'
* implementation 'com.squareup.okhttp3:okhttp:3.12.1'
* implementation 'com.google.code.gson:gson:2.8.5'

##### Python backend technologies
* \>= Python 3.6
* Django
* PostgreSQL

### Instructions for Setting Up Build Environment: 
* (Details pending)

### Screenshots

##### Resort Detail Activity

![home view](./assets/peakScreenshot_ResortDetail.png)

##### Nav Drawer Opened

![home view with nav drawer opened](./assets/peakScreenshot_NavDrawerOpened.png)

##### User Profile Activity

![user profile activity](./assets/peakScreenshot_ProfileActivity.png)

##### My Groups Activity

![my groups activity](./assets/peakScreenshot_MyGroupsActivity.png)

##### Resort Activity with Resorts Drawer Opened

![home view with resorts drawer opened](./assets/peakScreenshot_ResortsDrawerOpen.png)

##### Create Group Activity

![create group activity](./assets/peakScreenshot_CreateGroupFormFilledOut.png)

##### New Group Added, Resort Detail Activity

![home view with new group added](./assets/peakScreenshot_ResortDetailWithGroupAdded.png)

##### Group Detail Activity

![group detail activity](./assets/peakScreenshot_GroupDetail.png)

### Attributions: 
* Background image for screenshot pics: macOs Mojave version 10.14.2 "El Capitan 2"
* Default profile picture image: Photo by Viktor Vasicsek on Unsplash
