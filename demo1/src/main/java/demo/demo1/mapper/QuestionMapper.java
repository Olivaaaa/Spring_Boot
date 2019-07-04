package demo.demo1.mapper;

import demo.demo1.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionMapper {

    @Insert("insert into question (title, description, gmtCreate, gmtModified, creator, commentCount, viewCount, likeCount, tag) values (#{title}, #{description}, #{gmtCreate}, #{gmtModified}, #{creator}, #{commentCount}, #{viewCount}, #{likeCount}, #{tag})")
    void create(Question question);
}
