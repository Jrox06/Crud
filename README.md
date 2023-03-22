# Crud

Path: /users<br>
Post<br>
Descripcion: Creación de usuario con validacion de formato de email, validación de passowrd y campos no nulleables<br>
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
Path: /users/find/{id}<br>
Get<br>
Descripcion: Busqueda de user por id (UUID)<br>

Path: /users/{id}<br>
Put<br>
Descripcion: Endpoint para actualizar cualquier campo del Objeto User<br>
```sh
{
    "isActive": false
}
```
