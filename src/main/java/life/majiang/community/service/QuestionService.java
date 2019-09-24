package life.majiang.community.service;

import life.majiang.community.dto.PaginationDTO;
import life.majiang.community.dto.QuestionDTO;
import life.majiang.community.mapper.QuestionMapper;
import life.majiang.community.mapper.UserMapper;
import life.majiang.community.model.Question;
import life.majiang.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
//当一个请求需要组装两个mapper时可以加一个service层
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;
    //接收从indexController传过来的参数
    public PaginationDTO list(Integer page, Integer size) {
        Integer totalPage;
        Integer totalCount = questionMapper.count();
        if(totalCount%size==0){
            totalPage=totalCount/size;
        }else {
            totalPage=totalCount/size+1;
        }
        //编写具体的计算细节size*(page-1);
        if (page<1){
            page=1;
        }
        if (page>totalPage){
            page=totalPage;
        }
        Integer offset= size*(page-1);
        List<Question> questionList=questionMapper.list(offset,size);
        PaginationDTO paginationDTO=new PaginationDTO();
        List<QuestionDTO> questionDTOList= new ArrayList();
        for (Question question : questionList) {
            User user=userMapper.findByAccountId(question.getCreator());
            QuestionDTO questionDTO=new QuestionDTO();
//            questionDTO.setId(question.getId());
            BeanUtils.copyProperties(question,questionDTO);//将question的内容拷贝到questionDTO里面去
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);
        paginationDTO.setPagination(totalCount,page,size);
        return paginationDTO;
    }
}
