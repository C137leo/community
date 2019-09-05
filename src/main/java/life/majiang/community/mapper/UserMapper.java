package life.majiang.community.mapper;

import life.majiang.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserMapper {
    @Insert("INSERT INTO user(id,username,token)VALUE(#{id},#{username},#{token})")
    void insert(User user);

    @Select("SELECT * from user WHERE token=#{token}")
    User findByToken(@Param("token") String token);
}
