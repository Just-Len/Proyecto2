import com.una.controllers.client.UserController;
import com.una.models.user.UserContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserControllerTest {

    UserController test;
@BeforeEach
    public void setup() throws Exception {
        test = new UserController();
        UserContainer.users.clear();
    }
    @Test
    public void testAddUser() throws Exception {
    String [] user = {"Len", "123","Jose","jose@gmail.com", "898884362", "12321"};
    String response = test.add(user);
        Assertions.assertEquals("Se ha agregado exitosamente", response);
    }
}
