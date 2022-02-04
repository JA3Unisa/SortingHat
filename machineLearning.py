from sklearn.ensemble import RandomForestClassifier
from sklearn.model_selection import train_test_split
import pandas as pd
import pickle
import mysql.connector
from dotenv import load_dotenv
import os

load_dotenv()

#carico dataset dal database con credenziali di accesso
def load_dataset():
    mydb = mysql.connector.connect(
        host=os.environ.get("host"),
        user=os.environ.get("user"),
        password=os.environ.get("pwd")
    )
    #creo una query che richiede dal database la tabella contribuisci con i valori del dataset salvati
    query = "SELECT `contribuisci`.`domanda1`, `contribuisci`.`domanda2`, `contribuisci`.`domanda3`, `contribuisci`.`domanda4`, `contribuisci`.`domanda5`, `contribuisci`.`domanda6`, `contribuisci`.`domanda7`, `contribuisci`.`domanda8`, `contribuisci`.`domanda9`, `contribuisci`.`domanda10`, `contribuisci`.`domanda11`, `contribuisci`.`domanda12`, `contribuisci`.`domanda13`, `contribuisci`.`domanda14`, `contribuisci`.`domanda15`, `contribuisci`.`domanda16`, `contribuisci`.`domanda17`, `contribuisci`.`domanda18`, `contribuisci`.`domanda19`, `contribuisci`.`domanda20`, `contribuisci`.`domanda21`, `contribuisci`.`domanda22`, `contribuisci`.`domanda23`, `contribuisci`.`domanda24` FROM `sorting_hat_test`.`contribuisci`;"
    df = pd.read_sql(query, mydb) #attraverso pandas effettuo la lettura del risultato, quindi tutte le risposte alle nostre domande
    mydb.close() #chiudo il database poichè non servirà per le operazioni successive
    #converto tutti i valori in tipo int

    for colonna in df:
        df[colonna] = df[colonna].astype(int)

    # inserisco in y la prima colonna "che dipartimento fai parte"
    y = df.iloc[:, 0].values

    # inserisco in X tutte le colonne tranne "che dipartimento fai parte"
    X = df.iloc[:, 1:].values
    x2 = df.iloc[:, 1:]
    # divido il dataset in training e test set
    X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.25, random_state=1)
    nElements = df.shape[0]
    #ritorno i valori calcolati
    return X_train, X_test, y_train, y_test, nElements

#metodo per esecuzione utilizzando le variabili create
def executeMachineLearning():
    X_train, X_test, y_train, y_test, nElements = load_dataset()

    #invoco algoritmo RandomForestClassifier
    forest = RandomForestClassifier(n_estimators=100, random_state=0)
    forest.fit(X_train, y_train)

    #rendo forest binario per poterlo successivamente salvare su file
    pickle_dump = pickle.dumps(forest)
    #calcolo accuracy
    score = forest.score(X_test, y_test)
    return score, nElements, pickle_dump
