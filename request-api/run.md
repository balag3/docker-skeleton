Run the image:  
__-p__ it will map the localhost's 3000 port to the container's 3000  
__--name__ name the container to ***api***  
__-d__ run it in the background  

docker run -p 3000:3000 --name=api -d api:latest
