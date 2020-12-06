@REM https://www.tutorialspoint.com/batch_script/batch_script_quick_guide.htm
@echo off

@REM echo starting database docker container:
@REM docker start postgres-main

echo =============================================================================
echo RESTING DATABASE
echo =============================================================================
docker cp .\database\reset_db.sql postgres-main:/reset_db.sql
docker exec -it postgres-main psql -f reset_db.sql -U postgres

echo =============================================================================
echo CREATING TABLES
echo =============================================================================
docker cp .\database\create_tables.sql postgres-main:/create_tables.sql
docker exec -it postgres-main psql -d exercise_dev -f create_tables.sql -U postgres

echo =============================================================================
echo INSERTING DATA
echo =============================================================================
docker cp .\database\insert_data.sql postgres-main:/insert_data.sql
docker exec -it postgres-main psql -d exercise_dev -f insert_data.sql -U postgres
