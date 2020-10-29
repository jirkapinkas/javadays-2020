docker rm -v -f app prometheus grafana && docker network rm app_net && build-servers.cmd && build-app.cmd

