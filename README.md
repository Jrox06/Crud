# Crud

Path: /users
Post
Create User:
{
    "name": "Juan Rodriguez",
    "email": "juan@rodrigue.org",
    "password": "Hunter87",
    "phones": [
        {
            "number": "1234567",
            "citycode": "1",
            "contrycode": "57"
        },
        {
            "number": "12347",
            "citycode": "2",
            "contrycode": "58"
        }
    ]
}

Path: /users/find/{id}
Get

Path: /users/{id}
Put
{
    "isActive": false
}
