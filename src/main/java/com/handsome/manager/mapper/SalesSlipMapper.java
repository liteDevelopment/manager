package com.handsome.manager.mapper;

import com.handsome.manager.ao.SalesSlipAO;
import com.handsome.manager.model.SalesSlip;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author handsome
 * @since 2020-05-13
 */
public interface SalesSlipMapper extends BaseMapper<SalesSlip> {

    List<SalesSlipAO> getSalesSlips(@Param("begin") int begin, @Param("length") int length);

}
