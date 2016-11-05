import lethallima.web.configuration.WebMvcConfig;
import lethallima.web.helpers.Const;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.anonymous;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by LethalLima on 11/4/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebMvcConfig.class)
@WebAppConfiguration
public class WebSecurityConfigTest {
    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;


    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    public void testRoutesWithAdmin() throws Exception {
        mvc.perform(get("/users").with(user("admin").authorities(new SimpleGrantedAuthority(Const.ROLE_ADMIN))))
                .andExpect(status().isOk());

        mvc.perform(get("/admin").with(user("admin").authorities(new SimpleGrantedAuthority(Const.ROLE_ADMIN))))
                .andExpect(status().isOk());
    }

    @Test
    public void testRoutesWithUser() throws Exception {
        mvc.perform(get("/users").with(user("user").authorities(new SimpleGrantedAuthority(Const.ROLE_USER))))
                .andExpect(status().isForbidden());
        mvc.perform(get("/admin").with(user("user").authorities(new SimpleGrantedAuthority(Const.ROLE_USER))))
                .andExpect(status().isForbidden());
    }

    @Test
    public void testRoutesWithAnonymous() throws Exception {
        mvc.perform(get("/login").with(anonymous()))
                .andExpect(status().isOk());

        mvc.perform(get("/users").with(anonymous()))
                .andExpect(status().is3xxRedirection());

        mvc.perform(get("/admin").with(anonymous()))
                .andExpect(status().is3xxRedirection());
    }
}
