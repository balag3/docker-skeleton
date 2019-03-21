Run the image:  
docker run -p 3000:3000 --net=my_isolated_bridge_network --hostname=api --name=api -d api:latest
docker network create --driver bridge my_isolated_bridge_network
