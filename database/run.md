Run the image:  

docker run --net=my_isolated_bridge_network -v /var/postgresql/data:/var/lib/postgresql/data --hostname=database -p 5432:5432 --name=database -d database:latest
