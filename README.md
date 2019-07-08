# Getting Started

## Building

```
mvn clean package
```

## Running

```
mvn spring-boot:run
```
Once the project has started, open your browser and point to `http://localhost:8080/` to check.
It should show this json response:

```
{
    "data": "ok"
}
```

Once that works, try pointing your browser to `http://localhost:8080/animals`. 
This time, it should return a list of animals. This performs an insert to the database,
then retrieving it to display.