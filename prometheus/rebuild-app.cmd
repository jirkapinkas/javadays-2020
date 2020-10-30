rem ************ rebuild-app.cmd ************

call docker rm -v -f app

rem build app
cd spring-boot-prometheus
call mvn clean package

cd ..

rem run docker-compose
call docker-compose -p prometheus-app -f docker-compose-app.yml up --build -d
