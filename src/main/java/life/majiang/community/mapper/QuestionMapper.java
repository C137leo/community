package life.majiang.community.mapper;

import life.majiang.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {

    //提问
    @Insert("INSERT INTO question(title,description,gmt_create,gmt_modified,creator,tag)VALUE(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void create(Question question);

    @Select("SELECT * FROM question limit #{offset},#{size}")
    List<Question> list(@Param(value="offset") Integer offset,@Param(value="size") Integer size);

    @Select("SELECT count(*) FROM question")
    Integer count();
}
