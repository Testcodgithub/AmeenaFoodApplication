# 🍔 Food Delivery Application
A Java-based web application that allows users to explore restaurants, order food online, and manage their orders.

# ✨ Features
-  [✔️ User Authentication: Sign-up, sign-in, and sign-out functionality.][#✔️ User Authentication: Sign-up, sign-in, and sign-out functionality.]
[✔️ Home Page: Displays a list of different restaurants.][#]
[✔️ Menu Page: View food items of a selected restaurant.]
[✔️ Add to Cart: Users can add items to their cart.]
[✔️ Checkout & Order Confirmation: Proceed to checkout and confirm the order.]
[✔️ Order History: Users can view past orders with all details.]
[✔️ Profile Management: Users can edit their profile information.]
# ✨ Screenshots
image
![image](https://github.com/user-attachments/assets/2d2d5cec-dae6-43cc-9fa2-1521ec812d9b)
![image](https://github.com/user-attachments/assets/e5bbce3b-5377-4d9e-ac75-c2592a2f3ec8)
![image](https://github.com/user-attachments/assets/7d406c13-aa3b-434d-8968-3c5f29a3052e)

image

# 🔧 Technologies Used
Frontend: JSP, CSS
Backend: Java (Servlets, JDBC)
Database: MySQL
Server: Apache Tomcat
📝 Project Structure
FoodDeliveryApplication/
├── src/main/java/
│   ├── com.tap.model/           # Model classes (User, Order, Restaurant, etc.)
│   ├── com.tap.dao/             # DAO interfaces
│   ├── com.tap.daoImplementation/  # DAO implementation classes
│   ├── com.tap.utility/         # Database connection utility
│   ├── com.tap.servlets/        # Servlets handling requests
│
├── webapp/
│   ├── assets/                  # Images, animation video, sound files
│   ├── jspFiles/                # All JSP pages
│   ├── styles/                  # CSS files
│   ├── WEB-INF/
│   │   ├── lib/                 # MySQL Connector JAR
│   │   ├── web.xml              # Deployment descriptor
⚡ How to Run the Project
Follow these steps to set up and run the project on your system:

# 🛠 Prerequisites
Install Java JDK (11 or higher)
Install Apache Tomcat (9 or higher)
Install MySQL Server
Install Eclipse IDE (or any other IDE that supports Java Web Development)
Add MySQL Connector JAR to the lib/ folder
## 📝 Step 1: Clone the Repository
git clone https://github.com/Testcodgithub/AmeenaFoodApplication
## 🔧 Step 2: Set Up the MySQL Database
Open MySQL Workbench or any MySQL client.
Create a new database:
CREATE DATABASE FoodDeliveryDB;
Switch to the new database:
create database ameena_food;;
Create the required tables:
use ameena_food;
Create table `user`(
userId int auto_increment primary Key,
username varchar(45),
email varchar(45)  unique,
phonenumber varchar(45),
`password` varchar(45),
address varchar(45),
createddate datetime default CURRENT_TIMESTAMP,
lastlogin datetime default CURRENT_TIMESTAMP
);
Create table restauranttable(
restaurantId int auto_increment primary key,
restaurantName varchar(45),
deliveryTime varchar(40),
cuisineType varchar(45),
address varchar(450),
rating float,
isActive varchar(10),
adminId int,
imagePath varchar(500),
foreign key (adminId) references `user` (userId)
);

Create table menu(
menuId int auto_increment primary key,
restaurantId int,
menuName varchar(45),
price float,
description varchar(800),
isAvailable varchar(5),
imagePath varchar(45),
foreign key (restaurantId) references `restauranttable`(restaurantId)
);
Create table ordertable(
orderId int auto_increment primary Key,
restaurantId int,
userId int,
orderDate datetime,
totalAmount float,
status varchar(45),
paymentMode varchar(45),
foreign key (restaurantId) references `restauranttable`(restaurantId)
);
Create table orderiteam(
orderIteamId int auto_increment primary key,
orderId int,
menuId int,
quantity int,
subTatal float,
foreign key (menuId) references `menu`(menuId)
);
Create table orderhistory(
orderHistoryId int auto_increment primary key,
orderId int,
userId int,
orderDate datetime,
totalAmount float,
status varchar(45),
foreign key (orderId) references `ordertable`(orderId),
foreign key (userId) references  `user`(userId)
);
## 🛠 Step 3: Import the Project in Eclipse
Open Eclipse IDE.
Click File → Import → Existing Projects into Workspace.
Select the FoodDeliveryApplication folder.
Click Finish.
## 🌐 Step 4: Configure Tomcat Server
In Eclipse, go to Window → Show View → Servers.
Right-click and Add New Server → Select Apache Tomcat.
Set the Tomcat installation directory.
Click Finish.
## 🚀 Step 5: Run the Application
Right-click the project → Run As → Run on Server.
Choose Apache Tomcat and click Finish.
Open your browser and visit:
http://localhost:8080/AmeenaFoods/
## 💡 Additional Notes
Make sure MySQL is running before launching the project.
Update DatabaseConnection.java in com.tap.utility with your MySQL credentials:
String url = "jdbc:mysql://localhost:3306/ameena_food";
String user = "root";
String password = "your_password";
If you face any errors, check the Tomcat logs in Eclipse.
## 💼 Contributing
Pull requests are welcome! If you find any issues, feel free to open an issue.

## 💌 Contact
For any queries, reach out at mirjaameena@gmail.com.
