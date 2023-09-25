package com.bigdatacompany.mongodbent;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Arrays;

public class Application {
    public static void main(String[] args){
        MongoClient client =new MongoClient("localhost",27017);
        MongoDatabase infoDB = client.getDatabase("Info");
       MongoCollection<Document> personelCollection = infoDB.getCollection("Personal");

        BasicDBObject data=new BasicDBObject()
                .append("name","Stephen Hawking")
                .append("date",1942)
                .append("country","England");

        BasicDBObject data2=new BasicDBObject()
                .append("name","Isaac Newton")
                .append("date",1643)
                .append("country","England");
        //personelCollection.insertOne(Document.parse(data.toJson()));
        Document parse =Document.parse(data.toJson());
        Document parse2 =Document.parse(data2.toJson());
        personelCollection.insertMany(Arrays.asList(parse,parse2));
    }
}
