package sjsu.edu.cs151.PennySight.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This class is the configuration for the AWS Dynamodb using AWS SDK
 * By providing the access key and secret access key that generated from AWS IAM
 * Then giving the region id to connect to the AWS DynamoDB
 * The access key and secret access key would be rotated after the class is done
 * @author PennySight
 */
@Configuration
public class DynamoDBConfiguration {
    @Bean
    public DynamoDBMapper dynamoDBMapper() {
        return new DynamoDBMapper(buildAmazonDynamoDB());
    }

    private AmazonDynamoDB buildAmazonDynamoDB() {
        return AmazonDynamoDBClientBuilder
                .standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(
                                "dynamodb.us-west-1.amazonaws.com",
                                "us-west-1"
                        )
                ).withCredentials(
                        new AWSStaticCredentialsProvider(
                                new BasicAWSCredentials(
                                        "AKIARMLJF47HY2K3OEN5",
                                        "zpHuegoGoepWv6QYhftvLJ0Dsc33YiF7ZJUZytEO"
                                )
                        )
                )
                .build();
    }
}
