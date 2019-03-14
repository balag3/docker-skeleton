FROM python:latest

WORKDIR /

ADD requirements.txt requirements.txt

RUN pip install -r requirements.txt

ADD app.py app.py

EXPOSE 3000

CMD ["python", "app.py"]