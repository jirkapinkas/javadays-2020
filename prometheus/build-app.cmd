rem ************ build-app.cmd ************

docker rm -v -f app

rem build app
cd spring-boot-prometheus
call mvn clean package

cd ..

rem run docker-compose
docker-compose -p prometheus-app -f docker-compose-app.yml up --build -d
