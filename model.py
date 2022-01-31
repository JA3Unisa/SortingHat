import mysql.connector
from dotenv import load_dotenv
import os
from s3 import *
import uuid

load_dotenv()


def saveMachineLearning(nElements, score, pickle_dump):
    mydb = mysql.connector.connect(
        host=os.environ.get("host"),
        user=os.environ.get("user"),
        password=os.environ.get("pwd"),
        database='sorting_hat_test'
    )

    url = upload_file(pickle_dump, uuid.uuid4().hex)
    if not url:
        raise Exception("Fallito il salvataggio del MachineLearning")
    query = "INSERT INTO ia (nElements, score, file) VALUES (%s, %s, %s);"
    mycursor = mydb.cursor()
    val = (int(nElements), float(score), url)
    mycursor.execute(query, val)

    mydb.commit()
    mydb.close()
#metodo per ottenere l'ultimo modello predittivo ovvero il più aggiornato
def getLatestMachineLearning():
    mydb = mysql.connector.connect(
        host=os.environ.get("host"),
        user=os.environ.get("user"),
        password=os.environ.get("pwd"),
        database='sorting_hat_test'
    )

    #ordino per la data la query sulla tabella ia del database
    query = "SELECT * FROM ia ORDER BY dateTime DESC;"
    #eseguo query
    mycursor = mydb.cursor()
    mycursor.execute(query)

    res = mycursor.fetchall()
    #chiudo database e ritorno risultato
    mydb.close()
    return res[0][4]
#medoto per salvare i dati dei nuovi form compilati nel database
def saveContribuisci(dati):
    mydb = mysql.connector.connect(
        host=os.environ.get("host"),
        user=os.environ.get("user"),
        password=os.environ.get("pwd"),
        database='sorting_hat_test'
    )


    mycursor = mydb.cursor()

    sql = "INSERT INTO `contribuisci` (`idutente`, `domanda1`, `domanda2`, `domanda3`, `domanda4`, `domanda5`, `domanda6`, `domanda7`, `domanda8`, `domanda9`, `domanda10`, `domanda11`, `domanda12`, `domanda13`, `domanda14`, `domanda15`, `domanda16`, `domanda17`, `domanda18`, `domanda19`, `domanda20`, `domanda21`, `domanda22`, `domanda23`, `domanda24`) VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s);"
    mycursor.execute(sql, dati)

    mydb.commit()
#metodo per salvare le  risposte
def save_response(resp):
    mydb = mysql.connector.connect(
        host=os.environ.get("host"),
        user=os.environ.get("user"),
        password=os.environ.get("pwd"),
        database='sorting_hat_test'
    )


    mycursor = mydb.cursor()

    sql = "INSERT INTO `sorting_hat_test`.`predict` (`dipartimento`) VALUES (%s);"
    mycursor.execute(sql, resp)

    mydb.commit()
