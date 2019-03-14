Run the image:  
__-p__ it will map the localhost's 5432 port to the container's 5432 port (default postgres port)  
__-v__ creates a volume at the host machine under ***/var/postgresql/data*** to persist all the containers data which is stored under ***/var/lib/postgresql/data***  
__--name__ name the container to ***database***  
__-d__ run it in the background  

docker run -p 5432:5432 -v /var/postgresql/data:/var/lib/postgresql/data --name=database -d database:latest