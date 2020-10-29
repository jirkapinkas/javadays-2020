rem ************ build-servers.cmd ************

docker-compose -p prometheus-servers -f docker-compose-servers.yml up --build -d
