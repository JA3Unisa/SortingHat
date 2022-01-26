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

def getLatestMachineLearning():
    mydb = mysql.connector.connect(
        host=os.environ.get("host"),
        user=os.environ.get("user"),
        password=os.environ.get("pwd"),
        database='sorting_hat_test'
    )


    query = "SELECT * FROM ia ORDER BY dateTime DESC;"

    mycursor = mydb.cursor()
    mycursor.execute(query)

    res = mycursor.fetchall()

    mydb.close()
    return res[0][4]
