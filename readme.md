# Todo App

A simple todo app with history tracking. To start the app, run the following command:

```bash
docker-compose up -d
```

## Create a new todo

```bash
curl -X POST http://localhost:8080/todos \
     -d '{
           "title": "Buy milk",
           "description": "Buy milk at the store"
         }' \
     -H 'Content-Type: application/json'
```

## Update a todo

```bash
curl -X PUT http://localhost:8080/todos/1 \
     -d '{
           "title": "UPD Buy milk",
           "description": "Buy milk at the store",
           "done": true
         }' \
     -H 'Content-Type: application/json'
```

## Get history of a todo with id 1

```bash
curl http://localhost:8080/todos/1/history
```