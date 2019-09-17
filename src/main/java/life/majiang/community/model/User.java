package life.majiang.community.model;

import lombok.Data;

@Data
public class User {
    private long id;
    private String username;
    private String token;
    private String accountId;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;
}
