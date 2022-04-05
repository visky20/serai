# serai
Serai Assignment 

**Rest API's** 

Below APIs are available in **Serai.postman_collection.json** with sample data set, please import in postman for working 

**"/"**:
Required Any Role
This API give welcome message

**"/createUser"** :
Required ADMIN Role,
This API is used to create user , by default user will have only USER Role

**"/findByUser?userName=<userName>"** : 
Required ADMIN Role,
This API is used to fetch user and user order details

**"/getUsers"** :
Required ADMIN Role,
This API will fetch all user 

**"/getOrder?userName=<userName>"** :
Required ADMIN/USER Role,
This API is to fetch order details by userName

**"/findAllOrders"** :
Required ADMIN Role,
This API is used to fetch all users and user's order details

**"/placeOrder"** :
Required ADMIN/USER Role
This API is used to place a order for an user along with user creation.


**data.sql** under resource folder creates default admin user with role ADMIN
