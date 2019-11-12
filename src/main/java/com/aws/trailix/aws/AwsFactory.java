package com.aws.trailix.aws;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

public class AwsFactory {

    private static AmazonDynamoDBClientBuilder dynamoBuilder() {
        AmazonDynamoDBClientBuilder builder = AmazonDynamoDBClientBuilder.standard();
        return builder;
    }

    public static AmazonDynamoDB dynamoClient() {
        AmazonDynamoDB ddb = AwsFactory.dynamoBuilder()
                .withRegion(Regions.US_EAST_1)
                .withCredentials(new ProfileCredentialsProvider("myProfile"))
                .build();

        return ddb;
    }
}
