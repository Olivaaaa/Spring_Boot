package demo.demo1.controller;

import demo.demo1.dto.AccessTokenDTO;
import demo.demo1.mapper.UserMapper;
import demo.demo1.model.User;
import demo.demo1.provider.GithubProvider;
import demo.demo1.provider.GithubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

//    @Value("${github.client.id}")
//    private String clientId;
//    @Value("${github.client.secret}")
//    private String clientSecret;
//    @Value("${github.redirect.uri}")
//    private String redirectUri;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/callback")
    public String authorize(@RequestParam(name = "code") String code,
                            @RequestParam(name = "state") String state,
                            HttpServletRequest request){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("e073d6b738c9365e4924");
        accessTokenDTO.setClient_secret("544e799d213267e28af60500d485473f50c23364");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        accessTokenDTO.setRedirect_uri("http://localhost:8080/callback");
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getUser(accessToken);
        if (githubUser != null)
        {
            User user = new User();
            user.setToken(UUID.randomUUID().toString());
            user.setName(githubUser.getName());
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
            request.getSession().setAttribute("githubUser", githubUser);
            return "redirect:/";
        }
        else {
            System.out.println("没有没有没有没有");
            return "redirect:/";
        }
    }
}
