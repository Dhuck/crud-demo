# CRUD Sample - SpringBoot + Spring Data Repositories

This sample demonstrates SpringBoot + Spring Data Repositories integration.

## User Service.
Contains general user input/output logic and validations.

Method	| Path	| Description	
------------- | ------------------------- | ------------- |
GET	| /user/all	| Get all users	|
PUT	| /user/create	| User creation |
PUT	| /user/{userId}	| User update	|
DELETE	| /user/{userId}	| User delete	|

## Build.

### Prerequisites.
* Apache Maven 3.x.
* Oracle JDK 8/OpenJDK 8.

### Packaging project.
* Retrieve available profiles: `mvn help:all-profiles`
* Build with default profile: `mvn clean package -Plocal`
* Build the project to test Docker inside: `mvn clean package -Ptest`

## Run.

### Prerequisites.
#### *local* profile (localhost).
* MySQL >5.x Installed and configured.

#### *test* profile (Docker)
* Docker and Docker compose installed and configured.

### Running on localhost.
* `java -Xmx200m -jar /target/crud-api.jar`

### Running on Docker.
* `docker-compose build`
* `docker-compose up`

## Testing using CURL tool.
* User list.
```
curl -H "Content-Type: application/json" -X GET http://{IP}:8090/user/all

# Response:
{
    "users": [
        {
            "id": 1,
            "name": "John Lennon",
            "email": "jlennon@applemusic.com"
        }
    ]
}
```

* User creation.
```
curl -d '{ "id" : 1, "name" : "John Doe", "email": "johndoe@domain.com" }' -H "Content-Type: application/json" -X POST http://{IP}:8090/user/create
```

* User update.
```
curl -d '{ "id" : 1, "name" : "John Doe", "email": "jdoe@domain.com" }' -H "Content-Type: application/json" -X PUT http://{IP}:8090/user/{user-id}

# Response
{
    "user": {
        "id": 1,
        "name": "John Doe",
        "email": "jdoe@domain.com"
    }
}
```

* User delete.
```
curl -H "Content-Type: application/json" -X DELETE http://{IP}:8090/user/{user-id}
```
