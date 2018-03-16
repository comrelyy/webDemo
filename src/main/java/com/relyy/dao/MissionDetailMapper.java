package com.relyy.dao;

import com.relyy.VO.MissionDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("missionDetailMapper")
public interface MissionDetailMapper {

    int insertSelective(MissionDetail record);

    MissionDetail selectByPrimaryKey(@Param(value = "id") Integer id, @Param(value = "userId") Long userId);

    int updateByPrimaryKeySelective(MissionDetail record);


    /**
     * 批量保存
     *
     * @param list
     * @return
     */
    public int batchSave(List<MissionDetail> list);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    public int batchDelete(@Param(value = "ids") List<Integer> ids, @Param(value = "userId") Long userId);

    /**
     * 查询总数
     *
     * @return 总数
     */
    int getMaxId();

    /**
     * 分页查询ids
     *
     * @return ids
     */
    List<Integer> getIdList(@Param("start") Integer start, @Param("count") Integer count);

    /**
     * 拿到关卡总观看时长
     *
     * @param missionId 关卡id
     * @return 总时长
     */
    int getMissionTotalTime(Integer missionId);

    /**
     * 根据missionid查询missionDetailIds
     *
     * @param missionId 关卡id
     * @param userId    用户id
     * @return 关卡详情列表
     */
    List<MissionDetail> getMissionDetailIdsByMissionId(@Param(value = "missionId") Integer missionId, @Param(value = "userId") Long userId);

    /**
     * 获取stuExamId为空的数据
     */
    List<MissionDetail> getRepairData();

    /**
     * 批量更新stuExamId
     */
    void batchUpdateStuExamIdByExamId(List<MissionDetail> list);
}
