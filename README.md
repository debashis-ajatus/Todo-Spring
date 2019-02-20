# ToDo-spring


This is a simple Todo App built on Springboot framwork

**FindAll ToDos**
URL: localhost:8080
Response:
[
    {
        "id": 3,
        "category": "done",
        "name": "Debashis",
        "complete": false
    },
    {
        "id": 7,
        "category": "Done",
        "name": "Debashis Swain",
        "complete": false
    },
    {
        "id": 29,
        "category": "Done",
        "name": "DebuDemo",
        "complete": false
    },
    {
        "id": 30,
        "category": "Done",
        "name": "Car Wash",
        "complete": false
    }
]


**Add Todo**

URL: http://localhost:8080/addTodo
Request:
  {
	"category":"Done",
	"name":"Car wash"
  }
Response:
  {
    "id": 31,
    "category": "Done",
    "name": "Car wash",
    "complete": false
  }


**Delete Todo**
URL: http://localhost:8080/deleteTodo?todoid=20
Response:
  false
  
  **Update Todo**
URL: http://localhost:8080/updateTodo
Request:
  {
	"category":"Done",
	"name":"Car Servicing",
	"id":7,
	"complete":0
  }
Response:
  {
    "id": 7,
    "category": "Done",
    "name": "Car Servicing",
    "complete": false
  }
# Todo-Spring
