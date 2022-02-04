from flask import Flask, request, Response
from controller import *
from machineLearning import executeMachineLearning
import json
from model import saveMachineLearning
from flask_cors import CORS, cross_origin
from s3 import *

app = Flask(__name__)
CORS(app)
app.config['CORS_HEADERS'] = 'Content-Type'


@app.route('/FIA/consiglio', methods=['POST'])
@cross_origin()
def consiglio():
    try:
        content = request.get_json(silent=True)
        if not 'risposte' in content:
            return Response("campi invalidi", status=300)
        response = analyze_data(content['risposte'])
        save_response([str(response)])
        response = {"dipartimento": str(response)}
        response = json.dumps(response)
        return Response(response, status=200, mimetype='application/json')
    except Exception as e:
        print(e)
        return Response("Internal error", status=500)

@app.route('/FIA/contribuisci', methods=['POST'])
@cross_origin()
def contribuisci():
    try:
        content = request.get_json(silent=True)
        if not 'risposte' in content:
            return Response("campi invalidi", status=300)
        save_data(content['risposte'], content['idUtente'])
        response = {"msg": "dati salvati con successo"}
        response = json.dumps(response)
        return Response(response, status=200, mimetype='application/json')
    except Exception as e:
        print(e)
        return Response("Internal error", status=500)


@app.route('/FIA/machineLearning', methods=['GET'])
@cross_origin()
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