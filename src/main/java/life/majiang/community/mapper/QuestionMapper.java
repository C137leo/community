package life.majiang.community.mapper;

import life.majiang.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionMapper {

    //提问
    @Insert("INSERT INTO question(title,description,gmt_create,gmt_modified,creator,tag)VALUE(#{title},#{description}),#{title},#{gmtCreate},#{gmtModified},#{creator},#{tag}")
    void create(Question question);



}
