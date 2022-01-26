from flask import Flask, request, Response
from controller import *
from machineLearning import executeMachineLearning
import json
from model import saveMachineLearning

app = Flask(__name__)


@app.route('/FIA/consiglio', methods=['POST'])
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
        response, nElements = executeMachineLearning()
        saveMachineLearning(nElements, response)
        response = {"score": str(response), "nElements": str(nElements)}
        response = json.dumps(response)
        return Response(response, status=200, mimetype='application/json')
    except Exception as e:
        print(e)
        return Response("Internal error", status=500)


if __name__ == "__main__":
    app.run()
