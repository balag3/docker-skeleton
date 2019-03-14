from flask import Flask
from flask_restful import Resource, Api
import requests

app = Flask(__name__)
api = Api(app)
link = 'https://api.chucknorris.io/jokes/search?query={0}'


class Quote(Resource):
    def get(self, word):
        response = requests.get(link.format(word))
        if response.json()['total'] > 0:
            value = response.json()['result'][0]['value']
            return {'value': value}


class Welcome(Resource):
    def get(self):
        return "Welcome! " \
               "Api usage: http://my-api-url/<search-term> will return a Chuck Norris quote " \
               "containing the phrase if it exist! " \
               "Response format : {'value' : 'quote'}"


api.add_resource(Welcome, '/')
api.add_resource(Quote, '/<string:word>')

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=3000)
