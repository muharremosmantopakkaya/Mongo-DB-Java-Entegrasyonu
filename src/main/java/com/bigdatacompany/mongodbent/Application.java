package com.bigdatacompany.mongodbent;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Application {
    public static void main(String[] args){
        MongoClient client =new MongoClient("localhost",27017);
        MongoDatabase infoDB = client.getDatabase("Info");
       MongoCollection<Document> personelCollection = infoDB.getCollection("Personal");

        BasicDBObject data=new BasicDBObject()
                .append("name","Stephen Hawking")
                .append("date",1942)
                .append("country","England");

        personelCollection.insertOne(Document.parse(data.toJson()));
    }
}
