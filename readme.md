1.
```cd backend
docker pull roal005/backend-eureka-server:latest
docker pull roal005/backend-user-management:latest
docker pull roal005/backend-parent-service:latest
docker pull roal005/backend-children-service:latest
docker pull roal005/backend-feedback-service:latest
docker pull roal005/backend-message-service:latest
docker pull roal005/backend-gateway:latest
docker compose up
docker compose up -d
```


2. 
Run these commands to start docker application. This will ensure the application is being built and backend + frontend should run.
Cencor can access backend at localhost:8080 and frontend at localhost:3000

```docker-compose up -d --build```
```docker-compose up -d```

3. 
All the services should now be "running":

PNG

4. 
You can Login or signup when accessing the homepage. There is different accounts saved in the database that can be used, Admin and user.
Each account/user serves different purpose. 
Admin can create children, list all active parents, list all active children, see feedback and create a message to every user/parent there is.
      
Example accounts: 
•	Admin1@test.com, password: admin 
•	Parent1@test.com, password: parent1 
•	Parent2@test.com, password: parent2 

A parent can view their childrens details such as name and age, and also their images. A parent can also create a feedback to the admin.
An Admin can view all children, view all parents, create children, view messages/feedbacks from parents and create message/notifications to parents.

Application functionality: 1.	
Children server POST example data: http://localhost:8080/api/children/create  
```{ "name": "Albert", "age": "2", "parentName": "Jonas", "message": "Hello message" }” ```


2.	Parent server POST example data: http://localhost:8080/api/parents/create  
```{ "firstName": "Roar", "lastName": "Andersen", "address": "Lilleveien 2", "childrenName": "Albert", "messageFromAdmin": "Welcome to the kindergarden" } ```


3. Messages server POST example data: http://localhost:8080/api/messages  
```{ "messageToParents": "Hello everyone, this is a message to all the parents from admin" } ```

4. Feedback server POST example data: http://localhost:8080/api/feedbacks 
```{ "email": "Algun@nr10.com", "messageToAdmin": "Hello This is Algun" } ```

5. User management server POST example data: http://localhost:8080/api/users 
```{ "userName": "Roar123", "email": "roar@gmail.com", "password": "password123", "role": "PARENT" }”```
Or Admin
```{ "userName": "admin123", "email": "admintest@gmail.com", "password": "password321", "role": "ADMIN" }```

When logged in as admin you have a navigation bar containing a list to choose from. Each optionin the list is a service. 
For instance, there is List Children that uses the children-service microservice to getAllChildren and return list for admin to see:

this is the path to nav bar as admin: http://localhost:3000/screen/navigation-bar
it can also be accesed logging in with one of the admin users.



there is also a createChildren option for Admin, It can use that to create a children by sending POST data to http://localhost:8080/api/children/create. 
Here can the Admin create new children for the kindergarden. can also use postman as backend is working better than frontend:


PNG




Furthermore, there is also a section where admin can create a message for all the parents to see, simply fill out the form and submit:
in this case use postman to submit to http://localhost:8080/api/messages  wit this data:
```{ "messageToParents": "Hello everyone, this is a message to all the parents from admin" } ```


Lastly you can view feedbacks messages sent from parents:



PNG

when hit this endpoint as get method http://localhost:8080/api/feedbacks, you will get messages from RMQ queue, sendt by  message server.

PNG RMQ




When accessing http://localhost:5050 you get to postgres where database is located. Here you can create a server:
PNG CREATE SERVER



Diagram:











