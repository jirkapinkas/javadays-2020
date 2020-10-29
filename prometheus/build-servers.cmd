rem ************ build-servers.cmd ************
rem stop docker-compose
docker-compose -f docker-compose-servers.yml down

rem run docker-compose
docker-compose -p prometheus-servers -f docker-compose-servers.yml up --build -d
