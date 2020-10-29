rem stop docker-compose
docker-compose down

rem build app
cd spring-boot-prometheus
call mvn clean package -DskipTests

cd ..

rem run docker-compose
docker-compose up --build -d

