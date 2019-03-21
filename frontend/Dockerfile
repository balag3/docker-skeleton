FROM python:latest

# Set the application directory
WORKDIR /app

# Install our requirements.txt
ADD requirements.txt /app/requirements.txt
RUN pip install -r requirements.txt

# Copy our code from the current folder to /app inside the container
ADD app.py /app/app.py
ADD templates/index.html /app/templates/index.html

# Make port 4000 available
EXPOSE 4000

# Define our command to be run when launching the container
CMD ["python", "app.py"]