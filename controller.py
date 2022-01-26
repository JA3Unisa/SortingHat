import pickle
import numpy as np


def analyze_data(dati):
    loaded_model = pickle.load(open('finalized_model.sav', 'rb'))
    return (loaded_model.predict(np.asarray(dati).reshape(1, -1)))[0]
