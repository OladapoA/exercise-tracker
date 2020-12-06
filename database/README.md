# Database Setup

## View ER diagram
To view the ER diagram, open it in draw.io

## Docker Postgres Setup
Create a postgres docker instance:
https://hub.docker.com/_/postgres
```
docker run --name postgres-main -e POSTGRES_PASSWORD=test -p 5432:5432 -d postgres
```

connect to docker instance:
```
docker exec -it postgres-main psql -U postgres
```

create the database exercise dev:
```
CREATE DATABASE exercise_dev;
```

check it was created
```
\l
```

## Application Database Setup
For these steps, you must navigate to the directory of the sql scripts.

Create and set-up the tables:
```
docker cp create_tables.sql postgres-main:/create_tables.sql
docker exec -it postgres-main psql -d exercise_dev -f create_tables.sql -U postgres
```

Create and set-up the data:
```
docker cp insert_data.sql postgres-main:/insert_data.sql
docker exec -it postgres-main psql -d exercise_dev -f insert_data.sql -U postgres
```