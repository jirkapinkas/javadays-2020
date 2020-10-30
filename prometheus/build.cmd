call docker rm -v -f app prometheus grafana
call docker network rm app_net
call docker-compose -p prometheus-servers -f docker-compose-servers.yml up --build -d
call rebuild-app.cmd

