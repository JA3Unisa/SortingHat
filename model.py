import mysql.connector
from dotenv import load_dotenv
import os

load_dotenv()


def saveMachineLearning(nElements, score):
    mydb = mysql.connector.connect(
        host=os.environ.get("host"),
        user=os.environ.get("user"),
        password=os.environ.get("pwd"),
        database='sorting_hat_test'
    )

    query = "INSERT INTO ia (nElements, score) VALUES (%s, %s);"
    mycursor = mydb.cursor()
    val = (int(nElements), float(score))
    mycursor.execute(query, val)

    mydb.commit()
    mydb.close()