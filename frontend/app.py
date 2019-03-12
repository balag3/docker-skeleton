from flask import Flask, render_template
import requests
import json
import os


app = Flask(__name__)

try:
    backend = os.environ['BACKEND_HOST']
except KeyError as e:
    backend = 'localhost'


@app.route('/<name>')
def hello_name(name):
    url = 'http://' + backend + ':8080/'
    headers = {'Content-type': 'application/json; charset=UTF-8'}
    payload = {'value': name}
    response = requests.post(url, data=json.dumps(payload), headers=headers)
    return render_template('index.html', value=json.loads(response.text)['value'])


@app.route('/')
def hello():
    return "Enter a keyword in the url!"


if __name__ == '__main__':
    app.run(host='0.0.0.0', port=4000)
