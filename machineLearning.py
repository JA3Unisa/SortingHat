from sklearn.ensemble import RandomForestClassifier
from sklearn.model_selection import train_test_split
import pandas as pd
import pickle
import mysql.connector
from dotenv import load_dotenv
import os

load_dotenv()

#carico dataset dal database con credenziali di accesso
def load_dataset(test_size=0.3):
    mydb = mysql.connector.connect(
        host=os.environ.get("host"),
        user=os.environ.get("user"),
        password=os.environ.get("pwd")
    )
    #creo una query che richiede dal database la tabella contribuisci con i valori del dataset salvati
    query = "SELECT `contribuisci`.`domanda1`, `contribuisci`.`domanda2`, `contribuisci`.`domanda3`, `contribuisci`.`domanda4`, `contribuisci`.`domanda5`, `contribuisci`.`domanda6`, `contribuisci`.`domanda7`, `contribuisci`.`domanda8`, `contribuisci`.`domanda9`, `contribuisci`.`domanda10`, `contribuisci`.`domanda11`, `contribuisci`.`domanda12`, `contribuisci`.`domanda13`, `contribuisci`.`domanda14`, `contribuisci`.`domanda15`, `contribuisci`.`domanda16`, `contribuisci`.`domanda17`, `contribuisci`.`domanda18`, `contribuisci`.`domanda19`, `contribuisci`.`domanda20`, `contribuisci`.`domanda21`, `contribuisci`.`domanda22`, `contribuisci`.`domanda23`, `contribuisci`.`domanda24` FROM `sorting_hat_test`.`contribuisci`;"
    df = pd.read_sql(query, mydb)#attraverso pandas effettuo la lettura del risultato
    mydb.close()#chiudo il database poichè non servirà per le operazioni successive
    #i parametri sono caricati in un array con gli interi delle risposte
    for colonna in df:
        df[colonna] = df[colonna].astype(int)

    # carico tutti i valori della prima colonna "che dipartimento fai parte"
    y = df.iloc[:, 0].values

    # carico tutti i valori, tranne "che dipartimento fai parte"
    X = df.iloc[:, 1:].values

    # divido il dataset in training e test set
    X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=test_size, random_state=2)
    nElements = df.shape[0]
    #ritorno i valori calcolati
    return X_train, X_test, y_train, y_test, nElements

#metodo per esecuzione utilizzando le variabili create
def executeMachineLearning():
    X_train, X_test, y_train, y_test, nElements = load_dataset()

    #invoco algoritmo RandomForestClassifier
    forest = RandomForestClassifier(criterion='gini', n_estimators=1000, random_state=1, n_jobs=4)
    forest.fit(X_train, y_train)

    #rendo forest binario
    pickle_dump = pickle.dumps(forest)
    #calcolo score
    score = forest.score(X_test, y_test)
    return score, nElements, pickle_dump
