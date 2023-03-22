# Crud

Path: /users
Post
Descripcion: Creación de usuario con validacion de formato de email, validación de passowrd y campos no nulleables
Create User:
```sh
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
```
Path: /users/find/{id}
Get
Descripcion: Busqueda de user por id (UUID)

Path: /users/{id}
Put
Descripcion: Endpoint para actualizar cualquier campo del Objeto User
```sh
{
    "isActive": false
}
```
