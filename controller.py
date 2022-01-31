import pickle
import numpy as np
import urllib.request
from model import *

def analyze_data(dati):
    # url il valore dell’ultimo modello predittivo usato(salvato online)
    url = getLatestMachineLearning()
    #effettuo il load del model
    loaded_model = pickle.load(urllib.request.urlopen(url))
    #return valore predetto sui dati ricevuti in input
    return (loaded_model.predict(np.asarray(dati).reshape(1, -1)))[0]
#salvo i dati delle risposte dell'utente
def save_data(dati, utente):
    dati.insert(0, utente)
    saveContribuisci(dati)
