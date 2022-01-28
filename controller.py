import pickle
import numpy as np
import urllib.request
from model import *

def analyze_data(dati):
    url = getLatestMachineLearning()
    loaded_model = pickle.load(urllib.request.urlopen(url))
    return (loaded_model.predict(np.asarray(dati).reshape(1, -1)))[0]

def save_data(dati, utente):
    dati.insert(0, utente)
    saveContribuisci(dati)
