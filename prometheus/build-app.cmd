rem ************ build-app.cmd ************
rem stop docker-compose
docker-compose -f docker-compose-app.yml down

rem build app
cd spring-boot-prometheus
call mvn clean package -DskipTests

cd ..

rem run docker-compose
docker-compose -p prometheus-app -f docker-compose-app.yml up --build -d
