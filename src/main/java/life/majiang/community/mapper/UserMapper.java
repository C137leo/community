package life.majiang.community.mapper;

import life.majiang.community.model.User;
import org.apache.ibatis.annotations.*;


@Mapper
public interface UserMapper {
    @Insert("INSERT INTO user(accountId,username,token,gmt_create,gmt_modified,avatar_url)VALUE(#{accountId},#{username},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    void insert(User user);

    @Select("SELECT * from user WHERE token=#{token}")
    User findByToken(@Param("token") String token);

    @Select("SELECT * from user WHERE id=#{id}")
    User findById(@Param("id") Integer id);

    @Select("SELECT * from user WHERE accountId=#{accountId}")
    User findByAccountId(@Param("accountId")String accountId);

    @Update("UPDATE user SET name=*{name},token=#{token},gmt_modified=#{gmtModified},avatar_url=#{avatarUrl} WHERE id=#{id}")
    void update(User user);
}
