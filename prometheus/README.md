# Je zapotřebí mít nainstalované:

- Docker
- Maven

# Spuštění:

	build.cmd

# Aplikace:

url: http://localhost:8080
username / password: user / letmein

# Prometheus:

url: http://localhost:9090

# Grafana:

url: http://localhost:3000
username / password: admin / admin

Je zapotřebí přidat Data Source typu Prometheus, URL: http://prometheus:9090


# Vypnutí:

	docker-compose down