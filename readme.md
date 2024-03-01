1. Run all these commands to start the project, build and run (Cencor might need to clean and install maven for all the microservice packages: Maven -> "The service" -> Lifecycle -> Clean and Install)
  
![maven](https://github.com/RojhatAlg/microexam2024/assets/115071835/374ee5ef-fadc-4210-a10f-a1d337d51ec4)

```
cd backend
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

Cencor can access backend at localhost:8080 and frontend at localhost:3000


2. 
All the services should now be "running":

![allServicesRunning](https://github.com/RojhatAlg/microexam2024/assets/115071835/6e5cc82f-40e2-463d-a4d9-2563fafc0ec0)


3. 
You can Login or signup when accessing the homepage. There is different accounts saved in the database that can be used, Admin and user.
Each account/user serves different purpose. 
Admin can create children, list all active parents, list all active children, see feedback and create a message to every user/parent there is.
      
Example accounts: 
•	admin1@example.com, password: admin1password 


A parent can view their childrens details such as name and age, and also their images. A parent can also create a feedback to the admin.
An Admin can view all children, view all parents, create children, view messages/feedbacks from parents and create message/notifications to parents.

Application functionality: 

1.	
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

![createChildren](https://github.com/RojhatAlg/microexam2024/assets/115071835/32079413-0f1f-413f-940b-5b0bfafba51a)


Furthermore, there is also a section where admin can create a message for all the parents to see, simply fill out the form and submit:
in this case use postman to submit to http://localhost:8080/api/messages  wit this data:
```{ "messageToParents": "Hello everyone, this is a message to all the parents from admin" } ```


Lastly you can view feedbacks messages sent from parents:

![postFeedback](https://github.com/RojhatAlg/microexam2024/assets/115071835/cb048531-0ff2-4979-aa65-571c57d8050b)

![getFeedbacks](https://github.com/RojhatAlg/microexam2024/assets/115071835/69b2e268-a516-4531-b3a0-0e9fd41e35d6)


when hit this endpoint as get method http://localhost:8080/api/feedbacks, you will get messages from RMQ queue, sendt by  message server.

Go to queue and streams section

![rabbitmq](https://github.com/RojhatAlg/microexam2024/assets/115071835/59115042-65f3-4a8d-8155-0ea4cd09ab1b)

Here is the message in RabbitMQ:

![rabbitmq2](https://github.com/RojhatAlg/microexam2024/assets/115071835/347144c7-d01c-4c59-b4cb-45f01d2eb07d)

To access RabbitMQ to see this, go to: http://localhost:15672 and use "guest" as the name and password to log in.

-------------------------------------------------------------------------------------------------------------------

When accessing http://localhost:5050 you get to postgres where database is located. 
You log in with password: ```password```

![Capture](https://github.com/RojhatAlg/microexam2024/assets/115071835/018e97af-ea70-4c37-b22e-11b9fb2b3b32)


Here you can create a server:

![createServer](https://github.com/RojhatAlg/microexam2024/assets/115071835/152ce277-0673-42af-950b-0cbd5f4cb956)

And then name the server:

![write connection name](https://github.com/RojhatAlg/microexam2024/assets/115071835/7ccf05e0-008d-4cf7-b8a5-005bcd6a6a03)

Then create connection:
remember to have host name/address to ```postgres``` and the name to ```root``` and password to ```password```

![registerconnection](https://github.com/RojhatAlg/microexam2024/assets/115071835/2dd8d757-5b92-45dd-a727-14ddfb5422c1)

Then you can access all the databases and the tables: for example we can see the users table and use query tool to access data:
```SELECT * FROM users```


![selectTableThenQueryTool](https://github.com/RojhatAlg/microexam2024/assets/115071835/8af4123b-dfc6-4069-8448-fbcb0a67ee77)

![selectUsersPostgres](https://github.com/RojhatAlg/microexam2024/assets/115071835/7126a5ec-89b1-4d54-9dc3-f36710946596)

In this connection: http://localhost:8761 you get to the Eureka server. Here you can see all the API's listed to the server

![eurekaAPI](https://github.com/RojhatAlg/microexam2024/assets/115071835/25795b7e-27ce-4ab5-82db-d8932df8ae5a)

All the API routing have been defined in "gateway" service. see application.yml in gateway service in src/main/resources

DOCKER IMAGES:

![dockerimages1](https://github.com/RojhatAlg/microexam2024/assets/115071835/fce8b4a9-1e8f-49fc-b38a-bc2535515dd0)

![dockerimage2](https://github.com/RojhatAlg/microexam2024/assets/115071835/7bf4a5bc-c62d-4b87-a5b3-40ac89b7a9b2)

DOCKER REPO:

![dockerRepo](https://github.com/RojhatAlg/microexam2024/assets/115071835/afcdec2b-962a-46ec-8a7a-1404818c50ac)


Diagram:


![diagram_microserviceeksamen](https://github.com/RojhatAlg/microexam2024/assets/115071835/cd6f7b73-29bc-4fbb-8645-a44c2efdb6b3)









