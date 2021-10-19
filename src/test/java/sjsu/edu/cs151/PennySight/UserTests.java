package sjsu.edu.cs151.PennySight;


import org.junit.jupiter.api.Test;
import sjsu.edu.cs151.PennySight.model.User;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTests {

    @Test
    public void usernameTest() throws Exception {
        User user1 = new User();
        user1.setUsername("Bob");
        assertThat(user1.getUsername()).isEqualTo("Bob");
        User user2 = new User();
        user2.setUsername(user1.getUsername());
        assertThat(user1).isNotEqualTo("Alice");
    }

    @Test
    public void passwordTest() throws Exception {
        User user1 = new User();
        user1.setPassword("1212");
        assertThat(user1.getPassword()).isEqualTo("1212");
        User user2 = new User();
        user2.setPassword(user1.getPassword());
        assertThat(user1).isNotEqualTo("6467");
    }
}
