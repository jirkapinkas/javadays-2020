# Je zapotřebí mít nainstalované:

- Docker
- Maven

# Spuštění:

	build.cmd

# Rebuild aplikace:

	rebuild-app.cmd

# Aplikace:

url: http://localhost:8080
username / password: user / letmein

# Prometheus:

url: http://localhost:9090

# Grafana:

url: http://localhost:3000
username / password: admin / admin
Poznámka: Při prvním přihlášení se doporučí změna admin hesla, to je možné ignorovat

Je zapotřebí přidat Data Source typu Prometheus, URL: http://prometheus:9090

# Vypnutí:

	docker rm -v -f app prometheus grafana
	docker network rm app_net
