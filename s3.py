import boto3
from dotenv import load_dotenv
import os
load_dotenv()

def upload_file(file, file_name):
    #Creating Session With Boto3.
    session = boto3.Session(
        aws_access_key_id=os.environ.get("aws_access_key_id"),
        aws_secret_access_key=os.environ.get("aws_secret_access_key")
    )
    #Creating S3 Resource From the Session.
    s3 = session.resource('s3')
    file_name = file_name+".sav"
    result = s3.meta.client.put_object(Body=file, Bucket=os.environ.get("aws_bucket"), Key=file_name)

    res = result.get('ResponseMetadata')

    if res.get('HTTPStatusCode') == 200:
        url = "http://s3-eu-west-3.amazonaws.com/"+os.environ.get("aws_bucket")+"/"+file_name
        return url
    else:
        return 0




