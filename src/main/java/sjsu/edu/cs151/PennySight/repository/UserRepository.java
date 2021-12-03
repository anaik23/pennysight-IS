package sjsu.edu.cs151.PennySight.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sjsu.edu.cs151.PennySight.model.User;

/**
 * This class is the Repository layer for User
 * Annotated with @Repository to indicate this is a repository bean in the spring container
 * This UserRepository class inject the DynamoDBMapper by using @Autowired
 * This UserRepository have provided CRUD operations for controller class to use
 * @author PennySight
 */
@Repository
public class UserRepository {
    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    /**
     * This method is to save a User into the database
     * @param user the brand new User object
     * @return a JSON format of the User representation
     */
    public User save(User user) {
        dynamoDBMapper.save(user);
        return user;
    }

    /**
     * This method is the GET operation by using dynamoDBMapper
     * @param username the user that wants to be returned
     * @return User
     */
    public User getUserByUsername(String username) {
        return dynamoDBMapper.load(User.class, username);
    }

    /**
     * This method is the DELETE operation by using dynamoDBMapper
     * @param username the user that wants to be deleted
     * @return A String that shows user has been successfully deleted
     */
    public String delete(String username) {
        User user = dynamoDBMapper.load(User.class, username);
        dynamoDBMapper.delete(user);
        return "User deleted";
    }

    /**
     *
     * @param username the username as the id that to search the old User object
     * @param user the new User object with new attributes that update on the old User
     * @return the old User's username
     */
    public String update(String username, User user) {
        dynamoDBMapper.save(user,
                new DynamoDBSaveExpression()
                        .withExpectedEntry("username",
                                new ExpectedAttributeValue(
                                        new AttributeValue().withS(username)
                                )));
        return username;
    }
}
