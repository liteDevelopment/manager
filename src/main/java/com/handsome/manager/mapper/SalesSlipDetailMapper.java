package com.handsome.manager.mapper;

import com.handsome.manager.ao.SalesSlipDetailAO;
import com.handsome.manager.model.SalesSlipDetail;
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
public interface SalesSlipDetailMapper extends BaseMapper<SalesSlipDetail> {

    List<SalesSlipDetailAO> getSalesSlipDetails(@Param("begin") int begin, @Param("length") int length);
}
