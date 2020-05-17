# Cosmetica Ecommerce-rest-api
This project was created using JAVA Spring boot for e-commerce web applications 

## Endpoints 
|    HTTP       |          Path |    Action       |          Used for      |
| ------------- | ------------- | -------------   | -------------          |
|         POST  | /autenticate  | authenticate    | login and generate JWT |
|         GET   | /saller/tag/all  | get          | get all tags         |
|         GET   | /saller/tag/{tag_id}  | get     | get tag by id |
|         POST  |/saller/add/tag  | create    | add a new tag |
|         PUT  | /saller/tag/modify  | update    | modify an existing tag |
|         DELETE  | /saller/tag/remove/{tagId}  | delete    | delete an existing tag |

**Note:** in order to access all the other routes, please visit the swagger documentation page.
```diff
+ http://localhost:8020/swagger-ui.html
```

## Deployment

Create a "cosmetica" database on your Database Designer, Run the app. and it will automatically generate all the tables and constraints.
Then Navigate to http://localhost:8020/COSMETICA/**. to access the API.

## Installation
```diff
$ git clone  https://github.com/abdeladimabid/Cosmetica.git
$ cd Cosmetica/
$ run on any IDE
```
## Schema Design
![](images/Capture.PNG)

## Usage
**Post request to Authenticate**
```diff
localhost:8020/COSMETICA/authenticate
```
Response:
```diff
{
    "jwt": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU4OTY2MzQyNCwiaWF0IjoxNTg5NjI3NDI0fQ.zbBxfG3KPOeSlr8g8sFHd2DNiqeJ3tcq_VeqroY6ukQ"
}
```
**Make a post request to create a new client**
```diff
localhost:8020/COSMETICA/signup/client/add
```
Content of Create_client.json
```diff
{
    {
        "username": "client",
        "firstname": "fname",
        "lastname": "lname",
        "email": "client@user.com",
        "password": "7df5de9f74caeb1d12c7ef33aca8aaa",
        "token": null,
        "active": false,
        "insertedAt": null,
        "updatedAt": null,
        "userRole": {
            "roleId": 2,
            "label": "user",
            "insertedAt": "2020-01-26T00:00:00.000+0000",
            "updatedAt": null
        },
        "adresse": "somewhere",
        "amountSpent": 0.0,
        "userReviews": []
    }
}
```
**Note:** Username and email must be unique. otherwise you'll get a duplicate entry Error.

**Make a put request to update an existing client**

```diff
localhost:8020/COSMETICA/client/modify
```
Content of Update_client.json
```diff
{
    {
        "userId": 1,
        "username": "client",
        "firstname": "fnameChanged",
        "lastname": "lnameChanged",
        "email": "client@user.com",
        "password": "7df5de9f74caeb1d12c7ef33aca8aaa",
        "token": null,
        "active": false,
        "insertedAt": null,
        "updatedAt": null,
        "userRole": {
            "roleId": 2,
            "label": "user",
            "insertedAt": "2020-01-26T00:00:00.000+0000",
            "updatedAt": null
        },
        "adresse": "somewhere",
        "amountSpent": 0.0,
        "userReviews": []
    }
}
```
**Make a get request to get client details**

```diff
localhost:8020/COSMETICA/user/client/id/{clientId}
```
Response:
```diff
{
    {
        "userId": 1,
        "username": "client",
        "firstname": "fnameChanged",
        "lastname": "lnameChanged",
        "email": "client@user.com",
        "password": "7df5de9f74caeb1d12c7ef33aca8aaa",
        "token": null,
        "active": false,
        "insertedAt": null,
        "updatedAt": null,
        "userRole": {
            "roleId": 2,
            "label": "user",
            "insertedAt": "2020-01-26T00:00:00.000+0000",
            "updatedAt": null
        },
        "adresse": "somewhere",
        "amountSpent": 0.0,
        "userReviews": []
    }
}
```
**Make a delete request to remove a client**

```diff
localhost:8020/COSMETICA/superadmin/client/remove/{clientId}
```

