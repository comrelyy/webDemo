package com.relyy.dao;


import com.relyy.VO.QuestionnaireVo;
import com.relyy.VO.UserVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TestMapper {

    /**
     * @desc
     * @author: cairuirui
     * @date
     * @param id
     * @return
     */
    UserVO selectById(int id);

    UserVO getUser(int id);

    QuestionnaireVo getQuestionnaire(int id);

    QuestionnaireVo getQuestionnaireByUserId(@Param("userId") int userId, @Param("grade") int grade);

    QuestionnaireVo getQuestionnaireLazy(int id);
}
