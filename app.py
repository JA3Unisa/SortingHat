from flask import Flask, request, Response
from controller import *
from machineLearning import executeMachineLearning
import json
from model import saveMachineLearning
from flask_cors import CORS, cross_origin
from s3 import *

app = Flask(__name__)
CORS(app, support_credentials=True)


@app.route('/FIA/consiglio', methods=['POST'])
@cross_origin(supports_credentials=True)
def contribuisci():
    try:
        content = request.get_json(silent=True)
        if not 'risposte' in content:
            return Response("campi invalidi", status=300)
        response = analyze_data(content['risposte'])
        response = {"dipartimento": str(response)}
        response = json.dumps(response)
        return Response(response, status=200, mimetype='application/json')
    except Exception as e:
        print(e)
        return Response("Internal error", status=500)


@app.route('/FIA/machineLearning', methods=['GET'])
def machineLearning():
    try:
        response, nElements, pickle_dump = executeMachineLearning()
        saveMachineLearning(nElements, response, pickle_dump)
        response = {"score": str(response), "nElements": str(nElements)}
        response = json.dumps(response)
        return Response(response, status=200, mimetype='application/json')
    except Exception as e:
        print(e)
        return Response("Internal error", status=500)


if __name__ == "__main__":
    app.run()
