Je zapotřebí mít nainstalované:

- Docker
- Maven

Spuštění:

build.cmd

NEBO:

cd spring-boot-prometheus
mvn clean package
cd ..
docker-compose up --build -d

Vypnutí:

docker-compose down