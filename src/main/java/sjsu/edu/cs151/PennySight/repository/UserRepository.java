package sjsu.edu.cs151.PennySight.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sjsu.edu.cs151.PennySight.model.User;

@Repository
public class UserRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public User save(User user) {
        dynamoDBMapper.save(user);
        return user;
    }

    public User getUserByUsername(String username) {
        return dynamoDBMapper.load(User.class, username);
    }

    public String delete(String username) {
        User user = dynamoDBMapper.load(User.class, username);
        dynamoDBMapper.delete(user);
        return "User deleted";
    }

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
