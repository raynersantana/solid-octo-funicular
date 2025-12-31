package br.com.ray.tester.service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static com.mongodb.client.model.Filters.eq;

@Service
public class MoviesService {

    @Value("${MONGODB_URI}")
    private String uri;

    public String getMovieNameByTitleAsJson(String title) {
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("sample_mflix");
            MongoCollection<Document> collection = database.getCollection("movies");

            Document doc = collection.find(eq("title", title)).first();
            if (doc != null) {
                System.out.println("found! @@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println(doc.toJson());
                return doc.toJson();
            }

            return null;
        }
    }
}
