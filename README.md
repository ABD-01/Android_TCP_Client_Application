# Android_TCP_Client_Application
The app establish a TCP communication between PC and Android device.

# Start a Server (in PC/Laptop)
#### 1.Using Java Server Class
  1. Download the following Server.java file from [here](https://raw.githubusercontent.com/ABD-01/Android_TCP_Client_Application/master/Server%20Class/Server.java).
  2. Compile the file using `javac Server.java`.
  3. Run it using command line argument where second argument is *Port No.(eg. port no : 6066)* `java Server 6066`
  
  ![cmd_java](https://user-images.githubusercontent.com/63636498/90413636-5b6c5d00-e0cc-11ea-818f-dc8cc948dc01.png)

#### 2.Using NetCat
  1. Download the netcat zip file from [here](https://joncraton.org/files/nc111nt.zip).
  2. Extract the contents of the file and open that directory in terminal `cd Downloads/nc111nt`.
  3. Run the following command: `nc.exe -nlvp 6066`, (where 6066 is port no. on which server is listening). 
  
  ![cmd_nc](https://user-images.githubusercontent.com/63636498/90414724-c4a0a000-e0cd-11ea-8e65-5c8811970851.png)

# Running the Client App and Starting the Connection
1. Enter the port no. and IP Address of your pc/laptop.
![image](https://user-images.githubusercontent.com/63636498/90416331-f6b30180-e0cf-11ea-98de-f3a94fa34b63.png)
2. Click `Connect` button.

# Send Messages
1. Enter the message eg: `Hello to Server from Client`.
2. Hit 'Send'.

![image](https://user-images.githubusercontent.com/63636498/90417892-fca9e200-e0d1-11ea-92d1-ee2623cdb3df.png)

# Closing Connection
1. Send the message `Over` to Server to close the sockets.
