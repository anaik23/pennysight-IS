package sjsu.edu.cs151.PennySight.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class is the user entity model class
 * The User class contains user's attritubes
 * Getters, Setter, and Constructor generated by Lombok annotation
 * This model class corresponding to the Dynamodb table on AWS
 * @author PennySight
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "cs151_user")
public class User {

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String username;

    @DynamoDBAttribute(attributeName = "password")
    private String password;

    @DynamoDBAttribute(attributeName = "date")
    private String date;

    @DynamoDBAttribute(attributeName = "rent")
    private double rent;

    @DynamoDBAttribute(attributeName = "grocery")
    private double grocery;

    @DynamoDBAttribute(attributeName = "subscription")
    private double subscription;

    @DynamoDBAttribute(attributeName = "saving")
    private double saving;

    @DynamoDBAttribute(attributeName = "gas")
    private double gas;

    @DynamoDBAttribute(attributeName = "auto_insurance")
    private double auto_insurance;

    @DynamoDBAttribute(attributeName = "entertainment")
    private double entertainment;

}
