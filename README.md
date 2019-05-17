#Hierarchical mapping

Small project that mainly reflects on implementing hierarchical mapping structure. 
Structure contains vehicle super class and two sub classes of bikes and cars. 
You are able to add new bikes, cars and afterwards retrieve table content trough 
vehicle repository all together or sort them out. Also there is a simple UI to
execute all the requests. Run in terminal `npm start` at frontend directory.

To start application locally, use docker and enter command in terminal docker 
` docker run -p 5432:5432 -e POSTGRES_USER=nils -e POSTGRES_PASSWORD=nils -e POSTGRES_DB=hierarchical_mapping postgres
`

##Vehicle API

**Add Bike**
*Request:*

```POST http://localhost:8080/api/bike```

Status code: ```200 OK```

Request body:
```json
{
  "name": "bike1",
  "password": "black"
}
```

**Add Car**
*Request:*

```POST http://localhost:8080/api/car```

Status code: ```200 OK```

Request body:
```json
{
  "name": "bike1",
  "year": 1998
}
```

**Fetch Vehicles**
*Request:*

```GET http://localhost:8080/api/vehicles```

Where query parameters are:

  - *type* - vehicle type

Response body:
```json
[
    {
        "id": 1,
        "vehicleType": "BIKE",
        "name": "bike"
    }
]
```



